/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dumbweb.dis.dao;

import com.dumbweb.dis.entity.Doctor;
import java.util.List;

/**
 *
 * @author user
 */
public interface DoctorDAO {
    
    List<Doctor> showAll();
    void insert(Doctor d);
    void update(Doctor d);
    void delete(Doctor d);
    List<Doctor> searchBySpecialization(String specialization);
    List<Doctor> search(String text);
    Doctor searchById(int id);
    
    
}
