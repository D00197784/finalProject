/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author D00194667
 */
public class Articles {
    private int articleId;
    private int userId;
    private String title;
    private String body;
    private String images;
    
    public Articles(){
        this.articleId = -1;
    }

    public Articles(int articleId, int userId, String title, String body, String images) {
        this.articleId = articleId;
        this.userId = userId;
        this.title = title;
        this.body = body;
        this.images = images;
    }
    
     public Articles( int userId, String title, String body, String images) {
        this.articleId = -1;
        this.userId = userId;
        this.title = title;
        this.body = body;
        this.images = images;
    }

    public int getArticleId() {
        return articleId;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getImages() {
        return images;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.articleId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Articles other = (Articles) obj;
        if (this.articleId != other.articleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Articles{" + "articleId=" + articleId + ", userId=" + userId + ", title=" + title + ", body=" + body + ", images=" + images + '}';
    }
    
    
}
