/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Articles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author D00194667
 */
public class ArticleDao extends Dao implements ArticleDaoInterface {
    
    public ArticleDao(String databaseName) {
        super(databaseName);
    }
    
    @Override
    public List<Articles> getAllArticles(int articleId) {
        ArrayList<Articles> articles = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Get a connection to the database
            conn = getConnection();

            // Set up the SQL and compile it for the database
            String query = "Select * from artcicles where articleId= ?";
            ps = conn.prepareStatement(query);

            ps.setInt(1, articleId);
            //Run query and get results
            rs = ps.executeQuery();

            // Load next result from resultset and process it
            while (rs.next()) {
                Articles a = new Articles();
                a.setArticleId(rs.getInt("articleId"));
                a.setTitle(rs.getString("title"));
                a.setBody(rs.getString("body"));
                a.setUserId(rs.getInt("userId"));
                a.setImages(rs.getString("images"));
              

               articles.add(a);
            }
        } catch (SQLException e) {
            System.out.println("An exception occurred in the getAllArticles " + e.getMessage());
        } finally {
            // Close resultset
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("An exception occurred when closing the ResultSet of the getAllReviewsForThisBook(int bookId) " + e.getMessage());
            }
            // Close prepared statement
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println("An exception occurred when closing the PreparedStatement of the getAllReviewsForThisBook(int bookId)" + e.getMessage());
            }
            // Close connection
            freeConnection(conn);
        }

        // Return results
        return articles;
    }
}
