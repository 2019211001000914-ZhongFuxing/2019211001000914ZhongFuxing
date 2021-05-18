package com.zhongfuxing.Controller;

import com.zhongfuxing.model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductListServlet",value="/adimin/productList")
public class ProductListServlet extends HttpServlet {
    Connection con=null;
    public  void init(){
        con=(Connection) getServletContext().getAttribute("con");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            List<Category>categoryList= Category.findAllCategory(con);
        request.setAttribute("categoryList",categoryList);
        String path="WEB-INF/views/admin/productList.jsp";
        request.getRequestDispatcher(path).forward(request,response);}
        catch(SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
