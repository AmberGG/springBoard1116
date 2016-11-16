<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
.modDiv {
	border: 1px solid pink;
	width: 300px;
	height: 100px;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-left: -150px;
	margin-top: -50px;
	background-color: lightpink;
	display: none;
}
</style>

</head>
<body>

	<h2>${vo.title}</h2>
	<h4>${vo.writer}</h4>
	<h4>${vo.content}</h4>
	<p>${vo.updatedate}</p>

	<button id="listBtn">목록</button>
	<button id="modBtn">수정</button>
	<button id="delBtn">삭제</button>

	<form method="get" id="f1" action="listSearch">
		<input type="hidden" name="page" value=${param.page}>
		<input type="hidden" name="sType" value=${param.sType}>
		<input type="hidden" name="keyword" value=${param.keyword}>
		<input type="hidden" name="bno" value=${param.bno}>
	</form>

	<div class="modDiv">
		<p>	title: <input type="text" id="title" name="title" value="${vo.title}"></p>
		<p> content: <input type="text" id="content" name="content" value="${vo.content}"></p>
		<button id="mBtn">modify</button>
	</div>

	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script>
	
	$("#listBtn").on("click",function(evnet){
		$("#f1").submit();
	});
	
	$("#delBtn").on("click",function(evnet){
		$("#f1").attr("action","delete").attr("method","post").submit();
	});

	
	  $("#modBtn").on("click",function () {
      $(".modDiv").show('slow');
  });
	
	  var modifyMannager = (function () {
	      var mod = function (data, fn) {
	         
	       $.post("modify",data, function(result){
	    	   fn(result); 
	       });
	      }; 
	      return {mod: mod};

	  })();


	  $("#mBtn").on("click",function () {
		  modifyMannager.mod(
				  {bno:'${param.bno}',title:$('.modDiv #title').val(),content:$('.modDiv #content').val()}, 
		      function (result) { alert(result)	 });
	  });
	

</script>



</body>
</html>