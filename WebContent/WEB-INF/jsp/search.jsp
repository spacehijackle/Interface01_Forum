<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/Forum/css/common.css">
		<title>捜索結果</title>
	</head>
	<body>

		<!-- 掲示板タイトル -->
		<div style="padding:1em; background:#EEEEEE;">
			<span style="font-size:1.1em;">タマ</span><span style="font-size:0.8em;">ちゃんねる (=^・^=)</span>
			<span style="margin-left:1em; color:#6666BB; font-weight:bold;">🏃‍♂️捜索結果 - ${result_size}件</span>
		</div>

		<!-- レス表示のループ -->
		<c:forEach var="v" items="${contents}" varStatus="sts">
			<table style="margin:0.5em;">
				<tr>
					<td style="width:1em; text-align:right;">
						<form action="/Forum/threads#${v.no}" method="post">
							<input type="submit" value="${v.no}"  class="link" style="font-size:1em;">
							<input type="hidden" name="threadId" value="${threadId}">
							<input type="hidden" name="pageId" value="thread">
						</form>
					</td>
					<td style="color:green; width:15em;">${v.poster}</td>
					<td style="font-style:italic; font-size:0.7em;">${v.postDT}</td>
				</tr>
				<tr>
					<td colspan="3" style="padding:0.8em;">
						${fn:replace(v.content, search_word, "<span style=\"background:lemonchiffon; font-weight:bold;\">".concat(search_word).concat("</span>"))}
					</td>
				</tr>
			</table>
		</c:forEach>

		<!-- スレッドに戻るボタン -->
		<form action="/Forum/threads" method="post">
			<input type="submit" value="🔙 スレッドに戻る"  class="link" style="margin:1em;">
			<input type="hidden" name="threadId" value="${threadId}">
			<input type="hidden" name="pageId" value="thread">
		</form>

		<%-- サーブレット情報
		<div>Servlet Engine: <span><%= session.getServletContext().getMajorVersion() %>.<%= session.getServletContext().getMinorVersion() %></span></div>
		<div>JSP Engine: <span><%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %></span></div>
		<div>Application Server: <span><%= application.getServerInfo() %></span></div>
		--%>

	</body>
</html>