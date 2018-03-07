package com.unisys.training.controller;

import com.alibaba.fastjson.JSONObject;
import com.unisys.training.po.Flight;
import com.unisys.training.po.Route;
import com.unisys.training.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
public class RouteController {
    @Autowired
    RouteService routeService;

    //Static date formatter
    private static final SimpleDateFormat date_formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @RequestMapping("/route/insert")
    private Object routeInsert(HttpServletRequest req) {
        String airpCode = req.getParameter("airp_code");
        String dOrI = req.getParameter("domsintl_code");
        String arrTime = req.getParameter("arrival_date_time");
        String depTime = req.getParameter("departure_date_time");
        String stepNum = req.getParameter("step_number");
        String flightId = req.getParameter("flight_id");

        Route newRoute = null;
        try {
            newRoute = new Route(
                    airpCode,
                    dOrI,
                    arrTime==null?null:date_formatter.parse(arrTime),
                    depTime==null?null:date_formatter.parse(depTime),
                    Integer.parseInt(stepNum),
                    Integer.parseInt(flightId)
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int result = 0;
        if(newRoute != null) {
            result = routeService.RouteInsert(newRoute);
        }
        return result;
    }

    @RequestMapping("/route/update")
    private Object routeUpdate(HttpServletRequest req) {
        String id = req.getParameter("id");
        String airpCode = req.getParameter("airp_code");
        String dOrI = req.getParameter("domsintl_code");
        String arrTime = req.getParameter("arrival_date_time");
        String depTime = req.getParameter("departure_date_time");
        String stepNum = req.getParameter("step_number");
        String flightId = req.getParameter("flight_id");

        Route updRoute = null;
        try {
            updRoute = new Route(
                    airpCode,
                    dOrI,
                    arrTime==null?null:date_formatter.parse(arrTime),
                    depTime==null?null:date_formatter.parse(depTime),
                    Integer.parseInt(stepNum),
                    Integer.parseInt(flightId)
            );
            updRoute.setId(Integer.parseInt(id));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int result = 0;
        if(updRoute != null) {
            result = routeService.RouteUpdate(updRoute);
        }
        return result;
    }

    @RequestMapping("/route/deleteById")
    private Object routeDelete(HttpServletRequest req) {
        String id = req.getParameter("id");
        return routeService.RouteDelete(Integer.parseInt(id));
    }

    @RequestMapping("/route/selectOne")
    private Object routeSelectOne(HttpServletRequest req) {
        String id = req.getParameter("id");
        Route route = new Route();
        route.setId(Integer.parseInt(id));
        return JSONObject.toJSONString(routeService.RouteSelectOne(route));
    }

    @RequestMapping("/route/selectByFlight")
    private Object routeSelectByFlight(HttpServletRequest req) {
        String flightId = req.getParameter("flight_id");
        return JSONObject.toJSONString(routeService.RouteSelectByFlight(Integer.parseInt(flightId)));
    }
}
