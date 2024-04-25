package com.app.studenthub.dto;

import com.app.studenthub.util.YearOfStudy;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private List<Long> interestIds = new ArrayList<>();
    private String firstName;
    private String lastName;
    private String country;
    private String program;
    private String major;
    private YearOfStudy yearOfStudy;

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public YearOfStudy getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(YearOfStudy yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public List<Long> getInterestIds() {
        if (interestIds == null) {
            return new ArrayList<>();
        }
        return interestIds;
    }

    public void setInterestIds(List<Long> interestIds) {
        this.interestIds = interestIds;
    }

}
