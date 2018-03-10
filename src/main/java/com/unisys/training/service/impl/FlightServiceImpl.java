package com.unisys.training.service.impl;

import com.unisys.training.dao.FlightDao;
import com.unisys.training.dao.RouteDao;
import com.unisys.training.po.Flight;
import com.unisys.training.po.Route;
import com.unisys.training.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightDao flightDao;
    @Autowired
    private RouteDao routeDao;

    @Override
    public int FlightInsert(Flight flight) {
    	int result = flightDao.FlightInsert(flight);
    	if (result == 0) {
    		throw new RuntimeException("Flight insert failed.");
    	}
		if(flight.getId()<=0) {
			throw new RuntimeException("Failed to get flight ID.");
		}
		
		// insert route
    	for(Iterator<Route> it=flight.getRoutes().iterator();it.hasNext();) {
    		Route route = it.next();
    		// provide flight id before insert
    		route.setFlight_id(flight.getId());
    		result = routeDao.RouteInsert(route);
    		if (result == 0) {
        		throw new RuntimeException("Flight's route insert failed.");
        	}
    	}
    	
        return result;
    }

    @Override
    public int FlightDelete(int id) {
        return flightDao.FlightDelete(id);
    }

    @Override
    public int FlightUpdate(Flight flight) {
        return flightDao.FlightUpdate(flight);
    }

    @Override
    public Flight FlightSelectOne(Flight flight) {
        return flightDao.FlightSelectOne(flight);
    }

    @Override
    public List<Flight> FlightSelectAll(int whichPage) {
        whichPage = whichPage < 1 ? 1 : whichPage;
        return flightDao.FlightSelectAll((whichPage - 1) * 10);
    }
}
