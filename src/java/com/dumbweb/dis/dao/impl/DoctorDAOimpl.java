/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dumbweb.dis.dao.impl;

import com.dumbweb.dis.dbutil.DbConnection;
import com.dumbweb.dis.dao.DoctorDAO;
import com.dumbweb.dis.entity.Doctor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class DoctorDAOimpl implements DoctorDAO {

    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private DbConnection db = new DbConnection();

    public DoctorDAOimpl() {

    }

    @Override
    public void insert(Doctor d) {

        try {
            String sql = "INSERT INTO tbl_details SET first_Name=?, last_Name=?,address=?,contact=?,specialization=?,workplace=? ";

            db.open();
            ps = db.initStatement(sql);

            ps.setString(1, d.getFirstName());
            ps.setString(2, d.getLastName());
            ps.setString(3, d.getAddress());
            ps.setString(4, d.getContact());
            ps.setString(5, d.getSpecialization());
            ps.setString(6, d.getWorkplace());

            if (db.executeUpdate() == 1) {
                System.out.println("Record inserted successfully..");
            } else {

                System.out.println("Insertion failed..");
            }
            db.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Doctor> showAll() {
        List<Doctor> doctorList = new ArrayList<>();
        try {

            String sql = "SELECT *FROM tbl_details ";

            db.open();
            ps = db.initStatement(sql);

            rs = db.executeQuery();

            while (rs.next()) {
                Doctor d = new Doctor();
                d.setId(rs.getInt(1));
                d.setFirstName(rs.getString(2));
                d.setLastName(rs.getString(3));
                d.setAddress(rs.getString(4));
                d.setContact(rs.getString(5));
                d.setSpecialization(rs.getString(6));
                d.setWorkplace(rs.getString(7));

                doctorList.add(d);

            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        return doctorList;
    }

    @Override
    public List<Doctor> searchBySpecialization(String specialization) {

        List<Doctor> dummy = new ArrayList<>();

        for (Doctor d : showAll()) {
            if (d.getSpecialization().contains(specialization)) {
                dummy.add(d);

            }
        }
        return dummy;
    }

    @Override
    public List<Doctor> search(String text) {

        List<Doctor> dummy = new ArrayList<>();
        for (Doctor d : showAll()) {
            if (d.getSpecialization().contains(text) || d.getAddress().contains(text) || d.getFirstName().contains(text) || d.getLastName().contains(text) || d.getWorkplace().contains(text)) {
                dummy.add(d);

            }
        }

        return dummy;
    }

    @Override
    public void update(Doctor d) {
 
         try {
            String sql = "UPDATE tbl_details SET first_Name=?, last_Name=?,address=?,contact=?,specialization=?,workplace=? WHERE id=? ";

            db.open();
            ps = db.initStatement(sql);

            ps.setString(1, d.getFirstName());
            ps.setString(2, d.getLastName());
            ps.setString(3, d.getAddress());
            ps.setString(4, d.getContact());
            ps.setString(5, d.getSpecialization());
            ps.setString(6, d.getWorkplace());
            ps.setInt(7, d.getId());

            if (db.executeUpdate() == 1) {
                System.out.println("Record updated successfully..");
            } else {

                System.out.println("Insertion failed..");
            }
            db.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Doctor d) {

        try{
            
            String sql = "DELETE FROM tbl_details where id=?";
            db.open();
            
            ps=db.initStatement(sql);
            
            ps.setInt(1, d.getId());
            
            db.executeUpdate();
        }catch(SQLException |ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Doctor searchById(int id)  {
      
        for(Doctor d: showAll()){
            
            if(d.getId()==id){
                return d;
            }
        }
        return null;
    }

}
