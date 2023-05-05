<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Freemarker 邮件</title>
</head>
<body>
    <table>
        <tr>
            <th>序号</th>
            <th>标题</th>
            <th>创建时间</th>
        </tr>

        <#list articles as article>
            <tr>
                <td>${article.id}</td>
                <td>${article.title}</td>
                <td>${article.dateTime?string("yyyy-MM-dd HH:mm:ss")}</td>
            </tr>
        </#list>
    </table>
</body>
</html>