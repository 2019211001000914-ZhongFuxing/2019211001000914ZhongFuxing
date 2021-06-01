<html>
<body>
<%@include  file="header.jsp" %>
<h1>Login</h1><br>
<%
if(!(request.getAttribute("message")==null)){
    out.print("<h3>"+request.getAttribute("message")+"</h3>");
}
%>
<form method="post"   action="login">
   Username: <input type="text" name="username"  />
    Password:<input type="password" name="txt"  />
    <input type="submit" value="Submit"/>
</form>
<%@include  file="footer.jsp" %>
</body>
</html>
