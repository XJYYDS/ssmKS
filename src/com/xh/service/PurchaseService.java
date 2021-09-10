package com.xh.service;

import com.xh.bean.Purchase;
import com.xh.dao.PurchaseDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseService {
    //全查
    public Map tbl_purchaseService(Map map1) {
        PurchaseDao dao = new PurchaseDao();
        List<Map> maps = dao.selectAllTb(map1);
        Map codeMap = new HashMap();
        codeMap.put("code", 0);
        codeMap.put("data", maps);
        codeMap.put("msg", "ok");
        return codeMap;
    }

    public Map likePname(Map map) {
        PurchaseDao dao = new PurchaseDao();
        List<Map> maps = dao.likePname(map);
        Map codeMap = new HashMap();
        codeMap.put("code", 0);
        codeMap.put("data", maps);
        codeMap.put("msg", "ok");
        return codeMap;
    }

    //添加
    public Map addTbl(Purchase tbl) {
        System.out.println("进入到 service 层了---");
        Map map = new HashMap();
        PurchaseDao dao = new PurchaseDao();
        int i = dao.addTbl(tbl);
        System.out.println("i = " + i);
        if (i == 1) {
            map.put("code", 0);
            map.put("msg", "添加成功");
        } else {
            map.put("code", 400);
            map.put("msg", "添加不成功");
        }
        return map;
    }
}
