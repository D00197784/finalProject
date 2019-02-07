<%-- 
    Document   : header
    Created on : 11-Nov-2018, 23:23:41
    Author     : Richard
--%>



<%@page import="DAO.UserDao"%>
<%@page import="DTO.Address"%>

<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="DTO.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Library</title>
        <style>
            body {font-family: Arial;}

            /* Style the tab */
            .tab {
                overflow: hidden;
                border: 1px solid #ccc;
                background-color: #f1f1f1;
            }

            /* Style the buttons inside the tab */
            .tab a {
                background-color: inherit;
                float: left;
                border: none;
                outline: none;
                cursor: pointer;
                padding: 14px 16px;
                transition: 0.3s;
                font-size: 17px;
                color:black;
                text-decoration: none;

            }

            /* Change background color of buttons on hover */
            .tab a:hover {
                background-color: #ddd;
            }

            /* Create an active/current tablink class */
            .tab a.active {
                background-color: #ccc;
            }

            /* Style the tab content */
            .tabcontent {
                display: none;
                padding: 6px 12px;
                border: 1px solid #ccc;
                border-top: none;
            }

            .submit{

                margin-left:500px;
            }




            .dropdown {
                float: left;
                overflow: hidden;
            }

            .dropdown .dropbtn {
                font-size: 16px;    
                border: none;
                outline: none;

                padding: 14px 16px;
                background-color: inherit;
                font-family: inherit;
                margin: 0;
            }

            .navbar a:hover, .dropdown:hover .dropbtn {
                background-color: #ddd;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

            .dropdown-content a {
                float: none;
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
                text-align: left;
            }

            .dropdown-content a:hover {
                background-color: #ddd;
            }

            .dropdown:hover .dropdown-content {
                display: block;
            }      

            body{
                margin:0;
            }


        </style>
    </head>
    <body>
        <%@ include file = "footer.jsp" %>


        <div class="tab">

            <a href ='index.jsp'><%=dataBundle.getString("header_home")%></a>
            <a href ='register.jsp'><%=dataBundle.getString("header_register")%></a>
            <a href ='viewTeam.jsp'>View Team</a>
            <a href ='shop.jsp'>Shop</a>
            <a href ='tickets.jsp'>Tickets</a>
             <a href ='social.jsp'>Social</a>


            <%                String message = null;

                Object resultValue = session.getAttribute("numLogin");

                User u = (User) resultValue;
            

                if (u != null && u.getRole() == 1 && u.getActive() == 1) {
            %>

            <div class="navbar">

                <div class="dropdown">
                    <button class="dropbtn" href="MyAccount.jsp" > <%=dataBundle.getString("header_myAccount")%></button>
                    <div class="dropdown-content">
                        <a href="MyAccount.jsp"><%=dataBundle.getString("header_personalDetails")%></a>
                        <a href="EditAccount.jsp"><%=dataBundle.getString("header_editAcc")%></a>
                        <a href="OrderList.jsp"><%=dataBundle.getString("header_myBorrowHistory")%></a>
                        <a href="OrderListCurrent.jsp"><%=dataBundle.getString("header_currentlyBorrowing")%></a>


                    </div>

                </div> 
            </div>

            <a href="FrontController?action=logout"><%=dataBundle.getString("header_logout")%></a>

            <%=u.getUsername()%> <%=dataBundle.getString("header_loggedIn")%>
            <%

            } else if (u != null && u.getRole() == 2 && u.getActive() == 1) {
            %>

            <div class="navbar">

                <div class="dropdown">
                    <button class="dropbtn" href="MyAccount.jsp" > <%=dataBundle.getString("header_myAccount")%>

                    </button>
                    <div class="dropdown-content">
                        <a href="MyAccount.jsp"><%=dataBundle.getString("header_personalDetails")%></a>
                        <a href="EditAccount.jsp"><%=dataBundle.getString("header_editAcc")%></a>
                        <a href="OrderList.jsp"><%=dataBundle.getString("header_myBorrowHistory")%></a>
                        <a href="OrderListCurrent.jsp"><%=dataBundle.getString("header_currentlyBorrowing")%></a>

                    </div>

                </div> 
            </div>

            <div class="navbar">

                <div class="dropdown">
                    <button class="dropbtn"><%=dataBundle.getString("header_adminFunctions")%>
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-content">
                        <a href="AddBook.jsp"><%=dataBundle.getString("header_addBook")%></a>
                        <a href="DisableUser.jsp"><%=dataBundle.getString("header_disableUser")%></a>
                    </div>

                </div> 
            </div>
            <div class="dropbtn">
                <a href="FrontController?action=logout"><%=dataBundle.getString("header_logout")%></a>
            </div>

            <%=u.getUsername()%><%=dataBundle.getString("header_loggedIn")%>
        </div>
        <%

        } else if (u != null && u.getActive() == 2) {
%>
<h1><%=dataBundle.getString("header_accDisabled")%></h1><%

        } else {
        %> <form action="FrontController" method="post">
            <table>
                <tr>
                    <td> <%=dataBundle.getString("header_username")%> </td><td> <input name="username" size=30 type="text" /> </td> 
                </tr>
                <tr>
                    <td> <%=dataBundle.getString("header_password")%> </td><td> <input name="password" size=30 type="password" /> </td> 
                </tr>
            </table>
            <div class="submit">
                <input type="submit" value="<%=dataBundle.getString("header_login")%>" />
                <!-- Include a hidden field to identify what the user wants to do -->
                <input type="hidden" name ="action" value="login" />
        </form></div>

    <% }
    %>


</div>
</body>
</html>
