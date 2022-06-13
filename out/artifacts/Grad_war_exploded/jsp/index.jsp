<%--
  Created by IntelliJ IDEA.
  User: zxf
  Date: 2022/5/14
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>基于知识图谱的推荐系统</title>
  </head>
  <body>
  <div align="center">基于知识图谱的推荐系统</div>
  <div align="center">
    <form action="/insertUser" method="post">
      登录名称:<input type="text" name="loginName" value=""><br>
      登录密码:<input type="password" name="loginPassword" value=""><br>
      <input type="submit" name="submit" value="登录">
      <input type="reset" name="reset" value="取消">
    </form>
  </div>
  </body>
</html>
