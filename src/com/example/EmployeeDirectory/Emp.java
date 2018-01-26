package com.example.EmployeeDirectory;

/**
 * Created by amaid on 1/24/2018.
 */
public class Emp {
    private int id;
    private String name,title,email,workPhone,department;
     boolean manOfMonth;

    public boolean isManOfMonth() {
        return manOfMonth;
    }

    public void setManOfMonth(boolean manOfMonth) {
        this.manOfMonth = manOfMonth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
