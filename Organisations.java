package gr.projAboutCovid.leo.proj;

public abstract class Organisations {
    private String name;
    private String area;
    private int id;
    private static int count = 0;
    public Organisations(String name, String area, int numbersOfPeople) {
       this.name = name;
       this.area = area;
       count++;
       this.id = count;
    }
   public int getId() {
     return id;
    }
  public String getName() {
    return name;
  }
  public void setName(String name) {
     this.name = name;
  }
  public String getArea() {
    return area;
  }
 public void setArea(String name) {
   this.name = area;
 }
 // can allhuman or one human 
  // απο εδω και κατω βλεπουμε
 public abstract void people(Human human);
  
 public abstract /*vlepoyme*/ void  managementCases();
 
}
