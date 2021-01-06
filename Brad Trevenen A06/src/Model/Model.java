package Model;

import java.util.ArrayList;

public class Model
{
    private FootballPlayerData fpData;

    public Model(){   
        this.fpData = new FootballPlayerData();
        System.out.println(" ");
    }
        
    public FootballPlayerData getFpData() {
        return fpData;
    }

    public void setFpData(FootballPlayerData fpData) {
        this.fpData = fpData;
    }

}
