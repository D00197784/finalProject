<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
       
        </style>
    </head>
    <body>
  <%@ include file = "header.jsp" %>
        <form action="FrontController" method="post">

           
            <p>Register</p>
            <table>
                <tr>
                    <td>Username: </td><td> <input name="username" size=30 type="text" /> </td> 
                </tr>
                <tr>
                    <td> Password: </td><td> <input name="password" size=30 type="text" /> </td> 
                </tr>
                <tr>
                    <td> Email </td><td> <input name="email" size=30 type="text" /> </td> 
                </tr>
            </table>
            <input type="submit" value='Register' />
            <!-- Include a hidden field to identify what the user wants to do -->
            <input type="hidden" name ="action" value="register" />
        </form>
    </body>
</html>
