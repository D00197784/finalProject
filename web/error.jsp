<%-- 
    Document   : error.jsp
    Created on : 11-Nov-2018, 11:55:44
    Author     : Richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <%@ include file = "header.jsp" %>
    </head>
    <body>
        <h1><%=dataBundle.getString("error_Message")%></h1>
        <%
            // Get the error message variable out of the session
            Object msg = session.getAttribute("errorMessage");
            // Cast it to a String so we can use it
            String error = (String) msg;
            // Display the message
%>

        <div> <%=error%> </div>
        <%
            // We have finished with the results of this action
            // so now we can remove the value from the session
            session.removeAttribute("errorMessage");
            // This makes sure that old error messages 
            // don't mistakenly get printed out later
%> 

<div><a href="index.jsp"><%=dataBundle.getString("error_BacktoHome")%></a></div>
    </body>
</html>
