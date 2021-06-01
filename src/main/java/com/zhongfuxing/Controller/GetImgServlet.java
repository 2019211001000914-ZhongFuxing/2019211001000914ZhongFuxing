package com.zhongfuxing.Controller;

import com.zhongfuxing.dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "GetImgServlet")
public class GetImgServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int id = 0;
        if (request.getParameter("id")!=null){
            id = Integer.parseInt(request.getParameter("id"));
        }
        ProductDao productDao = new ProductDao();

        try {
            byte[] imgByte = new byte[0];
            imgByte = productDao.getPictureById(id,con);
            if (imgByte!=null){
                response.setContentType("image/gif");
                OutputStream os = response.getOutputStream();
                os.write(imgByte);
                os.flush();
//                os.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
