package com.po;

/**
 * @program database
 * @description: TODO: persistent object for faculty.
 * @author: tujunda
 * @create: 2018/11/18 21:09
 */
public class FacultyPO {
    private String id;
    private String name;
    private String deptId;
    private String password;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "FacultyPO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", deptId='" + deptId + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

