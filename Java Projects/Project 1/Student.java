
//New Class student, the subclass of Person
public class Student extends Person
{
    //Data
    private final String name;
    private final int ID;
    private int credit;
    private double GPA, TGPE;
    
    //Constructor that uses the Person constructor
    Student(String n, int i)
    {super(n, i);
       name = n;
       ID = i;     
    }
    
    //Returns name of person
    public String getName()
    {
     return name;   
    }
    
    //Returns ID of person
    public int getID()
    {
      return ID;
    }
    
    //Sets amount of credits
    public void setCredits(int credits)
    {
        credit = credits;
    }
    
    //Returns credits
    public int getCredits()
    {
        return credit;
    }
    
    //Sets total grade points earned
    public void setGPE(double GPE)
    {
       TGPE = GPE;
    }
    
    //Returns total grade points earned
    public double getGPE()
    {
        return TGPE;
    }
    
    //Calculates gpa and returns it
    public double getGPA()
    {
        int c = getCredits();
        GPA = getGPE() / c;
        return GPA;
    }
}

