package Model;

public class Student
{
    //---------Declaring attributes----

    private String firstName;
    private String lastName;
    private int age;
    private MailAddress address;
    private int credits;
    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return the age
     */
    public int getAge()
    {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age)
    {
        this.age = age;
    }

    /**
     * @return the address
     */
    public MailAddress getAddress()
    {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(MailAddress address)
    {
        this.address = address;
    }

    /**
     * @return the credits
     */
    public int getCredits()
    {
        return credits;
    }

    /**
     * @param credits the credits to set
     */
    public void setCredits(int credits)
    {
        this.credits = credits;
    }

    //------------------------------
    //----------Constructor------------

    public Student(String a, String b, int c, MailAddress d)
    {
        firstName = a;
        lastName = b;
        age = c;
        address = d;
        credits = creditsThisSemester();
    }

    //---------- METHODS --------
    public String getInfo()
    {
        return "NAME = " + getFirstName() + "  " + getLastName() + "  " + "Age = " + getAge() + ", address=" + getAddress().toString() + " credits=" + getCredits();
    }
    


    //------------------------------------------------
    public int creditsThisSemester()
    {
        //calculate randomly a new value for credits in the semester
        //and updates the attribute credits
        double dn = Math.random();
        setCredits((int) (15.0 * dn));
        return getCredits();
    }
}
