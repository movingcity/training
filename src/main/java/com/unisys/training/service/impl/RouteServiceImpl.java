package com.unisys.training.service.impl;

import com.unisys.training.dao.RouteDao;
import com.unisys.training.po.Route;
import com.unisys.training.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService{
    @Autowired
    private RouteDao routeDao;

    @Override
    public int RouteInsert(Route route) {
        return routeDao.RouteInsert(route);
    }

    @Override
    public int RouteDelete(int id) {
        return routeDao.RouteDelete(id);
    }

    @Override
    public int RouteUpdate(Route route) {
        return routeDao.RouteUpdate(route);
    }

    @Override
    public Route RouteSelectOne(Route route) {
        return routeDao.RouteSelectOne(route);
    }

    @Override
    public List<Route> RouteSelectByFlight(int flight_id) {
                return routeDao.RouteSelectByFlight(flight_id);
    }

}
