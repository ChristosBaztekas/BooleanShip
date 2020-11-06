package gr.projAboutCovid.leo.proj;

public class NursingHomes extends Organisations {
    String status_descr;
    boolean status; //true means enclosed and false free access
    public NursingHomes(String name, String area, int numberOfPeople, boolean enclosed) {
        super(name, area, numberOfPeople);
        status = enclosed;
        status_descr = (enclosed ? "Enclosed" : "Free Access");
    }
    private void monitoring() {
        
    }
}
