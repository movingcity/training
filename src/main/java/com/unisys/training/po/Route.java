package com.unisys.training.po;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Route {
    private int id;
    private String airpCode;
    private String dOrI;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date arrTime;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date depTime;
    private int stepNum;
    private int flightId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirpCode() {
        return airpCode;
    }

    public void setAirpCode(String airpCode) {
        this.airpCode = airpCode;
    }

    public String getdOrI() {
        return dOrI;
    }

    public void setdOrI(String dOrI) {
        this.dOrI = dOrI;
    }

    public Date getArrTime() {
        return arrTime;
    }

    public void setArrTime(Date arrTime) {
        this.arrTime = arrTime;
    }

    public Date getDepTime() {
        return depTime;
    }

    public void setDepTime(Date depTime) {
        this.depTime = depTime;
    }

    public int getStepNum() {
        return stepNum;
    }

    public void setStepNum(int stepNum) {
        this.stepNum = stepNum;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Route() {
    }

    public Route(String airpCode, String dOrI, Date arrTime, Date depTime, int stepNum, int flightId) {
        this.airpCode = airpCode;
        this.dOrI = dOrI;
        this.arrTime = arrTime;
        this.depTime = depTime;
        this.stepNum = stepNum;
        this.flightId = flightId;
    }

    @Override
    public String toString() {
        return "RouteDao{" +
                "id=" + id +
                ", airpCode='" + airpCode + '\'' +
                ", dOrI='" + dOrI + '\'' +
                ", arrTime=" + arrTime +
                ", depTime=" + depTime +
                ", stepNum=" + stepNum +
                ", flightId=" + flightId +
                '}';
    }
}
