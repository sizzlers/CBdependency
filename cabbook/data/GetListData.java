package com.verizon.cabbook.data;

import org.apache.log4j.Logger;

import utilities.CabLogger;

import com.verizon.cabbook.Services.GetServices;


public class GetListData extends DbConn {
	 private static Logger logger = CabLogger.getLogger(GetListData.class);
	 public boolean GetEmpData()throws Exception {
	        
		 logger.info("Inside data");
	        boolean isSuccess = true;
	        try {

	            String sql = "select * from route_master";
	            this.createPreparedStatement(sql);
	            this._res= this._pstmt.executeQuery();
	            
	            return isSuccess;
	        } catch (Exception e) {
	          
	            throw e;
	        }

	 }

	 public boolean submitTrip(int userId)throws Exception {
	        
		 
	        boolean isSuccess = false;
	        try {

	            String sql = "insert into user_request(user_id)values("+userId+")";
	            this.createPreparedStatement(sql);
	            int rowsAffected = this._pstmt.executeUpdate();
	            if(rowsAffected > 0)
	            	isSuccess = true;
	            
	            return isSuccess;
	        } catch (Exception e) {
	          
	            throw e;
	        }

	 }

	 public boolean getUserDetails(String vzId)throws Exception {
	        
		 logger.info("Inside data");
	        boolean isSuccess = true;
	        try {

	            String sql = "select * from tbl_users where vzid='"+vzId+"'";
	            this.createPreparedStatement(sql);
	            this._res= this._pstmt.executeQuery();
	            
	            return isSuccess;
	        } catch (Exception e) {
	          
	            throw e;
	        }

	 }
}