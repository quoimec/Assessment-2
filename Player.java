
import java.util.Scanner;

public class Player {
    
    private static int count = 0;
    
    private String name;
    private int unplacedArmies;
    
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
    
    public void placeArmies(int numberArmies) {
    
        unplacedArmies -= numberArmies;
        
    }

}
