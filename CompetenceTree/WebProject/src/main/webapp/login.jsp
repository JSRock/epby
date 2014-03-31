<jsp:include page="header.jsp"/>
	<div class = "loginTable" align="center">
		<form method="POST" name="loginForm">
			<table class = "loginForm">
				<tbody>
					<tr>
						<td>&nbsp;ScrumWorks Login</td>
						<td><input type="text" name="ScrumWorksLogin" value="" /></td>
						<td rowspan="4" style=" color: red; ">
							<%
							    if (request.getAttribute("LoginError").equals("true"))
							    {
							%> Wrong login or
							password! <%
							    }
							    ;
							%>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="right"><input type="reset" name="Reset"
							value="reset" /><input type="submit" name="Submit"
							value="submit" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
<jsp:include page="footer.jsp"/>