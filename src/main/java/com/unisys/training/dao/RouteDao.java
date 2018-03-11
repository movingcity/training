package com.unisys.training.dao;

import com.unisys.training.po.Route;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface RouteDao {
    @Insert("INSERT INTO flight_route (id,airp_code,domsintl_code,arrival_date_time,departure_date_time,"+
    "step_number,flight_id) VALUES(#{id},#{airp_code},#{domsintl_code},#{arrival_date_time}," +
    "#{departure_date_time},#{step_number},#{flight_id})")
    public int RouteInsert(Route route);

    @Delete("DELETE FROM flight_route WHERE id = #{id} limit 1")
    public int RouteDelete(int id);

    @Delete("DELETE FROM flight_route WHERE flight_Id = #{flightId}")
    public int RouteDeleteByFlightId(int flightId);

    @Update("UPDATE flight_route SET airp_code=#{airp_code},domsintl_code=#{domsintl_code},"+
    "arrival_date_time=#{arrival_date_time},departure_date_time=#{departure_date_time},"+
    "step_number=#{step_number} WHERE id=#{id} limit 1")
    public int RouteUpdate(Route route);

    @Select("SELECT * FROM flight_route WHERE id = #{id} limit 1")
    public Route RouteSelectOne(Route route);

    @Select("SELECT * FROM flight_route WHERE flight_id=#{flight_id} ORDER BY id")
    public List<Route> RouteSelectByFlight(int flight_id);

}
