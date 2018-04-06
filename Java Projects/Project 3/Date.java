package hebenathproj3;

//Date class, which contains the methods and data for descibing a date
public class Date 
{
    //Variables
    int month, day, year;
    
    //Constructor
    Date(int newmonth, int newday, int newyear)
    {
        day = newday;
        month = newmonth;
        year = newyear;
    }
    
    //Advances date by 1
    public void advancedate()
    {
        day = day + 1;
        if(month == 2 && day > 28) //If date is in february
          {
              day = 1;
              month++;
          }
        else if((month == 4 || month == 6 || month == 9 || month == 11) && (day >  30)) //If month contains 30 days
          {			
            day = 1;
            month++;
          }
        else if ( day > 31 ) //If month contains 31
          {
            day = 1;
            month++;
          }

        if( month > 12 ) //If month is december
          {
            month = 1;
            year++;
          } 
    }
    
    //Displays month in MM/DD/YY format
    public void displaymonthNum()
    {
        System.out.println(month + "/" + day + "/" + year);
    }
    
    //Displays month in Month day, Year format
    public void displaymonthword()
    {
        String wordmonth = "";
        
        //Switch statement to determine the name of the month based on the month number
        switch (month)
        {
            case 1: wordmonth = "January";
                    break;
            case 2: wordmonth = "February";
                    break;
            case 3: wordmonth = "March";
                    break;
            case 4: wordmonth = "April";
                    break;
            case 5: wordmonth = "May";
                    break;
            case 6: wordmonth = "June";
                    break;
            case 7: wordmonth = "July";
                    break;       
            case 8: wordmonth = "August";
                    break;
            case 9: wordmonth = "September";
                    break;        
            case 10: wordmonth = "October";
                    break;
            case 11: wordmonth = "November";
                    break;
            case 12: wordmonth = "December";
                    break;
        }
        System.out.println(wordmonth + " " + day + ", " + year); //Ouputs date
    } 
}

