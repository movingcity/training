package com.unisys.training.controller;

import com.alibaba.fastjson.JSONObject;
import com.unisys.training.po.Flight;
import com.unisys.training.po.Route;
import com.unisys.training.security.po.User;
import com.unisys.training.security.servcie.UserService;
import com.unisys.training.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
public class UserController {
	private static final Integer SUCCEED = 1;
	private static final Integer FAILED = 0;

	@Autowired
	UserService userService;

	@RequestMapping("/user/insert")
	public Object routeInsert(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		User user = new User(username, password);

		user = userService.createUser(user);
		if (user != null) {
			return SUCCEED;
		} else {
			return FAILED;
		}
	}

/*	@RequestMapping("/user/update")
	public Object routeUpdate(HttpServletRequest req) {
		String id = req.getParameter("id");
		String airpCode = req.getParameter("airp_code");
		String dOrI = req.getParameter("domsintl_code");
		String arrTime = req.getParameter("arrival_date_time");
		String depTime = req.getParameter("departure_date_time");
		String stepNum = req.getParameter("step_number");
		String flightId = req.getParameter("flight_id");

		Route updRoute = null;
		try {
			updRoute = new Route(airpCode, dOrI, arrTime == null ? null : date_formatter.parse(arrTime),
					depTime == null ? null : date_formatter.parse(depTime), Integer.parseInt(stepNum),
					Integer.parseInt(flightId));
			updRoute.setId(Integer.parseInt(id));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int result = 0;
		if (updRoute != null) {
			result = routeService.RouteUpdate(updRoute);
		}
		return result;
	}

	@RequestMapping("/user/deleteById")
	public Object routeDelete(HttpServletRequest req) {
		String id = req.getParameter("id");
		return routeService.RouteDelete(Integer.parseInt(id));
	}

	@RequestMapping("/user/selectOne")
	public Object routeSelectOne(HttpServletRequest req) {
		String id = req.getParameter("id");
		Route route = new Route();
		route.setId(Integer.parseInt(id));
		return JSONObject.toJSONString(routeService.RouteSelectOne(route));
	}*/


}
