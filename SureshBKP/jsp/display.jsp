<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%> 
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <div id="Metadatadiv">
                           <select name="cboHeaderType" id="cboHeaderType" style="width:250px;">
                               <option value="">--Select-- </option>
                                 <c:forEach var="metadata" items="${mapMetaData}" varStatus="rowCounter">       
                                      <option value="${metadata.key}"> <c:out value="${metadata.value}" /> </option>
                                </c:forEach>
                            </select>
      
                       </div>
                       
</body>
</html>