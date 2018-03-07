package com.unisys.training.dao;

import com.unisys.training.po.Flight;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FlightDao {
    @Insert("INSERT INTO flight (id, airl_code, flt_number, schd_date_time, arrvdept, acfttype," +
            " flgttype, reno, domsintl, actual_date_time, estimated_date_time, user_code, terminal_code) VALUES (" +
            "#{id}, #{airl_code}, #{flt_number}, #{schd_date_time}, #{arrvdept}, #{acfttype}," +
            "#{flgttype}, #{reno}, #{domsintl}, #{actual_date_time}, #{estimated_date_time}, " +
            "#{user_code}, #{terminal_code})")
    public int CalendarInsert(Flight flight);

    @Delete("delete from flight where id = #{id} limit 1")
    public int CalendarDelete(int id);

    @Update("update flight set title=#{title}, importance = #{importance}, " +
            "finishDate = #{finishDate} where id = #{id} limit 1")
    public int CalendarUpdate(Flight flight);

    @Select("select * from flight where id = #{id} limit 1")
    public Flight CalendarSelectOne(Flight flight);

    @Select("select * from flight order by id desc limit #{whichNum},10")
    public List<Flight> CalendarSelectAll(int whichNum);
}
