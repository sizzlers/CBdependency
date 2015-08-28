<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Leave Feedback</title>

<title>Trip Listing</title>
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
	<div class="container">
  <h2>Leave Feedback </h2>
  
  <form>
  	<div class="control-group ">
						<label class="control-label" for="lblname">Trip Date: </label> 
						<span>
							test</span>
	</div>
	
	<div class="control-group ">
						<label class="control-label" for="lblname">Vehicle Nrumbe: </label> 
						<span>
							112312</span>
	</div>
	
	<div class="form-group">
            <label for="feedback">Feedback: </label>
            <textarea class="form-control" id="feedback" name="feedback"></textarea>
        </div>
        
        <button type="submit" class="btn btn-primary">Leave Feedback</button>
			
		</form>
  </div>

</body>
</html>