package covid.app.data.dao;

import covid.app.data.model.User;

import java.sql.SQLException;

public interface UserDao {

    boolean insertUser(User user) throws SQLException;
    void updateUser(User user, int id);
    void deleteUser(User user, int id);
    User readUserById(long id);
     boolean insertOrganisation(String userid,String orgType,String orgName,String orgLocation,int orgNumOfPeople,String orgUsername,String activity);

}
