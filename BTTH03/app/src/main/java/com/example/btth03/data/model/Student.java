package com.example.btth03.data.model;

import com.example.btth03.Utils.utils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Objects;


public class Student implements Serializable {

    @JsonProperty("id")
    private String studentId;
    private FullName fullName;
    @JsonProperty("birth_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = utils.DATE_FORMAT)
    private Date birthDate;
    @JsonProperty("address")
    private String address;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("email")
    private String email;
    @JsonProperty("major")
    private String major;
    @JsonProperty("gpa")
    private float gpa;
    @JsonProperty("year")
    private int year;

    public Student() {
    }

    public Student(String studentId) {
        setStudentId(studentId);
    }

    @JsonProperty("full_name")
    private void unpackFullName(Map<String, Object> fullName) {
        this.fullName = new FullName(
                Objects.requireNonNull(fullName.get("first")).toString(),
                Objects.requireNonNull(fullName.get("last")).toString(),
                Objects.requireNonNull(fullName.get("midd")).toString()
        );
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName.lastName + " " + fullName.midName
                + " " + fullName.firstName;
    }

    public void setFullName(String fullName) {
        if (this.fullName == null) {
            this.fullName = new FullName();
        }
        this.fullName.setFullName(fullName);
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFirstName() {
        return fullName.firstName;
    }

    public String getLastName() {
        return fullName.lastName;
    }

    public String getMiddName() {
        return fullName.midName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }


    static class FullName {
        @JsonProperty("first")
        private String firstName;
        @JsonProperty("last")
        private String lastName;
        @JsonProperty("mid")
        private String midName;

        public FullName() {
        }

        public FullName(String firstName, String lastName, String midName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.midName = midName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setMidName(String midName) {
            this.midName = midName;
        }

        public void setFullName(String fullName) {
            String[] names = fullName.split("\\s+");
            if (names.length == 1) {
                setFirstName(names[0]);
            } else if (names.length == 2) {
                setFirstName(names[1]);
                setLastName(names[0]);
            } else if (names.length >= 3) {
                setFirstName(names[names.length - 1]);
                setLastName(names[0]);
                StringBuilder midd = new StringBuilder();
                for (int i = 1; i < names.length - 1; i++) {
                    midd.append(names[i]).append(" ");
                }
                setMidName(midd.toString().trim());
            }
        }
    }
}
