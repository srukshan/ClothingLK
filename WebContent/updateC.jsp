<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.clothing.DBConnect.*"
    import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="divs/head.jsp" %>
<title> Update Category </title>
</head>
<body>
<%@ include file="divs/header.jsp" %>
<!-- banner -->
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
        Update CATEGORIES<br>
    </div>
    <form id="addTitle"action="ClothingServlet" method="get" class="addC">
    	<table>
        	<tr>
        
       			<td>Select Main Category Type :</td>
  				<td><select name="mainCategory">
  						<option  value="0">--------Select--------</option>
    					<option  value="MEN">MEN</option>
    					<option value="WOMEN">WOMEN</option>
    					<option value="BOY">Kids(BOYS)</option>
    					<option value="GIRL">Kids(GIRLS)</option>
  					</select>
  				</td>
  			</tr>
  			<tr>
  				<td>Enter Category Title:</td>
  				<td><select name="subCategory">
  				<%String name = (String)request.getAttribute("mainCategory"); 
  				%>
    					<option  value="0">--Select Sub Category--</option>
    					
    					
  					</select>
  				</td>
  			<tr>
  				<td>Enter Category Description:</td>
  				<td><input name="Description" type="text"></td>
  			</tr>
  			<tr>
  				<td><input type="submit" value="SUBMIT"></td><td><input type="reset" value="RESET"></td><td><input type="button" value="Cancel" onclick="window.location.href='viewC.jsp'"></td>
  			</tr>
  </table>
</form>
</div>
<%@ include file="divs/footer.jsp" %>
</body>
</html>
