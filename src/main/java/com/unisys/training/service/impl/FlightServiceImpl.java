package com.unisys.training.service.impl;

import com.unisys.training.dao.FlightDao;
import com.unisys.training.po.Flight;
import com.unisys.training.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightDao flightDao;

    @Override
    public int FlightInsert(Flight flight) {
        return flightDao.FlightInsert(flight);
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
