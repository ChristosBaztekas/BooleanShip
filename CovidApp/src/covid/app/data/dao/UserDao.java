package covid.app.data.dao;

import covid.app.data.model.User;

import java.sql.SQLException;

public interface UserDao {

    boolean insertUser(User user) throws SQLException;
    void updateUser(User user, long id);
    void deleteUser(User user);
    User readUserById(long id);

}
