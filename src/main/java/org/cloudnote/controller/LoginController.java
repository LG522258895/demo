package org.cloudnote.controller;

import org.cloudnote.core.exception.OMException;
import org.cloudnote.core.logger.LoggerUtils;
import org.cloudnote.entity.User;
import org.cloudnote.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {
	//private static LoggerUtils logger = LoggerUtils.getLogger(LoginController.class);
	
	@Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public String login(String name,String password) throws OMException {
        User user = new User();
        user.setCn_user_name(name);
        user.setCn_user_password(password);
        String result = userService.userLogin(user);
        return result;
    }
}
