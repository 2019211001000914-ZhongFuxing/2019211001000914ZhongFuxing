<%--
  Created by IntelliJ IDEA.
  User: yun
  Date: 2021/4/13
  Time: 8:55 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%@include  file="header.jsp" %>
<h1>User Info</h1>
<table>
    <tr><td>Username:</td><td><%=request.getAttribute("username")%>></td></tr>
    <tr><td>Password:</td><td><%=request.getAttribute("Password")%>></td></tr>
    <tr><td>email:</td><td><%=request.getAttribute("email")%>></td></tr>
    <tr><td>Gender:</td><td><%=request.getAttribute("gender")%>></td></tr>
    <tr><td>Birth Date:</td><td><%=request.getAttribute("birthDate")%>></td></tr>

</table>

<%@include  file="footer.jsp" %>
</body>
</html>