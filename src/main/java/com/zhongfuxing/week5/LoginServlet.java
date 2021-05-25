package com.zhongfuxing.week5;
import com.zhongfuxing.dao.UserDao;
import com.zhongfuxing.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    Connection connection;
    @Override
    public void init(ServletConfig config) throws ServletException {
//        ServletContext context = config.getServletContext();
//        String driver = context.getInitParameter("driver");
//        String url = context.getInitParameter("url");
//        String username = context.getInitParameter("username");
//        String password = context.getInitParameter("password");
//
//        try {
//            Class.forName(driver);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        // 建立数据库连接，获得连接对象conn
//        try {
//            conn = DriverManager.getConnection(url, username,password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        super.init();
        connection = (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        try {

            User user = userDao.findByUsernamePassword(connection, username, password);

            if (user!=null){
                String remeberMe =request.getParameter("remeberMe");
                if (remeberMe!=null && remeberMe.equals("1")){
                    Cookie usernameCookie = new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie = new Cookie("cPassword",user.getPassword());
                    Cookie remeberMeCookie = new Cookie("cRemeberMe",remeberMe);
                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    remeberMeCookie.setMaxAge(5);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(remeberMeCookie);

                }
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(10);
                Cookie cookie = new Cookie("sessionid",""+user.getId());
                cookie.setMaxAge(10*60);
                response.addCookie(cookie);
                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
            }else {
                request.setAttribute("msg","UserName OR Password Error!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

//        try {
//
//
//            String sql = "select * from usertable where username = ? and password = ?";

//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1,username);
//            ps.setString(2,password);
//
//
//            ResultSet rs = ps.executeQuery();
//            if(rs.next()){
//                request.setAttribute("id",rs.getInt("id"));
//                request.setAttribute("username",rs.getString("username"));
//                request.setAttribute("password",rs.getString("password"));
//                request.setAttribute("email",rs.getString("email"));
//                request.setAttribute("gender",rs.getString("gender"));
//                request.setAttribute("birthDate",rs.getString("birthDate"));
//
//
//            }else {
//                request.setAttribute("message","username or password error!!!");
//                request.getRequestDispatcher("login.jsp").forward(request,response);
//            }
//
//            PrintWriter pw = response.getWriter();
//            if (rs.next()) {
//                pw.write("<h1>Login Success!!!</h1>");
//                pw.write("<h1>Welcome,"+username+"</h1>");
//            }
//
//            else {
//                pw.write("<h1>Login Error！</h1>");
//            }
//
//
//
//        } catch (SQLException e) {
//
//            e.printStackTrace();
 //       }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
}