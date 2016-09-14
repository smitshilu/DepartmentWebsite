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
<title>Program Requirement</title>
</head>
<body>


	<!-- NAV BAR-->
	<%
		String type = (String) session.getAttribute("type");
		if (!type.equals("1")) {
	%>
	<jsp:include page="include/rnavbar.html" />
	<%
		} else {
	%>
	<jsp:include page="include/navbar.html" />
	<%
		}
	%>

	<!-- NAV BAR-->

	<br>
	<br>
	<br>
	<div class="col-sm-5 form-box ">
		<div class="form-top center_div">
			<div class="form-top-left">
				<h3 style="color: white">Requirements</h3>
				<p style="color: white"></p>
			</div>
			<div class="form-top-right">
				<i class="fa fa-pencil"></i>
			</div>
		</div>

		<%
			String program = (String) session.getAttribute("program");
			if (program.equals("MS")) {
		%>
		<p style="color: white">General Program M.S. A minimum of 31
			credits as follows:</p>

		<ul style="color: white">

			<li>A proficiency examination in Discrete Mathematics is given
				at the beginning of the first semester of graduate study. Students
				who fail this examination are required to pass a departmentally
				approved remedial program.</li>

			<li>Computer Science core (13-14 credits): CSI 503 and CSI 518
				plus two courses chosen from CSI 500, CSI 508, CSI 509, or CSI 519.
				A 3.0 average must be attained in these core courses. Full-time
				students are expected to complete these courses in the first year,
				or as soon as possible if undergraduate deficiencies are being made
				up.</li>

			<li>Elective subjects (15 credits): Computer Science courses or
				courses in other academic departments as approved by the department.
				Approval of non-departmental electives is based on the individual
				student's overall academic program and preparation.</li>

			<li>Master's Project, Thesis, or Internship (3 credits):
				Satisfactory completion of (a) any Master's Project course (CSI
				68X). The project includes the design and implementation of a
				computer program of significant scope, unless this is waived by the
				project faculty supervisor for a student who has sufficient
				programming experience. The project must include a written report.;
				(b) CSI 699, Master's Thesis; or (c) CSI 698, Internship.</li>

		</ul>

		<%
			} else if (program.equals("BS")) {
		%>

		<p style="color: white">General Program B.S. (Combined major and
			minor sequence). A minimum of 73 credits as follows:</p>
		<ul style="color: white">
			<li>Computer Systems and Science Core (24 cr.): I-Csi 201, 210,
				310, 333, 403, 404 and 409.</li>
			<li>Programming Language Principles (3 cr.): I-Csi 311.</li>
			<li>Intensive System Software Development (3 cr): I-Csi 402.</li>
			<li>Mathematics (17 cr.): A-Mat 111 or 112 or 118; 113 or 119;
				220; 367; 214 or 3 cr. from any A-Mat course numbered 300 or above.</li>
			<li>Physics and Laboratory Science (8 cr.): A-Phy140 or 141;
				145; 150 or 151; and 155. Students who took Physics I or II without
				a laboratory can substitute 1 cr. of other laboratory work for each
				of the A-Phy 145 and A-Phy 155 requirements.</li>
			<li>Science Sequence (6 cr.): One pair of related major
				biological, physical or engineering science courses (not in
				mathematics or computer science) as approved by the department.
				Approved pairs include A-Bio 110 and 111, A-Phy 240 and 250, two
				courses from A-Phy 415, 353 and 454, or others as advised.</li>
			<li>Social Aspects of Computing (3 cr.): I-Csi 300Z.</li>
			<li>Computer Science Electives (9 cr.): 6-9 cr. must be from
				I-Csi courses numbered 300-470 or 500-550 or specially approved.
				Students in the honors program can also select 487. 0-3 cr. may be
				in A-Phy 353 or 454 in digital hardware, or A-Phi 432 in advanced
				logic.</li>
		</ul>

		<%
			} else if (program.equals("BA")) {
		%>

		<p style="color: white">General Program B. A. A minimum of 41
			credits as below plus the completion of an approved minor whose
			courses do not overlap with any of the courses used to complete this
			major. (See your advisor to find an addition or substitution in case
			your minor requires a course from those below.)</p>
		<ul style="color: white">
			<li>Computer Systems and Science Core (18 cr.): I-Csi 201, 210,
				310, 333 and 404.</li>
			<li>Programming Principles and Practice (3 cr.): One of I-Csi
				311 or 405.</li>
			<li>Intensive Software Development (3 cr.): One of I-Csi 402 or
				418 or other course with intensive software development as approved
				by the department.</li>
			<li>Mathematics (11 cr.): A-Mat 111 or 112 or 118; 113 or 119,
				and 367.</li>
			<li>Electives: 6 credits in two I-Csi courses numbered 400-470
				or 500-550 or specially approved.</li>
		</ul>

		<%
			} else {
		%>
		
		<p style="color: white">Your Status: <%= session.getAttribute("phd_status") %></p>
		
		<p style="color: white">General Program PhD. A minimum of 60
			credits required</p>
		<ul style="color: white">
			<li>The course of study for each student is planned with a
				departmental advisor who considers the student's previous
				preparation, area of specialization, and professional objectives.
				The student must complete a minimum of 60 credits of graduate
				courses (which may include seminars, independent study, and
				research) and at least one additional year of research leading to an
				acceptable dissertation. These credits must include:</li>
			<ol>
				<li>Core Computer Science (14 credits): CSI 500, CSI 503, CSI
					509, and CSI 518. A 3.0 average must be attained in these four
					courses. Full-time students are expected to complete these courses
					in the first year, or as soon as possible if undergraduate
					deficiencies are being made up;</li>
				<li>Computer Science breadth: At least 9 credits from
					departmentally approved areas of specialization including at least
					3 credits from systems, 3 credits from theory, and 3 credits from
					applications;</li>
				<li>A minor of at least 9 credits in approved courses offered
					by other departments. The minor may be waived or reduced in scope
					for students with an advanced degree in a suitable field.</li>
			</ol>
			<li>Each student must complete a programming project of
				significant scope. This requirement can be satisfied by programming
				involved in dissertation research, by any project-oriented course
				numbered CSI 68X, or by programming involved in master's thesis
				research.</li>
			<li>After completing their first year of study, all doctoral
				students are expected to participate routinely in research seminars.</li>
			
		</ul>

		<%
			}
		%>

	</div>

	<!-- Academics form-->
	<div class="spacing"></div>
	<section id="login" class="content-section padbot"></section>

	<!-- Footer -->
	<jsp:include page="include/footer.html" />
</body>
</html>