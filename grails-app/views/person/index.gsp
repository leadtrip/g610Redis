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
                <td>Name</td>
                <td>Age</td>
            </tr>
        </thead>
        <tbody>
            <g:each in="${people}" var="person">
                <tr>
                    <td><g:link action="show" id="${person.id}">${person.id}</g:link></td>
                    <td>${person.name}</td>
                    <td>${person.age}</td>
                </tr>
            </g:each>
        </tbody>
    </table>
</body>
</html>