<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<div class="container">
<%--	${boards.content} : 반환타입 List아니고 페이징 적용한 Page타입이라서--%>
	<c:forEach var="board" items="${boards.content}">
		<div class="card m-2">
			<div class="card-body">
<%--				{board.title} : board객체의 getter 호출--%>
				<h4 class="card-title">${board.title}</h4>
				<a href="/board/${board.id}" class="card-link">상세보기</a>
			</div>
		</div>
	</c:forEach>
<%--	justify-content-center : 부트스트랩 가운데 정렬--%>
	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${boards.first}">
<%--				boards.number : Page속성에 있는거 (이해안되면 /dummy/user로 테스트해서 Page속성 json값 보기)--%>
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${boards.last}">
				<li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>

	</ul>
</div>

<%@ include file="layout/footer.jsp"%>


