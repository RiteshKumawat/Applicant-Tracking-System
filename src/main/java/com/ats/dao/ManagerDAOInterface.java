package com.ats.dao;
import java.util.List;
import com.ats.pojo.Manager;

public interface ManagerDAOInterface {
public void addManager(Manager manager);
public List<Manager> getAllCandidates();
public boolean isManagerExisits(String email);
public String getPassword(String email);
}
