<%--
  Created by IntelliJ IDEA.
  User: bewitch
  Date: 2021/3/16
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path= request.getContextPath();%>
<html>
<head>
    <title>Title</title>
     <script type="text/javascript">
          function validate_email(field,alerttxt)
          {
               with (field)
               {
                    apos=value.indexOf("@")
                    dotpos=value.lastIndexOf(".")
                    if (apos<1||dotpos-apos<2)
                    {alert(alerttxt);return false}
                    else {return true}
               }
          }

          function validate_form(thisform)
          {
               with (thisform)
               {
                    if (validate_email(email,"Not a valid e-mail address!")==false)
                    {email.focus();return false}
               }
          }

     </script>

</head>
<body>
<%@include  file="header.jsp" %>
This is my JSP Page <br/>
<form action="<%=path%>/register" method="post">
     UserName:<input type="text" name="name" required> <br/>
     Password:<input type="password" name="password" required minlength="8" /> <br/>
     Email:<input type="email" name="Email" required> <br/>
     <input id="man" type="radio" checked="checked" name="1" value="female" required />female
     <input id="woman" type="radio" name="1" value="male" required/>male
     <br/>
     <input type="date" name="birthday"  required/>
     <br/>
     <input type="submit" value="Register"/>
    <%@include  file="footer.jsp" %>

</form>
</body>
</html>
