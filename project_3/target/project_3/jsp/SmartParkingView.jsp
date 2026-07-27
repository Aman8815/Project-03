<%@page import="in.co.rays.project_3.controller.SmartParkingCtl"%>
<%@page import="in.co.rays.project_3.controller.LoanCtl"%>
<%@page import="in.co.rays.project_3.controller.ComplaintCtl"%>
<%@page import="in.co.rays.project_3.controller.MeetingRoomCtl"%>
<%@page import="in.co.rays.project_3.controller.OnlineCourseCtl"%>
<%@page import="in.co.rays.project_3.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.project_3.controller.CourseCtl"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@page import="in.co.rays.project_3.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Smart Parking view</title>
<style type="text/css">
i.css {
	border: 2px solid #8080803b;
	padding-left: 10px;
	padding-bottom: 11px;
	background-color: #ebebe0;
}

.p4 {
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/user1.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	padding-top: 75px;

	/* background-size: 100%; */
}
</style>
</head>
<body class="p4">
	<div class="header">
		<%@include file="Header.jsp"%>
		<%@include file="calendar.jsp"%>
	</div>
	<div>
		<jsp:useBean id="dto" class="in.co.rays.project_3.dto.SmartParkingDTO"
			scope="request"></jsp:useBean>

		<main>
		<form action="<%=ORSView.SMARTPARKING_CTL%>" method="post">

			<div class="row pt-3 pb-3">
				<!-- Grid column -->
				<div class="col-md-4 mb-4"></div>
				<div class="col-md-4 mb-4">
					<div class="card">
						<div class="card-body">
							<%
								long id = DataUtility.getLong(request.getParameter("id"));

								if ( id > 0) {
							%>
							<h3 class="text-center default-text text-primary">Update
								Parking</h3>
							<%
								} else {
							%>
							<h3 class="text-center default-text text-primary">Add Parking
								</h3>
							<%
								}
							%>
							<!--Body-->
							<div>


								<H4 align="center">
									<%
										if (!ServletUtility.getSuccessMessage(request).equals("")) {
									%>
									<div class="alert alert-success alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<%=ServletUtility.getSuccessMessage(request)%>
									</div>
									<%
										}
									%>
								</H4>

								<H4 align="center">
									<%
										if (!ServletUtility.getErrorMessage(request).equals("")) {
									%>
									<div class="alert alert-danger alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<%=ServletUtility.getErrorMessage(request)%>
									</div>
									<%
										}
									%>

								</H4>

								<input type="hidden" name="id" value="<%=dto.getId()%>">
							 	<input type="hidden" name="createdBy"
									value="<%=dto.getCreatedBy()%>"> <input type="hidden"
									name="modifiedBy" value="<%=dto.getModifiedBy()%>"> <input
									type="hidden" name="createdDatetime"
									value="<%=DataUtility.getTimestamp(dto.getCreatedDatetime())%>">
								<input type="hidden" name="modifiedDatetime"
									value="<%=DataUtility.getTimestamp(dto.getModifiedDatetime())%>">  
							</div>
							<div class="md-form">
								<span class="pl-sm-5"><b>ParkingCode</b><span
									style="color: red;">*</span></span> </br>
								<div class="col-sm-12">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<i class="fa fa-book grey-text" style="font-size: 1rem;"></i>
											</div>
										</div>
										<input type="text" class="form-control" name="parkingCode"
											placeholder="Enter parkingCode "
											value="<%=DataUtility.getStringData(dto.getParkingCode())%>">
									</div>
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("parkingCode", request)%></font></br>


								<div class="md-form">
									<span class="pl-sm-5"><b>VehicleNumber</b><span
										style="color: red;">*</span></span> </br>
									<div class="col-sm-12">
										<div class="input-group">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fa fa-book grey-text" style="font-size: 1rem;"></i>
												</div>
											</div>
											<input type="text" class="form-control" name="vehicleNumber"
												placeholder="Enter vehicleNumber"
												value="<%=DataUtility.getStringData(dto.getVehicleNumber())%>">
										</div>
									</div>
									<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("vehicleNumber", request)%></font></br>


									<span class="pl-sm-5"><b>SlotNumber</b><span
										style="color: red;">*</span></span></br>
									<div class="col-sm-12">
										<div class="input-group">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fa fa-clock grey-text" style="font-size: 1rem;"></i>
												</div>
											</div>

										<input type="text" class="form-control" name="slotNumber"
												placeholder="Enter slotNumber"
												value="<%=DataUtility.getStringData(dto.getSlotNumber())%>">

									</div>
									<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("slotNumber", request)%></font></br>



									<div class="md-form">
										<span class="pl-sm-5"><b>Status</b><span
											style="color: red;">*</span></span> </br>
										<div class="col-sm-12">
											<div class="input-group">
												<div class="input-group-prepend">
													<div class="input-group-text">
														<i class="fa fa-book grey-text" style="font-size: 1rem;"></i>
													</div>
												</div>
												<input type="text" class="form-control" name="status"
													placeholder="Enter status"
													value="<%=DataUtility.getStringData(dto.getStatus())%>">
											</div>
										</div>
										<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("status", request)%></font></br>
										<%
											if (id > 0) {
										%>
										<div class="text-center">

											<input type="submit" name="operation"
												class="btn btn-success btn-md" style="font-size: 17px"
												value="<%=SmartParkingCtl.OP_UPDATE%>"> <input
												type="submit" name="operation"
												class="btn btn-warning btn-md" style="font-size: 17px"
												value="<%=SmartParkingCtl.OP_CANCEL%>">
										</div>
										<%
											} else {
										%>
										<div class="text-center">

											<input type="submit" name="operation"
												class="btn btn-success btn-md" style="font-size: 17px"
												value="<%=SmartParkingCtl.OP_SAVE%>"> <input
												type="submit" name="operation"
												class="btn btn-warning btn-md" style="font-size: 17px"
												value="<%=SmartParkingCtl.OP_RESET%>">
										</div>
										<%
											}
										%>
									</div>
								</div>
							</div>
							<div class="col-md-4 mb-4"></div>
						</div>
		</form>
		</main>


	</div>

</body>
<%@include file="FooterView.jsp"%>
</html>