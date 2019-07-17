<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/13
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/user/doUpload" method="POST" enctype="multipart/form-data">
    <div>
        <input type="file" name="file">
    </div>
    <div>
        <input type="submit" value="上传">
    </div>
</form>
</body>
</html>
