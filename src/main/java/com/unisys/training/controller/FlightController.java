package com.unisys.training.controller;

import com.alibaba.fastjson.JSONObject;
import com.unisys.training.po.Flight;
import com.unisys.training.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@Transactional
public class FlightController {
    @Autowired
    FlightService flightService;

    //Static date formatter
    private static final SimpleDateFormat date_formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private final Logger logger = LoggerFactory.getLogger(FlightController.class);
    @RequestMapping("/flight/insert")
    private Object flightInsert(HttpServletRequest req) {
        String airl_code = req.getParameter("airl_code");
        String flt_number = req.getParameter("flt_number");
        String schd_date_time = req.getParameter("schd_date_time")==null?"":req.getParameter("schd_date_time");
        String arrvdept = req.getParameter("arrvdept");
        String acfttype = req.getParameter("acfttype");
        String flgttype = req.getParameter("flgttype");
        String reno = req.getParameter("reno");
        String domsintl = req.getParameter("domsintl");
        String actual_date_time = req.getParameter("actual_date_time")==null?"":req.getParameter("actual_date_time");
        String estimated_date_time = req.getParameter("estimated_date_time")==null?"":req.getParameter("estimated_date_time");
        String user_code = req.getParameter("user_code");
        String terminal_code = req.getParameter("terminal_code");
        String dep_airp_code = req.getParameter("dep_airp_code");
        String dep_domsintl_code = req.getParameter("dep_domsintl_code");
        String departure_date_time = req.getParameter("departure_date_time");
        String arr_airp_code = req.getParameter("arr_airp_code");
        String arr_domsintl_code = req.getParameter("arr_domsintl_code");
        String arrival_date_time = req.getParameter("arrival_date_time");

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
            newFlight = new Flight(
                    airl_code,
                    flt_number,
                    date_formatter.parse(schd_date_time),
                    arrvdept,
                    acfttype,
                    flgttype,
                    reno,
                    domsintl,
                    actual_date_time==""?null:date_formatter.parse(actual_date_time),
                    estimated_date_time==""?null:date_formatter.parse(estimated_date_time),
                    user_code,
                    terminal_code
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int result = 0;
        if(newFlight != null) {
            result = flightService.FlightInsert(newFlight);
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
                    actual_date_time==null?null:date_formatter.parse(actual_date_time),
                    estimated_date_time==null?null:date_formatter.parse(estimated_date_time),
                    user_code,
                    terminal_code
            );
            updFlight.setId(Integer.parseInt(id));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int result = 0;
        if(updFlight != null) {
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
        return JSONObject.toJSONString(flightService.FlightSelectOne(flight));
    }

    @RequestMapping("/flight/selectAll")
    private Object flightSelectAll(HttpServletRequest req) {
        String whichPage = req.getParameter("whichNum");
        logger.info(whichPage);
        return JSONObject.toJSONString(flightService.FlightSelectAll(Integer.parseInt(whichPage)));
    }

}
