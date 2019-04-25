<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% String username = ((com.clothing.users.User)session.getAttribute("user")).getName(); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<!-- header -->
<div class="header" id="home">
		<div class="welcome">

		<!--<%
	//	if (session.getAttribute("username")==null)
	//	{
	//	response.sendRedirect(login.jsp);
	//	}
		%>
		-->
	<p class="hello">  Hello Welcome back <%=username %>} </p>
	<input type="submit" class="logout" id="logout" value="Logout">
	</div>
</div>

<div class="header-bot">
	<div class="header-bot_inner_wthreeinfo_header_mid">

		<div class="col-md-4 search-site">
			<form action="#" method="post">
					<input type="search" name="search" placeholder="Search here..." required="">
					<input type="submit" value=" ">
				<div class="clearfix"></div>
			</form>
		</div>

		<!-- header-bot -->

        <!-- header-bot -->
		<div class="share-on">
						<ul class="social-nav model-3d-0 footer-social w3_agile_social">
						                                   <li class="share">Share On : </li>
															<li><a href="#" class="facebook">
																  <div class="front"><i class="fa fa-facebook" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-facebook" aria-hidden="true"></i></div></a></li>
															<li><a href="#" class="twitter"> 
																  <div class="front"><i class="fa fa-twitter" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-twitter" aria-hidden="true"></i></div></a></li>
															<li><a href="#" class="instagram">
																  <div class="front"><i class="fa fa-instagram" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-instagram" aria-hidden="true"></i></div></a></li>
															<li><a href="#" class="pinterest">
																  <div class="front"><i class="fa fa-linkedin" aria-hidden="true"></i></div>
																  <div class="back"><i class="fa fa-linkedin" aria-hidden="true"></i></div></a></li>
														</ul>



		</div>
		<div class="clearfix"></div>
	</div>
</div>
<div class="header-logo" style="text-align: center">
	<a href="adminHome.html"><img src="images/t1.png" style="width: 400px" height="116px "></a>

</div>
<!-- //header-bot -->
</body>
</html>