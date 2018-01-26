package com.example.EmployeeDirectory;

import java.util.*;
import java.sql.*;

/**
 * Created by amaid on 1/24/2018.
 */


public class EmpDao {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://10.10.10.14:3306/employeedirectory","root","admin");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

/*
    public static int save(Emp e) {
        int status = 0;
        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into user905(name,password,email,country) values (?,?,?,?)");
            ps.setString(1, e.getName());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getCountry());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int update(Emp e) {
        int status = 0;
        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update user905 set name=?,password=?,email=?,country=? where id=?");
            ps.setString(1, e.getName());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getCountry());
            ps.setInt(5, e.getId());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from user905 where id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
*/
    public static Emp getEmployeeById(int id) {
        Emp e = new Emp();

        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM employeedirectory.tbl_employee where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setTitle(rs.getString(3));
                e.setDepartment(rs.getString(4));
                e.setWorkPhone(rs.getString(5));
                e.setEmail(rs.getString(6));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }


    public static List<Emp> getAllEmployees() {
        List<Emp> list = new ArrayList<Emp>();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM employeedirectory.tbl_employee");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Emp e = new Emp();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setTitle(rs.getString(3));
                e.setDepartment(rs.getString(4));
                e.setWorkPhone(rs.getString(5));
                e.setEmail(rs.getString(6));
                e.setManOfMonth(rs.getBoolean(7));
                list.add(e);
                //System.out.println(e.getId() + e.getWorkPhone() + e.getDepartment() + e.getTitle() + e.getEmail() + e.getName());
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<Emp> getSearchedEmployee(String dept ,String name,String email) {
        List<Emp> list = new ArrayList<Emp>();
        if(dept.equals("All")){
            return EmpDao.getAllEmployees();
        }else {
            try {
                Connection con = EmpDao.getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM employeedirectory.tbl_employee where department=? OR name=? OR email=?");
                ps.setString(1,dept);
                ps.setString(2,name);
                ps.setString(3,email);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Emp e = new Emp();
                    e.setId(rs.getInt(1));
                    e.setName(rs.getString(2));
                    e.setTitle(rs.getString(3));
                    e.setDepartment(rs.getString(4));
                    e.setWorkPhone(rs.getString(5));
                    e.setEmail(rs.getString(6));
                    list.add(e);
                    //System.out.println(e.getId() + e.getWorkPhone() + e.getDepartment() + e.getTitle() + e.getEmail() + e.getName());
                }
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


        return list;
    }

    public static EmployeeLogin checkLogin(String name , String pass) {
        EmployeeLogin e = new EmployeeLogin();

        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM employeedirectory.tbl_user where name=? AND password=?");
            ps.setString(1, name);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPassword(rs.getString(3));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }
}