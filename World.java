
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
        
        String outputString = "";
        Territory eachTerritory;
        String beginingString = "";
        
        for (int x = 1; x <= 4; x++) {
        
            if (x > 1) {
                beginingString = " ";
            }
            
            switch(x) {
            
                case 1:
                eachTerritory = territory1;
                break;
                
                case 2:
                eachTerritory = territory2;
                break;
                
                case 3:
                eachTerritory = territory3;
                break;
                
                default:
                eachTerritory = territory4;
                break;
            
            }
            
            outputString += beginingString + eachTerritory.toString();
            
        }
        
        return outputString; 
        
    }
    
    public int getArmies(Player selectedPlayer) {
        return selectedPlayer.getArmies();
    }
    
    public void placeArmies(Player selectedPlayer) {
        
        messageOutput("You have " + getArmies(selectedPlayer) + " armies to place.");
        
        while (getArmies(selectedPlayer) > 0) {
        
            Territory selectedTerritory = selectTerritory();
            selectedTerritory.placeArmies(selectedPlayer);
            System.out.println(toString());
        
        }
        
    }
    
    public void transfer(Player selectedPlayer) {

        messageOutput("Select source/target territories for a transfer.");

        while (true) {

            Territory sourceTerritory = selectTerritory();

            if (sourceTerritory == null) {
                break;
            } else if (!validTransferSource(sourceTerritory, selectedPlayer)) {
                continue;
            }

            Territory destinationTerritory = selectTerritory();
            
            if (destinationTerritory.validTransferDestination(selectedPlayer)) {

                sourceTerritory.sourceTransfer();
                System.out.println(toString());

            }

        }

    }
    
    public void attack(Player selectedPlayer) {
        
        messageOutput("Select source/target territories for an attack.");
        
        Territory sourceTerritory;
        Territory destinationTerritory;
        
        while (true) {
        
            sourceTerritory = selectTerritory();
            
            if (sourceTerritory == null) {
                return;
            } else if (validTransferSource(sourceTerritory, selectedPlayer)) {
                
                while (true) {
                
                    destinationTerritory = selectTerritory();
                    
                    if (destinationTerritory == null) {
                        return;
                    } else {
                    
                        Player destinationPlayer = destinationTerritory.currentOwner();
                        
                        if (destinationPlayer == selectedPlayer) {
                            sourceTerritory = destinationTerritory;
                            continue;
                        } else if (destinationPlayer != null) {
                            
                           sourceTerritory.executeAttack();
                           destinationTerritory.executeAttack();
                           System.out.println(toString());
                            
                           if (sourceTerritory.isEmpty()) {
                               break;
                           } 
                            
                        }
                    
                    }
                
                }
                
            }
        
        }
        
    }
    
    public Boolean validTransferSource(Territory transferDestination, Player transferPlayer) {
    
        return transferDestination.currentOwner() == transferPlayer;
    
    }
    
    public Territory selectTerritory() {
    
        System.out.print("Select a territory: ");
        
        int columnIndex = keyboard.nextInt();
        
        if (columnIndex < 0) {
        
            return null;
            
        }
        
        int rowIndex = keyboard.nextInt();
        
        int calculatedIndex = rowIndex * 3 + columnIndex;
        
        switch (calculatedIndex) {
        
            case 0:
            return territory1;
            
            case 1:
            return territory2;
            
            case 3:
            return territory3;
            
            case 4:
            return territory4;
            
            default:
            return null;
        
        }
        
    }
    
    public void messageOutput(String passedMessage) {
        System.out.println(passedMessage);
        System.out.println(toString());
    }
    
    public void turn(Player selectedPlayer) {
    
        String playerName = selectedPlayer.toString();
        
        System.out.println(playerName + "'s turn.");
        int currentTurn = selectedPlayer.getTurn();
        
        if (currentTurn > 0) {
        
            int ownedTerritories = selectedPlayer.getSetTerritories();
            System.out.println("Giving " + ownedTerritories + " new armies to " + playerName);
            
        
        }
        
        placeArmies(selectedPlayer);
        
        if (0 < currentTurn) {
        
            attack(selectedPlayer);
            transfer(selectedPlayer);
        
        }
        
        selectedPlayer.endTurn();
    
    }
    
    public void mainGame() {
    
        for (int i = 1; i > 0; i++) {
        
            Player selectedPlayer;
            Player opposingPlayer;
            
            if (i % 2 == 0) {
                selectedPlayer = player2;
                opposingPlayer = player1;
            } else {
                selectedPlayer = player1;
                opposingPlayer = player2;
            }
            
            turn(selectedPlayer);
            
            if (opposingPlayer.getTerritories() == 0 && i >= 3) {
                System.out.println(selectedPlayer.toString() + " wins! ");
                break;
            }
        
        }
    
    }
    
    
    
}
