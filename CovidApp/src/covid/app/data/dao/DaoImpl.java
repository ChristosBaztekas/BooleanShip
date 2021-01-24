package covid.app.data.dao;

import covid.app.data.model.User;
import covid.app.gui.bool.ship.mainMenu.GuiClass;
import covid.app.gui.bool.ship.mainMenu.JavaMailUtil;
import covid.app.data.model.Human;
import covid.app.manager.DBConnectionManager;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class DaoImpl implements UserDao {

    private final DBConnectionManager manager;

    public DaoImpl(DBConnectionManager manager) {
        this.manager = manager;
    }
    private final JTextArea allOrgs = new JTextArea(20, 40);

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

    public String createAuthCode(String regEmail,Boolean condition) {
        String sixDigits = GuiClass.getRandomNumberString();
        String query = "insert into auth(mail, sixdigits, active) values('"+regEmail+"','"+sixDigits+"','"+condition+ "')";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            int i = ps.executeUpdate();
            return sixDigits;
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
            return "";
        }

    }
    public boolean usernameExists(String username) {

        String query = "SELECT username FROM organisations WHERE username =?";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ResultSet i = ps.executeQuery();
            while (i.next()) {
                return true;
            }

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again because it seems like this afm does not belong to your organisation.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
    public boolean emailExists(String email) {

        String query = "SELECT * FROM organisations o inner join users u on o.username = u.username WHERE u.user_email =?";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet i = ps.executeQuery();
            while (i.next()) {
                return true;
            }

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again because it seems like this afm does not belong to your organisation.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }
    public boolean disactivateAuthCode(String regEmail,Boolean condition) {
        String query = "UPDATE auth SET active =?WHERE mail =?";

        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(2, regEmail);
            ps.setBoolean(1, condition);
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
            return i.next();

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
    public void sendMailToAllMembersofYourOrg(String subject, String mainSub,String orgName) {
        String query = "SELECT h.email as email From organisations o inner join humans h on o.org_name = h.org_name WHERE h.org_name =?";
        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, orgName);
            ResultSet i = ps.executeQuery();
            if (i.next()) {
                try {
                    JavaMailUtil.sendMail(i.getString("email"), subject, mainSub);
                } catch (MessagingException e) {
                    JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);

        }
    }
    public int countCases(String orgName) {
        String query = "Select * from cases c inner join humans h on h.afm = c.afm inner join organisations o on o.org_name = h.org_name WHERE h.org_name =?";
        Connection con = this.manager.getCon();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, orgName);
            ResultSet i = ps.executeQuery();
            int count = 0;
            while(i.next()){
                count++;
            }
            return count;
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);

        }
        return 0;
    }
    public void getAllcases() {
        String query = " SELECT h.afm as afm,h.org_name as org_name,h.org_type as org_type  from cases ca inner join humans h on h.afm = ca.afm ";
        Connection con = this.manager.getCon();
        allOrgs.setText("List of Cases\n");
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet i = ps.executeQuery();
            int count = 0;
            while(i.next()){
                ++count;
                String info = count +")Afm:" + i.getString("afm") + " and Organisation name:" + i.getString("org_name")+" and Organisation Type:" + i.getString("org_type")+"\n";
                allOrgs.append(info);

            }
            allOrgs.setFont(new Font("Arial", Font.BOLD, 14));
            allOrgs.setEditable(false);
            allOrgs.setBackground(Color.CYAN);
            JOptionPane.showMessageDialog(null,allOrgs,"All Cases", JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);

        }

    }
    public void getAllcontacts() {
        String query = "SELECT h.afm as afm,ca.email as email  from contacts ca inner join humans h on h.afm = ca.afm ";
        Connection con = this.manager.getCon();
        allOrgs.setText("List of Contacts\n");
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet i = ps.executeQuery();
            int count = 0;
            while(i.next()){
                ++count;
                String info = count +")Afm:" + i.getString("afm") + " and Contact's email:" + i.getString("email")+"\n";
                allOrgs.append(info);

            }
            allOrgs.setFont(new Font("Arial", Font.BOLD, 14));
            allOrgs.setEditable(false);
            allOrgs.setBackground(Color.CYAN);
            JOptionPane.showMessageDialog(null,allOrgs,"All Cases", JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);

        }

    }
    public void getAllOrgs() {
        String query = "SELECT org_name,org_type FROM organisations WHERE org_name <> 'Eody'";
        Connection con = this.manager.getCon();
        allOrgs.setText("List of Organisations\n");
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet i = ps.executeQuery();
            int count = 0;
            while(i.next()){
                ++count;
             String info = count +") Organisation name: " + i.getString("org_name") + " and Organisation Type: " + i.getString("org_type")+"\n";
                allOrgs.append(info);

            }
            allOrgs.setFont(new Font("Arial", Font.BOLD, 14));
            allOrgs.setEditable(false);
            allOrgs.setBackground(Color.CYAN);
            JOptionPane.showMessageDialog(null,allOrgs,"All organisations", JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);

        }

    }
    public int countMembers(String orgName) {
        String query = "SELECT *  from organisations o inner join humans h on h.org_name = o.org_name Where o.org_name =?";
        Connection con = this.manager.getCon();

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, orgName);
            ResultSet i = ps.executeQuery();
            int count = 0;
           while(i.next()){
               count++;
           }
            return count;
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);

        }
        return 123;
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
