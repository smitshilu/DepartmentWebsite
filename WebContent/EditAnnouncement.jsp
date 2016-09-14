<%@page import="java.util.ArrayList"%>
<%@page import="database.DAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="model.GetProfileModel"%>

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
<title>Edit</title>
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
				<h3 style="color: white">Edit Profile</h3>
				<p style="color: white"></p>
			</div>
			<div class="form-top-right">
				<i class="fa fa-pencil"></i>
			</div>
		</div>

		<%
			String netid = (String) session.getAttribute("netid");
			String type = (String) session.getAttribute("type");

			DAO dao = new DAO();
			ArrayList<GetProfileModel> profile = new ArrayList<>();

			try {
				if (type.equals("1")) {
					profile = dao.getStudentProfile(netid);
				} else if (type.equals("2")) {
					profile = dao.getFacultyProfile(netid);
				} else {
					profile = dao.getStaffProfile(netid);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		%>


		<div class="form-bottom">
			<form role="form" action="EditAnnouncement" method="post"
				class="registration-form center_div">

				<input type="hidden" name="id"
					value="<%=request.getParameter("id")%>"> <input
					type="hidden" name="type"
					value="<%=request.getParameter("type")%>">

				<div class="form-group">
					<input type="text" name="announcement" placeholder="Title"
						value="<%=request.getParameter("announcement")%>"
						class="form-email form-control" id="form-email" required>
					<p style="color: red"></p>
				</div>



				<%
					if ((request.getParameter("type")).equals("job")) {
				%>

				<div class="form-group">
					<input type="email" name="email"
						value="<%=request.getParameter("email")%>"
						class="form-email form-control" id="form-email" required>
					<p style="color: red"></p>
				</div>

				<div class="form-group">
					<input type="text" name="link" class="form-email form-control"
						value="<%=request.getParameter("link")%>" id="form-email"
						required>
					<p style="color: red"></p>
				</div>

				<%
					}
				%>

				<input type="submit" class="btn btn-lg btn-default" value="Edit">
			</form>
		</div>
	</div>

	<!-- Academics form-->
	<div class="spacing"></div>
	<section id="login" class="content-section padbot"></section>

	<!-- Footer -->
	<jsp:include page="include/footer.html" />
</body>
</html>