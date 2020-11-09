package com.yg.sevlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("success!");

//        getServletContext().setAttribute("", "");
        int userCount = (int) getServletContext().getAttribute("userCount");
        resp.getWriter().write("当前登录的用户量：" + userCount);
    }
}
