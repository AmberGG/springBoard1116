<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
ul li {
list-style:none;

}
</style>

</head>


<body>

<ul>
<c:forEach items="${list}" var="vo" >
<li>${vo.bno} <a href="${vo.bno}">${vo.title}</a> ${vo.writer} ${vo.regdate} </li>
</c:forEach>
</ul>


	<form method="get" id='f1'>
		<input id='pageHidden' type='hidden' name='page' value=${param.page}>
		<input id='bnoHidden' type='hidden' name='bno'>
	</form>


	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script>

$(document).ready(function() {

	$("ul li a").on("click", function(event) {
		event.preventDefault();
		var bno = $(this).attr("href");
		$("#bnoHidden").val(bno);
		$("#f1").attr("action", "view").submit(); 
	});

	var result = '${param.result}';

	if(result == 's'){
		alert("삭제처리완료");
		window.history.replaceState('', '', "list?page=1");
	}
});
	
</script>


</body>
</html>