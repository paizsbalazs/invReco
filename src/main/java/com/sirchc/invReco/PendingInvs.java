package com.sirchc.invReco;

public class PendingInvs {

    public String id;
    public String status;
    public String descr;
    public String invtype;
    public String supvatnum;

    public PendingInvs(String id, String status, String descr, String invtype, String supvatnum) {
        this.id = id;
        this.status = status;
        this.descr = descr;
        this.invtype = invtype;
        this.supvatnum = supvatnum;
    }
}
