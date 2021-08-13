package ui.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Service;
import org.json.JSONException;
import org.json.JSONObject;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ServerEndpoint("/notify")
public class NotifyServer {

    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
    private Service model = new Service();


    @OnOpen
    public void onOpen(Session session) throws JsonProcessingException {
        sessions.add(session);

    }

    @OnMessage
    public void onMessage(String message, Session session) throws JSONException, IOException {
        JSONObject object = new JSONObject(message);
        sendMessageToAll(message);
        String name = object.getString("name");
        model.addPositive(name);

    }

    @OnClose
    public void onClose(Session session){
        sessions.remove(session);
    }

    private void sendMessageToAll(String message) throws IOException {
        for (Session s : sessions) {
            s.getBasicRemote().sendText(message);
        }
    }




}
