<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STOCK MANAGEMENT</title>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/stock_management.css"/>'>
</head>
<body>
    <header>
		<div id="cafeTitle">
			<h1>Java Cafe</h1>
		</div>
	</header>
    <div id="wrap">
        <div id="stock_wrap">
            <h2>재고수정</h2>
            <table>
                <c:forEach var="menu" items="${stockMenus }" >
                    <tr>
                        <th>상품번호</th>
                        <th>상품명</th>
                        <th>카테고리</th>
                        <th>재고량</th>
                        <th></th>
                    </tr>
                    <tr>
                        <td>${menu.itemNumber }</td>
                        <td>${menu.itemName }</td>
                        <td>${menu.itemCategory }</td>
                        <td>${menu.itemStock }</td>
                        <td><a href="changeStock?itemNumber=${menu.itemNumber }" class="stock_button">재고 수량 수정</a></td>
                    </tr>
                </c:forEach>
            </table>
            <div>
                <a href="home" class="home_button">홈으로</a>
            </div>
        </div>
    </div>
</body>
</html>