package com.xh.bean;

import java.util.Date;

public class Approval {
    private int paId;
    private int pId;
    private Date paDate;
    private String paState;

    public int getPaId() {
        return paId;
    }

    public void setPaId(int paId) {
        this.paId = paId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public Date getPaDate() {
        return paDate;
    }

    public void setPaDate(Date paDate) {
        this.paDate = paDate;
    }

    public String getPaState() {
        return paState;
    }

    public void setPaState(String paState) {
        this.paState = paState;
    }

    @Override
    public String toString() {
        return "Tbl_pur_approval{" +
                "paId=" + paId +
                ", pId=" + pId +
                ", paDate=" + paDate +
                ", paState='" + paState + '\'' +
                '}';
    }
}
