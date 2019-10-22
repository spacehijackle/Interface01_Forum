<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/Forum/css/common.css">
		<title>スレッド一覧</title>
	</head>
	<body>

		<!-- 掲示板タイトル -->
		<div style="padding:1em; background:#EEEEEE;">
			<span style="font-size:1.1em;">タマ</span><span style="font-size:0.8em;">ちゃんねる (=^・^=)</span>
			<span style="margin-left:1em; color:#6666BB; font-weight:bold;">スレッド一覧</span>
		</div>

		<!-- スレッド一覧 -->
		<div style="margin:1em;">
			<c:forEach var="v" items="${threads}" varStatus="sts">
				<form action="/Forum/threads" method="post">
					<div style="font-size:0.9em;">
						<span><fmt:formatNumber value="${sts.count}" groupingUsed="false" minIntegerDigits="3" />: </span>
						<span style="color:green; width:15em;">
							<input type="submit" value="${v.title} （${v.lastNo}）" class="link">
							<input type="hidden" name="threadId" value="${v.threadId}">
						</span>
					</div>
					<input type="hidden" name="pageId" value="thread">
				</form>
			</c:forEach>
		</div>

	</body>
</html>