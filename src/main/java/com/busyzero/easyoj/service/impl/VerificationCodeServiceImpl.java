package com.busyzero.easyoj.service.impl;

import com.busyzero.easyoj.commons.exception.BusinessException;
import com.busyzero.easyoj.commons.exception.ExceptionCodeEnum;
import com.busyzero.easyoj.commons.result.Result;
import com.busyzero.easyoj.commons.tool.MD5EncryptionUtil;
import com.busyzero.easyoj.commons.tool.ResultCheckUtil;
import com.busyzero.easyoj.entity.AccountInfo;
import com.busyzero.easyoj.entity.AccountVerification;
import com.busyzero.easyoj.enums.AccountStateEnum;
import com.busyzero.easyoj.enums.VerificationStateEnum;
import com.busyzero.easyoj.repository.AccountInfoRepository;
import com.busyzero.easyoj.repository.AccountVerificationRepository;
import com.busyzero.easyoj.service.EmailService;
import com.busyzero.easyoj.service.VerificationCodeService;
import com.busyzero.easyoj.utils.VerificationCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.time.Instant;
import java.util.Random;

/**
 * 提供验证码服务
 * @author katey2658
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
    private final Logger logger = LoggerFactory.getLogger(VerificationCodeServiceImpl.class);

    /**验证码操作表*/
    @Autowired
    private AccountVerificationRepository verificationRepository;

    /**用户服务表进行操作*/
    @Autowired
    private AccountInfoRepository accountInfoRepository;

    /**邮件服务对象*/
    @Autowired
    private EmailService emailService;

    @Override
    public Result<Boolean> sendEmailBindVerification(String accountNo, String emailAddress) {
        Result<Boolean> result = new Result<>();
        String checkStr = accountNo+","+emailAddress;
        String urlLink = null;
        try {
            urlLink = "http://localhost:8888/?secretKey="+ MD5EncryptionUtil.getEncryptedStr(checkStr);
            Context context = new Context();
            context.setVariable("username",accountNo);
            context.setVariable("urlLink",urlLink);
            emailService.sendEmailBindVerification(result,emailAddress,context);
        } catch (Exception e) {
            result.fail(new BusinessException(ExceptionCodeEnum.MAIL_SEND_ERROR));
            logger.error("the error happening send the mail:{}",e.getMessage());
        }
        return result;
    }

    @Override
    public Result<Boolean> sendMobileBindVerification(String mobile) {
        // TODO 暂时不提供实现，之后会来实现
        return null;
    }

    /**
     * 通过邮箱地址发送验证码
     * @param emailAddress
     * @return
     */
    @Override
    public Result<Boolean> sendEmailVerification(String emailAddress) {
        Result<Boolean> result = new Result<>();
        String verificationCode = VerificationCodeUtil.getVerificationCode(6);
        logger.info("the request veriification  code is {}", verificationCode);

        AccountVerification verification = new AccountVerification();
        verification.setEmailAddress(emailAddress);
        verification.setVerificationCode(verificationCode);
        //设置失效时间
        verification.setInvalidTime(Instant.now().plusSeconds(15 * 60));
        //存储进入数据库
        verificationRepository.save(verification);

        try {
            Context context = new Context();
            context.setVariable("code",verificationCode);
            emailService.sendEmailBindVerification(result,emailAddress,context);
        } catch (Exception e) {
            result.fail(new BusinessException(ExceptionCodeEnum.MAIL_SEND_ERROR));
            logger.error("the error happening send the mail:{}",e.getMessage());
        }
        return result;
    }

    /**
     * 通过手机号发送验证码
     * @param mobile
     * @return
     */
    @Override
    public Result<Boolean> sendMobileVerification(String mobile) {
        // TODO 暂时不提供实现，之后来进行实现
        return null;
    }

    /**
     * 根据用户编号获取图形验证码
     * @param accountId
     * @return
     */
    @Override
    public Result<BufferedImage> getVerificationImage(Integer accountId) {
        Result<BufferedImage> result = new Result<>();
        //调用工具类获取对应验证码
        String checkCode = VerificationCodeUtil.getVerificationCode();
        logger.info("the request veriification  code is {}", checkCode);

        AccountVerification verification = new AccountVerification();
        verification.setAccountId(accountId);
        verification.setVerificationCode(checkCode);
        //设置失效时间
        verification.setInvalidTime(Instant.now().plusSeconds(15 * 60));
        //存储进入数据库
        verificationRepository.save(verification);

        final int width = 80;
        final int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //获取一个画笔
        Graphics g = image.getGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, width, height);
        //随机设置3条干扰线
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), r.nextInt(80));
        }
        //设置验证码字符串的颜色
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        g.setFont(new Font("黑体", Font.BOLD, 24));
        g.drawString(checkCode, 15, 20);
        result.setResultObj(image);
        return result;
    }

    /**
     * 邮箱绑定验证
     * @param accountNo    账户号
     * @param emailAddress 邮箱地址
     * @param secretKey    加密字符串，采用base64进行编码，防止有人恶意修改
     * @return
     */
    @Override
    public Result<Boolean> checkEmailbindVerification(String accountNo, String emailAddress, String secretKey) {
        Result<Boolean> result = new Result<>();
        //检查参数是否正确
        boolean validFlag = false;
        String checkStr = accountNo+","+emailAddress;
        try {
            validFlag = MD5EncryptionUtil.validEncryptedStr(checkStr,secretKey);
        } catch (Exception e) {
            logger.error("the error happening when invalid the accountNo,emailAddress:{}",e.getMessage());
        }
        if (validFlag){
            logger.info("the parameters is changed accountNo:{},emailAddress:{},secretKey:{}",accountNo,emailAddress,secretKey);
            //参数校验失败
            result.fail(new BusinessException(ExceptionCodeEnum.ACCPOUNTINFO_PARAMETER_ERROR));
            return result;
        }


        AccountInfo accountInfo = accountInfoRepository.findByAccountNo(accountNo);
        //查找数据库中是不是有该用户
        if (ResultCheckUtil.isNull(accountInfo)) {
            logger.info("the accountInfo is not found by accountNo：{}", accountNo);
            //找不到对应的用户
            result.fail(new BusinessException(ExceptionCodeEnum.ACCOUNTINFO_NOT_FOUND));
            return result;
        }
        if (!ResultCheckUtil.isEqual(emailAddress, accountInfo.getEmailAddress())) {
            // 邮箱和注册中的邮箱不符合
            logger.info("the emailAddress:{} is not equals to accountInfo ：{}", emailAddress, accountInfo.getEmailAddress());
            result.fail(new BusinessException(ExceptionCodeEnum.ACCOUNTINFO_EMAIL_NOT_EQUAL));
            return result;
        }
        //修改状态，进行更新
        accountInfo.setAccountState(AccountStateEnum.STATE_NORMAL.getState());
        accountInfoRepository.updateAccountState(accountInfo);
        return result;
    }

    /**
     * 检验用户输入验证码：邮箱
     * @param emailAddress     邮箱地址
     * @param verificationCode 验证码
     * @return
     */
    @Override
    public Result<Boolean> checkEmailVerificationCode(String emailAddress, String verificationCode) {
        Result<Boolean> result = new Result<>();
        AccountVerification verification = verificationRepository.findByEmailAddress(emailAddress);
        if (ResultCheckUtil.isNull(verification)) {
            logger.info("the verification is not found by emailAddress：{}", emailAddress);
            //找不到验证码
            result.fail(new BusinessException(ExceptionCodeEnum.VERIFICATION_NOT_FOUND));
            return result;
        }
        checkVerificationCode(verification, result, verificationCode);
        return result;
    }

    /**
     * 根据用户输入的验证码进行校验：手机
     * @param mobile           用户手机号
     * @param verificationCode 验证码
     * @return
     */
    @Override
    public Result<Boolean> checkMobileVerificationCode(String mobile, String verificationCode) {
        Result<Boolean> result = new Result<>();
        AccountVerification verification = verificationRepository.findByMobile(mobile);
        if (ResultCheckUtil.isNull(verification)) {
            logger.info("the verification is not found by mobile：{}", mobile);
            //找不到验证码
            result.fail(new BusinessException(ExceptionCodeEnum.VERIFICATION_NOT_FOUND));
            return result;
        }
        checkVerificationCode(verification, result, verificationCode);
        return result;
    }

    /**
     * 图片验证码比较
     *
     * @param accountId        用户编号
     * @param verificationCode 验证码
     * @return
     */
    @Override
    public Result<Boolean> checkVerificationImageCode(Integer accountId, String verificationCode) {
        Result<Boolean> result = new Result<>();
        AccountVerification verification = verificationRepository.findByAccountId(accountId);
        if (ResultCheckUtil.isNull(verification)) {
            logger.info("the verification is not found by accountId：{}", accountId);
            //找不到验证码
            result.fail(new BusinessException(ExceptionCodeEnum.VERIFICATION_NOT_FOUND));
            return result;
        }
        checkVerificationCode(verification, result, verificationCode);
        return result;
    }

    /**
     * 忽略大小写图片验证码进行比较
     * @param accountId        用户账号
     * @param verificationCode 验证码
     * @return
     */
    @Override
    public Result<Boolean> checkVerificationImageCodeIgnoreCase(Integer accountId, String verificationCode) {
        Result<Boolean> result = new Result<>();
        AccountVerification verification = verificationRepository.findByAccountId(accountId);
        if (ResultCheckUtil.isNull(verification)) {
            logger.info("the verification is not found by accountId：{}", accountId);
            //找不到验证码
            result.fail(new BusinessException(ExceptionCodeEnum.VERIFICATION_NOT_FOUND));
            return result;
        }
        //全部变为大写进行比较
        verificationCode = verificationCode.toUpperCase();
        verification.setVerificationCode(verification.getVerificationCode().toUpperCase());
        checkVerificationCode(verification, result, verificationCode);
        return result;
    }

    /**
     * 内部方法，进行验证码的校验和确认
     * 另外关于如果错误次数超过三次就需要请求验证码，暂时每天不做上限，之后可以修正为有上限，上限后冻结
     *
     * @param verification     验证码对象
     * @param result           结果对象
     * @param verificationCode 用户输入的验证码
     * @return
     */
    private Result<Boolean> checkVerificationCode(AccountVerification verification,
                                                  Result<Boolean> result,
                                                  String verificationCode) {
        if (verification.getInvalidTime().toEpochMilli() > Instant.now().toEpochMilli()) {
            //时间超时
            logger.info("the verification is overtime");
            result.fail(new BusinessException(ExceptionCodeEnum.VERIFICATION_ERROR_OVERTIME));
            verification.setVerificationState(VerificationStateEnum.STATE_OVERTIME.getState());
            verificationRepository.updateVerificationState(verification);
            return result;
        }
        //输入的验证码不正确，将次数加一
        if (!ResultCheckUtil.isEqual(verification.getVerificationCode(), verificationCode)) {
            //将错误次数加1，如果加一之后上限，就需要重新请求验证码
            verification.setErrorInput(verification.getErrorInput() + 1);
            if (verification.getErrorInput() > 3) {
                logger.info("the verification input is wrong:{},the verification error number is to max:{}", verification.getVerificationCode(), 3);
                verification.setVerificationState(VerificationStateEnum.STATE_ERROR_MAX.getState());
                result.fail(new BusinessException(ExceptionCodeEnum.VERIFICATION_ERROR_INPUT_MAX));
            } else {
                logger.info("the verification input is wrong:{},the verification error number now is {}", verification.getVerificationCode(), verification.getErrorInput());
                result.fail(new BusinessException(ExceptionCodeEnum.VERIFICATION_ERROR_INPUT));
            }
            return result;
        }
        //更新验证码状态
        logger.info("the verification input is correct :{}", verification.getVerificationCode());
        verification.setVerificationState(VerificationStateEnum.STATE_VALID.getState());
        verificationRepository.updateVerificationState(verification);
        return result;
    }


//    /**
//     * 验证用户输入的验证码
//     * @param imageCode 用户输入的验证码
//     * @param verificationCode 验证码
//     * @return
//     */
//    @Override
//    public VerificationCodeResult checkVerificationCode(String imageCode, String verificationCode) {
//        VerificationCodeResult result=null;
//        if (DataVerifyUtil.isNullOrEmptyString(imageCode)){
//            result=new VerificationCodeResult<>(false, VerificationErrorEnum.ERROR_CODE_EMPTY);
//            return result;
//        }
//        if(DataVerifyUtil.isNull(verificationCode)){
//            result=new VerificationCodeResult<>(false, VerificationErrorEnum.ERROR_ORIGIN_CODE_NULL);
//            return result;
//        }
//        if(verificationCode.equals(imageCode.trim())){
//            result=new VerificationCodeResult<Boolean>(true);
//            return result;
//        }
//        return null;
//    }
//
//    /**
//     * 忽略大小写的验证
//     * @param imageCode        用户输入的验证码
//     * @param verificationCode 验证码
//     * @return
//     */
//    @Override
//    public VerificationCodeResult checkVerificationCodeIgnoreCase(String imageCode, String verificationCode){
//        return checkVerificationCode(imageCode,verificationCode);
//    }
//    /**
//     * 获取一个固定长度的数字验证码
//     * 当位数不满足的时候前方用0进行填充
//     * @param length 验证码的长度
//     * @return
//     */
//    private String getRandomNumber(int length){
//        String code = new Random().nextInt(999999)+"";
//        StringBuilder builder = new StringBuilder("");
//        for (int i=code.length();i<length;i++){
//            builder.append("0");
//        }
//        builder.append(code);
//        return builder.toString();
//    }
//
}
