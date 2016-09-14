<%@page import="model.ReserveResourceModel"%>
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
<title>Create Resource</title>
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
				<h3 style="color: white">Select Resource Time</h3>
				<p style="color: white"></p>
			</div>
			<div class="form-top-right">
				<i class="fa fa-pencil"></i>
			</div>
		</div>

		<%
			String timeslots[] = (String[]) request
					.getAttribute("resourcetime");
			String resourcename = (String) request.getAttribute("resourcename");
			String reourcedate = (String) request.getAttribute("resourcedate");
		%>

		<table style="color: white">
			<tr>
				<th style="min-width: 10em">Time Slot</th>
				<th style="min-width: 10em">Reservation</th>
			</tr>

			<%
			
				for (int i = 0; i < timeslots.length; i++) {
			%>

			<tr>
				<td><%=timeslots[i]%></td>
				<td>

					<form role="form" action="ReserveResource" method="post"
						class="registration-form center_div">

						<input type="hidden" name="reourcename"
							class="form-email form-control" value="<%=resourcename%>"
							id="form-email"> 
							<input type="hidden" class="form-email form-control"
							value="<%=reourcedate%>" id="form-email" name="reourcedate">
						 <input type="hidden" name="resourcetime"
							class="form-email form-control" value="<%=timeslots[i]%>"
							id="form-email" required> 
							<input type="submit"
							class="btn btn-primary btn-xs pull-right " value="Reserve">
					</form>

				</td>
			</tr>

			<%
				}
			%>

		</table>

		
	</div>

	<!-- Academics form-->
	<div class="spacing"></div>
	<section id="login" class="content-section padbot"></section>

	<!-- Footer -->
	<jsp:include page="include/footer.html" />
</body>
</html>