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

@WebServlet(name = "ShopServlet",value="/shop")
public class ShopServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = new Category();
        try {
            List<Category >categoryList=Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ProductDao productDao=new ProductDao();
        try
        {
            if (request.getParameter("categoryId")==null) {
                List<Product> productList = productDao.findAll(con);
                request.setAttribute("productList", productList);
            }
            else {
                int categoryID = Integer.parseInt(request.getParameter("categoryId"));
                List<Product> productList = productDao.findByCategoryId(categoryID, con);
            }
        }
        catch(SQLException throwables){
        throwables.printStackTrace();
    }
        String path="WEB-INF/views/admin/productList.jsp";
        request.getRequestDispatcher(path).forward(request,response);}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
