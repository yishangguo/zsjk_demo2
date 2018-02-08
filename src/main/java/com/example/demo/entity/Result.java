package com.example.demo.entity;

public class Result {

    private int flag;

    public Result() {
    }

    @Override
    public String toString() {
        return "Result{" +
                "flag=" + flag +
                '}';
    }

    public Result(int flag) {
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
