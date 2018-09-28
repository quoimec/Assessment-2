
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
        
        if (owner == null) {
            return "[" + column + "," + row + "]" + owner + "(" + armies + ")";
        } else {
            return "[" + column + "," + row + "]" + owner.toString() + "(" + armies + ")";
        }
        
    }
    
    public void placeArmies(Player selectedPlayer, int numberArmies) {
    
        owner = selectedPlayer;
        armies += numberArmies;
        
    }

}
