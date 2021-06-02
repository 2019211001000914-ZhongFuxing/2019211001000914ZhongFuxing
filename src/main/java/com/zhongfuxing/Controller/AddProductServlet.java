package com.zhongfuxing.Controller;

import com.zhongfuxing.dao.ProductDao;
import com.zhongfuxing.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

@WebServlet(name = "AddProductServlet",value="/admin/addproduct")
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String prosuctName=request.getParameter("productName");
    double price=request.getParameter("price")!=null?Double.parseDouble(request.getParameter("price")):0.0;
    //int cateogryId=request.getParameter("categoryId")!=null?Integer.parseInt(request.getParameter("price")):0.0;
    String productDescription=request.getParameter("productDescription");
        InputStream inputStream=null;
        Part fileparts=request.getPart("picture");
        if(fileparts!=null){
            inputStream=fileparts.getInputStream();
        }
        Product product=new Product();
        product.setProductName(prosuctName);
        product.setProductDescription(productDescription);
        product.setPicture(inputStream);
        product.setPirce(price);
        //product.setCategoryId(cateogryId);
        ProductDao productDao=new ProductDao();
        try {
            Connection con = null;
            int n = productDao.save(product,con);
            if (1 > 0)
                response.sendRedirect("productList");
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path="/WEB-INF/views/admin/addproduct.jsp";
    request.getRequestDispatcher(path).forward(request,response);

    }
}
