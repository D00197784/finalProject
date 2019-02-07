<%-- 
    Document   : registerSuccesful
    Created on : 11-Nov-2018, 23:07:51
    Author     : Richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <%@ include file = "header.jsp" %>
        <%
          
            Object resultValues = session.getAttribute("numLogin");
            User u2 = (User) resultValues;
               if (u2 != null) {
            %>
            <%=u2.getUsername()%> <%=dataBundle.getString("registerSucc_succ")%>
        <%

        } else {
        %> <%=dataBundle.getString("registerSucc_Failed")%> <% }
        %>
        
              <div> <a href = "index.jsp" > <%=dataBundle.getString("error_BacktoHome")%></a > </div> 
    </body>
</html>
