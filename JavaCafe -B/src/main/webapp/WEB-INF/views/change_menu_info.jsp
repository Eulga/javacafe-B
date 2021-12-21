<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHANGE MENU INFO</title>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/change_menu_info.css"/>'>
</head>
<body>
 <header>
		<div id="cafeTitle">
			<h1>Java Cafe</h1>
		</div>
	</header>
    <!-- 아이템넘버 안보이게 처리 -->
    <div id="wrap">
        <div id="info_wrap">
            <h2>메뉴수정</h2>
            <form action="changeMenuImage" method="post">
                <input type="text" value="${menu.itemNumber }" name="itemNumber" class="hidden">
                <table>
                    <tr>
                        <th class="first_line">이름</th>
                        <td class="first_line"><input type="text" value="${menu.itemName }" name="itemName" class="table_box"></td>
                    </tr>
                    <tr>
                        <th>카테고리</th>
                        <td>
                            Drink<input type="radio" value="Drink" name="itemCategory" <c:if test="${menu.itemCategory eq 'Drink' }">checked="checked"</c:if> />
                Cake<input type="radio" value="Cake" name="itemCategory" <c:if test="${menu.itemCategory eq 'Cake' }">checked="checked"</c:if> />
                        </td>
                    </tr>
                    <tr>
                        <th>가격</th>
                        <td><input type="number" value="${menu.itemPrice }" name="itemPrice" class="table_box"></td>
                    </tr>
                    <tr>
                        <th class="last_line">시즌</th>
                        <td class="last_line">
                            Always<input type="radio" value="Always" name="salesSeason" <c:if test="${menu.salesSeason eq 'Always' }">checked="checked"</c:if> />
                Spring<input type="radio" value="Spring" name="salesSeason" <c:if test="${menu.salesSeason eq 'Spring' }">checked="checked"</c:if> />
                Summer<input type="radio" value="Summer" name="salesSeason" <c:if test="${menu.salesSeason eq 'Summer' }">checked="checked"</c:if> />
                Fall<input type="radio" value="Fall" name="salesSeason" <c:if test="${menu.salesSeason eq 'Fall' }">checked="checked"</c:if> />
                Winter<input type="radio" value="Winter" name="salesSeason" <c:if test="${menu.salesSeason eq 'Winter' }">checked="checked"</c:if> />
                        </td>
                    </tr>
                </table>
                <div id="button_sector">
                    <input type="submit" value="다음" class="submit_button">
                    <input type="button" onclick="history.back()" value="이전페이지로 이동" class="submit_button">
                </div>
            </form>
        </div>
    </div>
</body>
</html>