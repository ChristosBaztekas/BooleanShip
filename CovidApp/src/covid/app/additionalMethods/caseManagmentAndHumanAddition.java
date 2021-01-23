package covid.app.additionalMethods;


import covid.app.data.model.Human;

public interface caseManagmentAndHumanAddition {

    static void createOrg() {}
     void declareCase(Human human);
     void declareCase();
     void printDetails();
     void monitoring();
     void autoMonitoring();
}

