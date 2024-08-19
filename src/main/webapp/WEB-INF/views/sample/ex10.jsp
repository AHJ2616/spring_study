<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>commons-upload 를 활용한 테스트</title>
</head>
<body>
	<form action="/sample/ex10_upload" method="pst" enctype="multipart/form-data">
		<div>
		<input type="file" name="files" />
		<input type="file" name="files" />
		<input type="file" name="files" />
		<input type="file" name="files" />
		<input type="file" name="files" />
		<button type="submit">전송</button>
		</div>
	</form>
</body>
</html>