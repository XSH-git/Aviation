package com.yg.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface AllRowMapper<T> {

    public  T getRow(ResultSet resultSet) throws SQLException;
}
