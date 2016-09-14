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
	document.getElementsByName("major")[0].disabled = true;
}
function enableField() {
	document.getElementsByName("year")[0].disabled = false;
	document.getElementsByName("program")[0].disabled = false;
	document.getElementsByName("major")[0].disabled = false;
}
</script>

<!-- Custom CSS -->
<link href="CSS/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="scripts/jquery.easing.1.3.min.js"></script>
<script type="text/javascript" src="scripts/scripts.js"></script>
<title>Student Registration</title>
</head>
<body>


	<!-- NAV BAR-->
	<nav class="navbar navbar-custom navbar-fixed-top gold"
		role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">


				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-main-collapse">
					<i class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand page-scroll" href="index.jsp"> <i
					class="fa fa-play-circle"></i> <span class="light">Faculty</span>
					
				</a>

			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div
				class="collapse navbar-collapse navbar-right navbar-main-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="Registration.jsp">Register</a></li>
					<li><a href="login.jsp">Login</a></li>
					<li class="dropdown"></li>
				</ul>


			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<!-- NAV BAR-->

	<br>
	<br>
	<br>
	<div class="col-sm-5 form-box ">
		<div class="form-top center_div">
			<div class="form-top-left">
				<h3 style="color: white">Sign up now</h3>
				<p style="color: white"></p>
			</div>
			<div class="form-top-right">
				<i class="fa fa-pencil"></i>
			</div>
		</div>
		<div class="form-bottom">
			<form role="form" action="UserRegistration" method="post"
				class="registration-form center_div">
				
				<div class="form-group">
					<label style="color: white" class="" for="netid">NetID</label> <input
						type="text" name="netid" placeholder="NetID"
						class="form-email form-control" id="form-email" required> <p style="color: red">${error_email}</p> 
				</div>
				
				<div class="form-group">
					<label style="color: white" class="" for="fname">First name</label>
					<input type="text" name="fname" placeholder="First name"
						class="form-first-name form-control" id="form-first-name" required>
				</div>
				<div class="form-group">
					<label style="color: white" class="" for="lname">Last name</label>
					<input type="text" name="lname" placeholder="Last name"
						class="form-last-name form-control" id="form-last-name" required>
				</div>
				
				<div class="form-group">
					<label style="color: white" class="" for="lname">Email</label>
					<input type="email" name="email" placeholder="Last name"
						class="form-last-name form-control" id="form-last-name" required>
				</div>
				
				<div class="form-group">
					<label style="color: white" class="" for="password">Password</label> <input
						type="password" name="password" placeholder="Password"
						class="form-password form-control" id="form-password" required></input>
				</div>

				<div class="form-group">
					<label style="color: white" class="" for="role">Role</label> <select
						class="form-control" name="role">
						<option value="student" onclick="enableField()">Student</option>
						<option value="faculty" onclick="disableField()">Faculty</option>
						<option value="staff" onclick="disableField()">Staff</option>
					</select>

				</div>
				<div class="form-group">
					<label style="color: white" class="" for="year">Year of Admission</label>
					<input type="text" name="year" placeholder="Year of Admission"
						class="form-last-name form-control" id="form-last-name" required>
				</div>
				
				<div class="form-group">
					<label style="color: white" class="" for="program">Program</label> <select
						class="form-control" name="program">
						<option value="BA">BA</option>
						<option value="BS">BS</option>
						<option value="MS">MS</option>
						<option value="PhD">PhD</option>
					</select>
				</div>
				
				<div class="form-group">
					<label style="color: white" class="" for="major">Major
						</label> <input type="text" name="major"
						placeholder="Program" class="form-email form-control"
						id="form-email" required>
				</div>

				<input type="submit" class="btn btn-lg btn-default"
					value="Register">
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