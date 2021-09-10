package com.xh.controller;

import com.alibaba.fastjson.JSONObject;
import com.xh.service.PurchaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "SelectAllTb1Servlet",urlPatterns = "/SelectAllTb1Servlet")
public class SelectAllTb1Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受登陆传过来的3个参数
        //1、修正编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        String pId = req.getParameter("pId");
        String pType = req.getParameter("pType");

        String pName = req.getParameter("pName");

        String pUnit = req.getParameter("pUnit");

        String pNum = req.getParameter("pNum");
        String pPerson = req.getParameter("pPerson");
        String paDate = req.getParameter("paDate");

        String paState = req.getParameter("paState");

        Map paramMap = new HashMap();
        paramMap.put("pId",pId);
        paramMap.put("pType",pType);
        paramMap.put("pName",pName);
        paramMap.put("pUnit",pUnit);
        paramMap.put("pNum",pNum);
        paramMap.put("pPerson",pPerson);
        paramMap.put("paDate",paDate);
        paramMap.put("paState",paState);


        //调用service层
        PurchaseService tbl_purchaseService=new PurchaseService();
        Map map = tbl_purchaseService.likePname(paramMap);
        PrintWriter printWriter=resp.getWriter();
        String s= JSONObject.toJSONString(map);
        printWriter.println(s);
        printWriter.close();
    }
}
