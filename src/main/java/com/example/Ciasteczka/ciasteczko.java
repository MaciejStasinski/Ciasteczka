package com.example.Ciasteczka;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ciasteczko")
public class ciasteczko extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ciasteczko() {
        super();
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter responseWriter = resp.getWriter();
//         ZAPIS
        String Name;
        String Value;
        Cookie cookie = new Cookie("Miasto","Wrocław");
        Cookie cookie2 = new Cookie("Autor", "Nieznany");
        Cookie cookie3 = new Cookie("Co","Gówno");

        cookie.setMaxAge(600);
        resp.addCookie(cookie);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);

        responseWriter.write("<html><body>test");
        // ODCZYT
        Cookie[] cookies = req.getCookies();
        for(Cookie ciasteczko: cookies) {
            Value = ciasteczko.getValue();
            Name = ciasteczko.getName();
            responseWriter.println("<br    >"+Name+" : "+Value);
        }
        responseWriter.write("</body></html>");
    }
}
