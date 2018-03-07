package com.unisys.training.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RouteController {
    @RequestMapping("/route/insert")
    private Object flightInsert(HttpServletRequest req) {
        return null;
    }

    @RequestMapping("/route/update")
    private Object flightUpdate(HttpServletRequest req) {
        return null;
    }

    @RequestMapping("/route/delete")
    private Object flightDelete(HttpServletRequest req) {
        return null;
    }

    @RequestMapping("/route/selectOne")
    private Object flightSelectOne(HttpServletRequest req) {
        return null;
    }

    @RequestMapping("/route/selectAllForFlight")
    private Object flightSelectAllForFlight(HttpServletRequest req) {
        return null;
    }
}
