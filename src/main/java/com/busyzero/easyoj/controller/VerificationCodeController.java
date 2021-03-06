package com.busyzero.easyoj.controller;

import com.busyzero.easyoj.commons.result.ResultVO;
import com.busyzero.easyoj.service.VerificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 验证码控制器
 * 提供图片验证码,邮箱验证码，短信验证码
 * @author katey2658
 */
@Controller
@RequestMapping("/verification")
public class VerificationCodeController {
    private Logger logger = LoggerFactory.getLogger(VerificationCodeController.class);

    /**验证码在缓存中key*/
    private static final String KEY_VERFICATION_CODE = "verificationCode";

    /**验证码服务提供对象*/
    @Autowired
    private VerificationService verificationCodeService;

    /**
     * 请求一个图片验证码
     * @param request
     * @param response
     */
    @RequestMapping(value = "/imgCode",method = RequestMethod.GET)
    public void requestImageCode(HttpServletRequest request,
                                 HttpServletResponse response){
        ResultVO<BufferedImage> result=verificationCodeService.getVerificationImage(4);
        /*
        //放弃这个方案，因为会采用集群方案，session 不一定在那一个机器上，所以还是暂时先存入数据库中
        HttpSession session=request.getSession();
        //将验证码放置在会话对象中
        session.setAttribute(KEY_VERFICATION_CODE,result.getSuccessObj().getVerificationCode());
        */
        try {
            //输出验证图像
            ImageIO.write(result.getResultObj(),"PNG",response.getOutputStream());
        } catch (IOException e) {
            logger.debug("the error message is :{}",e.getMessage());
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
    public ResultVO<Boolean> requestImageCodeCheck(HttpServletRequest request,
                                                   String imageCode){
        String verificationCode = (String) request.getSession().getAttribute(KEY_VERFICATION_CODE);
        ResultVO<Boolean> result = verificationCodeService.checkVerificationImageCode(1111,verificationCode);
        return result;
    }
}
