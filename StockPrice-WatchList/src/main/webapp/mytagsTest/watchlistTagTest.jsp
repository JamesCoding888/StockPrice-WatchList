<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Watch List Table</title>
    </head>
    <body style="padding: 15px">
        <h1>
            <my:watchListTagTest symbols = "${ param.symbols }" />
        </h1>   
    </body>
</html>
