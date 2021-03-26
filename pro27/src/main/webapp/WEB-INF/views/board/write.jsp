<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src = "https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
	function write_check(){
		var title = $("#title").val();
		var content = $("#wcontent").val();
		var sid = $("#sid").val();
		
		if(sid == "" || sid == null){
			alert("작성 권한이 없습니다");
			return;
		}else if(title == "" || title == null){
			alert("제목을 입력해 주세요");
			return;
		}else if(content == "" || content == null){
			alert("내용을 입력해 주세요");
			return;
		}else{
			document.wfr.submit();
		}
	}
</script>
<body>
	<form action="${contextPath }/board/write2.do" name="wfr" method="post">
		<table align="center" width="80%" height="300">
			<tr height="30px">
				<td>제목</td>
				<td><input type="text" name="title" id="title" style="width:100%;"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" id="wcontent" style="width: 100%; height:100%"></textarea></td>
			</tr>
		</table>
		<input type="hidden" id="sid" value="${sid }">
		<input type="button" onclick="write_check();" value="저장">
		<input type="button" onclick="javascript:history.back();" value="뒤로가기">
	</form>
</body>
</html>