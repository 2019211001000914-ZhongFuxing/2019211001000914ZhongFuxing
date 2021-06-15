package com.zhongfuxing.Controller;

import com.zhongfuxing.dao.OrderDao;
import com.zhongfuxing.model.Order;
import com.zhongfuxing.model.Payment;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/admin/orderList")
public class AdminOrderList extends HttpServlet {
    private  Connection con=null;
    public  void destroy(){
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        con=(Connection)getServletContext().getAttribute("con");
    }
    public  void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        doGet(request,response);
    }
    public void  doGet(HttpServletRequest request,HttpServletResponse response) throws  ServletException,IOException{
        List<Payment> paymentTypeList=Payment.findAllPayment(con);
        request.setAttribute("paymentTypeList",paymentTypeList);
        OrderDao orderDao=new OrderDao();
        List<Order> orderList=orderDao.findAll(con);
        request.setAttribute("orderList",orderList);
               String path="/WEB-INF/views/admin/orderList.jsp";
               request.getRequestDispatcher(path).forward(request,response);
    }
}
