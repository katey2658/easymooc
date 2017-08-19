package com.busyzero.easyoj.controller;

import com.busyzero.easyoj.dto.VerificationCodeResult;
import com.busyzero.easyoj.dto.VerificationCodeDto;
import com.busyzero.easyoj.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 验证码控制器
 * 提供图片验证码,邮箱验证码，短信验证码
 * @author katey2658
 */
@Controller
@RequestMapping("/verification")
public class VerificationCodeController {
    private static final String KEY_VERFICATION_CODE="verificationCode";

    /**验证码服务提供对象*/
    @Autowired
    private VerificationCodeService verificationCodeService;

    /**
     * 请求一个图片验证码
     * @param request
     * @param response
     */
    @RequestMapping(value = "/imgCode",method = RequestMethod.GET)
    public void requestImageCode(HttpServletRequest request,
                                 HttpServletResponse response){
        VerificationCodeResult<VerificationCodeDto> result=verificationCodeService.getVerificationImage();
        HttpSession session=request.getSession();
        //将验证码放置在会话对象中
        session.setAttribute(KEY_VERFICATION_CODE,result.getSuccessObj().getVerificationCode());
        try {
            //输出验证图像
            ImageIO.write(result.getSuccessObj().getImage(),"PNG",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证码检验
     * @param request
     * @param imageCode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/imageCode",method = RequestMethod.POST)
    public VerificationCodeResult requestImageCodeCheck(HttpServletRequest request,
                                                        String imageCode){
        String verificationCode = (String) request.getSession().getAttribute(KEY_VERFICATION_CODE);
        VerificationCodeResult result = verificationCodeService.checkVerificationCodeIgnoreCase(imageCode,verificationCode);
        return result;
    }
}
