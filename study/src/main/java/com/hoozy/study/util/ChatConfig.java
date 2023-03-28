package com.hoozy.study.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

// stomp
@EnableWebSocketMessageBroker
@Configuration
public class ChatConfig implements WebSocketMessageBrokerConfigurer {
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// 클라이언트에서 웹소켓 연결할 때 사용할 API 경로를 설정해주는 메소드
		registry.addEndpoint("/ws/chat")
				.setAllowedOriginPatterns("*") // 외부에서도 접근 가능
				.withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// /queue 나 /topic이 api 경로 맨 앞에 붙으면 브로커가 잡아서 해당 채팅방에 있는 클라이언트에게 메시지 전달
		// /topic : 한 명이 메세지를 보내면 해당 토픽 내부에 유저에게 다 전달
		// /queue : 한 명이 베시지 보냈을 때 다른 한 명에게만 전달
		registry.enableSimpleBroker("/queue", "/topic");
		
		// 클라이언트가 메시지를 보낼 때 맨앞에 / 이 붙으면 broker로 보내짐
		registry.setApplicationDestinationPrefixes("/app");
	}
}
