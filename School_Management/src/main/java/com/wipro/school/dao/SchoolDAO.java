package com.wipro.school.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.wipro.school.bean.SchoolBean;
import com.wipro.school.util.DBUtil;
public class SchoolDAO {
	public String createRecord(SchoolBean bean) {
    	String status = "FAIL";
        try (Connection con = DBUtil.getDBConnection()) {
        	String sql = "INSERT INTO SCHOOL_TB VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bean.getRecordId());
            ps.setString(2, bean.getStudentName());
            ps.setString(3, bean.getClassName());
            ps.setString(4, bean.getSection());
            ps.setDate(5, new java.sql.Date(bean.getAdmissionDate().getTime()));
            ps.setInt(6, bean.getAge());
            ps.setString(7, bean.getRemarks());
            int row = ps.executeUpdate();
            if (row > 0)
                status = bean.getRecordId();
            }
        catch (Exception e) {
        	e.printStackTrace();
            }
        return status;
    }
    public SchoolBean fetchRecord(String studentName, java.util.Date date) {
    	SchoolBean bean = null;
        try (Connection con = DBUtil.getDBConnection()) {
        	String sql = "SELECT * FROM SCHOOL_TB WHERE STUDENTNAME=? AND ADMISSION_DATE=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, studentName);
            ps.setDate(2, new java.sql.Date(date.getTime()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	bean = new SchoolBean();
                bean.setRecordId(rs.getString("RECORDID"));
                bean.setStudentName(rs.getString("STUDENTNAME"));
                bean.setClassName(rs.getString("CLASS"));
                bean.setSection(rs.getString("SECTION"));
                bean.setAdmissionDate(rs.getDate("ADMISSION_DATE"));
                bean.setAge(rs.getInt("AGE"));
                bean.setRemarks(rs.getString("REMARKS"));
                }
}
        catch (Exception e) {
        	e.printStackTrace();
            }
        return bean;
    }
    public String generateRecordID(String studentName, java.util.Date admissionDate) {
    	String recordId = "";
        try (Connection con = DBUtil.getDBConnection()) {
        	Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT SCHOOL_SEQ.NEXTVAL FROM DUAL");
            int seq = 0;
            if (rs.next())
                seq = rs.getInt(1);
            java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat("yyyyMMdd");
            String datePart = sdf.format(admissionDate);
            String namePart = studentName.substring(0, 2).toUpperCase();
            recordId = datePart + namePart + String.format("%02d", seq);
}
        catch (Exception e) {
        	e.printStackTrace();
         }
        return recordId;
        }
 }
