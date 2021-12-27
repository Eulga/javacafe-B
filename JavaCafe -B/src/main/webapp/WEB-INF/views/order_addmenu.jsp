<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ORDER</title>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/order_addmenu.css"/>'>
</head>
<body>
        <header>
            <div id="cafeTitle">
                <h1>Java Cafe</h1>
            </div>
        </header>
        <div id="wrap">
            <div id="orderlist_wrap">
                <h2>주문메뉴</h2>
                <button>drink</button>
                <button>cake</button>
                <c:forEach var="menu" items="${menuList }">
                <c:choose>
                
                        <c:when test="${menu.itemCategory eq 'Drink' }">
                            <form action="addOrder" method="post" class="drink">
                                <div>
                                	<img src="${menu.itemImage }" height="200">
                                </div>  
                                <input type="text" value="${menu.itemNumber }" name="itemNumber" class="drink_box"><br>
                                <input type="text" value="${menu.itemName }" name="itemName" class="drink_box"><br>
                                <input type="text" value="${menu.itemPrice }" name="itemPrice" class="drink_box"><br>                    
                                <input type="submit" value="선택" class="correct_button">
                            </form>
                        </c:when>
                        <c:otherwise>
                            <form action="addOrder" method="post" class="cake">
                                <div>
                               		<img src="${menu.itemImage }">
                                </div>
                                <input type="text" value="${menu.itemNumber }" name="itemNumber" class="cake_box"><br>
                                <input type="text" value="${menu.itemName }" name="itemName" class="cake_box"><br>
                                <input type="text" value="${menu.itemPrice }" name="itemPrice" class="cake_box"><br>
                                <input type="submit" value="선택" class="correct_button">
                            </form>
                        </c:otherwise>
                </c:choose>
                </c:forEach>
                <a href="home">홈으로</a>
            
            </div>
        </div>
</body>
</html>