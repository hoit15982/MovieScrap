<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
	<script>
		$(document).ready(function() {
			$.ajax({
				dataType : "json",
				type: "post",
				url : "./test2.jsp",
				success : onSuccess,
				error : onError,
				async : false
			});
		});
/* 		$(document).ready(function() {
			$.ajax({
				dataType : "json",
				type: "post",
				url : "./test2.jsp",
				success : onSuccess,
				error : onError,
				async : false
			});
		}); */
		
		function onSuccess(data){
			var items = data.items;
			var output="";
			
			for(var i=0; i<items.length; i++) {
				output+="<li>"+items[i].title+"</li>"
			}
			$("#list").append(output);
			console.log(items);
		}
		
		
		function onError(request,status,error){
			/* alert("메롱"); */
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

		}
		
		
	</script>
</head>
<body>
<ul id="list"></ul>
남형남형
</body>

</html>
