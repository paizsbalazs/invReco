package com.sirchc.invReco;

public class InvReco {

    public Long licence;
    public String taxnumber;
    public String pdf;

    public Long getLicence() {
        return licence;
    }

    public String getTaxnumber() {
        return taxnumber;
    }

    public String getPdf() {
        return pdf;
    }

    public void setLicence(Long licence) {
        this.licence = licence;
    }

    public void setTaxnumber(String taxnumber) {
        this.taxnumber = taxnumber;
    }

    public void setPdf() {
        this.pdf = pdf;
    }
}
