package com.junjc9.funu.f4d.data.res;

import com.junjc9.funu.f4d.data.dto.GankIO;

import java.util.ArrayList;

public class GankRes {
    private Boolean error;
    private ArrayList<GankIO> results;

    public GankRes() { }

    public GankRes(Boolean error, ArrayList<GankIO> results) {
        this.error = error;
        this.results = results;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public ArrayList<GankIO> getResults() {
        return results;
    }

    public void setRes(ArrayList<GankIO> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "GankRes{" +
                "error=" + error +
                ", results=" + results.toString() +
                '}';
    }
}
