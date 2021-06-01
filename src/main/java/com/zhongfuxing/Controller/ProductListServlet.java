package com.zhongfuxing.Controller;

import com.zhongfuxing.dao.ProductDao;
import com.zhongfuxing.model.Category;
import com.zhongfuxing.model.Product;

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
        ProductDao productDao=new ProductDao();
        try
        {
            //week12
            List<Product> productList=productDao.findAll(con);
            request.setAttribute("productList",productList);
            List<Category>categoryList= Category.findAllCategory(con);}
        catch(SQLException throwables){
            throwables.printStackTrace();
        }
        String path="WEB-INF/views/admin/productList.jsp";
        request.getRequestDispatcher(path).forward(request,response);}
    }

