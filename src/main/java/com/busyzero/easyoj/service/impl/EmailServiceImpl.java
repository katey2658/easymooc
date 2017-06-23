package com.busyzero.easyoj.service.impl;

import com.busyzero.easyoj.service.EmailService;
import org.springframework.stereotype.Service;

/**
 * Created by 11456 on 2017/6/23.
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public int emailAddressSignUp(String username, String emailAddress) {
        return 0;
    }

    @Override
    public int passwordForgot(String username, String emailAddress) {
        return 0;
    }
}
