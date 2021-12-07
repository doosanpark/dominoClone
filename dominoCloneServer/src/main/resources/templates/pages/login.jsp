<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="UTF-8">
        <title>로그인 페이지</title>
    </head>
    <body>
        <h1>로그인</h1>
        <hr>
        <form th:action="@{/login}" method="post">
            <input type="text" name="username" placeholder="account를 입력해주세요.">
            <input type="password" name="password" placeholder="password를 입력해주세요.">
            <button type="submit">로그인</button>
        </form>
    </body>
</html>