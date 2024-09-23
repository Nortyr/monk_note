package com.mountain.monk;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MonkMapper {

    @Insert("INSERT INTO `test`.`monk` (`name`, `age`, `email`, `city`, `test`) VALUES ('User22232000', 78, 'user30000@example.com', 'City', NULL)")
    public int insertData();
}