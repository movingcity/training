package com.unisys.training.dao;

import com.unisys.training.po.Flight;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface FlightDao {
    @Insert("INSERT INTO flight (id, airl_code, flt_number, schd_date_time, arrvdept, acfttype," +
            " flgttype, reno, domsintl, actual_date_time, estimated_date_time, user_code, terminal_code) VALUES (" +
            "#{id}, #{airl_code}, #{flt_number}, #{schd_date_time}, #{arrvdept}, #{acfttype}," +
            "#{flgttype}, #{reno}, #{domsintl}, #{actual_date_time}, #{estimated_date_time}, " +
            "#{user_code}, #{terminal_code})")
    public int FlightInsert(Flight flight);

    @Delete("delete from flight where id = #{id} limit 1")
    public int FlightDelete(int id);

    @Update("UPDATE flight SET airl_code=#{airl_code}, flt_number=#{flt_number}, schd_date_time=#{schd_date_time}, " +
            "arrvdept=#{arrvdept}, acfttype=#{acfttype}, flgttype=#{flgttype}, reno=#{reno}, domsintl=#{domsintl}, " +
            "actual_date_time=#{actual_date_time}, estimated_date_time=#{estimated_date_time}, user_code=#{user_code}, " +
            "terminal_code=#{terminal_code} WHERE id=#{id} limit 1")
    public int FlightUpdate(Flight flight);

    @Select("select * from flight where id = #{id} limit 1")
    public Flight FlightSelectOne(Flight flight);

    @Select("select * from flight order by id desc limit #{whichNum},10")
    public List<Flight> FlightSelectAll(int whichNum);
}
