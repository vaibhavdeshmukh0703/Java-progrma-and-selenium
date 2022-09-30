package com.vaibhav;

public class EmployeePojo {
    private String name;
    private String job;
    private String[] skill;

    private Details details;

    EmployeePojo(String name, String job, String[] skill, String companyName, String emailId) {
        this.name = name;
        this.job = job;
        this.skill = skill;
        this.details = new Details(companyName, emailId);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String[] getSkill() {
        return this.skill;
    }

    public void setSkill(String[] skill) {
        this.skill = skill;
    }

    public Details getDetails() {
        return this.details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

}
