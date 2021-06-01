<html>
<body>
<%@include  file="header.jsp" %>
<h2>Welcome to My Online Shop Home Page.</h2><br>
<form method="get"  target="_blank" action="search">
    <input type="text" name="txt" size="30" />
    <select name="search">
        <option value="baidu">Baidu </option>
        <option value="bing">bing </option>
        <option value="google">google </option>
    </select>
    <input type="submit" value="Search"/>
</form>
<%@include  file="footer.jsp" %>
</body>
</html>
