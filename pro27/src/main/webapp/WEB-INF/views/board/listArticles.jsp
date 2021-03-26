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
	<table align="center" width="80%" style="margin: 0 auto">
		<c:choose>
			<c:when test="${boardList == '0'}">
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성시간</th>
				</tr>
				<c:forEach var="board" items="${boardList}">
					<tr onclick="location.href='${contextPath }/board/content.do?num=${board.articleno}'">
						<td>${board.articleno }</td>
						<c:choose>
							<c:when test="${board.parentno != 0}">
								<td>ㄴ>${board.title }</td>
							</c:when>
							<c:otherwise>
								<td>${board.title }</td>
							</c:otherwise>
						</c:choose>
						<td>${board.id }</td>
						<td>${board.writedate }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr><th>글이 존재하지 않습니다</th></tr>
			</c:otherwise>
		</c:choose>
	</table>
	<form action="${contextPath }/board/search.do" method="get">
		<div style="float: right; margin: 30px 180px 0 0">
			<input type="text" name="search">
			<input type="submit" value="검색">
			<c:if test="${sid != null}">
				<input type="button" value="글쓰기" onclick="location.href='${contextPath }/board/write.do'">
			</c:if>
		</div>
	</form>
</body>
</html>