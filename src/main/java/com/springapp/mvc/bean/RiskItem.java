package com.springapp.mvc.bean;

import java.util.Date;

/**
 * Created by H77 on 2016/11/7 0007.
 */
public class RiskItem {
    //4.风险条目：风险编号（主键）、项目编号、风险提出者编号、风险内容、风险类别（性能风险、进度风险、成本风险.......）
    // 风险概率（高、中、低）、风险影响程度（高、中、低）、建立时间
    private int rid;
    private int projectId;
    private int createrId;
    private String descript;
    private int typeId;
    private int prob;
    private int affect;
    private Date time;

    public RiskItem() {
    }

    public RiskItem(int rid, int projectId, int createrId,
                    String descript, int typeId, int prob, int affect) {
        this.rid = rid;
        this.projectId = projectId;
        this.createrId = createrId;
        this.descript = descript;
        this.typeId = typeId;
        this.prob = prob;
        this.affect = affect;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getCreaterId() {
        return createrId;
    }

    public void setCreaterId(int createrId) {
        this.createrId = createrId;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getProb() {
        return prob;
    }

    public void setProb(int prob) {
        this.prob = prob;
    }

    public int getAffect() {
        return affect;
    }

    public void setAffect(int affect) {
        this.affect = affect;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}