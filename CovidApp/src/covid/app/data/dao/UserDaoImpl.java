package covid.app.data.dao;

import covid.app.data.model.User;
import covid.app.main.app.boolship.Human;
import covid.app.manager.DBConnectionManager;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private DBConnectionManager manager;

    public UserDaoImpl(DBConnectionManager manager) {
        this.manager = manager;
    }


    @Override
    public boolean insertUser(User user) {
        String query = "insert into users(user_Type,username,user_password,user_email) values('" + user.getUserType() + "','"
                + user.getUsername() + "','"
                + user.getPassword() + "','" + user.getEmail() + "')";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            int i = ps.executeUpdate();
            if (i > 0)
                return true;
            else
                return false;
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    //    org_Id serial Primary Key not null,
//    org_Type varchar not null,
//    org_Name varchar unique not null,
//    org_Location varchar not null,
//    org_Num_Of_People int not null,
//    org_username varchar not null,
//    activity varchar null
    @Override
    public boolean insertOrganisation(String userid, String orgType, String orgName, String orgLocation, int orgNumOfPeople, String orgUsername, String activity) {
        String query = "insert into organisations(org_Type,org_Name,org_Location,org_Num_Of_People,username,activity) values('" + orgType + "','"
                + orgName + "','"
                + orgLocation + "','" + orgNumOfPeople + "','" + orgUsername + "','" + activity + "')";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            int i = ps.executeUpdate();
            if (i > 0)
                return true;
            else
                return false;
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public boolean insertHuman(Human human, String orgname) {
        String query = "insert into humans(afm, ename, surname, email, gender, org_type, erole, org_name) values ('" + human.getAfm() + "','" + human.getName() + "','" + human.getSurname() + "','" + human.getEmail() + "','" +human.getGender()+"','" + human.getOrgType() + "','" + human.getRole() + "','" + orgname + "')";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            int i = ps.executeUpdate();
            if (i > 0)
                return true;
            else
                return false;
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    @Override
    public void updateUser(User user, int id) {

    }

    @Override
    public void deleteUser(User user, int id) {
        String query = "DELETE FROM users WHERE user_id = " + id;

        System.out.println(query);
        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            int i = ps.executeUpdate();

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
            sqlException.printStackTrace();

        }
    }

    public String findOrgname(String username) {
        String query = "select org_name from organisations where username=?";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);

            ResultSet i = ps.executeQuery();
            while ( i.next() ) {
                String org_name = i.getString("org_name");
                return org_name;
            }
        } catch (SQLException sqlException) {
//            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);

        }
        return "this will not happen";
    }


    @Override
    public Boolean readUserById(String username, String password, String user_type) {
        String query = "select * from users where username=? and user_password=? and user_type=?";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, user_type);
            ResultSet i = ps.executeQuery();
            if (i.next()) {
                return true;
            }

        } catch (SQLException sqlException) {
//            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
}
