package com.verizon.cabbook.Services;

import java.util.HashMap;

import org.apache.log4j.Logger;

import utilities.CabLogger;

import com.verizon.cabbook.Controller.ListController;
import com.verizon.cabbook.data.GetListData;
import com.verizon.cabbook.model.UserBean;

public class GetServices {
	
	 GetListData oData = null;
	 private static Logger logger = CabLogger.getLogger(GetServices.class);
	  public HashMap<String,String> getMassMetadata() throws Exception {
	        
		  logger.info("Inside service");
	        try {
	        oData = new GetListData();
	        
	        if (!oData.GetEmpData()) {
	           
	        }

	        HashMap<String,String> mapMetaData = new HashMap<String,String>();
	        while (oData.getNextRow()) {
	        
	         
	                mapMetaData.put(oData.getString("id"),oData.getString("route_name"));
	            
	          
	        }

	        return mapMetaData;
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    } finally {
	        if (oData != null) {
	        	oData.close();
	        }                        
	}
	  }

	  public boolean submitTrip(int userId) throws Exception {
	        
		    try {
	        oData = new GetListData();
	        boolean flag=true;
	        if (!oData.submitTrip(userId)) {
	        	flag=false;
	        }

	      return flag;
	      } catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    } finally {
	        if (oData != null) {
	        	oData.close();
	        }                        
	}
	  }

	public UserBean getUserDetails(String vzId) throws Exception {
		        
	  		  
	  	        try {
	  	        oData = new GetListData();
	  	        
	  	        if (!oData.getUserDetails(vzId)) {
	  	           
	  	        }

	  	      UserBean oBean = new UserBean();
	  	        while (oData.getNextRow()) {
	  	        oBean.setUserId(oData.getInt("user_Id"));
	  	         oBean.setVzId(oData.getString("vzid"));
	  	         oBean.setUserName(oData.getString("username"));
	  	         oBean.setManagerName(oData.getString("manager_name"));
	  	         oBean.setMobileNumber(oData.getString("mobile_no"));
	  	         oBean.setStrAddress(oData.getString("address"));
	  	         oBean.setLocation(oData.getString("location"));
	  	         oBean.setDeviceId(oData.getString("device_id"));
	  	         oBean.setEmerContact(oData.getString("emer_contact"));
	  	         oBean.setStrGender(oData.getString("gender"));
	  	     
	  	          
	  	        }

	  	        return oBean;
	  	    } catch (Exception e) {
	  	        e.printStackTrace();
	  	        throw e;
	  	    } finally {
	  	        if (oData != null) {
	  	        	oData.close();
	  	        }                        
	  	}

	 }
}
