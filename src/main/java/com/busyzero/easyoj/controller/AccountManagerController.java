package com.busyzero.easyoj.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 账户信息管理
 * 只有站点管理员才可以
 * @author 11456
 */
@Controller
@RequestMapping("/manager")
@PreAuthorize("hasRole('WEBMASTER')")
public class AccountManagerController {

}
