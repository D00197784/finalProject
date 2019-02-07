<%-- 
    Document   : footer
    Created on : 26-Nov-2018, 22:07:07
    Author     : Richard
--%>

<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <style>
            html {
                position: relative;
                min-height: 100%;
            }

            body {
                margin: 0 0 100px;
                /* bottom = footer height */

            }

            .footer{
                position: absolute;
                bottom: 0;
                left: 0;
                right: 0;
                height:30px;

            }
        </style>
    </head>
    <body>
        <div class="footer" >
            <%
                // Retrieve the appropriate Locale - check if it's already been set within the site
                Locale clientLocale = (Locale) session.getAttribute("currentLocale");

                // If there was no locale already set -- it's their first time here or their session timed out
                if (clientLocale == null) {
                    // Get the locale for the client's browser (that is what's stored in the request)
                    clientLocale = request.getLocale();
                    // Save it as the currently selected locale
                    session.setAttribute("currentLocale", clientLocale);
                }
            %>
            <!-- create a form to change the language based on changing the drop down selection -->
            <form action="FrontController" method="post">
                <!-- When the value of the drop down changes, 
                submit the form and send the value to the controller -->
                <select name ="language" onchange="this.form.submit()">
                    <%
                        String language = (String) session.getAttribute("language");
                        if (language == null || language.equals("en")) {

                    %>
                    <option value="en" selected>English</option>
                    <option value="lt">Lithuanian</option>
                    <%        } else {
                    %>
                    <option value="en">English</option>
                    <option value="lt" selected>Lithuanian</option>
                    <%
                        }
                    %>
                </select>
                <input type="hidden" name="action" value="changeLanguage"/>
            </form>
            <!-- Create the resource bundle we're going to be using in all pages.
                Putting it in here means we don't need to repeat it in every page
            --> 
            <%
                // Retrieve the resource bundle from the session
                ResourceBundle dataBundle = (ResourceBundle) session.getAttribute("dataBundle");
                // If there is no bundle stored (i.e. if this is the first time you're coming to the site)
                if (dataBundle == null) {
                    // Create a resource bundle based on the client's current locale settings
                    dataBundle = ResourceBundle.getBundle("Properties.ClassicModels", clientLocale);

                    // Store this resource bundle for future use
                    session.setAttribute("dataBundle", dataBundle);
                }

            %>
        </div>

    </body>
</html>
