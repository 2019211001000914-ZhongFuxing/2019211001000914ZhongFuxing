<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>

<%
    if (request.getParameter("msg")!=null){
    }
%>

<%
    Cookie[] allCookies = request.getCookies();
    String username="",password="",remeberMeValue="";
    if (allCookies!=null){
        for (Cookie c :allCookies){
            if (c.getName().equals("cUsername")){
                username = c.getValue();
            }
            if (c.getName().equals("cPassword")){
                password = c.getValue();
            }
            if (c.getName().equals("cRemeberMe")){
                remeberMeValue = c.getValue();
            }
        }
    }
%>
<form action="${pageContext.request.contextPath}/login" method="post">
    <h1>Login</h1>
    UserName:<input type="text" name="username" value="<%username%>"><br>
    Password:<input type="password" name="password" value="<%username%>><br>
    <input type="submit" name="remeberMe" value="Login" <%remeberMeValue.equals("1")?checked:""%>checked/>RemeberMe<br/>
    <span style="color: red">${requestScope.msg}</span>
</form>



<%@include file="footer.jsp" %>
</body>
</html>
