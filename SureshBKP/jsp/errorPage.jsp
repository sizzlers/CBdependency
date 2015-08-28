<!--[if IE 6]><html lang="en" class="no-js ie6"><![endif]-->
<!--[if (gt IE 6)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head><meta http-equiv="X-UA-Compatible" content="IE=edge" /> 
<meta charset="utf-8" />
<title>Verizon </title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isErrorPage="true" %>
<%@ page import="java.util.*"%>

<style>
.errorbox{height:85px; border:1px solid  #dcd8d8; padding-top:10px;
background-color:#fdfdfd;
filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#fdfdfd, endColorstr=#eaeae7);
background-image:-moz-linear-gradient(top, #fdfdfd 0%, #eaeae7 100%);
background-image:-webkit-linear-gradient(top, #fdfdfd 0%, #eaeae7 100%);
background-image:-ms-linear-gradient(top, #fdfdfd 0%, #eaeae7 100%);
background-image:linear-gradient(top, #fdfdfd 0%, #eaeae7 100%);
background-image:-o-linear-gradient(top, #fdfdfd 0%, #eaeae7 100%);
background-image:-webkit-gradient(linear, right top, right bottom, color-stop(0%,#fdfdfd), color-stop(100%,#eaeae7));box-shadow: 0 0 4px #d0cece;
-moz-box-shadow: 0 0 4px #d0cece;
-webkit-box-shadow: 0 0 4px #d0cece;margin:10px;
}
.errorbox img{float:left; padding:8px 15px 15px 15px;}
.errorbox span{padding-right:25px;}

</style>

</head>
<body>
<div id="page">

  <header id="globalHeader">
          <section class="outerWrapper">
  <div class="globalNavContainer pr">
    <!--Main Menu-->
    
    <!-- END MENU -->
    </nav>
  </div>
</section>
<nav class="sec_nav">
  <section class="outerWrapper">
    <section class="nav_links wrapper"> </section>
  </section>
</nav>
  </header>
  <section id="container">
    <!-- BODY CONTAINER STARTS HERE -->
    <section class="bodyContainer">
      <!-- TITLE SECTION STARTS HERE -->
     <!--Main Menu-->
    
    <!-- END MENU -->
    
        
    
      <!-- TITLE SECTION ENDS HERE -->
      <section class="middleContainer  minh350">
        
        <!--Left Nav-->
        <!--Right Column-->
        <div class="errorbox"> 
          <h1>We're Sorry...</h1>
            <span>THERE WAS A PROBLEM WITH&nbsp;YOUR&nbsp;REQUEST. For questions, please contact administrator</span> </div>
        <!-- TABLE STARTS HERE -->
        <!-- TABLE ENDS HERE -->
      </section>
    </section>
  
  </section>
    
  </section>
         <div id="pgTitle" style="display:none;">
            <span>Error Message</span>
          </div>
       </div>
<div id="exceptionDiv" style="display:none">
	---------------the exception is---------------------
	
	<c:forEach var="stackTraceElem" items="${expcatch.stackTrace}">
		<c:out value="${stackTraceElem}"/><br/>
	</c:forEach>
	<%
		 try
	    { 
			 Exception ex=(Exception)request.getAttribute("expcatch");
			 			
	    }catch(Exception e){
	    	//do nothing
	    	out.println("Exception in mailing"+e.getMessage());
	    	 
	    }
     
	%>
</div>
</body>
</html>
