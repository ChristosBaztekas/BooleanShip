package covid.app.data.model;

import java.util.ArrayList;

public final class Human {
    private static final ArrayList<Human> allHuman = new ArrayList<>();
    private String name;
    private final String surname;
    private String afm;
    private final String gender;
    private String email;
    private String orgType;
    private String role;
    private final ArrayList<Organisations> belongs = new ArrayList<>();
    private Status status = Status.NORMAL;// initialization of all people in a normal state
    private static final ArrayList<Human> waitTest = new ArrayList<>();


    public Human(String name, String surname, String afm, String email, String gender, String orgType,String role)
            throws IllegalAccessException {
        this.gender = gender;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.orgType = orgType;
        this.role = role;
        if (!isValidAfm(afm))
            throw new IllegalAccessException("Your input<" + afm + ">not valid afm");
        this.afm = afm;


    }
    public Human(String name, String surname, String afm, String email, String gender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.afm = afm;
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }
    enum Status {
        NORMAL, PRESUMPTIVE, CONFIRMED
    }


    public static boolean isValidAfm(String afm) {
        int len = afm.length();
        if (len != 9) {
            return false;
        } else {
            for (int i = 0; i < 9; i++) {
                if (!(afm.charAt(i) >= '0' && afm.charAt(i) <= '9')) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Name %s Surname %s afm %s", name, surname, afm);
    }

    public String seeStatus() {
        return status.toString();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAfm() {
        return afm;
    }



    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void haveToBeTested() {
        status = Status.PRESUMPTIVE;
        waitTest.add(this);
    }
    public void bePositive() {
        status = Status.CONFIRMED;
    }
    public void removeFromOrg(Organisations org) {
        for (int i = 0; i < belongs.size(); i++) {
            if (belongs.get(i) == org) {
                belongs.remove(i);
                break;
            }
        }
    }
    // finds if the human exists in allHuman
    // if yes, returns its position, otherwise -1
    public static int search(String idGiven) {
        int low = 0;
        int high = allHuman.size();
        int mid;
        if (high == 0) {
            return -1;
        }
        while (low < high) {
            mid = (low + high) / 2;
            if (idGiven.compareTo(allHuman.get(mid).afm) < 0)  {
                high = mid -1;
            } else if (idGiven.compareTo(allHuman.get(mid).afm) > 0) {
                low = mid +1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}

