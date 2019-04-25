<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
     <%@ page import="java.sql.*"%>
     <%@ page import ="java.util.*" %>
    <%@ page import="CRUD.CRUD.*" import="java.ArrayList.*"%>
    <%@ page import= "CRUD.Item.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="divs/head.jsp" %>
<title> View Categories </title>

    <!-- SQL connection for view categories -->

<%@ include file="divs/header.jsp" %>
</head>
<body>
<div

		style="background-color: transparent; color: black; font-family: 'Calibri Light'; padding-left: 30px">


		<table align="center">
			<tr>
				<td style="font-size: larger; color: white"><h3 align="center">Delete Items</h3></td>
			</tr>
			<tr>
				<td><hr width="700"></td>
			</tr>
			<tr>
			
				<td>
					<form name="deleteitems" method="post" action="DELETE" enctype="multipart/form-data">
						<table>
							<tr>
								
								<td style="font-family: Calibri; width: 200px; font-size: large">Item ID</td>
								<td><input type="text" id="ID" name="ID"
									style="border-radius: 5px; color: black; width: 400px; height: 25px; border-style: groove"></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
								<tr>
								
								<td style="font-family: Calibri; width: 200px; font-size: large">Item Name</td>
								<td><input type="Text" id="name" name="Name"
									style="border-radius: 5px; color: black; width: 400px; height: 25px; border-style: groove"></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
								<td style="font-family: Calibri; width: 200px; font-size: large">Category</td>
								<td><input type="text" id="Category" name="Category"
									style="border-radius: 5px; color: black; width: 400px; height: 25px; border-style: groove"></td>
							</tr>
							<tr>
								<td><br></td>
							</tr>
							<tr>
    							<td><input class="button" type="submit" value="DELETE"></td>
    							<td><input class="button" type="button" value="Cancel" onclick="window.location.href='DELETE.jsp'"></td>
							</tr>

							<tr>
								<td><br></td>
							</tr>
							
						</table>
					</form>
				</td>
			</tr>
		</table>
	
	</div>



</body>
</html>