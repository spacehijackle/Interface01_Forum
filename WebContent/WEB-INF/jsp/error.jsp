<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/Forum/css/common.css">
		<title>エラーページ</title>
	</head>
	<body>

		<!-- 掲示板タイトル -->
		<div style="padding:1em; background:#EEEEEE;">
			<span style="font-size:1.1em;">タマ</span><span style="font-size:0.8em;">ちゃんねる (=－・－=)</span>
			<span style="margin-left:1em; color:darkred; font-weight:bold;">エラー発生</span>
		</div>

		<!-- エラーメッセージ -->
		<div style="margin:1em; padding:1em; border:1px solid lightgray;">
			<span style="font-size:0.9em;">エラーが発生しました。</span><br/><br/>
			<span style="font-size:0.8em;">管理者のタマちゃんに伝えてチョーだい =^_^=</span>
		</div>

		<!-- スレッド一覧遷移ボタン -->
		<form action="/Forum/threads" method="post">
			<input type="submit" value="🔝 スレッド一覧へ" class="link" style="margin:1em;">
		</form>

	</body>
</html>