package com.unisys.training.controller;

import com.alibaba.fastjson.JSONObject;
import com.unisys.training.po.Flight;
import com.unisys.training.po.Route;
import com.unisys.training.service.FlightService;
import com.unisys.training.service.RouteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FlightController {
    @Autowired
    FlightService flightService;
    @Autowired
    RouteService RouteService;

    private static final int SUCCEED = 1;
    private static final int FAILED = 0;

    //Static date formatter
    private static final SimpleDateFormat date_formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    private final Logger logger = LoggerFactory.getLogger(FlightController.class);

    @RequestMapping("/flight/insert")
    private Object flightInsert(HttpServletRequest req) {
        int result = 0;
        String airl_code = req.getParameter("airl_code");
        String flt_number = req.getParameter("flt_number");
        String schd_date_time = req.getParameter("schd_date_time") == null ? "" : req.getParameter("schd_date_time");
        String arrvdept = req.getParameter("arrvdept");
        String acfttype = req.getParameter("acfttype");
        String flgttype = req.getParameter("flgttype");
        String reno = req.getParameter("reno");
        String domsintl = req.getParameter("domsintl");
        String actual_date_time = req.getParameter("actual_date_time") == null ? ""
                : req.getParameter("actual_date_time");
        String estimated_date_time = req.getParameter("estimated_date_time") == null ? ""
                : req.getParameter("estimated_date_time");
        String user_code = req.getParameter("user_code");
        String terminal_code = req.getParameter("terminal_code");
        String dep_airp_code = req.getParameter("dep_airp_code");
        String dep_domsintl_code = "D";
        String departure_date_time = req.getParameter("departure_date_time") == null ? ""
                : req.getParameter("departure_date_time");
        String arr_airp_code = req.getParameter("arr_airp_code");
        String arr_domsintl_code = "D";
        String arrival_date_time = req.getParameter("arrival_date_time") == null ? ""
                : req.getParameter("arrival_date_time");

        // prepare flight to be inserted
        Flight newFlight = null;
        try {
            if (schd_date_time.contains("T")) {
                schd_date_time = schd_date_time.replace("T", " ");
            }
            if (actual_date_time.contains("T")) {
                actual_date_time = actual_date_time.replace("T", " ");
            }
            if (estimated_date_time.contains("T")) {
                estimated_date_time = estimated_date_time.replace("T", " ");
            }
            newFlight = new Flight(airl_code, flt_number, date_formatter.parse(schd_date_time), arrvdept, acfttype,
                    flgttype, reno, domsintl, actual_date_time == "" ? null : date_formatter.parse(actual_date_time),
                    estimated_date_time == "" ? null : date_formatter.parse(estimated_date_time), user_code,
                    terminal_code);
        } catch (ParseException e) {
            logger.error("Flight date format error!", e);
            return FAILED;
        }

        // prepare routes
        Route routeDep = null;
        Route routeArr = null;
        try {
            if (departure_date_time.contains("T")) {
                departure_date_time = departure_date_time.replace("T", " ");
            }
            if (arrival_date_time.contains("T")) {
                arrival_date_time = arrival_date_time.replace("T", " ");
            }
            routeDep = new Route(dep_airp_code, dep_domsintl_code, null, date_formatter.parse(departure_date_time), 0,
                    0);
            routeArr = new Route(arr_airp_code, arr_domsintl_code, date_formatter.parse(arrival_date_time), null, 1, 0);
            List<Route> routes = new ArrayList<Route>();
            routes.add(routeDep);
            routes.add(routeArr);
            newFlight.setRoutes(routes);
        } catch (ParseException e) {
            e.printStackTrace();
            logger.error("Failed to create routes!", e);
            return FAILED;
        }

        // insert flight into DB
        if (newFlight != null && newFlight.getRoutes().size() >= 2) {
            try {
                result = flightService.FlightInsert(newFlight);
            } catch (Exception e) {
                logger.error("Failed to insert flight!", e);
                return FAILED;
            }
        }

        return result;
    }

    @RequestMapping("/flight/update")
    private Object flightUpdate(HttpServletRequest req) {
        String id = req.getParameter("id");
        String airl_code = req.getParameter("airl_code");
        String flt_number = req.getParameter("flt_number");
        String schd_date_time = req.getParameter("schd_date_time");
        String arrvdept = req.getParameter("arrvdept");
        String acfttype = req.getParameter("acfttype");
        String flgttype = req.getParameter("flgttype");
        String reno = req.getParameter("reno");
        String domsintl = req.getParameter("domsintl");
        String actual_date_time = req.getParameter("actual_date_time");
        String estimated_date_time = req.getParameter("estimated_date_time");
        String user_code = req.getParameter("user_code");
        String terminal_code = req.getParameter("terminal_code");

        Flight updFlight = null;
        try {
            updFlight = new Flight(
                    airl_code,
                    flt_number,
                    date_formatter.parse(schd_date_time),
                    arrvdept,
                    acfttype,
                    flgttype,
                    reno,
                    domsintl,
                    actual_date_time == null ? null : date_formatter.parse(actual_date_time),
                    estimated_date_time == null ? null : date_formatter.parse(estimated_date_time),
                    user_code,
                    terminal_code
            );
            updFlight.setId(Integer.parseInt(id));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int result = 0;
        if (updFlight != null) {
            result = flightService.FlightUpdate(updFlight);
        }
        return result;
    }

    @RequestMapping("/flight/deleteById")
    private Object flightDeleteById(HttpServletRequest req) {
        String id = req.getParameter("id");
        return flightService.FlightDelete(Integer.parseInt(id));
    }

    @RequestMapping("/flight/selectOne")
    private Object flightSelectOne(HttpServletRequest req) {
        String id = req.getParameter("id");
        Flight flight = new Flight();
        flight.setId(Integer.parseInt(id));
        logger.info(id);
        String returnString = JSONObject.toJSONString(flightService.FlightSelectOne(flight));
        logger.debug("[flight/SelectOne] result:" + returnString);
        return returnString;
    }

    @RequestMapping("/flight/selectAll")
    private Object flightSelectAll(HttpServletRequest req) {
        String offset = req.getParameter("offset");
        String limit = req.getParameter("limit");
        logger.info(offset + limit);
//        return JSONObject.toJSONString(flightService.FlightSelectAll(Integer.parseInt(whichPage),Integer.parseInt(limit)));
        int total = flightService.FlightCount();
        List<Flight> flights = flightService.FlightSelectAll(Integer.parseInt(offset), Integer.parseInt(limit));

        JSONObject json = new JSONObject(true);
        json.put("rows", flights);
        json.put("total", total);
        
        String returnString = json.toJSONString();
        logger.debug("[flight/SelectAll] result:" + returnString);
        return returnString;
    }

}
