package com.zhongfuxing.week3;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "Servlet3", urlPatterns = "/register", initParams = {
        @WebInitParam(name="driver",value = "com.microsoft.sqlserver.jdbc.SqlServerDriver"),
        @WebInitParam(name="url",value = "jdbc:sqlserver://localhost;databaseName=userdatabase;"),
        @WebInitParam(name="username",value = "sa"),
        @WebInitParam(name="password",value = "12345678"),
}
)
public class RegisterServlet extends HttpServlet {
    private String driver;
    private String url;
    private String username;
    private String password;
    Connection conn=null;

     public void init() throws ServletException {
        super.init();
        driver = getServletContext().getInitParameter("driver");
        url = getServletContext().getInitParameter("url");
        username = getServletContext().getInitParameter("username");
        password = getServletContext().getInitParameter("password");
        System.out.println(driver);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);

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
        String Usernamevalue =request.getParameter("name");
        String Passwordvalue = request.getParameter("password");
        String Emailvalue = request.getParameter("Email");
        String Gendervalue = request.getParameter("1");
        String Birthdatevalue = request.getParameter("birthday");
        int n = 1;
        try{

            System.out.println("init()-->"+conn);

            String sql = "insert into usertable values (null ,?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
          //  stmt.setString(1,Usernamevalue);
          //  stmt.setString(2,Passwordvalue);
          //  stmt.setString(3,Emailvalue);
          //  stmt.setString(4,Gendervalue);
          //  stmt.setString(5,Birthdatevalue);// System.out.println(sql);

            stmt.executeUpdate();

           // st.executeUpdate()

            int count=stmt.executeUpdate(sql);
            if(count>0)
                System.out.println("添加成功");
            else
                System.out.println("添加失败");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //PrintWriter writer= response.getWriter();
        //writer.print("<h1>Username:"+Usernamevalue+"<h1>");
        //writer.print("<h1>Password:"+Passwordvalue+"<h1>");
        //writer.print("<h1>Email:"+Emailvalue+"<h1>");
        //writer.print("<h1>Gender:"+Gendervalue+"<h1>");
        response.sendRedirect(request.getContextPath()+"/Select");
        //writer.print("<h1>Birthdata:"+Birthdatevalue+"<h1>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }



public void destory(){
        super.destroy();
        try {
        conn.close();

        } catch (SQLException e) {
        e.printStackTrace();
        }
        }
        }
