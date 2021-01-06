package Model;

import java.util.ArrayList;

public class OffensiveLine
{
    private ArrayList<FootballPlayer> footballPlayers = new ArrayList<FootballPlayer>();
    
    public OffensiveLine(FootballPlayer fp1, FootballPlayer fp2, FootballPlayer fp3)
    { 
        //footballPlayers = new ArrayList<FootballPlayer>();
        footballPlayers.add(fp1);
        footballPlayers.add(fp2);
        footballPlayers.add(fp3);
    }
    
    @Override
    public String toString()
    {
        
        return "The offensive line is comprised of: "
//                + "/n"
                + footballPlayers.get(0).getName() + ", "
//                + footballPlayers.get(0).getNumber() + " "
//                + footballPlayers.get(0).getPosition() + " "
//                + footballPlayers.get(0).getHeight() + " "
//                + footballPlayers.get(0).getWeight() + " "
//                + footballPlayers.get(0).getHometown() + " "
//                + footballPlayers.get(0).getHighSchool()
//                + "/n"
                + footballPlayers.get(1).getName() + ", and "
//                + footballPlayers.get(1).getNumber() + " "
//                + footballPlayers.get(1).getPosition() + " "
//                + footballPlayers.get(1).getHeight() + " "
//                + footballPlayers.get(1).getWeight() + " "
//                + footballPlayers.get(1).getHometown() + " "
//                + footballPlayers.get(1).getHighSchool()
//                + "/n"
                + footballPlayers.get(2).getName() + ".";
//                + footballPlayers.get(2).getNumber() + " "
//                + footballPlayers.get(2).getPosition() + " "
//                + footballPlayers.get(2).getHeight() + " "
//                + footballPlayers.get(2).getWeight() + " "
//                + footballPlayers.get(2).getHometown() + " "
//                + footballPlayers.get(2).getHighSchool();
    }
    
    public int calcAverageWeight()
    {
        int totalWeight = 0;
        int averageWeight;
        
        for (int x = 0; x < footballPlayers.size(); x++)
        {
            FootballPlayer tempPlayer = footballPlayers.get(x);
            
            totalWeight += footballPlayers.get(x).getWeight();
        }
        
        averageWeight = totalWeight / footballPlayers.size();
        //totalWeight += footballPlayers.get(x).getWeight();
        
        return averageWeight;
    }
    
    
}
