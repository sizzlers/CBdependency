package com.verizon.cabbook.data;

import java.sql.*; 
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DbConn {
	
		private Connection dbConn = null;
	    protected ResultSet _res;
	    protected CallableStatement _cstmt;
	    protected PreparedStatement _pstmt;

	    public void createCallableStatement(String sql) throws SQLException,
	                                                                      Exception {

	        try {

	            try {
	                if (dbConn != null && !dbConn.isClosed()) {
	                	dbConn.close();
	                }
	            } catch (Exception e) {
	            	dbConn = null;
	            }
	            dbConn = null;

	            dbConn = getConnection();
	           
	            _cstmt = dbConn.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        } catch (Exception e) {
	            throw e;
	        }

	    }
	    public void createPreparedStatement(String sql) throws SQLException,
        Exception {

try {

try {
if (dbConn != null && !dbConn.isClosed()) {
dbConn.close();
}
} catch (Exception e) {
dbConn = null;
}
dbConn = null;

dbConn = getConnection();

_pstmt = dbConn.prepareStatement(sql);
} catch (Exception e) {
throw e;
}

}


	    
	    public boolean getNextRow() throws SQLException {
	        boolean _resnext = false;
	        try {

	            if (_res != null)
	                _resnext = _res.next();


	        } catch (SQLException ex) {
	            
	            throw ex;
	        }
	        return _resnext;
	    }


	    public String getString(String colName) throws SQLException {

	        try {
	            String colNameStr = _res.getString(colName);

	            if (colNameStr == null) {
	                return "";
	            } else {
	                return colNameStr.trim();
	            }

	        } catch (SQLException ex) {
	           
	            throw ex;
	        }
	    }
	    
	    public int getInt(String colName) throws SQLException {

	        try {
	            return _res.getInt(colName);
	        } catch (SQLException ex) {

	       
	            throw ex;
	        }
	    }
	    
	    public boolean getBoolean(String colName) throws SQLException {

	        try {
	            return _res.getBoolean(colName);
	        } catch (SQLException ex) {
	     
	            throw ex;
	        }

	    }
	    
	    public void close() {

	        try {
	            if (_res != null)
	                _res.close();

	        } catch (SQLException sqe) {

	        }
	        _res = null;

	        try {
	            if (_cstmt != null)
	                _cstmt.close();

	        } catch (SQLException sqe) {

	        }
	        _cstmt = null;

	        try {
	            if (_pstmt != null)
	                _pstmt.close();

	        } catch (SQLException sqe) {

	        }
	        _pstmt = null;

	        if (dbConn != null)
	        	closeConnection();
	        dbConn = null;
	    }
	    public void setResultSet() throws SQLException {
	        this._res = this._cstmt.getResultSet();

	    }

	    public int getResultSetSize() {
	        int i = 0;
	        try {
	            this._res.last();
	            i = this._res.getRow();
	            this._res.beforeFirst();
	        } catch (Exception e) {
	          
	        }
	        return i;
	    }

	    public ResultSetMetaData getResultSetMetaData() {
	        try {
	            return this._res.getMetaData();
	        } catch (Exception e) {

	        }
	        return null;
	    }

	    public void registerOutputCursor(int index) throws Exception {
	        _cstmt.registerOutParameter(index, oracle.jdbc.OracleTypes.CURSOR);

	    }

	    public boolean getResultObject(int index) {
	        try {
	            this._res = (java.sql.ResultSet)this._cstmt.getObject(index);
	        } catch (Exception e) {
	            return false;
	        }
	        return (this._res != null);

	    }

	    public boolean getNextResultSet() throws SQLException {

	        if (_cstmt.getMoreResults()) {
	            _res = _cstmt.getResultSet();
	            return true;
	        }

	        return false;
	    }

	public Connection getConnection() {

		try {
			
			Class.forName("com.mysql.jdbc.Driver");  
			  
			//step2 create  the connection object  
			dbConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cbdb","root","root");    


			return dbConn;

		} catch (Exception e) {
			return dbConn;
		}
	}
	
public void closeConnection() {
		
		try {
			if (dbConn != null && !dbConn.isClosed()) {				
				dbConn.close();				
			}
		} catch (Exception e) {

		}
		dbConn=null;
	}

}
