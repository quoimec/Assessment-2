
/**
 * Write a description of class Territory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Territory {
    
    private int row;
    private int column;
    private int armies;
    private Player owner;
    
    public Territory(int passedColumn, int passedRow) {
       row = passedRow;
       column = passedColumn;
       armies = 0;
    }
    
    public String toString() {
        
        String ownerName;
        
        if (owner == null) {
            ownerName = "null";
        } else {
            ownerName = owner.toString();
        }
        
        return "[" + column + "," + row + "]" + ownerName + "(" + armies + ")";
        
    }
    
    public void placeArmies(Player selectedPlayer) {
    
        if (owner == null) {
            owner = selectedPlayer;
            selectedPlayer.addTerritory();
        } 
        
        if (owner == selectedPlayer) {
            selectedPlayer.placeArmies();
            armies++;
        }
        
    }
    
    public Player currentOwner() {
        return owner;
    }
   
    public Boolean validTransferDestination(Player selectedPlayer) {

        if (owner == null) {
            owner = selectedPlayer;
        } else if (owner != selectedPlayer) {
            return false;
        }
        
        armies++;
        return true;
        
    }
    
    public void executeAttack() {
    
        if (armies == 1) {
            owner.removeTerritory(); 
        }
            
        sourceTransfer();
    
    }
    
    public void sourceTransfer() {

        armies--;

        if (armies == 0) {
            owner = null;
        }

    }
    
    public Boolean isEmpty() {
        return owner == null;
    }

    
    
}
