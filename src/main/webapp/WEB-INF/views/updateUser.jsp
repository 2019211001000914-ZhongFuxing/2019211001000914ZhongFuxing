<%@ page import="com.zhongfuxing.model.User" %>
<% Object path = null; %><%--
  Created by IntelliJ IDEA.
  User: bewitch
  Date: 2021/4/27
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<%
    User user = (User) session.getAttribute("user");
%>
<form action="<%=path%>/register" method="post">
    <input type="hidden" name="id" value="<%=user.getId()%>">
    UserName:<input type="text" name="name" value="<%=user.getUsername()%>" required> <br/>
    Password:<input type="password" name="password" required minlength="8"  value="<%=user.getPassword()%>"/> <br/>
    Email:<input type="email" name="Email" value="<%=user.getEmail()%>" required> <br/>
    <input id="man" type="radio" checked="checked" name="1" value="female" <%="Male".equals(user.getGender())?"checked":""%>required />female
    <input id="woman" type="radio" name="1" value="male" required/>male
    <br/>
    <input type="date" name="birthday" value="<%=user.getBirthdate()%>" required/>
    <br/>
    <input type="submit" value="Register"/>
    <%@include  file="footer.jsp" %>

</form>
<%@include file="footer.jsp"%>