<%@page import="in.co.rays.project_3.controller.SmartParkingListCtl"%>
<%@page import="in.co.rays.project_3.dto.SmartParkingDTO"%>
<%@page import="in.co.rays.project_3.controller.LoanListCtl"%>
<%@page import="in.co.rays.project_3.dto.LoanDTO"%>
<%@page import="in.co.rays.project_3.controller.ComplaintListCtl"%>
<%@page import="in.co.rays.project_3.dto.ComplaintDTO"%>
<%@page import="in.co.rays.project_3.dto.MeetingRoomDTO"%>
<%@page import="in.co.rays.project_3.controller.MeetingRoomListCtl"%>
<%@page import="in.co.rays.project_3.dto.OnlineCourseDTO"%>
<%@page import="in.co.rays.project_3.controller.OnlineCourseListCtl"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.project_3.util.HTMLUtility"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@page import="in.co.rays.project_3.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>Parking List View</title>

<script src="<%=ORSView.APP_CONTEXT%>/js/jquery.min.js"></script>

<script src="<%=ORSView.APP_CONTEXT%>/js/CheckBox11.js"></script>

<style>
.text {
	text-align: center;
}

.p4 {
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/list2.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	padding-top: 85px;
}
</style>

</head>

<body class="p4">

	<%@include file="Header.jsp"%>

	<form action="<%=ORSView.SMARTPARKING_LIST_CTL%>" method="post">

		<jsp:useBean id="dto" class="in.co.rays.project_3.dto.SmartParkingDTO"
			scope="request"></jsp:useBean>

		<%
			List list1 = (List) request.getAttribute("courseList");

			int pageNo = ServletUtility.getPageNo(request);
			int pageSize = ServletUtility.getPageSize(request);
			int index = ((pageNo - 1) * pageSize) + 1;

			/* SAFE nextListSize */
			Object obj = request.getAttribute("nextListSize");
			int nextPageSize = 0;
			if (obj != null) {
				nextPageSize = DataUtility.getInt(obj.toString());
			}

			/* SAFE list */
			List list = ServletUtility.getList(request);
			Iterator<SmartParkingDTO> it = null;

			if (list != null) {
				it = list.iterator();
			}
		%>

		<%
			if (list != null && list.size() != 0) {
		%>

		<center>
			<h1 class="text-light font-weight-bold pt-2">
				<font color="black">Parking List</font>
			</h1>
		</center>
		<div class="row">
				<div class="col-md-4"></div>
				<%
					if (!ServletUtility.getSuccessMessage(request).equals("")) {
				%>

				<div class="col-md-4 alert alert-success alert-dismissible"
					style="background-color: #80ff80">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h4>
						<font color="#008000"><%=ServletUtility.getSuccessMessage(request)%></font>
					</h4>
				</div>
				<%
					}
				%>
				<div class="col-md-4"></div>
			</div>
			<div class="row">
				<div class="col-md-4"></div>

				<%
					if (!ServletUtility.getErrorMessage(request).equals("")) {
				%>
				<div class=" col-md-4 alert alert-danger alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h4>
						<font color="red"> <%=ServletUtility.getErrorMessage(request)%></font>
					</h4>
				</div>
				<%
					}
				%>
				<div class="col-md-4"></div>
			</div>

		<div class="row">

			<div class="col-sm-2"></div>

			<div class="col-sm-3">
				<%=HTMLUtility.getList("id", String.valueOf(dto.getId()), list1)%>
			</div>

			<div class="col-sm-3">
            <input type="text" name="slotNumber" placeholder="Enter slotNumber"
						class="form-control"
						value="<%=ServletUtility.getParameter("slotNumber", request)%>">

			</div>

			<div class="col-sm-2">

				<input type="submit" class="btn btn-primary" name="operation"
					value="<%=SmartParkingListCtl.OP_SEARCH%>"> <input
					type="submit" class="btn btn-dark" name="operation"
					value="<%=SmartParkingListCtl.OP_RESET%>">

			</div>

			<div class="col-sm-2"></div>

		</div>

		<br>

		<div class="table-responsive">

			<table class="table table-dark table-bordered">

				<thead>

					<tr>

						<th width="10%"><input type="checkbox" id="select_all">
							Select All</th>

						<th class="text">S.NO</th>
						<th class="text">Parking Code</th>
						<th class="text">Vehicle Number</th>
						<th class="text">Slot Number</th>
						<th class="text">Status</th>
						<th class="text">Edit</th>

					</tr>

				</thead>

				<tbody>

					<%
						while (it.hasNext()) {

								dto = it.next();
					%>

					<tr>

						<td align="center"><input type="checkbox" class="checkbox" name="ids"
							value="<%=dto.getId()%>"></td>

						<td align="center"><%=index++%></td>
						<td align="center"><%=dto.getParkingCode()%></td>
						<td align="center"><%=dto.getVehicleNumber()%></td>
						<td align="center"><%=dto.getSlotNumber()%></td>
						<td align="center"><%=dto.getStatus()%></td>

						<td align="center"><a
							href="SmartParkingCtl?id=<%=dto.getId()%>">Edit</a></td>

					</tr>

					<%
						}
					%>

				</tbody>

			</table>

		</div>

		<table width="100%">

			<tr>
					<td><input type="submit" name="operation"
						class="btn btn-warning btn-md" style="font-size: 17px"
						value="<%=SmartParkingListCtl.OP_PREVIOUS%>"
						<%=pageNo > 1 ? "" : "disabled"%>></td>
					<td><input type="submit" name="operation"
						class="btn btn-primary btn-md" style="font-size: 17px"
						value="<%=SmartParkingListCtl.OP_NEW%>"></td>
					<td><input type="submit" name="operation"
						class="btn btn-danger btn-md" style="font-size: 17px"
						value="<%=SmartParkingListCtl.OP_DELETE%>"></td>

					<td align="right"><input type="submit" name="operation"
						class="btn btn-warning btn-md" style="font-size: 17px"
						style="padding: 5px;" value="<%=SmartParkingListCtl.OP_NEXT%>"
						<%=(nextPageSize != 0) ? "" : "disabled"%>></td>
				</tr>

		</table>

		<%
			} else {
		%>

		<center>
			<h2>Parking List Not Found</h2>
			<div style="padding-left: 48%;">
				<input type="submit" name="operation" class="btn btn-primary btn-md"
					style="font-size: 17px" value="<%=SmartParkingListCtl.OP_BACK%>">
			</div>
		</center>

		<%
			}
		%>

		<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
			type="hidden" name="pageSize" value="<%=pageSize%>">

	</form>

	<%@include file="FooterView.jsp"%>

</body>
</html>
