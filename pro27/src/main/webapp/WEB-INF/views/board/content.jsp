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
<body>
	<table align="center" width="80%" height="500px">
		<tr height="30px" style="border-bottom: 1px">
			<th>글번호</th>
			<td>${vo.articleno }</td>
			<th>작성시간</th>
			<td>${vo.writedate }</td>
			<th>조회수</th>
			<td></td>
		</tr>
		<tr height="30px">
			<th>제목</th>
			<td colspan="3">${vo.title }</td>
			<th>작성자</th>
			<td>${vo.id }</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="5" align="left">${vo.content }</td>
		</tr>
	</table>
	<div align="right">
		<input type="button" value="목록" onclick="location.href='${contextPath }/board/listArticles.do'"/>
		<c:if test="${sid == vo.id }">
			<input type="button" value="수정" onclick="location.href='${contextPath}/board/update.do?num=${vo.articleno }'"/>
			<input type="button" value="삭제" onclick="location.href='${contextPath}/board/delete.do?num=${vo.articleno }'"/>
		</c:if>
	</div>
</body>
</html>