<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ORDER LIST</title>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/order_list.css"/>'>
</head>
<body>
    <header>
        <div id="cafeTitle">
            <h1>Java Cafe</h1>
        </div>
    </header>
    <div id="container">
        <div id="list_wrap">
            <h2>주문목록</h2>
                <div id="order_list">
                    <c:forEach var="order" items="${orderList }">
                        <form action="changeQuantity" method="post">
                            <input type="hidden" value="${order.menu.itemNumber }" name="itemNumber">
                        <table>
                            <tr>
                                <th>메뉴명</th>
                                <th>수량</th>
                                <th>가격</th>
                                <th></th>
                            </tr>
                            <tr>
                                <td><p>${order.menu.itemName }</p></td>
                                <td><input type="number" value="${order.orderQuantity }" name="orderQuantity" class="input_box">
                                <input type="submit" value="수량수정" class="change_quantity_button">
                            </td>
                                <td><p>${order.menu.itemPrice }</p></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td colspan="3"><a href="deleteOrder?itemNumber=${order.menu.itemNumber }" class="delete_button">삭제</a></td>
                            </tr>
                        </table>
                    </form>
                    </c:forEach>
                </div>
                <div id="button_box">
                    <a href="doOrder" class="add_order">주문 추가</a> <br>
                    <button type="button" onclick="history.back()">이전페이지</button>
                    <a href="home">홈으로</a>
                </div>
                <form action="finalPayment" method="post">
                    현금<input type="radio" name="paymentMethod" value="Cash">
                    카드<input type="radio" name="paymentMethod" value="CreditCard">
                    무료<input type="radio" name="paymentMethod" value="Free">
                    회원번호 <input type="text" value="0" name="customerNumber" class="customerNumber"><br>
                    <input type="submit" value="결제" class="payment">
                </form>
        </div>
    </div>
</body>
</html>