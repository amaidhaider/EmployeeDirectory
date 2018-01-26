package com.example.EmployeeDirectory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amaid on 1/25/2018.
 */
public class DeptDao {
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

    public static List<Dept> getAllDepartment() {
        List<Dept> list = new ArrayList<Dept>();

        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM employeedirectory.tbl_department");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dept e = new Dept();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                list.add(e);
                //System.out.println(e.getId() + e.getWorkPhone() + e.getDepartment() + e.getTitle() + e.getEmail() + e.getName());
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = DeptDao.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from employeedirectory.tbl_department where id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static int update(String name,String id) {
        int status = 0;
        try {
            Connection con = DeptDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update employeedirectory.tbl_department set name=? where id=?");
            ps.setString(1, name);
            ps.setInt(2, Integer.parseInt(id));

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
}
