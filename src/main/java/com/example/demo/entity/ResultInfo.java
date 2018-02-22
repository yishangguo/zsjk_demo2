package com.example.demo.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/21.
 */
public class ResultInfo implements Serializable {

    private static final long serialersionUID = -1L;
    private String resultInfo;
    public ResultInfo(String resultInfo){
        super();
        this.resultInfo = resultInfo;
    }
    public ResultInfo(){
        super();
    }
    public String getResultInfo(){
        return resultInfo;
    }
    public void setResultInfo(String resultInfo){
        this.resultInfo = resultInfo;
    }
}
