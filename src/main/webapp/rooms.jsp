<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<form action="CustomerInfo.jsp" method="post">
		<table border="1">
			<tr>
				<th>Room_Number</th>
				<th>Pice</th>
				<th>Room_type</th>
				<th>Status</th>

			</tr>
			<%
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagent", "root", "mubeenM#7745");
				PreparedStatement pr = con.prepareStatement("select * from Rooms");
				ResultSet rs = pr.executeQuery();
				while (rs.next()) {
			%>
			<tr>
				<td>
						<%
					out.print(rs.getInt(1));
					%>
				</td>
				<td>
					<%
					out.print(rs.getString(2));
					%>
				</td>
				<td>
					<%
					out.print(rs.getString(3));
					%>
				</td>
				<td>
					<%
					out.print(rs.getString(4));
					%>
				</td>
				
				
				<td>
				<a href="CustomerInfo.jsp?rid=<%=rs.getInt(1)%>&amt=<%=rs.getString(2) %> " class="btn btn-success">book</a>
				</td>
			</tr>
			<% 
			}
			} catch (Exception e) {
			System.out.println(e.getMessage());
			}
			%>
		</table>
	</form>
	
</body>
</html>