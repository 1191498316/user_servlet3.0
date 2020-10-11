package com.cs.Dao.impl;

import com.cs.BaseDao.BaseDao;
import com.cs.Dao.UserDao;
import com.cs.entity.User;
import com.cs.entity.Users;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoimpl extends BaseDao implements UserDao {
    @Override
    public int userfindcount() throws Exception {
        String sql="select count(*) from user";
        Object[] obj=null;
        int index=0;
        ResultSet rs=exeuQuery(sql,obj);
        while (rs.next()){
            index=rs.getInt(1);
        }
        return index;
    }

    @Override
    public List<User> userbylimit(int page, int countpage) throws Exception {
        List<User> list=new ArrayList<User>();
        String sql="select * from user limit ?,?";
        Object[] obj={(page-1)*countpage,countpage};
        ResultSet rs=exeuQuery(sql,obj);
        while (rs.next()){
            User u=new User();
            u.setId(rs.getInt(1));
            u.setUsername(rs.getString(2));
            u.setPassword(rs.getString(3));
            u.setSex(rs.getString(4));
            u.setBorndate(rs.getString(5));
            u.setUserpic(rs.getString(6));
            list.add(u);
        }
        return list;
    }

    @Override
    public Users login(String username, String password) throws Exception {
        Users u=null;
        String sql="select * from users where username=? and password=?";
        Object[] obj={username,password};
        ResultSet rs=exeuQuery(sql,obj);
        while (rs.next()){
            u=new Users();
            u.setUsername(rs.getString(1));
            u.setPassword(rs.getString(2));
        }
        getClose();
        return u;
    }

    @Override
    public User finduser(int id) throws Exception {
        User u=null;
        String sql="select * from user where id=?";
        Object[] obj={id};
        ResultSet rs=exeuQuery(sql,obj);
        while (rs.next()){
            u=new User();
            u.setId(rs.getInt(1));
            u.setUsername(rs.getString(2));
            u.setPassword(rs.getString(3));
            u.setSex(rs.getString(4));
            u.setBorndate(rs.getString(5));
        }
        return u;
    }

    @Override
    public int update(User u) throws Exception {
        int index=-1;
        String sql="update user set username=?,password=?,sex=?,borndate=? where id=?";
        Object[] obj={u.getUsername(),u.getPassword(),u.getSex(),u.getBorndate(),u.getId()};
        index=exeuUpdate(sql,obj);
        getClose();
        return index;
    }

    @Override
    public int del(int id) throws Exception {
        int index=-1;
        String sql="delete from user where id=?";
        Object[] obj={id};
        index=exeuUpdate(sql,obj);
        return index;
    }

    @Override
    public int add(User u) throws Exception {
        int index=-1;
        String sql="insert into user(username,password,sex,borndate)" +
                "value(?,?,?,?)";
        Object[] obj={u.getUsername(),u.getPassword(),u.getSex(),u.getBorndate()};
        index=exeuUpdate(sql,obj);
        return index;
    }
}
