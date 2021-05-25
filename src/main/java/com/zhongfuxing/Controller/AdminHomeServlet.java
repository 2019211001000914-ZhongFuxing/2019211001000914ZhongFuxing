package com.zhongfuxing.Controller;

import com.zhongfuxing.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminHomeServlet",value="/sdmin/home")
public class AdminHomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);//return session or null(no session)but its not creste a new session
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if ("admin".equals(user.getUsername())) {//admin username must be in table
                request.getRequestDispatcher("../WEB-INF/views/admin/index.jsp").forward(request, response);
            }
            else{
                //have session but itsnot admin user
                session.invalidate();
                request.setAttribute("message","Unauthorized Access Admin Module!!!");
                request.getRequestDispatcher("../WEB-INF/views/Login.jsp").forward(request,response);
            }
        }else
        {
            //no session -then user click the Link
            request.setAttribute("mseeage","Please login as admin!!!");
            request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request,response);
        }
    }
}
