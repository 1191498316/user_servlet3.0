package com.cs.BaseDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;

    public Connection getConn() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf8", "root", "123456");
        return conn;
    }

    public ResultSet exeuQuery(String sql,Object...object) throws Exception{
        getConn();
        ps=conn.prepareStatement(sql);
        if (object!=null){
            for (int i = 0; i <object.length ; i++) {
                ps.setObject(i+1,object[i]);
            }
        }
        rs=ps.executeQuery();
        return rs;
    }

    public int exeuUpdate(String sql,Object...objects) throws Exception{
        getConn();
        int index=-1;
        ps=conn.prepareStatement(sql);
        if (objects!=null){
            for (int i = 0; i <objects.length ; i++) {
                ps.setObject(i+1,objects[i]);
            }
        }
        index=ps.executeUpdate();
        return index;
    }

    public void getClose() throws Exception {
        if (rs!=null){
            rs.close();
        }
        if (ps!=null){
            ps.close();
        }
        if (conn!=null){
            conn.close();
        }
    }
}
