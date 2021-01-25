package covid.app.manager;



import covid.app.utils.DbConnectionUtils;

import java.sql.Connection;

public class DBConnectionManager {
    private Connection con;


    public DBConnectionManager() {

        this.con = DbConnectionUtils.initConnection();
    }

    public Connection getCon() {
        return con;
    }


    public void closeCon(){
        DbConnectionUtils.closeConnection();
    }
}
