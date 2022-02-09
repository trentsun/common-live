package com.xcbeyond.springboot.redis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.xcbeyond.springboot.SpringbootApplication;
import com.xcbeyond.springboot.dao.RoomDao;
import com.xcbeyond.springboot.dao.UserDao;
import com.xcbeyond.springboot.model.Room;
import com.xcbeyond.springboot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


//运行器，让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)
//SpringBoot单元测试注解，classes属性指定启动类
@SpringBootTest(classes=SpringbootApplication.class)
public class JsonRpcTest {
    static JsonRpcHttpClient client;

    @Autowired
    private RoomDao roomDao;

    class PlatformEntity {
        String name;
    }

    public JsonRpcTest() {
    }

    @Test
    public void testInsertUser() {
        String[] platforms = new String[]{"bilibili", "huya", "douyu"};
        for (String platform : platforms) {
            for (int room_id = 1000; room_id <= 10000; room_id++) {
                // 实例化请求地址，注意服务端web.xml中地址的配置
                try {
                    client = new JsonRpcHttpClient(new URL("http://127.0.0.1:4000/jsonrpc"));
                    // 请求头中添加的信息
                    Map<String, String> headers = new HashMap<String, String>();
                    // 添加到请求头中去
                    client.setHeaders(headers);
                    Object[] params = new Object[]{platform, room_id};
                    Room room = JsonRpcTest.getRoom(params);
                    roomDao.insertUser(room);
                    System.out.println(room.toString());
                    // print
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public static void main(String[] args) throws Throwable {
        // 实例化请求地址，注意服务端web.xml中地址的配置
        long before = System.currentTimeMillis();
        try {
            client = new JsonRpcHttpClient(new URL("http://127.0.0.1:4000/jsonrpc"));
            // 请求头中添加的信息
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Rpc-Type", "shop");
            // 添加到请求头中去
            client.setHeaders(headers);
            Object[] params = new Object[]{"bilibili", 46086};
            Room room = getRoom(params);

            System.out.println(room.toString());
            // print
        } catch (Exception e) {
            e.printStackTrace();
        }
        long after = System.currentTimeMillis();
        System.out.println("耗时：" + (after - before) + "ms.");
    }

    public void doSomething() throws Throwable {
        client.invoke("doSomething", null);
    }

    public static Room getRoom(Object[] params) throws Throwable {
        Room demo;
        demo = client.invoke("live_url", params, Room.class);
        return demo;
    }

    public int getInt(int code) throws Throwable {
        Integer[] codes = new Integer[]{code};
        return client.invoke("getInt", codes, Integer.class);
    }

    public String getString(String msg) throws Throwable {
        String[] msgs = new String[]{msg};
        return client.invoke("getString", msgs, String.class);
    }

}


