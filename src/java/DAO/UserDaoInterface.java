/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Richard
 */
public interface UserDaoInterface {

    public int register(String username, String password, String email);

    public User login(String username, String password);

    public User getUserByName(String username);

    public User getUserById(int id);

    public int editAccount(String username, String password, String email, int id);

    public List<User> getAllUsers();

    //ADMIN

    public int disableUser(String username);

//Functions for Testing to help
    public int removeUserById(int id);

    public int setActiveToDefault(String title);
    
    public int setUserBackToDefault();

}
