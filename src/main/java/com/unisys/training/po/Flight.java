package com.unisys.training.po;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Flight {
    private int id;
    private String airl_code;
    private String flt_number;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date schd_date_time;
    private String arrvdept;
    private String acfttype;
    private String flgttype;
    private String reno;
    private String domsintl;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date actual_date_time;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date estimated_date_time;
    private String user_code;
    private String terminal_code;

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", airl_code='" + airl_code + '\'' +
                ", flt_number='" + flt_number + '\'' +
                ", schd_date_time=" + schd_date_time +
                ", arrvdept='" + arrvdept + '\'' +
                ", acfttype='" + acfttype + '\'' +
                ", flgttype='" + flgttype + '\'' +
                ", reno='" + reno + '\'' +
                ", domsintl='" + domsintl + '\'' +
                ", actual_date_time=" + actual_date_time +
                ", estimated_date_time=" + estimated_date_time +
                ", user_code='" + user_code + '\'' +
                ", terminal_code='" + terminal_code + '\'' +
                '}';
    }

    public Flight(int id, String airl_code, String flt_number, Date schd_date_time, String arrvdept, String acfttype, String flgttype, String reno, String domsintl, Date actual_date_time, Date estimated_date_time, String user_code, String terminal_code) {
        this.id = id;
        this.airl_code = airl_code;
        this.flt_number = flt_number;
        this.schd_date_time = schd_date_time;
        this.arrvdept = arrvdept;
        this.acfttype = acfttype;
        this.flgttype = flgttype;
        this.reno = reno;
        this.domsintl = domsintl;
        this.actual_date_time = actual_date_time;
        this.estimated_date_time = estimated_date_time;
        this.user_code = user_code;
        this.terminal_code = terminal_code;
    }

    public Flight() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirl_code() {
        return airl_code;
    }

    public void setAirl_code(String airl_code) {
        this.airl_code = airl_code;
    }

    public String getFlt_number() {
        return flt_number;
    }

    public void setFlt_number(String flt_number) {
        this.flt_number = flt_number;
    }

    public Date getSchd_date_time() {
        return schd_date_time;
    }

    public void setSchd_date_time(Date schd_date_time) {
        this.schd_date_time = schd_date_time;
    }

    public String getArrvdept() {
        return arrvdept;
    }

    public void setArrvdept(String arrvdept) {
        this.arrvdept = arrvdept;
    }

    public String getAcfttype() {
        return acfttype;
    }

    public void setAcfttype(String acfttype) {
        this.acfttype = acfttype;
    }

    public String getFlgttype() {
        return flgttype;
    }

    public void setFlgttype(String flgttype) {
        this.flgttype = flgttype;
    }

    public String getReno() {
        return reno;
    }

    public void setReno(String reno) {
        this.reno = reno;
    }

    public String getDomsintl() {
        return domsintl;
    }

    public void setDomsintl(String domsintl) {
        this.domsintl = domsintl;
    }

    public Date getActual_date_time() {
        return actual_date_time;
    }

    public void setActual_date_time(Date actual_date_time) {
        this.actual_date_time = actual_date_time;
    }

    public Date getEstimated_date_time() {
        return estimated_date_time;
    }

    public void setEstimated_date_time(Date estimated_date_time) {
        this.estimated_date_time = estimated_date_time;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getTerminal_code() {
        return terminal_code;
    }

    public void setTerminal_code(String terminal_code) {
        this.terminal_code = terminal_code;
    }
}
