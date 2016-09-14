<%@ page import="model.CoursesViewModel"%>
<%@ page import="database.DAO"%>
<%@ page import="java.util.ArrayList;"%>

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
<title>My Courses</title>
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
			<div class="form-top-left">
				<h3 style="color: white">Courses</h3>
				<p style="color: white"></p>
			</div>
			<div class="form-top-right">
				<i class="fa fa-pencil"></i>
			</div>
		</div>
		<div class="form-bottom">
			<%
			DAO dao = new DAO();
				ArrayList<CoursesViewModel> courseinfo = dao.getMyCourseInfo(((String) session.getAttribute("netid")));
			%>
			<table style="color: white">
				<tr>
					<th style="min-width: 10em">Course Number</th>
					<th style="min-width: 10em">Course Name</th>
					<th style="min-width: 10em">Instructor</th>
					<th style="min-width: 10em">Term</th>
					<th style="min-width: 30em">Info</th>
				</tr>
				<%
					for (int i = 0; i < courseinfo.size(); i++) {
				%>
				<tr>
					<td><%=courseinfo.get(i).getCoursenumber()%></td>
					<td><%=courseinfo.get(i).getCoursename()%></td>
					<td>
						<%
							if (!(courseinfo.get(i).getInstructor()).equals("null")) {
						%> <%=courseinfo.get(i).getInstructor()%>
						<%
							} else {
						%> <a
						href="MakeMyCourse?coursenumber=<%=courseinfo.get(i).getCoursenumber()%>">Make
							me Instructor</a> <%
 	}
 %>
					</td>

					<td><%=courseinfo.get(i).getTerm() %></td>
					<td>
					
					<%
					if((courseinfo.get(i).getNetid()).equals(session.getAttribute("netid"))) {
					%>		
					<form action="EditMyCourse" method="post">
					<input
						type="hidden" name="coursenumber"
						class="form-email form-control" id="form-email" value="<%= courseinfo.get(i).getCoursenumber() %>" required>
						<input
						type="text" value="<%= courseinfo.get(i).getCourseinfo() %>"
						class="form-email form-control" id="form-email" name="courseinfo" required>
						<input type="submit" class="btn btn-lg btn-default"
					value="Edit">
					</form>
					<%
					}
					else { %>
						<%=courseinfo.get(i).getCourseinfo() %>
				<%	}
 %>
					
					
					
					 </td>
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