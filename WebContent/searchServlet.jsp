<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<script type="text/javascript">
	$(function() {
		$('#searchServlet').on('submit', function(e) {
			$('#loading_bar').show();
			$.ajax({
				type : 'post',
				url : 'searchServlet',
				data : $('#searchServlet').serialize(),
				success : function(responseText) {
					$('#results').html(responseText);
					$('#results_table').show();
					$('#loading_bar').hide();
				}
			});
			e.preventDefault();
		});
	});
</script>
<script>
  function onLoad()
  {
    $('#results_table').hide();
	$('#loading_bar').hide();
  }
  window.onload=onLoad;
</script>
<div class="jumbotron"></div>

<div class="bs-docs-section">
	<div class="row">
		<div class="col-lg-7 col-md-10 col-md-push-3">
			<!-- Forms================================================== -->
			<div class="bs-docs-section">
				<div class="row">
					<div class="col-lg-12">
						<div class="well bs-component">
							<form action="searchServlet" id="searchServlet" method="post"
								class="form-horizontal">
								<fieldset>
									<legend>Adavance Search: Choose from the dropdown box which category you want to search!</legend>
									<div class="form-group">
										<label for="tweetData" class="col-lg-2 control-label">Twitter
											Name:</label>
										<div class="col-lg-8">
											<input type="text" class="form-control" name="twitterID"
												id="twitterID"
												placeholder="Enter Twitter ID or type * to view all"
												required>
										</div>
												
										<select name="item" class="input-sm col-lg-2" required>
										    <option value="article">Article</option>
										    <option value="author">Author</option>
										    <option value="keywords">keywords</option>
										</select>
									</div>
									<div class="form-group">
										<div class="col-lg-10 col-lg-offset-2">
											<button type="submit" class="btn btn-primary">Submit</button>
											<input type="reset" class="btn btn-default" value="Reset" />
										</div>
									</div>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<img src="images/ajax-loader.gif" id="loading_bar" align="middle">
	<div class="row">
		<div id="results_table">
			<div class="col-lg-7 col-md-10 col-md-push-3">
				<div class="row">
					<div class="well bs-component">
						<h1>List of Saved User Tweets</h1>
						<div class="row">
							<div class="col-md-10">
								<table
									class="table table-hover table-responsive table-bordered table-condensed">
									<thead>
										<tr>
											<th><b>Picture</b>
											<th><b>Twitter Username</b>
											<th><b>Location</b>
											<th><b>Description</b>
											<th><b>Tweet</b>
											<th><b>ReTweet</b>
										</tr>
									</thead>
									<tbody class="table-hover" id="results">
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<%@ include file="footer.jsp"%>
	</footer>
	</body>
</html>