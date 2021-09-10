package com.xh.controller;

import com.alibaba.fastjson.JSONObject;
import com.xh.bean.Purchase;
import com.xh.service.PurchaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "AddServlet",urlPatterns = "/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.修正编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");

        //2.接收 2个参数
        String pType=req.getParameter("pType");
        String pName=req.getParameter("pName");
        String pUnit=req.getParameter("pUnit");
        String pNum=req.getParameter("pNum");
        String pPerson=req.getParameter("pPerson");

        System.out.println("pName = " + pName);

        //重新赋值
        Purchase purchase = new Purchase();
        purchase.setpType(pType);
        purchase.setpName(pName);
        purchase.setpUnit(pUnit);
        purchase.setpNum(Integer.parseInt(pNum));
        purchase.setpPerson(pPerson);

        PurchaseService service = new PurchaseService();
        Map map = service.addTbl(purchase);
        System.out.println("map = " + map);
        //4.把map 变成json
        String s = JSONObject.toJSONString(map);
        System.out.println("s = " + s);
        //5.使用 流输出
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();
    }
}
