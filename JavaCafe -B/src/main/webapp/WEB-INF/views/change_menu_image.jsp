<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/change_image.css"/>'>
</head>
<body>
<!-- 이미지태그사용하고 input의 value값을 이미지태그에 사용한 주소로 변경 -->
<!-- c태그안 eq문 뒤에 비교값을 주소값으로 변경 -->
<header>
	<div id="cafeTitle">
		<h1>Java Cafe</h1>
	</div>
</header>
    <div id="change_image">
        <div id="ch_wrap">
            <h2>이미지선택</h2>
            <form action="addMenu" method="post">
                <div id="scroll_wrap">
                    <div>
                        <div id="imagebox">
                            <img src="resources/image/americano.jpg" alt="" height="240">
                        </div>
                        <div id="radiobox">
                            <input type="radio" value="resources/image/americano.jpg" name="itemImage"/>
                        </div>
                    </div>
                    <div>
                        <div id="imagebox">
                            <img src="resources/image/latte.jpg" alt="" height="240">
                        </div>
                        <div id="radiobox">
                            <input type="radio" value="resources/image/latte.jpg" name="itemImage"/>
                        </div>
                    </div>
                    <div>
                        <div id="imagebox">
                            <img src="resources/image/cappuccino.jpg" alt="" height="240">
                        </div>
                        <div id="radiobox">
                            <input type="radio" value="resources/image/cappuccino.jpg" name="itemImage"/>
                        </div>
                    </div>
                    <div>
                        <div id="imagebox">
                            <img src="resources/image/caramel.jpg" alt="" height="240">
                        </div>
                        <div id="radiobox">
                            <input type="radio" value="resources/image/caramel.jpg" name="itemImage"/>
                        </div>
                    </div>
                    <div>
                        <div id="imagebox">
                            <img src="resources/image/berrylatte.jpg" alt="" height="240">
                        </div>
                        <div id="radiobox">
                            <input type="radio" value="resources/image/berrylatte.jpg" name="itemImage"/>
                        </div>
                    </div>
                    <div>
                        <div id="imagebox">
                            <img src="resources/image/greentea.jpg" alt="" height="240">
                        </div>
                        <div id="radiobox">
                            <input type="radio" value="resources/image/greentea.jpg" name="itemImage"/>
                        </div>
                    </div>
                    <div>
                        <div id="imagebox">
                            <img src="resources/image/icetea.jpg" alt="" height="240">
                        </div>
                        <div id="radiobox">
                            <input type="radio" value="resources/image/icetea.jpg" name="itemImage"/>
                        </div>
                    </div>
                </div>
                <button type="submit">추가</button>
                <button type="button" onclick="history.back()">이전페이지</button>
            </form>
        </div>
    </div>
</body>
</html>