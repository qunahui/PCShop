<%-- 
    Document   : testSocket
    Created on : Jun 10, 2020, 8:56:33 PM
    Author     : Hui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            var websocket = new WebSocket("ws://localhost:8080/PCShop/chatroomServerEndpoint");
            websocket.onmessage = function processMessage(message) {
                var jsonData = JSON.parse(message.data);
                if(jsonData.message !== null) {
                    messageTextArea.value += jsonData.message + "\n";
                }
            }
            function sendMessage() {
                websocket.send(messageText.value);
                messageText.value = "";
            }
        </script>
    </head>
    <body>
        <textarea id="messageTextArea" readonly row="10" cols="45"></textarea><br/>
        <input type="text" id="messageText" size="50"/><input type="button" value="Send" onclick="sendMessage();"/>
    </body>
</html>
