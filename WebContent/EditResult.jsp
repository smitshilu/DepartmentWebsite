<%@ page import="model.ExamResultModel"%>
<%@ page import="java.util.ArrayList"%>
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

<script type="text/javascript">
	function disableField() {
		document.getElementsByName("year")[0].disabled = true;
		document.getElementsByName("program")[0].disabled = true;
	}
	function enableField() {
		document.getElementsByName("year")[0].disabled = false;
		document.getElementsByName("program")[0].disabled = false;
	}
</script>

<!-- Custom CSS -->
<link href="CSS/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/jquery.easing.1.3.min.js"></script>
<script type="text/javascript" src="scripts/scripts.js"></script>
<title>Edit Exam Result</title>
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
				<h3 style="color: white">Edit Result</h3>
				<p style="color: white"></p>
			</div>
			<div class="form-top-right">
				<i class="fa fa-pencil"></i>
			</div>
		</div>
		<div class="form-bottom">

			<%
				DAO dao = new DAO();
			String id = request.getParameter("examid");
			System.out.println(id);
				ArrayList<ExamResultModel> exam = dao.getExamDetails(id);
				
				if(!(exam.get(0).getNetid()).equals(((String) session.getAttribute("netid")))) {
					response.sendRedirect("ViewResult.jsp");
				}
				
			%>

			<form role="form" action="EditExamResult" method="post"
				class="registration-form center_div">

				<div class="form-group">
					<label style="color: white" class="" for="role">Exam Name</label> <input
						type="text" name="examname" placeholder="Exam Name"
						value="<%=exam.get(0).getExamname()%>"
						class="form-last-name form-control" id="form-last-name" required>

				</div>

				<div class="form-group">
					<label style="color: white" class="" for="role">Exam Result</label>
					<textarea name="result" class="form-control share-text" rows="3"
						 placeholder="Result" required><%=exam.get(0).getResult()%></textarea>

				</div>

				<input type="hidden" name="id" value="<%=exam.get(0).getId()%>"
					required> <input type="submit"
					class="btn btn-lg btn-default" value="Edit Result">
			</form>

			<br> <br>

		</div>
	</div>

	<!-- Academics form-->
	<div class="spacing"></div>
	<section id="login" class="content-section padbot"></section>

	<!-- Footer -->
	<jsp:include page="include/footer.html" />
</body>
</html>