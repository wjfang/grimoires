<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grimoires Registry Monitor</title>
</head>
<body>
<font size=4>

<jsp:useBean id="rBean" class="uk.ac.soton.ecs.grimoires.monitor.RegistryBean" scope="request" />
<p/>On <jsp:getProperty name="rBean" property="currentTime" />, Grimoires contains
<ul>
<li><jsp:getProperty name="rBean" property="businessCounter" /> published businesses,</li>
<li><jsp:getProperty name="rBean" property="serviceCounter" /> published services.</li>
</ul>
<hr/>

<p/> It takes
<ul>
<li><jsp:getProperty name="rBean" property="countTime" />ms to count published businesses and services,</li>
<li><jsp:getProperty name="rBean" property="saveTime" />ms to publish a business,</li>
<li><jsp:getProperty name="rBean" property="findTime" />ms to find a business by name,</li>
<li><jsp:getProperty name="rBean" property="deleteTime" />ms to delete a business.</li>
</ul>
<p/>Error message if there is any: <jsp:getProperty name="rBean" property="errorMessage" />

<hr/>
<jsp:useBean id="mBean" class="uk.ac.soton.ecs.grimoires.monitor.MemoryBean" scope="request" />
<p/>Current memory usage:
<ul>
<li>Heap: <jsp:getProperty name="mBean" property="heapUsage" />,</li>
<li>Non-heap: <jsp:getProperty name="mBean" property="nonHeapUsage" />.</li>
</ul>
<p/>Error message if there is any: <jsp:getProperty name="mBean" property="errorMessage" />

</font>
</body>
</html>
