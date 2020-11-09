package com.yg.utils;

import com.yg.mapper.AllRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoUtils<T> {
    /**
     * 公共的更新
     */
    public  int commonUpdate(String sql,Object... args){
        //1.找公共部分，加载驱动，获取连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = DBUtils.getConnection();
            //2.预编译，编写sql语句
            preparedStatement = connection.prepareStatement(sql);

            //3.占位符个数+参数
            for (int i = 0; i < args.length; i++) {
                //根据传参设定补填的占位符
                preparedStatement.setObject(i+1,args[i]);
            }

            //执行sql语句
            int result = preparedStatement.executeUpdate();
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            DBUtils.closeAll(connection,preparedStatement,null);
        }

        return 0;
    }

    /**
     * 所有Dao层查询工具类   面向所有pojo
     * @param sql
     * @param rowMapper
     * @param args
     * @return
     */
    //使用泛型解决强转问题
    public  List<T> commonQuery(String sql, AllRowMapper<T> rowMapper, Object... args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //兼容所有的查询和所有pojo
        List<T> tlist = new ArrayList<>();

        try{
            //获取数据库连接
            connection = DBUtils.getConnection();
            //预编译
            preparedStatement = connection.prepareStatement(sql);
            System.out.println("DaoUtils-----commonQuery：预编译，获取sql：" + preparedStatement);
            //填充占位符
            if (args != null) {  //因为有时候不需要填充占位符，select * from user
                for (int i = 0 ; i < args.length;i++){
                    preparedStatement.setObject(i+1,args[i]);
                }

            }
            //执行sql
            resultSet = preparedStatement.executeQuery();
            //处理结果集
            while (resultSet.next()){
//                resultSet.getString("username");
//                Object object = new Object();
                T t= rowMapper.getRow(resultSet);
                //将处理完的对象放在list中
                tlist.add(t);

            }
            return  tlist;

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(connection,preparedStatement,resultSet);
        }
    return tlist;
    }


}
