package com.mountain.monk;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    @Insert(" INSERT INTO `test` ( `name`) VALUES ('zhangsan');")
    void insertTest();
}
