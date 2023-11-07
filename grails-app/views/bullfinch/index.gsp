<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>
    <table class="table table-bordered">
        <thead>
            <tr>
                <td>ID</td>
            </tr>
        </thead>
        <tbody>
            <g:each in="${responses}" var="resp">
                <tr>
                    <td><g:link action="show" id="${resp.id}">${resp.id}</g:link></td>
                </tr>
            </g:each>
        </tbody>
    </table>
</body>
</html>