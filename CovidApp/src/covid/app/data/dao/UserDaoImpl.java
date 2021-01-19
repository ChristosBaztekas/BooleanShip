package covid.app.data.dao;

import covid.app.data.model.User;
import covid.app.manager.DBConnectionManager;

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
        String query = "insert into users(pass,email,username) values('"+user.getPassword() +"','"
                                                                      + user.getEmail() + "','"

                                                                + user.getUsername() +"')";

        System.out.println(query);
        Connection con = this.manager.getCon();
        try {
          PreparedStatement ps =  con.prepareStatement(query);
          int i = ps.executeUpdate();
          if(i > 0)
              return true;
          else
              return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }

    @Override
    public void updateUser(User user, long id) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public User readUserById(long id) {
        return null;
    }
}
