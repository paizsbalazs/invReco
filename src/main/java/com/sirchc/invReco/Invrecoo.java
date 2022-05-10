package com.sirchc.invReco;

public class Invrecoo {

    public String licence;
    public String invtype;
    public String taxnumber;
    public String pdf;

    public Invrecoo(String licence, String invtype, String taxnumber, String pdf) {
        this.licence = licence;
        this.invtype = invtype;
        this.taxnumber = taxnumber;
        this.pdf = pdf;
    }

    public String getLicence() {
        return licence;
    }

    public String getTaxnumber() {
        return taxnumber;
    }

    public String getInvtype() {
        return invtype;
    }

    public void setInvtype(String invtype) {
        this.invtype = invtype;
    }

    public String getPdf() {
        return pdf;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public void setTaxnumber(String taxnumber) {
        this.taxnumber = taxnumber;
    }

    public void setPdf() {
        this.pdf = pdf;
    }
}
