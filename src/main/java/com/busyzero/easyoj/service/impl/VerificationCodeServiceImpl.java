package com.busyzero.easyoj.service.impl;

import com.busyzero.easyoj.dto.VerificationCodeResult;
import com.busyzero.easyoj.dto.VerificationCodeDto;
import com.busyzero.easyoj.enums.VerificationErrorEnum;
import com.busyzero.easyoj.service.VerificationCodeService;
import com.busyzero.easyoj.utils.DataVerifyUtil;
import com.busyzero.easyoj.utils.VerificationCodeUtil;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 提供验证码服务
 * @author katey2658
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    /**
     * 获取图像验证码
     * @return
     */
    @Override
    public VerificationCodeResult getVerificationImage() {
        //调用工具类获取对应验证码
        String checkCode = VerificationCodeUtil.getVerificationCode();
        final int width = 80;
        final int height = 30;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //获取一个画笔
        Graphics g = image.getGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0,0,width,height);
        //随机设置3条干扰线
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), r.nextInt(80));
        }

        //设置验证码字符串的颜色
        g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
        g.setFont(new Font("黑体", Font.BOLD,24));
        g.drawString(checkCode,15,20);
        return new VerificationCodeResult<>(new VerificationCodeDto(checkCode,image));
    }

    /**
     * 验证用户输入的验证码
     * @param imageCode 用户输入的验证码
     * @param verificationCode 验证码
     * @return
     */
    @Override
    public VerificationCodeResult checkVerificationCode(String imageCode, String verificationCode) {
        VerificationCodeResult result=null;
        if (DataVerifyUtil.isNullOrEmptyString(imageCode)){
            result=new VerificationCodeResult<>(false, VerificationErrorEnum.ERROR_CODE_EMPTY);
            return result;
        }
        if(DataVerifyUtil.isNull(verificationCode)){
            result=new VerificationCodeResult<>(false, VerificationErrorEnum.ERROR_ORIGIN_CODE_NULL);
            return result;
        }
        if(verificationCode.equals(imageCode.trim())){
            result=new VerificationCodeResult<Boolean>(true);
            return result;
        }
        return null;
    }

    /**
     * 忽略大小写的验证
     * @param imageCode        用户输入的验证码
     * @param verificationCode 验证码
     * @return
     */
    @Override
    public VerificationCodeResult checkVerificationCodeIgnoreCase(String imageCode, String verificationCode){
        return checkVerificationCode(imageCode,verificationCode);
    }
}
