<%@page import="in.co.rays.project_3.controller.LoginCtl"%>
<%@page import="in.co.rays.project_3.controller.ORSView"%>
<%@page import="in.co.rays.project_3.controller.LoginCtl"%>
<%@page import="in.co.rays.project_3.dto.RoleDTO"%>
<%@page import="in.co.rays.project_3.dto.UserDTO"%>
<%@page import="in.co.rays.project_3.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
.aj {
	background-image: linear-gradient(to bottom right, grey, black);
}
</style> 
</head>
<body>
	<%
		UserDTO userDto = (UserDTO) session.getAttribute("user");

		boolean userLoggedIn = userDto != null;

		String welcomeMsg = "Hi, ";

		if (userLoggedIn) {
			String role = (String) session.getAttribute("role");
			welcomeMsg += userDto.getFirstName() + " (" + role + ")";
		} else {
			welcomeMsg += "Guest";
		}
	%>
	<div class="header">
		<nav class="navbar navbar-expand-lg fixed-top aj"> <a
			class="navbar-brand" href="<%=ORSView.WELCOME_CTL%>"><img
			src="<%=ORSView.APP_CONTEXT%>/img/custom.png" width="190px"
			height="50px"></a>
		<button class="navbar-toggler " type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"> <i class="fa fa-bars"
				style="color: #fff; font-size: 28px;"></i></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="nav navbar-nav ml-auto">
				<a class="nav-link" href="#"> <span class="sr-only">(current)</span>
				</a>
				<%
					if (userLoggedIn) {
				%>
				<%
					if (userDto.getRoleId() == RoleDTO.STUDENT) {
				%>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Marksheet</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item"
							href="<%=ORSView.MARKSHEET_MERIT_LIST_CTL%>"><i
								class="fa fa-file-alt"></i><font style="color: white;">Marksheet
									Merit List</font></a>
					</div></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">User</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item"
							href="<%=ORSView.MY_PROFILE_CTL%>"><i class="fa fa-user-tie"></i><font
								style="color: white;">My Profile</font></a> <a class="dropdown-item"
							href="<%=ORSView.CHANGE_PASSWORD_CTL%>"><i
								class=" fa fa-file-alt"></i><font style="color: white;">Change
									Password</font></a>
					</div></li>
				<%
					} else if (userDto.getRoleId() == RoleDTO.ADMIN) {
				%>

				<li class="nav-item dropdown" style="padding-left: 5px;"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">User</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.USER_CTL%>"><i
							class="fa fa-user-circle"></i>Add User</a> <a class="dropdown-item"
							href="<%=ORSView.USER_LIST_CTL%>"><i
							class="fa fa-user-friends"></i>User List</a>
					</div></li>

				<li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Marksheet
					</font></a>

					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<a class="dropdown-item" href="<%=ORSView.MARKSHEET_CTL%>"><i
							class="fa fa-file"></i>Add Marksheet</a> <a class="dropdown-item"
							href="<%=ORSView.MARKSHEET_LIST_CTL%>"><i class="fa fa-paste"></i>Marksheet
							List</a> <a class="dropdown-item"
							href="<%=ORSView.MARKSHEET_MERIT_LIST_CTL%>"><i
							class=" fa fa-file-alt"></i>Marksheet Merit List </a> <a
							class="dropdown-item" href="<%=ORSView.GET_MARKSHEET_CTL%>"><i
							class="fa fa-copy"></i>Get Marksheet</a>
					</div></li>

				<li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Role</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.ROLE_CTL%>"><i
							class="fa fa-user-tie"></i>Add Role</a> <a class="dropdown-item"
							href="<%=ORSView.ROLE_LIST_CTL%>"><i
							class="fa fa-user-friends"></i>Role List</a>
					</div></li>
				<li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">College</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.COLLEGE_CTL%>"><i
							class="fa fa-university"></i>Add College</a> <a class="dropdown-item"
							href="<%=ORSView.COLLEGE_LIST_CTL%>"><i
							class="fa fa-building"></i>College List </a>
					</div></li>
				<li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Course
					</font></a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.COURSE_CTL%>"><i
							class="fa fa-book-open"></i>Add Course</a> <a class="dropdown-item"
							href="<%=ORSView.COURSE_LIST_CTL%>"><i
							class="fa fa-sort-amount-down"></i>Course List </a>
					</div></li>
			
			

				<li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Time
							Table</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.TIMETABLE_CTL%>"><i
							class="fa fa-clock"></i>Add TimeTable</a> <a class="dropdown-item"
							href="<%=ORSView.TIMETABLE_LIST_CTL%>"><i class="fa fa-clock"></i>TimeTable
							List</a>
					</div></li>
					
				<li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Subject</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.SUBJECT_CTL%>"><i
							class="fa fa-calculator"></i>Add Subject</a> <a class="dropdown-item"
							href="<%=ORSView.SUBJECT_LIST_CTL%>"> <i
							class="fa fa-sort-amount-down"></i>Subject List
						</a>
					</div></li>

				<li class="nav-item dropdown" style="padding-left: 4px;"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Schedule
							</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.SCHEDULE_CTL%>"><i
							class="fa fa-user-circle"></i>Add Schedule</a> <a
							class="dropdown-item" href="<%=ORSView.SCHEDULE_LIST_CTL%>"><i
							class="fa fa-user-friends"></i>Schedule List</a>
					</div></li>
					
				<%-- 	<li class="nav-item dropdown" style="padding-left: 4px;"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Meeting Room</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.MEETING_ROOM_CTL%>"><i
							class="fa fa-user-circle"></i>Add Meeting Room</a> <a
							class="dropdown-item" href="<%=ORSView.MEETING_ROOM_LIST_CTL%>"><i
							class="fa fa-user-friends"></i>Meeting Room List</a>
					</div></li> --%>
					
					<li class="nav-item dropdown" style="padding-left: 4px;"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Loan</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.LOAN_CTL%>"><i
							class="fa fa-user-circle"></i>Add Loan</a> <a
							class="dropdown-item" href="<%=ORSView.LOAN_LIST_CTL%>"><i
							class="fa fa-user-friends"></i>Loan List</a>
					</div></li>
					
					
				<li class="nav-item dropdown" style="padding-left: 4px;"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Press</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.PRESS_CTL%>"><i
							class="fa fa-user-circle"></i>Add Press</a> <a
							class="dropdown-item" href="<%=ORSView.PRESS_LIST_CTL%>"><i
							class="fa fa-user-friends"></i>Press List</a>
					</div></li>
					
					<li class="nav-item dropdown" style="padding-left: 4px;"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Return</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.RETURN_CTL%>"><i
							class="fa fa-user-circle"></i>Add Return</a> <a
							class="dropdown-item" href="<%=ORSView.RETURN_LIST_CTL%>"><i
							class="fa fa-user-friends"></i>Return List</a>
					</div></li>
					
						<li class="nav-item dropdown" style="padding-left: 4px;"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Decoration</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.DECORATION_CTL%>"><i
							class="fa fa-user-circle"></i>Add Decoration</a> <a
							class="dropdown-item" href="<%=ORSView.DECORATION_LIST_CTL%>"><i
							class="fa fa-user-friends"></i>Decoration List</a>
					</div></li>
					
							<li class="nav-item dropdown" style="padding-left: 4px;"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">SmartParking</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.SMARTPARKING_CTL%>"><i
							class="fa fa-user-circle"></i>Add Parking</a> <a
							class="dropdown-item" href="<%=ORSView.SMARTPARKING_LIST_CTL%>"><i
							class="fa fa-user-friends"></i>Parking List</a>
					</div></li>
					
							<li class="nav-item dropdown" style="padding-left: 4px;"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Notification</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.NOTIFICATION_CTL%>"><i
							class="fa fa-user-circle"></i>Add Notification</a> <a
							class="dropdown-item" href="<%=ORSView.NOTIFICATION_LIST_CTL%>"><i
							class="fa fa-user-friends"></i>Notification List</a>
					</div></li>

				 <li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">NFT Asset
					</font></a>

					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<a class="dropdown-item" href="<%=ORSView.NFTASSET_CTL%>"><i
							class="fa fa-user-circle"></i>Add NFT Asset</a> <a class="dropdown-item"
							href="<%=ORSView.NFTASSET_LIST_CTL%>"><i class="fa fa-user-friends"></i>NFT Asset
							List</a>
					</div></li>
					
					 <li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Voice Assistant
					</font></a>

					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<a class="dropdown-item" href="<%=ORSView.VOICEASSISTANT_CTL%>"><i
							class="fa fa-user-circle"></i>Add Voice Assistant</a> <a class="dropdown-item"
							href="<%=ORSView.VOICEASSISTANT_LIST_CTL%>"><i class="fa fa-user-friends"></i>Voice Assistant
							List</a>
					</div></li>
					
					 <li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Chat Application
					</font></a>

					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<a class="dropdown-item" href="<%=ORSView.CHATAPPLICATION_CTL%>"><i
							class="fa fa-user-circle"></i>Add Chat Application</a> <a class="dropdown-item"
							href="<%=ORSView.CHATAPPLICATION_LIST_CTL%>"><i class="fa fa-user-friends"></i>Chat Application
							List</a>
					</div></li>
					
					 <li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Banking App
					</font></a>

					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<a class="dropdown-item" href="<%=ORSView.BANKINGAPP_CTL%>"><i
							class="fa fa-user-circle"></i>Add Banking App</a> <a class="dropdown-item"
							href="<%=ORSView.BANKINGAPP_LIST_CTL%>"><i class="fa fa-user-friends"></i>Banking App
							List</a>
					</div></li>
					
					 <li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Petrol Pump
					</font></a>

					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<a class="dropdown-item" href="<%=ORSView.PETROLPUMP_CTL%>"><i
							class="fa fa-user-circle"></i>Add Petrol Pump</a> <a class="dropdown-item"
							href="<%=ORSView.PETROLPUMP_LIST_CTL%>"><i class="fa fa-user-friends"></i>Petrol Pump
							List</a>
					</div></li>
					
					 <li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Insurance App
					</font></a>

					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<a class="dropdown-item" href="<%=ORSView.INSURANCEAPP_CTL%>"><i
							class="fa fa-user-circle"></i>Add Insurance</a> <a class="dropdown-item"
							href="<%=ORSView.INSURANCEAPP_LIST_CTL%>"><i class="fa fa-user-friends"></i>Insurace
							List</a>
					</div></li>
					
				<%-- 	<li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Smart Light</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.SMART_CTL%>"><i
							class="fa fa-user-circle"></i>Add Smart Light</a> <a
							class="dropdown-item" href="<%=ORSView.SMART_LIST_CTL%>"><i
							class="fa fa-users"></i>Smart Light List</a>
					</div></li> --%>
					
					<li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Water</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.WATER_CTL%>"><i
							class="fa fa-user-circle"></i>Add Water</a> <a
							class="dropdown-item" href="<%=ORSView.WATER_LIST_CTL%>"><i
							class="fa fa-users"></i>Water List</a>
					</div></li>
					
						<li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Exam</font>
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.EXAM_CTL%>"><i
							class="fa fa-user-circle"></i>Add Exam</a> <a
							class="dropdown-item" href="<%=ORSView.EXAM_LIST_CTL%>"><i
							class="fa fa-users"></i>Exam List</a>
					</div></li>
					
					
						<li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Faculty
					</font></a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.FACULTY_CTL%>"><i
							class="fa fa-user-tie"></i>Add Faculty</a> <a class="dropdown-item"
							href="<%=ORSView.FACULTY_LIST_CTL%>"><i class=" fa fa-users"></i>Faculty
							List</a>
					</div></li>
					
						<li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Scholarship
					</font></a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.SCHOLARSHIP_CTL%>"><i
							class="fa fa-user-tie"></i>Add Scholarship</a> <a class="dropdown-item"
							href="<%=ORSView.SCHOLARSHIP_LIST_CTL%>"><i class=" fa fa-users"></i>Scholarship
							List</a>
					</div></li>
					
						<li class="nav-item dropdown" style="padding-left: 5px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font style="color: white;">Result
					</font></a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="<%=ORSView.RESULT_CTL%>"><i
							class="fa fa-user-tie"></i>Add Result</a> <a class="dropdown-item"
							href="<%=ORSView.RESULT_LIST_CTL%>"><i class=" fa fa-users"></i>Result
							List</a>
					</div></li>
					
					
					

				<%
					}
					}
				%>
				<li class="nav-item dropdown"
					style="padding-left: 5px; padding-right: 67px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><font style="color: white;"><%=welcomeMsg%>
					</font></a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<%
							if (userLoggedIn) {
						%>
						<a class="dropdown-item"
							href="<%=ORSView.LOGIN_CTL%>?operation=<%=LoginCtl.OP_LOG_OUT%>"><i
							class="fa fa-sign-out-alt"></i>Logout </a> <a class="dropdown-item"
							href="<%=ORSView.MY_PROFILE_CTL%>"><i class="fa fa-user-tie"></i>My
							Profile</a> <a class="dropdown-item"
							href="<%=ORSView.CHANGE_PASSWORD_CTL%>"> <i
							class="fa fa-edit"></i>Change Password
						</a> <a class="dropdown-item" target="blank"
							href="<%=ORSView.JAVA_DOC_VIEW%>"><i class="fa fa-clone"></i>Java
							Doc </a>
						<%
							} else {
						%>
						<a class="dropdown-item" href="<%=ORSView.LOGIN_CTL%>"><i
							class="fa fa-sign-in-alt">Login</i> </a><a class="dropdown-item"
							href="<%=ORSView.USER_REGISTRATION_CTL%>"><i
							class="fa fa-registered"></i> User Registration</a>
					</div></li>
				<%
					}
				%>
			</ul>
		</div>
		</nav>
	</div>
</body>
</html>