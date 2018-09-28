
import java.util.Scanner;

public class World {
    
    private Territory territory1;
    private Territory territory2;
    private Territory territory3;
    private Territory territory4;
    
    private Player player1;
    private Player player2;
    
    public static final Scanner keyboard = new Scanner(System.in);
    
    public World() {
        
        player1 = new Player();
        player2 = new Player();
        
        territory1 = new Territory(0, 0);
        territory2 = new Territory(1, 0);
        territory3 = new Territory(0, 1);
        territory4 = new Territory(1, 1);
        
    }
    
    public String toString() {
    
        return territory1.toString() + " " + territory2.toString() + " " + territory3.toString() + " " + territory4.toString(); 
        
    }
    
    public void placeArmies(Player selectedPlayer, Territory selectedTerritory) {
        
        System.out.print("How many armies would you like to place on " + selectedTerritory.toString() + "? ");
        int numberArmies = keyboard.nextInt();
        
        selectedTerritory.placeArmies(selectedPlayer, numberArmies);
        selectedPlayer.placeArmies(numberArmies);
        
        System.out.println(toString());
        
    }
    
    public void mainSetup() {
    
        System.out.println(player1.toString() + ", please place your armies");
        System.out.println(toString());
        placeArmies(player1, territory1);
        placeArmies(player1, territory2);
        
        System.out.println(player2.toString() + ", please place your armies");
        System.out.println(toString());
        placeArmies(player2, territory3);
        placeArmies(player2, territory4);
    
    }

    
}
