<%@page import="database.DAO"%>
<%@page import="model.DiscussionBoardModel"%>
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
<title>Discussion Board</title>
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
		<li class="active"><a href=newsfeed.jsp class="tabbold">News
				Feed</a></li>

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
													<a href="profile.jsp"> <%
 	out.println(session.getAttribute("netid"));
 %>
													</a>
												</div>

												<%
													Date dt = new java.util.Date();

													SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
													SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
													String datenow = sdf.format(dt);
													String date = sdf1.format(dt);

													ArrayList<DiscussionBoardModel> newsfeed = new ArrayList<>();
													ArrayList<DiscussionBoardModel> comment = new ArrayList<>();
													newsfeed = dao.getContent();
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
															<form action="PostContent" method="post">
																<div class="panel-heading panel-heading-gray title">
																	What&acute;s new</div>
																<div class="panel-body">
																	<input type="text" class="form-control share-text"
																		placeholder="Title" name="title" required="required">
																	<textarea name="content"
																		class="form-control share-text" rows="3"
																		placeholder="Question" required="required"></textarea>
																</div>
																<div class="panel-footer share-buttons">
																	<a href="#"><i class="fa fa-map-marker"></i></a> <a
																		href="#"><i class="fa fa-photo"></i></a> <a href="#"><i
																		class="fa fa-video-camera"></i></a><input type="hidden"
																		name="pid" value="0"> <input type="hidden"
																		name="date" value="<%=date%>">
																	<%
																		if (!(session.getAttribute("type")).equals("1")) {
																	%>
																	<input type="submit"
																		class="btn btn-primary btn-xs pull-right "
																		value="Post">
																	<%
																		}
																	%>
																</div>
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
										comment = newsfeed;
										for (int i = 0; i < newsfeed.size(); i++) {
											if ((newsfeed.get(i).getParentid()).equals("0")) {
									%>
									<li class="media media-clearfix-xs">
										<div class="media-left">
											<div class="user-wrapper">
												<img src="CSS/images/default.png" alt="people"
													class="img-circle" width="80" height="80" />

												<div>
													<a href="#"> <%
 	out.write(newsfeed.get(i).getNetid());
 %>
													</a>
												</div>
												<div class="date">
													<%
														out.write(newsfeed.get(i).getDatetime());
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
																out.println(newsfeed.get(i).getTitle());
															%>
														</p>

														<p>
															<%
																out.println(newsfeed.get(i).getContent());
															%>

															<%
																if (!(session.getAttribute("type")).equals("1")) {
															%>
														
														<form action="DeleteContent" method="post">
															<input type="hidden" name="id"
																value="<%=newsfeed.get(i).getId()%>"> <input
																type="hidden" name="pid" value="0"> <input
																type="submit" id="deletebutton"
																class="btn btn-primary btn-xs pull-right "
																value="Delete">
														</form>
														<%
															}
														%>
													</div>
													<!-- All Comments-->
													<ul class="comments">

														<li class="comment-form">
															<div class="input-group">
																<form action="PostContent" method="post">
																	<input type="hidden" class="form-control" name="title"
																		value="null" /> <input type="text"
																		class="form-control" name="content" required="required"/> <input
																		name="pid" type="hidden"
																		value="<%=newsfeed.get(i).getId()%>"> <span
																		class="input-group-btn"> <input type="hidden"
																		class="form-control" name="date" value="<%=date%>" />
																		<input type="submit" name="action"
																		class="btn btn-primary" value="reply" />
																	</span>
																</form>
															</div>
														</li>

														<!-- Comment Start-->
														<%
															for (int j = 0; j < comment.size(); j++) {
																		if (newsfeed.get(j).getParentid()
																				.equals(newsfeed.get(i).getId())) {
														%>
														<li class="media">

															<div class="media-body">
																<div class="pull-right dropdown" data-show-hover="li">
																	<a href="#" data-toggle="dropdown"
																		class="toggle-button"> <i class="fa fa-pencil"></i>
																	</a>

																</div>

																<a
																	href="viewprofile.jsp?Email=<%=newsfeed.get(j).getNetid()%>"
																	class="comment-author pull-left"> <%
 	out.write(newsfeed.get(j).getNetid());
 %>
																</a> <span> <%
 	out.write(newsfeed.get(j).getContent());
 %>


																	<form action="DeleteContent" method="post">
																		<input type="hidden" name="id"
																			value="<%=newsfeed.get(j).getId()%>"> <input
																			type="hidden" name="pid"
																			value="<%=newsfeed.get(j).getParentid()%>"> <input
																			type="submit"
																			class="btn btn-primary btn-xs pull-right "
																			value="Delete"
																			${ type eq 1 ? 'disabled="disabled"' : ''}>
																	</form>

																</span>
																<div class="comment-date">
																	<%
																		out.write(newsfeed.get(j).getDatetime());
																	%>
																</div>
															</div>
														</li>

														<%
															}
																	}
														%>

														<!-- Comment End-->
													</ul>

													<!-- All Comments-->
												</div>
											</div>
										</div>
									</li>

									<!-- Post Ends-->
									<%
										}
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