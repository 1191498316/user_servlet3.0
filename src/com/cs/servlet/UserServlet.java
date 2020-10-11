package com.cs.servlet;

import com.cs.entity.User;
import com.cs.entity.Users;
import com.cs.service.impl.Userserviceimpl;
import com.cs.until.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String comm=request.getParameter("comm");

        if (comm.equals("登录")){
            String name=request.getParameter("username");
            String pass=request.getParameter("password");

            Userserviceimpl usi=new Userserviceimpl();
            Users u= null;
            try {
                u = usi.login(name,pass);
                if (u!=null){
                    response.sendRedirect("/UserServlet?comm=list");
                }else {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (comm.equals("list")) {
            String pageno = request.getParameter("indexno");
            if (pageno == null || pageno == "") {
                pageno = "1";
            }
            int pno = Integer.parseInt(pageno);
            Userserviceimpl usi = new Userserviceimpl();
            PageSupport ps = new PageSupport();
            ps.setCurrentPageNo(pno);
            ps.setPageSize(3);
            try {
                ps.setTotalCount(usi.userfindcount());
                List<User> list = usi.userbylimit(ps.getCurrentPageNo(), ps.getPageSize());
                if (list.size() > 0 && list != null) {
                    request.getSession().setAttribute("lists", list);
                    request.getSession().setAttribute("ps", ps);
                    response.sendRedirect("success.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (comm.equals("query")){
            Userserviceimpl usi = new Userserviceimpl();
            String userid=request.getParameter("id");
            int id=Integer.parseInt(userid);
            try {
                User u= usi.finduser(id);
                if (u!=null){
                    request.getSession().setAttribute("u",u);
                    request.getRequestDispatcher("find.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (comm.equals("del")){
            Userserviceimpl usi = new Userserviceimpl();
            String userid=request.getParameter("id");
            int id=Integer.parseInt(userid);
            try {
                if(usi.del(id)>0){
                    response.sendRedirect("/UserServlet?comm=list");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (comm.equals("update")){
            Userserviceimpl usi = new Userserviceimpl();
            String userid=request.getParameter("id");
            int id=Integer.parseInt(userid);
            try {
                User u= usi.finduser(id);
                if (u!=null){
                    request.getSession().setAttribute("u",u);
                    request.getRequestDispatcher("update.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (comm.equals("修改")){
            Userserviceimpl usi=new Userserviceimpl();
            String userid=request.getParameter("id");
            String name=request.getParameter("username");
            String pass=request.getParameter("password");
            String sex=request.getParameter("sex");
            String borndate=request.getParameter("borndate");
            int id=Integer.parseInt(userid);
            User u=new User();
            u.setId(id);
            u.setUsername(name);
            u.setPassword(pass);
            u.setSex(sex);
            u.setBorndate(borndate);
            try {
                int a=usi.update(u);
                if (a>0){
                    response.sendRedirect("/UserServlet?comm=list");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (comm.equals("add")){
            response.sendRedirect("add.jsp");
        }

        if (comm.equals("添加")){
            Userserviceimpl usi=new Userserviceimpl();
//            String userid=request.getParameter("id");
            String name=request.getParameter("username");
            String pass=request.getParameter("password");
            String sex=request.getParameter("sex");
            String borndate=request.getParameter("borndate");
//            int id=Integer.parseInt(userid);
            User u=new User();
//            u.setId(id);
            u.setUsername(name);
            u.setPassword(pass);
            u.setSex(sex);
            u.setBorndate(borndate);
            try {
                int a=usi.add(u);
                if (a>0){
                    response.sendRedirect("/UserServlet?comm=list");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
