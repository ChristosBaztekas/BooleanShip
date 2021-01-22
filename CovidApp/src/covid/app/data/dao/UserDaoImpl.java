package covid.app.data.dao;

import covid.app.data.model.User;
import covid.app.gui.bool.ship.mainMenu.JavaMailUtil;
import covid.app.main.app.boolship.Human;
import covid.app.manager.DBConnectionManager;

import javax.mail.MessagingException;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private final DBConnectionManager manager;

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
            return i > 0;
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    @Override
    public boolean insertOrganisation(String userid, String orgType, String orgName, String orgLocation, int orgNumOfPeople, String orgUsername, String activity) {
        String query = "insert into organisations(org_Type,org_Name,org_Location,org_Num_Of_People,username,activity) values('" + orgType + "','"
                + orgName + "','"
                + orgLocation + "','" + orgNumOfPeople + "','" + orgUsername + "','" + activity + "')";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            int i = ps.executeUpdate();
            return i > 0;
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public boolean insertHuman(Human human, String orgname) {
        String query = "insert into humans(afm, ename, surname, email, gender, org_type, erole, org_name) values ('" + human.getAfm() + "','" + human.getName() + "','" + human.getSurname() + "','" + human.getEmail() + "','" + human.getGender() + "','" + human.getOrgType() + "','" + human.getRole() + "','" + orgname + "')";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            int i = ps.executeUpdate();
            return i > 0;
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Boolean findHumanFromAfm(String afm) {
        String query = "select * from humans where afm=?";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, afm);
            ResultSet i = ps.executeQuery();
            if (i.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again because it seems like this afm does not belong to your organisation.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public void declareContacts(Human hu,String afm){
        String query = "insert into contacts(name,surname,gender,c_afm,email,afm) values ('" + hu.getName() + "','" + hu.getSurname() +"','"+ hu.getGender() +"','"+ hu.getAfm() +"','"+ hu.getEmail() +"','"+ afm+"')";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            int i = ps.executeUpdate();
            if (i > 0) {

            }

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);

        }

    }


    public void findHumanFromAfmAndOrgToDeclareCase(String afm, String orgName) {
        String query = "select ename,surname,afm,email from humans where afm=? and org_name=?";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, afm);
            ps.setString(2, orgName);

            ResultSet i = ps.executeQuery();
            if (i.next()) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to declare person with name: " + i.getString("ename") + " ,Surname: " + i.getString("surname") + ", Afm: " + i.getString("afm") + ", Email: " + i.getString("email") + " as a case?", "Person found", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    if (declareCase(afm, "Positive")) {
                        JOptionPane.showMessageDialog(null, "Case declared.We will inform him to stay home.Stay Safe and keep your organisations member safe too.", "Case declared", JOptionPane.INFORMATION_MESSAGE);
                        try {
                            JavaMailUtil.sendMail(i.getString("email"), "Covid case", "Hello unfortunately we have been informed from your organisation that you are positive on covid.Stay in quarantine for 14 and inform as immediately about your contacts.If this is a mistake call your organisation in order to cancel your declaration as a covid case.Stay safe!");
                        } catch (MessagingException e) {
                            JOptionPane.showMessageDialog(null, "Something unexpected occurred trying to contact your member via email.Please contact him in order to inform him for the regulations..", "Unexpected error ", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Something unexpected occurred.Please try again or contact us.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Something unexpected occurred.Please try again or contact us.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again because it seems like this afm does not belong to your organisation.", "Unexpected error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public boolean declareCase(String afm, String status) {
        String query = "insert into cases(afm,status) values ('" + afm + "','" + status + "')";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            int i = ps.executeUpdate();
            if (i > 0) {
                return true;
            }
            return true;
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
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

    public void sendMailToAllorganisations(String subject, String main) {
        String query = "SELECT user_email FROM users";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet i = ps.executeQuery();
            if (i.next()) {
                try {
                    JavaMailUtil.sendMail(i.getString("user_email"), subject, main);
                } catch (MessagingException e) {
                    JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public String findOrgname(String username) {
        String query = "select org_name from organisations where username=?";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);

            ResultSet i = ps.executeQuery();
            if (i.next()) {
                return i.getString("org_name");
            }
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);

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
            return false;
        }
        return false;
    }

}
