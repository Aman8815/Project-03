<%@page import="in.co.rays.project_3.dto.RefundDTO"%>
<%@page import="in.co.rays.project_3.controller.RefundListCtl"%>
<%@page import="in.co.rays.project_3.dto.StaffMemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.project_3.util.HTMLUtility"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@page import="in.co.rays.project_3.controller.StaffMemberListCtl"%>
<%@page import="in.co.rays.project_3.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Refund List View</title>
<script src="<%=ORSView.APP_CONTEXT%>/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=ORSView.APP_CONTEXT%>/js/CheckBox11.js"></script>
<style>
.p1 {
	padding: 8px;
}

.p4 {
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/list2.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	padding-top: 85px;

	/* background-size: 100%; */
}
</style>
</head>
<body class="p4">
	<div>
		<%@include file="Header.jsp"%>
		<%@include file="calendar.jsp"%>
	</div>
	<div>
		<form action="<%=ORSView.REFUND_LIST_CTL%>" method="post">



			<jsp:useBean id="dto" class="in.co.rays.project_3.dto.RefundDTO"
				scope="request"></jsp:useBean>
			<%
				List list1 = (List) request.getAttribute("staffMemberList");
			%>

			<%
				int pageNo = ServletUtility.getPageNo(request);
				int pageSize = ServletUtility.getPageSize(request);
				int index = ((pageNo - 1) * pageSize) + 1;
				int nextPageSize = DataUtility.getInt(request.getAttribute("nextListSize").toString());
				List list = ServletUtility.getList(request);
				Iterator<RefundDTO> it = list.iterator();
				if (list.size() != 0) {
			%>
			<center>
				<h1 class="text-primary font-weight-bold pt-3">
					<font color="black">Refund List 
				</h1>
				</font>
			</center>
			</br>
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
						<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
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
					<input type="text" class="form-control" name="refundStatus"
						placeholder="Enter refund Status" class="p1"
						value="<%=ServletUtility.getParameter("refundStatus", request)%>">
				</div>

				<div class="col-sm-3">
				<%=HTMLUtility.getList("id", String.valueOf(dto.getId()), list1)%>
				</div>
				
				<div class="col-sm-3">
				<input type="text" id="datepicker" name="refundDate"
											class="form-control" placeholder="Date Of Refund"
											value="<%=ServletUtility.getParameter("refundStatus", request)%>">
											</div>

				<div class="col-sm-3">
					<input type="submit" class="btn btn-primary btn-md"
						style="font-size: 17px" name="operation"
						value="<%=RefundListCtl.OP_SEARCH%>">&emsp; <input
						type="submit" class="btn btn-warning btn-md"
						style="font-size: 17px" name="operation"
						value="<%=RefundListCtl.OP_RESET%>">
				</div>

				<div class="col-sm-1"></div>
			</div>

			</br>
			<div style="margin-bottom: 20px;" class="table-responsive">
				<table class="table table-hover table-dark table-bordered">
					<thead>
						<tr style="background-color: #8C8C8C;">

							<th width="10%"><input type="checkbox" id="select_all"
								name="Select" class="text"> Select All</th>
							<th class="text">S.NO</th>
							<th class="text">Refund Code</th>
							<th class="text">Refund Date</th>
							<th class="text">Refund Amount</th>
							<th class="text">Refund Status</th>
							<th class="text">Edit</th>


						</tr>
					</thead>
					<%
						while (it.hasNext()) {
								dto = it.next();
					%>

					<tbody>
						<tr>
							<td align="center"><input type="checkbox" class="checkbox"
								name="ids" value="<%=dto.getId()%>"></td>
							<td align="center"><%=index++%></td>
							<td align="center"><%=dto.getRefundCode()%></td>
							<td align="center"><%=DataUtility.getDateString(dto.getRefundDate())%></td>
							<td align="center"><%=dto.getRefundAmount()%></td>
							<td align="center"><%=dto.getRefundStatus()%></td>
							<td align="center"><a
								href="StaffMemberCtl?id=<%=dto.getId()%>">Edit</a></td>
						</tr>
					</tbody>
					<%
						}
					%>
				</table>
			</div>

			<table width="100%">
				<tr>
					<td><input type="submit" name="operation"
						class="btn btn-dark btn-md" style="font-size: 17px"
						value="<%=RefundListCtl.OP_PREVIOUS%>"
						<%=pageNo > 1 ? "" : "disabled"%>></td>
					<td><input type="submit" name="operation"
						class="btn btn-primary btn-md" style="font-size: 17px"
						value="<%=RefundListCtl.OP_NEW%>"></td>
					<td><input type="submit" name="operation"
						class="btn btn-danger btn-md" style="font-size: 17px"
						value="<%=RefundListCtl.OP_DELETE%>"></td>

					<td align="right"><input type="submit" name="operation"
						class="btn btn-dark btn-md" style="font-size: 17px"
						style="padding: 5px;" value="<%=RefundListCtl.OP_NEXT%>"
						<%=(nextPageSize != 0) ? "" : "disabled"%>></td>
				</tr>
				<tr></tr>
			</table>
			</br>

			<%
				}
				if (list.size() == 0) {
					System.out.println("user list view list.size==0");
			%><center>
				<h1 class="text-primary font-weight-bold pt-3">Refund
					List</h1>
			</center>
			</br>
			<div class="row">
				<div class="col-md-4"></div>

				<%
					if (!ServletUtility.getErrorMessage(request).equals("")) {
				%>
				<div class=" col-md-4 alert alert-danger alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h4>
						<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
					</h4>
				</div>
				<%
					}
				%>
				<div class="col-md-4"></div>
			</div>
			</br>
			<div style="padding-left: 48%;">
				<input type="submit" name="operation" class="btn btn-primary btn-md"
					style="font-size: 17px" value="<%=RefundListCtl.OP_BACK%>">
			</div>
			<%
				}
			%>
			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">


		</form>
	</div>
	</br>
	</br>
</body>
<%@include file="FooterView.jsp"%>
</html>