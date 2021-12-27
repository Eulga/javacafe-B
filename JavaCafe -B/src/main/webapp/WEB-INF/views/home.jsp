<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/home.css"/>'>
</head>
<body>
	<div id="home_wrap">
		<div class="home_item1">
            <div class="notice_wrap">
                <h2>※근무자 필수 확인※</h2>
                <ul>
                    <li>개점 시, 시재금액 정확하게 기입하기</li>
                    <li>재고사항 수시로 확인하고 매입 시 업데이트 바로 하기</li>
                    <li>근무 시, 마스크 착용 필수!</li>
                    <li>커피머신, 작업대, 싱크대 청결 항상 유지하기</li>
                    <li>항상 밝게 웃으며 손님 응대하기</li>
                    <li>마감 정산 후 시재금액과 맞는지 확인</li>
                    <li>마감 근무자는 퇴근전 뒷정리 깨끗이 하기</li>
                </ul>            
            </div>
        </div>
		<div class="home_item2">
			<ul>
				<li><a href="doOrder">주문관리</a></li>
				<li><a href="menuManagement">상품관리</a></li>
				<li><a href="salesManagement">매출관리</a></li>
				<li><a href="stockManagement">재고관리</a></li>
				<li><a href="#">고객관리</a></li>
			</ul>
		</div>
	</div>
</body>
</html>