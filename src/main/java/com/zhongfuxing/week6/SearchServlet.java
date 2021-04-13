package com.zhongfuxing.week6;

import java.io.IOException;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = request.getParameter("txt");
        String url = request.getParameter("search");
        if("".equals(txt)){
            response.sendRedirect("index.jsp");
        }else {
            switch (txt){
                case "baidu":response.sendRedirect("https://www.baidu.com/s?wd="+txt);
                case "google":response.sendRedirect("https://cn.bing.com/search?q="+txt);
                case "bing":response.sendRedirect("https://google.com/search?q="+txt);

            }
        }
    }
}