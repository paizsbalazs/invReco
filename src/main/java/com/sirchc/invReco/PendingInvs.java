package com.sirchc.invReco;

public class PendingInvs {

    public String id;
    public String status;
    public String descr;
    public String invtype;
    public String supvatnum;
    public String getin;

    public PendingInvs(String id, String status, String descr, String invtype, String supvatnum, String getin) {
        this.id = id;
        this.status = status;
        this.descr = descr;
        this.invtype = invtype;
        this.supvatnum = supvatnum;
        this.getin = getin;
    }
}
