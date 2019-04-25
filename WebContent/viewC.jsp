<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
     <%@ page import="java.sql.*"%>
     <%@ page import ="java.util.*" %>
    <%@ page import="com.clothing.CategoryCrud.*" import="java.ArrayList.*"%>
    <%@ page import= "com.clothing.DBConnect.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="divs/head.jsp" %>
<title> View Categories </title>

    <!-- SQL connection for view categories -->

<%@ include file="divs/header.jsp" %>
<!-- banner -->
<!--  
<script>
$(document).ready(function(){
    $("#insertButton").click(function(){
        $("#insertForm").show();
        $("#showRecord").hide();
        $("#delRecord").hide();
    });
    $("#showButton").click(function(){
    	  $("#insertForm").hide();
          $("#showRecord").show();
          $("#delRecord").hide();
    });
    
    $("#delBtn").click(function(){
    	  $("#insertForm").hide();
          $("#showRecord").hide();
          $("#delRecord").show();
    });
});
</script>-->
</head>
<body>
<div class="ban-top">
    <div class="container">
        <div class="top_nav_left">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse menu--shylock" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav menu__list">
                            <li class=" menu__item"><a class="menu__link" href="adminHome.html">HOME</a></li>
                            <li class="active menu__item menu__item--current dropdown menu__item">
                                <a href="viewC.html" class="dropdown-toggle menu__link" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">EDIT CATEGORY <span class="caret"></span></a>
                                <ul class="dropdown-menu multi-column columns-3">
                                    <div class="agile_inner_drop_nav_info">
                                        <div class="col-sm-6 multi-gd-img1 multi-gd-text ">
                                            <a href="#"><img src="images/top2.jpg" alt=" "/></a>
                                        </div>
                                        <div class="col-sm-3 multi-gd-img">
                                            <ul class="multi-column-dropdown">
                                                <li><a href="viewC.jsp">VIEW CATEGORIES</a></li>
                                                <li><a href="addC.jsp">ADD CATEGORY</a></li>
                                                <li><a href="updateC.jsp">UPDATE CATEGORY</a></li>
                                                <li><a href="deleteC.jsp">DELETE CATEGORY</a></li>
                                            </ul>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </ul>
                            </li>


                            <li class="dropdown menu__item">
                                <a href="#" class="dropdown-toggle menu__link" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">ITEMS<span class="caret"></span></a>
                                <ul class="dropdown-menu multi-column columns-3">
                                    <div class="agile_inner_drop_nav_info">
                                        <div class="col-sm-3 multi-gd-img">
                                            <ul class="multi-column-dropdown">
                                                <li><a href="addItem.jsp">ADD ITEM</a></li>
                                                <li><a href="editItem.jsp">EDIT ITEM</a></li>
                                                <li><a href="deleteItem.jsp">DELETE ITEM</a></li>
                                            </ul>
                                        </div>
                                        <div class="col-sm-6 multi-gd-img multi-gd-text ">
                                            <a href="womens.html"><img src="images/top1.jpg" alt=" "/></a>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </ul>
                            </li>
                            <li class=" menu__item"><a class="menu__link" href="verifyPayments.jsp">VERIFY PAYMENTS</a></li>
                            <li class=" menu__item"><a class="menu__link" href="generateReports.jsp">GENERATE REPORTS</a></li>
                            <li class=" menu__item"><a class="menu__link" href="newsLetter.jsp">NEWS LETTER</a></li>
                        </ul>
                    </div>


                </div>
            </nav>
        </div>
        <div class="clearfix"></div>
	</div>
</div>
<!-- //banner-top -->


<div class="content">
    <div class="contentHead">
        ALL CATEGORIES<br>
    </div>
</div>
<%
		//Class.forName("com.mysql.jdbc.Driver");
		//String DBName = "clothinglk";
		//String userName = "root";
		//String password = "uthpala";
		
		//Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName +"?autoReconnect=true&useSSL=false", userName, password);
    	//DBConnect myStat = new DBConnect();
    	//ps = DBConnect.getPreparedStatement();
    	Connection myConn = DBConnect.getConnection();
		Statement myStat = myConn.createStatement();
		 
		%>
<div class="grid">
<div class="men">
<table>
     	<thead>
            <tr>
                <th>ID</th>
                <th>MEN'S WEAR</th>
                
            </tr>
			</thead>
			<tbody>
				<%
							
                        String men = "select * from category Where categoryType = 'MEN'";
						ResultSet myRs1 = myStat.executeQuery(men);
            	while(myRs1.next()){
            	%>
            	<tr>
            		<td><%=myRs1.getString("categoryID")%> </td>
            		<td><%=myRs1.getString("categoryTitle")%> </td>
            	</tr>
            	<%
            	}
            	%> 
            	
            	
            	
			</tbody>
			
</table>
</div>
<div class="women">
<table>
     	<thead>
            <tr>
                <th>ID</th>
                <th>WOMEN'S WEAR</th>
                
            </tr>
			</thead>
			<tbody>
				<%
							
                        String women = "select * from category Where categoryType = 'WOMEN'";
                       	ResultSet myRs2 = myStat.executeQuery(women);
            	while(myRs2.next()){
            	%>
            	<tr>
            		<td><%=myRs2.getString("categoryID")%> </td>
            		<td><%=myRs2.getString("categoryTitle")%> </td>
            	</tr>
            	<%
            	}
            	%> 
            	
            	
            	
			</tbody>
			
</table>
</div>
<div class="boy">
	
<table>
     	<thead>
            <tr>
                <th>ID</th>
                <th>KID'S WEAR (BOY'S)</th>
                
            </tr>
			</thead>
			<tbody>
				<%
							
                        String boy = "select * from category Where categoryType = 'BOY'";
                       	ResultSet myRs3 = myStat.executeQuery(boy);
            	while(myRs3.next()){
            	%>
            	<tr>
            		<td><%=myRs3.getString("categoryID")%> </td>
            		<td><%=myRs3.getString("categoryTitle")%> </td>
            	</tr>
            	<%
            	}
            	%> 
            	
            	
            	
			</tbody>
			
</table>
</div>
<div class="girl" style="">
<table cellpadding="10">
     	<thead>
            <tr>
                <th>ID</th>
                <th>KID'S WEAR (GIRL'S) </th>
                
            </tr>
			</thead>
			<tbody>
				<%
							
                        String girl = "select * from category Where categoryType = 'GIRL'";
                       	ResultSet myRs4 = myStat.executeQuery(girl);
            	while(myRs4.next()){
            	%>
            	<tr>
            		<td><%=myRs4.getString("categoryID")%> </td>
            		<td><%=myRs4.getString("categoryTitle")%> </td>
            	</tr>
            	<%
            	}
            	%> 
            	
            	
            	
			</tbody>
			
</table>
</div>
</div>
	
</body>			
			



<%@ include file="divs/footer.jsp" %>

</html>