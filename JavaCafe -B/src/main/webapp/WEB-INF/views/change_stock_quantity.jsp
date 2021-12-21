<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHANGE STOCK QUATITY</title>
<%-- <link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/change_stock_quantity.css"/>'> --%>
<style type="text/css">
@charset "utf-8";
@import url(http://www.google.com/fonts/earlyaccess);


* { 
	margin: 0; padding: 0; 
    font-family: 'Jeju Gothic', sans-serif;
    }
a {
    text-decoration: none;
}
header {
    width: 100%; height: 100px;
}
#cafeTitle {
    width: 100%; height: 100px;
}
#cafeTitle h1 {
    font-family: 'Jeju Gothic', sans-serif;
    font-size: 60px;
    font-weight: bold;
    text-align: center;
    color: #9C6C39;
    text-transform: uppercase;
}
/* main */

#wrap {
    width: 100%; height: 70vh;
}
#chstock_wrap {
    width: 70%; height: 60vh;
    margin: 0 auto;
    padding: 100px;
    border: 5px solid #9C6C39;
    text-align: center;
}
#chstock_wrap h2 {
    font-size: 60px;
    margin-bottom: 30px;
    color: #d69d60;
}
table {
    border-collapse: collapse;
    width: 100%;
    text-align: center;
}
th {
    width: 20%; height: 50px;
    border-top: 3px solid #9C6C39;
    border-bottom: 1px solid #9C6C39;
}
td {
    width: 20%; height: 50px;
    border-bottom: 3px solid #9C6C39;
}
#chstock_wrap .text_box{
    width: 300px; height: 30px;
    border: 1px solid #9C6C39;
}
#chstock_wrap .modify_button {
    background-color: #9C6C39;
    border: 1px solid #d69d60;
    color: #fff;
    border-radius: 2.5px;
    padding: 5px;
}
#button_sector {
    width: 70%; height: 40px;
    margin: 30px auto;
    text-align: center;
}
button {
    width: 40%; height: 40px;
    background-color: #9C6C39;
    border: 1px solid #d69d60;
    border-radius: 20px;
    color: #fff;
}
#button_sector a {
    display: inline-block;
    width: 40%; height: 40px;
    line-height: 40px;
    background-color: #9C6C39;
    border: 1px solid #d69d60;
    border-radius: 20px;
    color: #fff;
    margin-left: 2%;
}
</style>
</head>
<body>
   <header>
		<div id="cafeTitle">
			<h1>Java Cafe</h1>
		</div>
	</header>
    <div id="wrap">
        <div id="chstock_wrap">
            <h2>재고수량</h2>
            <form action="changeStock" method="post">
                <table>
                    <tr>
                        <th>상품번호</th>
                        <th>상품명</th>
                        <th>현재 재고량</th>
                        <th>변경된 재고량</th>
                    </tr>
                    <tr>
                        <td><input type="text" value="${menu.itemNumber }" name="itemNumber" class="text_box"/></td>
                        <td>${menu.itemName }</td>
                        <td>${menu.itemStock }</td>
                        <td>
                            <input type="number" name="newStockQuantity" class="text_box"/>
                            <input type="submit" value="수정" class="modify_button"/>
                        </td>
                    </tr>
                </table>
                <div id="button_sector">
                    <button type="button" onclick="history.back()">이전페이지</button>
                    <a href="home">홈으로</a> 
                </div>
        </form>
        </div>
    </div>
</body>
</html>