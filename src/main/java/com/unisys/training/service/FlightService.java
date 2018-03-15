package com.unisys.training.service;

import com.unisys.training.po.Flight;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;

public interface FlightService {
    public int FlightInsert(Flight flight);
    public int FlightDelete(int id);
    public int FlightUpdate(Flight flight);
    public Flight FlightSelectOne(Flight flight);
    public List<Flight> FlightSelectAll(int offset, int limit);
    public int FlightCount();
}
