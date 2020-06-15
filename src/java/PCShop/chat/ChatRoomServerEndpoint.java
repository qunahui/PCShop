/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PCShop.chat;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


import javax.websocket.*;
import javax.websocket.server.*;
import org.json.simple.JSONObject;
/**
 *
 * @author Hui
 */

@ServerEndpoint("/chatroomServerEndpoint")
public class ChatRoomServerEndpoint {
    static Set<Session> chatroomUsers = Collections.synchronizedSet(new HashSet<Session>());
    @OnOpen
    public void handleOpen(Session userSession) {
        chatroomUsers.add(userSession);
    }
    
    @OnMessage
    public void handleMessage(String message, Session userSession) throws IOException{
        String username = (String) userSession.getUserProperties().get("username");
        if(username == null) {
            userSession.getUserProperties().put("username", message);
            userSession.getBasicRemote().sendText(buildJsonData("System","you are now connected as " + message));
        } else {
            Iterator<Session> iterator = chatroomUsers.iterator();
            while(iterator.hasNext()) {
                iterator.next().getBasicRemote().sendText(buildJsonData(username,message));
            }
        }
    }
    
    @OnClose
    public void handleClose(Session userSession) {
        chatroomUsers.remove(userSession);
    }

    private String buildJsonData(String username, String message) {
        JSONObject obj = new JSONObject();
        obj.put("message", username + ": " + message);
        System.out.println(obj);
        return obj.toJSONString();
    }
    
    @OnError
    public void onError(Throwable error) {
    }
}
