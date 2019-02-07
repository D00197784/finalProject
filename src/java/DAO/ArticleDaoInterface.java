/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.Articles;
import java.util.List;

/**
 *
 * @author D00194667
 */
public interface ArticleDaoInterface {
    
     public List<Articles> getAllArticles(int articleId);
}
