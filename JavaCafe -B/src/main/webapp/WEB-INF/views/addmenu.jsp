<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD MENU</title>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/addMenu.css"/>'>
</head>
<body>
	<header>
		<div id="cafeTitle">
			<h1>Java Cafe</h1>
		</div>
	</header>
	<div id="addmenu">
		<div id="add_wrap">
			<h2>메뉴관리</h2>
			<form action="choiceImage" method="post">
				<table>
               <tr>
                  <th>이름</th>
                  <td><input type="text" value="${menu.itemName }" name="itemName" class="boxInput"></td>
               </tr>
               <tr>
                  <th>카테고리</th>
                  <td>Drink<input type="radio" value="Drink" name="itemCategory" checked >
                     Cake<input type="radio" value="Cake" name="itemCategory" >
                  </td>
               </tr>
               <tr>
                  <th>가격</th>
                  <td><input type="number" value="${menu.itemPrice }" name="itemPrice" class="boxInput"></td>
               </tr>
               <tr>
                  <th>판매시즌</th>
                  <td>Always<input type="radio" value="Always" name="salesSeason" checked>
                     Spring<input type="radio" value="Spring" name="salesSeason">
                     Summer<input type="radio" value="Summer" name="salesSeason">
                     Fall<input type="radio" value="Fall" name="salesSeason">
                     Winter<input type="radio" value="Winter" name="salesSeason">
                  </td>
               </tr>
            </table>
				<button type="submit" >다음</button>
				<button type="button" onclick="history.back()">이전페이지</button>
			</form>
		</div>	
	</div>
</body>
</html>