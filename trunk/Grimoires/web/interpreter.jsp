<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*" %>
<%@ page import="uk.ac.soton.ecs.grimoires.gscript.Engine" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

<%
	BufferedReader reader = request.getReader();
	StringBuffer script = new StringBuffer(512);
	for (String line = reader.readLine(); line != null; line = reader.readLine()) {
		script.append(line);
	}
	reader.close();
	
	String result = new Engine().executeAndHandleException(script.toString());
	
	PrintWriter writer = response.getWriter();
	writer.println(result);
	writer.close();
%>

</body>
</html>