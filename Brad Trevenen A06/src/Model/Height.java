package Model;

public class Height
{
    private int feet;
    private int inches;
    
    public Height() {
        feet = 0;
        inches = 0;
    }
    
    //constructor
    public Height (int inf_feet, int inf_inches)
    {
        feet = inf_feet;
        inches = inf_inches;
    }
    
    //convert height to inches
     public int toInches ()
    {
        
        return feet*12 + inches;
    }
     
    //return height in f'i"
     @Override
    public String toString()
    {
        if(inches < 10){
            return (feet + "\'0" + inches + "\"");
        }
        else
            return (feet + "\'" + inches + "\"");
    }
    
    //check if height is greater than argument height
    public boolean isGreaterThan(Height compHeight)
    {
        return toInches() > compHeight.toInches();
    }
    
    //see if height is equal to argument heights
    public boolean areEqual (Height A, Height B)
    {
        return toInches() == A.toInches() && toInches() == B.toInches();
    }
    
    public int getFeet()
    {
        return feet;
    }
    
    public int getInches()
    {
        return feet;
    }
    
    public void setFeet(int feet)
    {
        this.feet = feet;
    }
    
    public void setInches(int inches)
    {
        this.inches = inches;
    }
}

