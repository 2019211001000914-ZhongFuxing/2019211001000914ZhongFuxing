package com.zhongfuxing.week3;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Usernamevalue =request.getParameter("name");
        String Passwordvalue = request.getParameter("password");
        String Emailvalue = request.getParameter("Email");
        String Gendervalue = request.getParameter("1");
        String Birthdatevalue = request.getParameter("birthday");
        PrintWriter writer= response.getWriter();
        writer.print("<h1>Username:"+Usernamevalue+"<h1>");
        writer.print("<h1>Password:"+Passwordvalue+"<h1>");
        writer.print("<h1>Email:"+Emailvalue+"<h1>");
        writer.print("<h1>Gender:"+Gendervalue+"<h1>");
        writer.print("<h1>Birthdata:"+Birthdatevalue+"<h1>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
