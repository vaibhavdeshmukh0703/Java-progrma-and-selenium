package com.vaibhav;

public class Details {
   private String companyName;
    private String emailId;

     Details(String companyName, String emailId){
        this.companyName = companyName;
        this.emailId = emailId;
     }


    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

}
