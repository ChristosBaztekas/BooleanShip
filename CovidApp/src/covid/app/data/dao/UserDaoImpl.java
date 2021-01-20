package covid.app.data.dao;

import covid.app.data.model.User;
import covid.app.manager.DBConnectionManager;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{

    private DBConnectionManager manager;

    public UserDaoImpl(DBConnectionManager manager) {
        this.manager = manager;
    }


    @Override
    public boolean insertUser(User user)  {
        String query = "insert into users(user_Type,username,user_password,user_email) values('"+user.getUserType() +"','"
                                                                      + user.getUsername()+ "','"
                                                                + user.getPassword()+"','"+user.getEmail() +"')";

        Connection con = this.manager.getCon();
        try {
          PreparedStatement ps =  con.prepareStatement(query);
          int i = ps.executeUpdate();
          if(i > 0)
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
    public boolean insertOrganisation(String userid,String orgType,String orgName,String orgLocation,int orgNumOfPeople,String orgUsername,String activity)  {
        String query = "insert into organisations(org_Type,org_Name,org_Location,org_Num_Of_People,username,activity) values('"+orgType+"','"
                +orgName+ "','"
                +orgLocation+"','"+orgNumOfPeople+"','"+orgUsername+"','"+activity +"')";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps =  con.prepareStatement(query);
            int i = ps.executeUpdate();
            if(i > 0)
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
    public void deleteUser(User user,int id) {
        String query = "DELETE FROM users WHERE user_id = "+id;

        System.out.println(query);
        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps =  con.prepareStatement(query);
            int i = ps.executeUpdate();

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
            sqlException.printStackTrace();

        }
    }

    @Override
    public User readUserById(long id) {


        return null;
    }
}
