package com.xh.controller;

import com.alibaba.fastjson.JSONObject;
import com.xh.dao.PurchaseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UpServlet",urlPatterns = "/UpServlet")
public class UpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.修正编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");

        //2.接收 2个参数
        String pId=req.getParameter("pId");
        int i = Integer.parseInt(pId);


        //重新赋值


        PurchaseDao service = new PurchaseDao();
        int ii = service.up(i);
        System.out.println("map = " + ii);
        //4.把map 变成json
        Map map = new HashMap();
        if (ii>0){

            map.put("code",0);
            map.put("msg","添加成功");
        }
        String s = JSONObject.toJSONString(map);
        System.out.println("s = " + s);
        //5.使用 流输出
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();
    }
}
