<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Cafe B</title>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/pos_login.css"/>'>
</head>
<body>
    <header>
        <div id="cafeTitle">
            <h1>Java Cafe</h1>
        </div>
    </header>
    <div id="login_wrap">
        <div>
            <form action="login" method="post">
                <p>ID</p>
                <input type="text" name="masterNumber" value="${masterNumber }" />
                <p>Password</p>
                <input type="password" name="passwd" placeholder="password"><br>
                <button type="submit">Sign in</button>
            </form>
        </div>
    </div>
</body>
</html>