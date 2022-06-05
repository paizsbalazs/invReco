package com.sirchc.invReco;

public class PendingInvs {

    public String id;
    public String getin;
    public String status;
    public String descr;
    public String invtype;
    public String supvatnum;

    public PendingInvs(String id, String getin, String status, String descr, String invtype, String supvatnum) {
        this.id = id;
        this.getin = getin;
        this.status = status;
        this.descr = descr;
        this.invtype = invtype;
        this.supvatnum = supvatnum;
    }
}
