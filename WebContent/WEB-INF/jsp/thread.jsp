<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/Forum/css/common.css">
		<title>${thread.title}</title>
	</head>
	<body>

		<!-- メッセージ表示 -->
		<c:if test="${not empty message}">
			<div id="msgbox" style="float:right; text-align:center; border:1px solid lightgray; margin:1em; padding:1em; font-size:0.8em; color:#888888;">
				${message}
			</div>
			<script>
				setTimeout
				(
					function() { document.getElementById("msgbox").style.display = "none"; }, 2500
				);
			</script>
		</c:if>

		<!-- 掲示板タイトル & 検索機能 -->
		<form action="/Forum/threads" method="post">
			<div style="padding:1em; background:#EEEEEE;">
				<span style="font-size:1.1em;">タマ</span><span style="font-size:0.8em;">ちゃんねる (=^・^=)</span>
				<span style="margin-left:2em;">
					<input type="text" name="word" size="24" maxlength="30" required>
					<input type="submit" value="️🔎捜索&nbsp;" style="padding:0.4em;">
					<input type="hidden" name="threadId" value="${thread.threadId}">
					<input type="hidden" name="pageId" value="thread">
					<input type="hidden" name="eventId" value="search">
				</span>
			</div>
		</form>

		<!-- スレッドタイトル -->
		<div style="color:#6666BB; font-size:1.2em; font-weight:bold; margin:1em; clear:both;">${thread.title}</div>

		<!-- レス表示のループ -->
		<c:forEach var="v" items="${contents}" varStatus="sts">
			<table style="margin:0.5em;">
				<tr>
					<td id="${v.no}" style="width:1em; text-align:right;">${v.no}</td>
					<td style="color:green; width:15em;">${v.poster}</td>
					<td style="font-style:italic; font-size:0.7em;">${v.postDT}</td>
				</tr>
				<tr>
					<td colspan="3" style="padding:0.8em;">${v.content}</td>
				</tr>
			</table>
		</c:forEach>

		<!-- 再読み込みボタン -->
		<form action="/Forum/threads" method="post">
			<div align="right" style="margin-right:1em; float:right;">
				<input type="submit" value="🔄 スレの再読み込み" style="padding:0.8em">
				<input type="hidden" name="threadId" value="${thread.threadId}">
				<input type="hidden" name="pageId" value="thread">
			</div>
		</form>

		<hr style="border: 1px solid #EEEEEE; margin:1.0em;">

		<!-- スレッド一覧遷移ボタン -->
		<form action="/Forum/threads" method="post">
			<input type="submit" value="🔝 スレッド一覧へ" class="link" style="margin:1em;">
		</form>

		<!-- 投稿機能 -->
		<form action="/Forum/threads" method="post">

			<div align="center" style="clear:both;">

				<table style="margin-bottom:1em;">
					<tr>
						<td style="color:#8888BB; font-weight:bold;">レスの投稿</td>
					</tr>
					<tr>
						<td>
							<input type="text" name="poster" size="30" maxlength="15" placeholder="名前（省略可）">
						</td>
					</tr>
					<tr>
						<td>
							<textarea name="content" cols="50" rows="3" placeholder="コメント" maxlength="200" wrap="off" required></textarea>
						</td>
					</tr>
					<tr>
						<td align="right">
							<input type="submit" value="書き込む" style="padding:0.6em;">
						</td>
					</tr>
				</table>

				<input type="hidden" name="threadId" value="${thread.threadId}">
				<input type="hidden" name="pageId" value="thread">
				<input type="hidden" name="eventId" value="post">

			</div>

		</form>

	</body>
</html>