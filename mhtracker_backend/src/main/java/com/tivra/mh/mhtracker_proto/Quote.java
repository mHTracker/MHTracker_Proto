package com.tivra.mh.mhtracker_proto;

/**
 * Created by Ravinder.Singroha on 12/31/2015.
 */
public class Quote {
    Long id;
    String who;
    String whom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getWhom() {
        return whom;
    }

    public void setWhom(String whom) {
        this.whom = whom;
    }
}
