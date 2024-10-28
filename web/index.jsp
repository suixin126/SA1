<%--
  Created by IntelliJ IDEA.
  User: 34779
  Date: 2024/10/24
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
  <head>
    <title>张哲哲天气预报系统</title>
  </head>
  <body>
  <h1>天气预报查询系统</h1>
  <form action="weather" method="post">
    <span>输入城市名:</span>
    <input type="text" id="city" name="city">
    <input type="submit" value="查询天气">
  </form>
  </body>
</html>
