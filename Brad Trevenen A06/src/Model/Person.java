package Model;

public class Person {
    protected String name;
    protected Height height;
    protected int weight;
    protected String hometown;
    
    public Person()
    {
        name = "N/A";
        height = new Height (-9, -9);
        weight = -99;
        hometown = "N/A";
    }

    //constructor
    Person(String name, int feet, int inches, int weight, 
            String hometown)
    {
        this.name = name;
        this.height = new Height(feet, inches);
        this.weight = weight;
        this.hometown = hometown;
    }
    
    //methods
    @Override
    public String toString()
    {
        return name + " is " + height.toString() + " and " + weight + " lbs."
                + " He is from " + hometown;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public Height getHeight()
    {
        return height;
    }
    
    public void setHeight(Height height)
    {
        this.height = height;
    }
    
    public int getWeight()
    {
        return weight;
    }
    
    public void setWeight(int weight)
    {
        this.weight = weight;
    }
    
    public String getHometown()
    {
        return hometown;
    }
    
    public void setHometown(String hometown)
    {
        this.hometown = hometown;
    }
}
