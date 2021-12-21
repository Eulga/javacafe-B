<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/period_orderlist.css"/>'>
</head>
<body>
	<div id="page_wrap">
		<div class="button_sec">
			<div class="button_wrap">
				<div><a href="dailySalesIndex">일간</a></div>
				<div><a href="weeklySalesIndex">주간</a></div>
				<div><a href="monthlySalesIndex">월간</a></div>
				<div class="home"><a href="home">홈으로</a></div>
			</div>
		</div>
		<div class="data_sec">
			<table>
				<tr>
					<th>날짜</th>
					<th>영수증번호</th>
					<th>주문번호</th>
					<th>품목</th>
					<th>수량</th>
					<th>금액</th>
					<th>결제수단</th>
				</tr>
				<c:forEach var="order" items="${monthList}">
				<c:set var="total" value="${order.orderQuantity * order.menu.itemPrice}"></c:set>
				<tr>
					<td>${order.orderDate}</td>
					<td>${order.receiptNumber}</td>
					<td>${order.orderNumber}</td>
					<td>${order.menu.itemName}</td>
					<td>${order.orderQuantity}</td>
					<td><c:out value="${total}"/></td>
					<td>${order.paymentMethod}</td>
				</tr>
				</c:forEach>
			</table>				
		</div>		
	</div>
</body>
</html>