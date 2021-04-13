package com.zhongfuxing.week5;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    Connection conn;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 建立数据库连接，获得连接对象conn
        try {
            conn = DriverManager.getConnection(url, username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {


            String sql = "select * from usertable where username = ? and password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);


            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                request.setAttritube("id",rs.getInt("id"));
                request.setAttritube("username",rs.getString("username"));
                request.setAttritube("password",rs.getString("password"));
                request.setAttritube("email",rs.getString("email"));
                request.setAttritube("gender",rs.getString("gender"));
                request.setAttritube("birthDate",rs.getString("birthDate"));


            }else {
                request.setAttritube("message","username or password error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }

            PrintWriter pw = response.getWriter();
            if (rs.next()) {
                pw.write("<h1>Login Success!!!</h1>");
                pw.write("<h1>Welcome,"+username+"</h1>");
            }

            else {
                pw.write("<h1>Login Error！</h1>");
            }



        } catch (SQLException e) {

            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}