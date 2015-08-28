
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%> 
 <%@ page import="com.verizon.cabbook.model.*"%>
 <%@ page isELIgnored="false"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book a Cab</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> 
<style type="text/css">
    .bs-example{
    	margin: 20px;
    }
</style>
</head>
<body>
<div class="bs-example">
	
<form method="post" action="/CabBook/controller.portal?type=submitTrip">
<div id="divSucc">${succMsg}</div>
<fieldset>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="lblname">Name: </label>
  <div class="controls">
    <label class="control-label" for="lblname">${UserDetails.userName}</label>
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="lblname">Manager Name: </label>
  <div class="controls">
    <label class="control-label" for="lblname">${UserDetails.managerName}</label>
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="lblname">Mobile Number: </label>
  <div class="controls">
    <label class="control-label" for="lblname">${UserDetails.mobileNumber}</label>
  </div>
</div>

<!-- Textarea -->
<div class="control-group">
  <label class="control-label" for="textarea">Address</label>
  <div class="controls">
    <textarea class="form-control" id="textarea" name="textarea">${UserDetails.strAddress}</textarea>
  </div>
</div>

<!-- Multiple Radios -->
<div class="control-group">
	<label class="control-label" for="radios"></label>
	<div class="controls">
		
			<div class="radio">
				<label class="radio-custom" data-initialize="radio" for="radios-0">
					<input class="sr-only" id="radios-0" name="radios" type="radio" value="pick" checked="checked">
					Pick Up
				</label>
			</div>
		
			<div class="radio">
				<label class="radio-custom" data-initialize="radio" for="radios-1">
					<input class="sr-only" id="radios-1" name="radios" type="radio" value="drop">
					Drop
				</label>
			</div>
		
	</div>
</div>


<!-- Button (Double) -->
<div class="control-group">
  <label class="control-label" for="button1id"></label>
  <div class="controls">
    <button id="button1id" name="button1id" class="btn btn-success">Submit</button>
    <button id="button2id" name="button2id" class="btn btn-danger">Cancel</button>
  </div>
</div>

</fieldset>
<input type="hidden" name="hdnUserId" id="hdnUserId" value="${UserDetails.userId}" />
</form>
    </div>
<script>
function disableBut()
{
	var succ="${succMsg}";
	if(succ!="")
	{
	document.getElementById("button1id").disabled=true;
	}
}
</script>



</body>
</html>