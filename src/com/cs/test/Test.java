package com.cs.test;

import com.cs.Dao.impl.UserDaoimpl;
import com.cs.entity.User;
import com.cs.until.PageSupport;

import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        UserDaoimpl udi=new UserDaoimpl();
        PageSupport ps=new PageSupport();
        ps.setPageSize(3);
        ps.setTotalCount(udi.userfindcount());
        ps.setCurrentPageNo(2);

        System.out.println("总页数："+ps.getTotalPageCount());
        System.out.println("总信息数："+ps.getTotalCount());

//        int a=ps.getTotalCount();
//        int b=ps.getTotalPageCount();
        if (ps.getCurrentPageNo()!=ps.getTotalPageCount()) {
            System.out.println("当前信息数：" + ps.getPageSize());
        }else {
            if (ps.getTotalCount()%ps.getPageSize()==0){
                System.out.println("当前信息数：" + ps.getPageSize());
            }else {
                System.out.println("当前信息数：" + ps.getTotalCount() % ps.getPageSize());
            }
        }
        System.out.println("当前页数："+ps.getCurrentPageNo());
        List<User> list=udi.userbylimit(ps.getCurrentPageNo(),ps.getPageSize());
        for (User u : list) {
            System.out.println(u.toString());
        }
    }
}
