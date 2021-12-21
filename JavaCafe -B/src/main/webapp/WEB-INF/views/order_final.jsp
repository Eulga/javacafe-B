<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ORDER FINAL</title>
</head>
<body>
	<div>
		<h2>주문목록</h2>
		<c:forEach var="order" items="${orderList }">
			${order.menu.itemName }
			${order.menu.itemPrice }
			${order.orderQuantity }
		</c:forEach>
	</div>
	total : ${totalPrice }
	
	<form action="finalPayment" method="get">
		<input type="text" value="${customer.customerNumber }" name="customerNumber">
		<input type="text" value="${customer.mileage }" name="mileage">
		<input type="submit" value="결제하기">
	</form>
	<p>${warningMsg }</p>
	
</body>
</html>