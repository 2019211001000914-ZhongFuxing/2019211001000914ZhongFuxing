<%@ page import="com.zhongfuxing.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp" %>
<h1>user info </h1>
<%    Cookie[] allCookies = request.getCookies();--%>
<%    for (Cookie cookie : allCookies) {--%>
<%--//        out.print("<br>" + cookie.getName() + "<br>  value=" + cookie.getValue());--%>
<%--    }--%>

<%
    User user = (User) request.getAttribute("user");
%>
<table>
    <tr>
        <td>Username:</td>
        <td><%=user.getUsername()%></td>
    </tr>
    <tr>
        <td>Password:</td>
        <td><%=user.getPassword()%></td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><%=user.getEmail()%></td>
    </tr>
    <tr>
        <td>Gender:</td>
        <td><%=user.getGender()%></td>
    </tr>
    <tr>
        <td>Birth Date:</td>
        <td><%=user.getBirthdate()%></td>
    </tr>
</table>
<%@include file="footer.jsp" %>
</body>
</html>
