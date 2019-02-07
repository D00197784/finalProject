/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Richard
 */
public class UserDao extends Dao implements UserDaoInterface {

    public UserDao(String databaseName) {
        super(databaseName);
    }

    @Override
    public int register(String username, String password, String email) {
        Connection con = null;
        PreparedStatement ps = null;                //Inserts the user information of username,password,email,address1,address2
        // and auto generate the id
        ResultSet generatedKeys = null;

        int newId = -1;
        try {
            con = this.getConnection();

            String query = "INSERT INTO users(username, password, email) VALUES (?, ?,?)";

            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);

            ps.executeUpdate();

            generatedKeys = ps.getGeneratedKeys();

            if (generatedKeys.next()) {

                newId = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Welcome");
            System.err.println("\t" + e.getMessage());
            newId = -1;
        } finally {
            try {
                if (generatedKeys != null) {
                    generatedKeys.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.err.println("Exception occured in the reigster method: " + e.getMessage());
            }
        }
        return newId;
    }

    @Override
    public User login(String username, String password) {
        //Select username and password and make they match so the user can login
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        try {
            con = getConnection();

            String query = "Select * from users where username = ? and password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String username2 = rs.getString("username");
                String password2 = rs.getString("password");
                String email2 = rs.getString("email");
                int role2 = rs.getInt("role");
                int active2 = rs.getInt("active");

                u = new User(id, username2, password2, email2, role2, active2);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the login method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the login method: ");
            }
        }
        return u;
    }

    @Override
    public int disableUser(String username) {
        {
            Connection con = null;
            PreparedStatement ps = null;
            int change = 0;                         //changes a users active to 2 and this dosnt allow it to access any functions

            try {
                con = getConnection();

                String query = "UPDATE users SET active = 2 WHERE username = ? AND active = 1 AND role = 1";

                ps = con.prepareStatement(query);
                ps.setString(1, username);

                change = ps.executeUpdate();

            } catch (SQLException e) {
                System.out.println("Exception occured in the disableUser(String username) " + e.getMessage());
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        freeConnection(con);
                    }
                } catch (SQLException e) {
                    System.out.println("Exception occured in the disableUser(String username) ");
                    e.getMessage();
                }
            }

            return change;
        }

    }

    @Override
    public int removeUserById(int id) {
        Connection con = null;              //remove user by its id useful for testing to not over populate the database
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = this.getConnection();

            String query = "DELETE FROM users WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Exception occured in the removeUserById(int id) ");
            System.err.println(e.getMessage());
            rowsAffected = 0;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.err.println("Exception occured in the removeUserById(int id) " + e.getMessage());
            }
        }
        return rowsAffected;
    }

    @Override
    public int setActiveToDefault(String username) {
        Connection con = null;
        PreparedStatement ps = null;                //sets the role to default so it can reset the role to what it was for the test
        int change = 0;

        try {
            con = getConnection();

            String query = "UPDATE users SET active = 1 WHERE username = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, username);

            change = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the setActiveToDefault(String username) " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the setActiveToDefault(String username) ");
                e.getMessage();
            }
        }

        return change;
    }

    @Override
    public User getUserByName(String username) {
        User u = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            String query = "Select * from users where username = ?";

            ps = conn.prepareStatement(query);

            ps.setString(1, username);

            rs = ps.executeQuery();

            while (rs.next()) {
                u = new User();
                u.setUserID(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));

            }

        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the GetUserByName() method:");
            System.err.println("\t" + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException e) {
                System.err.println("A problem occurred when closing down the GetuserBynAme() method:\n" + e.getMessage());
            }
        }
        return u;     // may be null
    }

    @Override
    public User getUserById(int user_id) {
        User u = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();

            String query = "Select * from users where id = ?";

            ps = conn.prepareStatement(query);

            ps.setInt(1, user_id);

            rs = ps.executeQuery();

            while (rs.next()) {
                u = new User();
                u.setUserID(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));

            }

        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the GetUserById() method:");
            System.err.println("\t" + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException e) {
                System.err.println("A problem occurred when closing down the GetuserByID() method:\n" + e.getMessage());
            }
        }
        return u;     // may be null
    }

    @Override
    public int editAccount(String username, String password, String email, int id) {

        Connection con = null;
        PreparedStatement ps = null;                //Inserts the user information of username,password,email,address1,address2
        // and auto generate the id

        int rowsUpdated = 0;
        try {
            con = this.getConnection();

            String query = "UPDATE users set username = ?, password = ? , email = ? where id = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setInt(4, id);

            rowsUpdated = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the login method: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the editAccount(String username, String password, String email, int id) ");
                e.getMessage();
            }
        }

        return rowsUpdated;
    }

    @Override
    public List<User> getAllUsers() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList();

        try {
            con = getConnection();

            String query = "Select * from users";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getInt("role"), rs.getInt("active"));
                users.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllUsers() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getAllUsers() " + e.getMessage());
            }
        }

        return users;
    }

    @Override
    public int setUserBackToDefault() {
        Connection con = null;
        PreparedStatement ps = null;                //Inserts the user information of username,password,email,address1,address2
        // and auto generate the id

        int rowsUpdated = 0;
        try {
            con = this.getConnection();

            String query = "UPDATE users set username = 'user', password = 'userpass' , email = 'user@gmail.com' where user_id = 1";

            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            rowsUpdated = ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Welcome");
            System.err.println("\t" + e.getMessage());
            rowsUpdated = -1;
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("An exception occurred when closing the PreparedStatement of the setUserBackToDefault() " + e.getMessage());
            }
            // Close connection
            freeConnection(con);
        }
        return rowsUpdated;

    }

}
