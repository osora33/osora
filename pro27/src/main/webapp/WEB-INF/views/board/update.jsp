<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%request.setCharacterEncoding("utf-8"); %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src = "https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
	function update_check(){
		var title = $("#title").val();
		var content = $("#wcontent").val();
		var sid = $("#sid").val();
		var vo_id = $("#vo_id").val();
		
		if(sid != vo_id){
			alert("수정 권한이 없습니다");
			return;
		}else if(title == "" || title == null){
			alert("제목을 입력해 주세요");
			return;
		}else if(content == "" || content == null){
			alert("내용을 입력해 주세요");
			return;
		}else{
			document.ufr.submit();
		}
	}
</script>
</head>
<body>
	<form action="${contextPath }/board/update2.do" name="ufr" method="post">
		<table align="center" width="80%" height="300">
			<tr height="30px">
				<td>제목</td>
				<td><input type="text" id="title" name="title" value="${vo.title }" style="width:100%;"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" id="wcontent" style="width: 100%; height:100%">${vo.content }</textarea></td>
			</tr>
		</table>
		<input type="hidden" id="sid" value="${sid }">
		<input type="hidden" id="vo_id" value="${vo.id }">
		<input type= "hidden" name="articleno" value="${vo.articleno }">
		<input type="button" value="저장" onclick="javascript:update_check();">
		<input type="button" onclick="javascript:history.back();" value="뒤로가기">
	</form>
</body>
</html>