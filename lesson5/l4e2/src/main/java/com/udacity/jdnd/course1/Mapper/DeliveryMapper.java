package com.udacity.jdnd.course1.Mapper;

import com.udacity.jdnd.course1.data.Delivery;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DeliveryMapper {
    @Select("select * from Delivery where id = #{id}")
    Delivery findDelivery(Integer id);

    @Insert("insert into Delivery(orderId,time) values(#{orderId},#{time})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Delivery delivery);

    @Delete("delete from Delivery where id = #{id}")
    void delete(Integer id);
}
