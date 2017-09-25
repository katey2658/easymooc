package com.busyzero.easyoj.controller;

import com.busyzero.easyoj.config.security.AuthService;
import com.busyzero.easyoj.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * 进行授权测试
 * @author 11456
 */
@RestController
public class AuthController {
    /**服务对象*/
    @Value("${jwt.header}")
    private String tokenHeader;

    /**授权服务*/
    @Autowired
    private AuthService authService;

    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {
        final String token = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException{
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if(refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }

    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
    public Account register(@RequestBody Account addedUser) throws AuthenticationException{
        return authService.register(addedUser);
    }

    public class JwtAuthenticationResponse implements Serializable {
        private static final long serialVersionUID = 1250166508152483573L;

        private final String token;

        public JwtAuthenticationResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return this.token;
        }
    }
    public class  JwtAuthenticationRequest implements Serializable {
        private static final long serialVersionUID = -8445943548965154778L;

        private String username;
        private String password;

        public JwtAuthenticationRequest() {
            super();
        }

        public JwtAuthenticationRequest(String username, String password) {
            this.setUsername(username);
            this.setPassword(password);
        }

        public String getUsername() {
            return this.username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return this.password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
