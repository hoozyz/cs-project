package com.hoozy.study.listener;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@Configuration
public class LoggedInUsersListener implements HttpSessionListener {

    private static List<HttpSession> sessions = new ArrayList<>();

    // 현재 세션 다 가져오기
    public static List<HttpSession> getLoggedInUsers() {
        return sessions;
    }

    // 세션이 생성될 때 -> 로그인할 때 세션에 저장
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        sessions.add(session);
    }

    // 세션이 제거될 때 -> 로그아웃할 때 세션에서 제거
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        sessions.remove(session);
    }
}