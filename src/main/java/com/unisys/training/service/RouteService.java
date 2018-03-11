package com.unisys.training.service;

import com.unisys.training.po.Route;

import java.util.List;

public interface RouteService {
    public int RouteInsert(Route route);
    public int RouteDelete(int id);
    public int RouteDeleteByFlightId(int flightId);
    public int RouteUpdate(Route route);
    public Route RouteSelectOne(Route route);
    public List<Route> RouteSelectByFlight(int flight_id);
}
