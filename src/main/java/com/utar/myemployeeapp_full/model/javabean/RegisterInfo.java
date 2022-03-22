package com.utar.myemployeeapp_full.model.javabean;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

public class RegisterInfo {

    private String fname;
    @NotNull
    private String lname;
    @NotNull
    private String address;
    private String gender;
    private String[] qualification;
    private String race;
    private String intro;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getQualification() {
        return qualification;
    }

    public void setQualification(String[] qualification) {
        this.qualification = qualification;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }



    @Override
    public String toString() {
        return "RegisterInfo{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", qualification=" + Arrays.toString(qualification) +
                ", race='" + race + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}
