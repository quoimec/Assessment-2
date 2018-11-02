
import java.util.Scanner;

public class Player {
    
    private static int count = 0;
    
    private String name;
    private int unplacedArmies;
    private int turn = 0;
    private int territories = 0;
    
    public Player() {
        
        count++;
        
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter player " + count + "'s name: ");
        name = userInput.nextLine();
        
        unplacedArmies = 3;
        
    }
    
    public String toString() {
        
        return name;
        
    }
    
    public void addArmies() {
        unplacedArmies++;
    }
    
    public void placeArmies() {
        unplacedArmies--;
    }
    
    public int getArmies() {
         return unplacedArmies;  
    }
    
    public int getSetTerritories() {
        unplacedArmies = territories;
        return territories;
    }
    
    public int getTerritories() {
        return territories;
    }
    
    public void addTerritory() {
        territories++;
    }
    
    public void removeTerritory() {
        territories--;
    }
    
    public int getTurn() {
        return turn;
    }
    
    public void endTurn() {
        turn++;
    }

}
