<%-- 
    Document   : ViewReviews
    Created on : 09-Dec-2018, 10:27:47
    Author     : Richard
--%>


<%@page import="java.util.List"%>
<%@page import="DTO.Articles"%>

<%@page import="DAO.ArticleDao"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ include file = "header.jsp" %>
    </head>
    <body>
        <%            String articleId = request.getParameter("articleId");
            int articleID = Integer.parseInt(articleId);
            ArticleDao articledao = new ArticleDao("gsw");
            Articles a = articledao.getAllArticles(articleID);

            ReviewDao reviewdao = new ReviewDao("library3");
            List<Reviews> r = reviewdao.getAllReviewsForThisBook(b.getBookID());
            UserDao userdao = new UserDao("library3");


        %>   <h1><%=b.getTitle()%> </h1> <%

                if (b != null && r != null && !r.isEmpty()) {
        %>
        <table>
            <tr>
                <th><%=dataBundle.getString("ViewReviews_Reviewer")%></th>
                <th><%=dataBundle.getString("ViewReviews_Content")%></th>
                <th><%=dataBundle.getString("ViewReviews_Rating")%></th>
                <th><%=dataBundle.getString("ViewReviews_DateOfReview")%></th>

            </tr>
            <%
                // Loop to print out all of the rows
                for (Reviews rev : r) {
                    User reviewer = userdao.getUserById(rev.getUserID());

            %>
            <tr>
                <td><%=reviewer.getUsername()%></td>
                <td><%=rev.getContent()%></td>
                <td><%=rev.getRating()%></td>  
                <td><%=rev.getDate()%></td>




            </tr>

            <%                    // Close the loop
                }
            %>
        </table>
        <%
            } else {
                %><h1><%=dataBundle.getString("ViewReviews_NoReviews")%></h1><%
            }
        %>


    </body>
</html>

