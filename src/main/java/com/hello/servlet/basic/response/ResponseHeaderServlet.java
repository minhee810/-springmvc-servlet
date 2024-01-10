package com.hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status-line]
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 200번 코드
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // cache 무효화
        response.setHeader("Pragma", "no-cache"); // 과거 캐시 삭제
        response.setHeader("my-header", "hello"); // 내가 원하는 헤더를 저장

        // [Header 편의 메서드]
        content(response);
        cookie(response);
        redirect(response);

        // [message body 사용]
        PrintWriter writer = response.getWriter();
        writer.print("ok");

    }

    private void content(HttpServletResponse response) {

        // response.setHeader("Content-Type", "text/plain;charset=utf-8"); 대신
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
//        response.setContentLength(2); // (생략 시 자동 생성)
    }

    /*
    쿠키 객체 활용
     */
    private void cookie(HttpServletResponse response) {
        // Set-Cookie : myCookie=good; Max-Age=600;
        // response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); // 600초
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException{
//        Status Code = 302;
//        Location:/basic/hello-form.html
        // 1. header 설정 방법
//        response.setStatus(HttpServletResponse.SC_FOUND);  // 302 번 코드
//        response.setHeader("Location", "/basic/hello-form.html");
        // 2. sendRedirect 방법
        response.sendRedirect("/basic/hello-form.html");
    }


}
