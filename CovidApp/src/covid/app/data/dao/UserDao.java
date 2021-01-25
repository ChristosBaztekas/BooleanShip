package covid.app.data.dao;

import covid.app.data.model.User;

import java.sql.SQLException;

public interface UserDao {

    void insertUser(User user) throws SQLException;

    Boolean readUserById(String username,String password,String user_type);
     void insertOrganisation(String userid, String orgType, String orgName, String orgLocation, int orgNumOfPeople, String orgUsername, String activity);

}
