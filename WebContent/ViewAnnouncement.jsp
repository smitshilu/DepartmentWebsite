<%@page import="database.DAO"%>
<%@page import="model.AnnouncementModel"%>
<%@page import="java.io.PrintWriter"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Announcement</title>
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

<link href="CSS/style.css" rel="stylesheet">
<script src="scripts/grayscale.js"></script>
<script src="scripts/scripts.js"></script>

<script type="text/javascript">
	function disableField() {
		document.getElementsByName("email")[0].disabled = true;
		document.getElementsByName("link")[0].disabled = true;
	}
	function enableField() {
		document.getElementsByName("email")[0].disabled = false;
		document.getElementsByName("link")[0].disabled = false;
	}
</script>

<link href="CSS/style.css" rel="stylesheet" type="text/css">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">

</head>

<body class="feeding">

	<!-- Wrapper required for sidebar transitions -->


	<!-- Fixed navbar -->

	<!-- Navigation -->
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

	<br>
	<br>
	<br>

	<!--tabs-->

	<div class="container"></div>

	<ul class="nav nav-tabs">
		<li class="active"><a href=newsfeed.jsp class="tabbold">Announcement</a></li>

	</ul>

	<div class="tab-content">
		<div id="home" class="tab-pane fade in active">

			<!--tabs-->

			<!--NEWSFEEDS-->

			<!-- this is the wrapper for the content -->
			<div class="st-content">

				<!-- extra div for emulating position:fixed of the menu -->
				<div class="st-content-inner">

					<div class="container">

						<div class="row">
							<div class="col-md-9">
								<ul class="timeline-list">
									<%
										DAO dao = new DAO();
									%>
									<!-- Post Starts-->
									<li class="media media-clearfix-xs">
										<div class="media-left">
											<div class="user-wrapper">
												<img src="CSS/images/default.png" alt="people"
													class="img-circle" width="80" height="80" />
												<div>
													<a href="#"> <%
 	out.println(session.getAttribute("netid"));
 %>
													</a>
												</div>

												<%
													Date dt = new java.util.Date();

													SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
													String datenow = sdf.format(dt);

													ArrayList<AnnouncementModel> announcementfeed = new ArrayList<>();
													announcementfeed = dao.getAnnouncement();
												%>

												<div class="date">
													<%
														out.println(datenow);
													%>
												</div>
											</div>
										</div>
										<div class="media-body">
											<div class="media-body-wrapper">
												<div class="row">
													<div class="col-md-10 col-lg-8">
														<div class="panel panel-default share clearfix-xs">
															<form action="PostAnnouncement" method="post">
																<div class="panel-heading panel-heading-gray title">
																	What&acute;s new</div>
																<div class="panel-body">

																	<textarea name="announcement"
																		class="form-control share-text" rows="3"
																		placeholder="Announcement" required="required"></textarea>
																</div>


																<div class="form-group">
																	<label style="color: white" class="" for="program">Type</label>
																	<select class="form-control" name="type" required="required">
																		<option value="job" onclick="enableField()">Job</option>
																		<option value="news" onclick="disableField()">News</option>
																		<option value="event" onclick="disableField()">Event</option>
																	</select>
																</div>

																<div class="panel-body">


																	<label style="color: white" class="" for="program">Email</label>
																	<input type="text" class="form-control share-text"
																		placeholder="Email" name="email">
																</div>

																<div class="panel-body">


																	<label style="color: white" class="" for="program">Link</label>
																	<input type="text" class="form-control share-text"
																		placeholder="Link" name="link">
																</div>

<%
																		if (!(session.getAttribute("type")).equals("1")) {
																	%>
<input
																type="submit" id=""
																class="btn btn-primary btn-xs pull-right "
																value="Post">
																<% } %>

															</form>
														</div>
													</div>
												</div>
												<div class="clearfix"></div>
											</div>

										</div>
									</li>

									<!-- Post Ends-->



									<!-- Post Starts-->
									<%
										
										for (int i = 0; i < announcementfeed.size(); i++) {
									%>
									<li class="media media-clearfix-xs">
										<div class="media-left">
											<div class="user-wrapper">
												<img src="CSS/images/default.png" alt="people"
													class="img-circle" width="80" height="80" />

												<div>
													<a href="#"> <%
 	out.write(announcementfeed.get(i).getNetid());
 %>
													</a>
												</div>
												<div class="date">
													<%
														out.write(announcementfeed.get(i).getDate());
													%>
												</div>
											</div>
										</div>
										<div class="media-body">
											<div class="media-body-wrapper">
												<div class="panel panel-default">

													<div class="panel-body">


														<p>
															<%
																out.println(announcementfeed.get(i).getAnnouncement());
															
															
															if((announcementfeed.get(i).getType()).equals("job")) {
															
																out.println("<br><a href='mailto:"+announcementfeed.get(i).getEmail()+"' target='_blank'>"+announcementfeed.get(i).getEmail()+"</a>");
																out.println("<br><a href='http://"+announcementfeed.get(i).getLink()+"' target='_blank'>"+announcementfeed.get(i).getLink()+"</a>");
																
															
															}	
															if((announcementfeed.get(i).getNetid()).equals(((String) session.getAttribute("netid")))) {
															
															%>
														
														<form action="EditAnnouncement.jsp" method="post">
															<input type="hidden" name="id"
																value="<%=announcementfeed.get(i).getId()%>">
																<input type="hidden" name="announcement"
																value="<%=announcementfeed.get(i).getAnnouncement()%>">
																<input type="hidden" name="type"
																value="<%=announcementfeed.get(i).getType()%>">
																<input type="hidden" name="email"
																value="<%=announcementfeed.get(i).getEmail()%>">
																<input type="hidden" name="link"
																value="<%=announcementfeed.get(i).getLink()%>">
																
																<input
																type="submit" id="deletebutton"
																class="btn btn-primary btn-xs pull-right "
																value="Edit">
														</form>
														
														<form action="DeleteAnnouncement" method="get">
															<input type="hidden" name="id"
																value="<%=announcementfeed.get(i).getId()%>"><input
																type="submit" id="deletebutton"
																class="btn btn-primary btn-xs pull-right "
																value="Delete">
																
																<% } %>
																
														</form>

													</div>
																									</div>
											</div>
										</div>
									</li>

									<!-- Post Ends-->
									<%
										}
										
									%>

								</ul>
							</div>

						</div>
					</div>
				</div>
			</div>

			<!--CLOSING OF TABS-->
		</div>
	</div>

	<!-- Footer -->
	<jsp:include page="include/footer.html" />
</body>

</html>