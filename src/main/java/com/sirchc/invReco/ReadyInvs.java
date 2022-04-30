package com.sirchc.invReco;

public class ReadyInvs {

    public String id;
    public String status;
    public String descr;
    public String invtype;
    public String supvatnum;
    public String cusvatnum;
    public String invnum;

    public ReadyInvs(String id, String status, String descr, String invtype, String supvatnum, String cusvatnum, String invnum) {
        this.id = id;
        this.status = status;
        this.descr = descr;
        this.invtype = invtype;
        this.supvatnum = supvatnum;
        this.cusvatnum = cusvatnum;
        this.invnum = invnum;
    }
}
