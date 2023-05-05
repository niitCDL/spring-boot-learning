package com.example.websocket;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

//服务端接收类
@ServerEndpoint(value = "/socket/{id}")
@Component
@Slf4j
public class WebSocketServer {

    /**
     * 用来统计在线数量
     */
    private static int onlineCount = 0;

    /**
     * 与某个客户端连接的会话,存放了和客户端连接对应的webSocket对象
     */
    private Session session;

    private Integer id;

    /**
     * concurrent 包: 线程安全的集合,用来存储每个客户端对应的 WebSocket 对象
     */
    public static ConcurrentHashMap<Integer, WebSocketServer> map = new ConcurrentHashMap<>();

    /**
     * 连接建立成功调用的方法
     */

    @OnOpen
    public void onOpen(@PathParam(value = "id") Integer id, Session session) {
        log.info("连接成功");
        this.id = id;
        this.session = session;
        map.put(id, this);
        addOnlineCount();
        log.info("有新连接加入,当前在线人数为:{}", getOnlineCount());
        sendMsg("--连接成功已经建立--");
    }

    @OnClose
    public void onClose() {
        //从map移除
        map.remove(this.id);
        //在线人数减一
        subOnlineCount();
        log.info("有连接关闭,当前在线人数为:{}", getOnlineCount());
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error(error.getMessage());
//        error.printStackTrace();
    }

    /**
     * 收到客户端发送的消息后,调用的方法
     *
     * @param session
     * @param zz
     */
    @OnMessage
    public void onMessage(Session session, String zz) {
        log.info("接收到客户端所发送的消息:{}",zz);
        this.sendMsg(zz);
    }

    /**
     * 群发消息
     *
     * @param msg
     */
    private void sendMsg(String msg) {
        RemoteEndpoint.Basic remote = getSession().getBasicRemote();
        try {
            remote.sendText(msg);
        } catch (IOException e) {
            log.error("发送消息失败!");
            throw new RuntimeException(e);
        }
    }

    /**
     * 给指定的id发送消息
     *
     * @param id
     * @param msg
     */
    private void sendMsgById(Integer id, String msg) {
        WebSocketServer webSocketServer = map.get(id);
        if (webSocketServer != null) {
            webSocketServer.sendMsg(msg);
        }else {
            log.info("客户端已下线");
        }
    }

    /**
     * 群发自定义消息
     * @return
     */
    private void broadcastMsg(String msg){
        for (WebSocketServer item : map.values()) {
            item.sendMsg(msg);
        }
    }

    public Session getSession() {
        return this.session;
    }

    private static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

    private static int getOnlineCount() {
        return WebSocketServer.onlineCount;
    }
}
