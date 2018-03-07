package com.unisys.training.po;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Route {
    private int id;
    private String airp_code;
    private String domsintl_code;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date arrival_date_time;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date departure_date_time;
    private int step_number;
    private int flight_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirp_Code() {
        return airp_code;
    }

    public void setAirp_Code(String airp_code) {
        this.airp_code = airp_code;
    }

    public String getDomsintl_code() {
        return domsintl_code;
    }

    public void setDomsintl_code(String domsintl_code) {
        this.domsintl_code = domsintl_code;
    }

    public Date getArrival_date_time() {
        return arrival_date_time;
    }

    public void setArrival_date_time(Date arrival_date_time) {
        this.arrival_date_time = arrival_date_time;
    }

    public Date getDeparture_date_time() {
        return departure_date_time;
    }

    public void setDeparture_date_time(Date departure_date_time) {
        this.departure_date_time = departure_date_time;
    }

    public int getStep_number() {
        return step_number;
    }

    public void setStep_number(int step_number) {
        this.step_number = step_number;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public Route() {
    }

    public Route(String airp_Code, String domsintl_code, Date arrival_date_time, Date departure_date_time, int step_number, int flight_id) {
        this.airp_code = airp_Code;
        this.domsintl_code = domsintl_code;
        this.arrival_date_time = arrival_date_time;
        this.departure_date_time = departure_date_time;
        this.step_number = step_number;
        this.flight_id = flight_id;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", airp_Code='" + airp_code + '\'' +
                ", domsintl_code='" + domsintl_code + '\'' +
                ", arrival_date_time=" + arrival_date_time +
                ", departure_date_time=" + departure_date_time +
                ", step_number=" + step_number +
                ", flight_id=" + flight_id +
                '}';
    }
}
