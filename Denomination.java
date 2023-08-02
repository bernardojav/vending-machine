
/**
 * This Denomination class represent the bills to be used by the vending machine and the user.
 * @author Tiaro Molina
 * @author Bernardo Javier
 */
public class Denomination {
    private int value;// The integer value this bill has
    /**
     * Constructs a new Denomination object with the given attributes.
     * @param value  The integer value that this bill has
     */
    Denomination(int value){
        this.value = value;
    }

    /**
     * Returns the integer value of the bill.
     *
     * @return the integer value of the bill
     */
    public int getValue(){
        return value;
    }


}
