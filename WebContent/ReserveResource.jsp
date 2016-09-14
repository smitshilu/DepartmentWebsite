<%@page import="model.ResourceModel"%>
<%@page import="java.io.PrintWriter"%>
<%@ page import="java.util.*"%>
<%@ page import="database.DAO"%>

<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<!-- Custom CSS -->
<link href="CSS/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/jquery.easing.1.3.min.js"></script>
<script type="text/javascript" src="scripts/scripts.js"></script>
<title>Reserve Resource</title>
</head>
<body>


	<!-- NAV BAR-->
	<jsp:include page="include/rnavbar.html" />

	<!-- NAV BAR-->

	<br>
	<br>
	<br>
	<div class="col-sm-5 form-box ">


		<div class="form-top center_div">
			<div class="form-top-left"></div>
			<div class="form-top-right">
				<i class="fa fa-pencil"></i>
			</div>
		</div>

		<div class="form-top center_div">
			<div class="form-top-left">
				<h3 style="color: white">Reserve Resource</h3>
				<p style="color: white"></p>
			</div>
			<div class="form-top-right">
				<i class="fa fa-pencil"></i>
			</div>
		</div>

		<div class="form-bottom">

			<%
				DAO dao = new DAO();
				ArrayList<ResourceModel> resource = dao.getResourceDetails();
			%>

			<table style="color: white">
				<tr>
					<th style="min-width: 10em">Room</th>
					<th style="min-width: 10em">Furniture</th>
					<th style="min-width: 10em">Devices</th>
				</tr>
				
				<%
					for (int i = 0; i < resource.size(); i++) {
				%>
				<tr>
					<%
						if ((resource.get(i).getResourcetype()).equals("Room")) {
					%>
					<td>
						<form role="form" action="SelectReservationTime" method="post"
							class="registration-form center_div">

								<input type="text"
								placeholder="Resource Name" class="form-email form-control"
								value="<%=resource.get(i).getResourcename()%>" id="form-email"
								disabled="disabled"> <input type="hidden" name="resourcename"
								placeholder="Resource Name" class="form-email form-control"
								value="<%=resource.get(i).getResourcename()%>" id="form-email"
								required> <input type="date" name="resourcedate"
								placeholder="mm/dd/yyyy" class="form-email form-control"
								id="form-email" required> <input type="submit"
								class="btn btn-primary btn-xs pull-right " value="Reserve">
						</form>
						</td>
					<%
						} else {
					%>
					<td></td>
					<%
						}
					%>

					<%
						if ((resource.get(i).getResourcetype()).equals("Furniture")) {
					%>
					<td>
					<form role="form" action="SelectReservationTime" method="post"
							class="registration-form center_div">

								<input type="text"
								placeholder="Resource Name" class="form-email form-control"
								value="<%=resource.get(i).getResourcename()%>" id="form-email"
								disabled="disabled"> <input type="hidden" name="resourcename"
								placeholder="Resource Name" class="form-email form-control"
								value="<%=resource.get(i).getResourcename()%>" id="form-email"
								required> <input type="date" name="resourcedate"
								placeholder="mm/dd/yyyy" class="form-email form-control"
								id="form-email" required> <input type="submit"
								class="btn btn-primary btn-xs pull-right " value="Reserve">
						</form>
					</td>
					<%
						} else {
					%>
					<td></td>
					<%
						}
					%>

					<%
						if ((resource.get(i).getResourcetype()).equals("Device")) {
					%>
					<td>
					<form role="form" action="SelectReservationTime" method="post"
							class="registration-form center_div">

								<input type="text"
								placeholder="Resource Name" class="form-email form-control"
								value="<%=resource.get(i).getResourcename()%>" id="form-email"
								disabled="disabled"> <input type="hidden" name="resourcename"
								placeholder="Resource Name" class="form-email form-control"
								value="<%=resource.get(i).getResourcename()%>" id="form-email"
								required> <input type="date" name="resourcedate"
								placeholder="mm/dd/yyyy" class="form-email form-control"
								id="form-email" required> <input type="submit"
								class="btn btn-primary btn-xs pull-right " value="Reserve">
						</form>
					</td>
					<%
						} else {
					%>
					<td></td>
					<%
						}
					%>

				</tr>
				<%
					}
				%>
			</table>

		</div>
	</div>

	<!-- Academics form-->
	<div class="spacing"></div>
	<section id="login" class="content-section padbot"></section>

	<!-- Footer -->
	<jsp:include page="include/footer.html" />
</body>
</html>