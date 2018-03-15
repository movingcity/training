package com.unisys.training.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
	private static final Integer SUCCEED = 1;
	private static final Integer FAILED = 0;

	@RequestMapping(value = "/login")
	public Object login(HttpServletRequest req) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(req.getParameter("username"),
				req.getParameter("password"));
		try {
			System.out.println("1");
			subject.login(token);

			System.out.println("2");
			return SUCCEED;
		} catch (Exception e) {
			return FAILED;
		}
	}

	@RequestMapping(value = "/unauth")
	public Object unauth() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "-1");
		map.put("msg", "未登录");
		return map;
	}
}
