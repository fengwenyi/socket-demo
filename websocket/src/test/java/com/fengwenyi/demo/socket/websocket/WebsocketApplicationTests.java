package com.fengwenyi.demo.socket.websocket;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebsocketApplicationTests {

	@Test
	public void contextLoads() {

	}

	@Test
	public void toJson () {
		Map<String, String> map = new HashMap<>();
		map.put("from", "sId");
		map.put("to", "sId");
		map.put("content", "content");
		System.out.println(new Gson().toJson(map));
	}

}
