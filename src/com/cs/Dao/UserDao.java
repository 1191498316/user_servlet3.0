package com.cs.Dao;

import com.cs.entity.User;
import com.cs.entity.Users;

import java.util.List;

public interface UserDao {

    public int userfindcount() throws Exception;
    public List<User> userbylimit(int page, int countpage) throws Exception;
    public Users login(String username, String password) throws Exception;
    public User finduser(int id) throws Exception;
    public int update(User u) throws Exception;
    public int del(int id) throws Exception;
    public int add(User u) throws Exception;
}
