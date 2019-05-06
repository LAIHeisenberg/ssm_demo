<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h1>HELLO LYZ</h1>
    <form action="/submit" method="post">
        <label>ID</label>><input type="text" name="id" value="" />
        <label>姓名</label><input type="text" name="name" value="" >
        <input type="hidden" name="name" value="laiyz" />
        <label>年龄</label><input type="text" name="age" value="" />
        <label>性别</label><input type="text" name="sexy" value="" />
        <input type="submit" value="提交" />
    </form>
</body>
</html>
