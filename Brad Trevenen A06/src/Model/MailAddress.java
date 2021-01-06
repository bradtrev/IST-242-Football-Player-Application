package Model;

public class MailAddress
{

    /**
     * @return the streetAddress
     */
    public String getStreetAddress()
    {
        return streetAddress;
    }

    /**
     * @param streetAddress the streetAddress to set
     */
    public void setStreetAddress(String streetAddress)
    {
        this.streetAddress = streetAddress;
    }

    /**
     * @return the city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState()
    {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state)
    {
        this.state = state;
    }

    /**
     * @return the zipcode
     */
    public int getZipcode()
    {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(int zipcode)
    {
        this.zipcode = zipcode;
    }

    private String streetAddress;
    private String city;
    private String state;
    private int zipcode;

    public MailAddress(String inf_streetAddress, String inf_city, String inf_state, int inf_zipcode)
    {
        streetAddress = inf_streetAddress;
        city = inf_city;
        state = inf_state;
        zipcode = inf_zipcode;
    }

    @Override
    public String toString()
    {
        return getStreetAddress() + "," + getCity() + "," + getState() + "," + getZipcode();
    }

}
