package patika_clone.model;

import patika_clone.helper.DBConnector;

import java.sql.*;

public class User {
    private int id;
    private String name;
    private String u_name;
    private String pass;
    private String type;

    public User(int id, String name, String u_name, String pass, String type) {
        this.id = id;
        this.name = name;
        this.u_name = u_name;
        this.pass = pass;
        this.type = type;
    }

    public static User getUser(String uname, String pass){
        User obj = null;
        String query = "SELECT * FROM users WHERE u_name=? AND pass=?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,uname);
            pr.setString(2,pass);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                obj = new User(rs.getInt("id"), rs.getString("name"),
                        rs.getString("u_name"), rs.getString("pass"), rs.getString("type"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return obj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return u_name;
    }

    public void setUname(String u_name) {
        this.u_name = u_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
