<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/menu_management.css"/>'>
</head>
<body>
    <header>
		<div id="cafeTitle">
			<h1>Java Cafe</h1>
		</div>
	</header>
    <div id="management_wrap">
        <div class="wrap">
        	<div id="item_wrap">        	
	            <table>
	                <tr>
	                    <th>번호</th>
	                    <th>이름</th>
	                    <th>카테고리</th>
	                    <th>가격</th>
	                    <th>이미지</th>
	                    <th>시즌</th>
	                    <th></th>
	                </tr>
	                <c:forEach var="menu" items="${menuList }">
	                    <tr>
	                        <td>${menu.itemNumber }</td>
	                        <td>${menu.itemName }</td>
	                        <td>${menu.itemCategory }</td>
	                        <td>${menu.itemPrice }</td>
	                        <td><img src="${menu.itemImage }" width="80" height="80"></td>
	                        <td>${menu.salesSeason }</td>
	                        <td>
	                            <a href="changeMenuInfo?itemNumber=${menu.itemNumber }" class="intable_button">수정</a>
	                            <a href="deleteMenu?itemNumber=${menu.itemNumber }" class="intable_button">삭제</a>
	                        </td>
	                    </tr>
	                </c:forEach>
	            </table>            
        	</div>
            <div class="button_sector">
                <a href="addMenu" class="submitbutton">추가하기</a>
                <a href="home" class="submitbutton">홈으로</a>
            </div>
        </div>
    </div>
</body>
</html>