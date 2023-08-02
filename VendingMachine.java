import java.util.*;

/**
 * The VendingMachine class represents a Vending Machine with its features
 * @author Tiaro Molina
 * @author Bernardo Javier
 */
public class VendingMachine {

    /**
     * The list of item slots the vending machine has
     */
    private ArrayList<ItemSlot> itemSlots;
    /**
     * The list of transactions the vending machine has completed
     */
    private ArrayList<Transaction> transactionLog;
    /**
     * The list of bills that the vending machine has for available change.
     */
    private ArrayList<Denomination> availableChange;
    /**
     * The cumulative total sales of the vending machine
     */
    private int totalSales;

    /**
     * Constructs a new Vending Machine object with the given attributes.
     */
    public VendingMachine() {
        itemSlots = new ArrayList<>();
        transactionLog = new ArrayList<>();
        availableChange = new ArrayList<>();
        totalSales = 0;

        for (int i = 0; i < 5; i++) {
            availableChange.add(new Denomination(100));
            availableChange.add(new Denomination(200));
            availableChange.add(new Denomination(300));
        }


    }

    /**
     * Sets the total sales of the vending machine
     *
     * @param totalSales the new value of totalSales
     */
    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    /**
     * Returns the total sales of the vending machine
     *
     * @return the total sales of the vending machine
     */
    public int getTotalSales() {
        return totalSales;
    }

    /**
     * Returns a list of all Denomination bills in the vending machine
     *
     * @return the list of all Denomination bills
     */
    public ArrayList<Denomination> getAvailableChange() {
        return availableChange;
    }

    /**
     * Returns a list of all Transaction logs of the vending machine
     *
     * @return the list of all Transaction logs
     */
    public ArrayList<Transaction> getTransactionLog() {
        return transactionLog;
    }

    /**
     * Returns a list of all item slots in the vending machine
     *
     * @return the list of all item slots
     */
    public ArrayList<ItemSlot> getItemSlots() {
        return itemSlots;
    }

    /**
     * Prints the list of denominations in a given format
     *
     * @param denominations The list of denominations to be printed
     */
    public void printChange(List<Denomination> denominations) {
        denominations.sort(Comparator.comparingInt(Denomination::getValue));

        int currentDenominationValue = -1; // Initialize a value that won't be in the denominations
        int count = 0;

        for (Denomination denomination : denominations) {
            int denominationValue = denomination.getValue();

            if (denominationValue != currentDenominationValue) {
                if (count > 0) {
                    System.out.println("- P" + currentDenominationValue + " x " + count);
                }

                currentDenominationValue = denominationValue;
                count = 1;
            } else {
                count++;
            }
        }

        if (count > 0) {
            System.out.println("- P" + currentDenominationValue + " x " + count);
        }
    }


    /**
     * Used to replenish the available change of the vending machine.
     *
     * @param denomination the denomination to be added to the machine
     * @param quantity the quantity to be added of that specific denomination
     */
    public void addAvailableChange(int denomination, int quantity){
        for (int i = 0; i < quantity; i++) {
            availableChange.add(new Denomination(denomination));
        }
    }

    /**
     * Used to clear the available change of the vending machine.
     *
     */
    public void clearAvailableChange() {
        System.out.println("Bills to be collected:");
        printChange(availableChange);
        availableChange.clear();
    }



    /**
     * Adds an existing item slot to the vending machine.
     *
     * @param itemSlot the item slot object to be added
     */
    public void addItemSlot(ItemSlot itemSlot) {
        itemSlots.add(itemSlot);
    }

    /**
     * Displays the item slots and the item they contain.
     */
    public void displayItemSlots() {
        System.out.println("Available items:");
        for (int i = 0; i < itemSlots.size(); i++) {
            ItemSlot itemSlot = itemSlots.get(i);
            Item item = itemSlot.getItem();
            int number = i + 1;
            System.out.println(number + ". " + item.getName() + " (" + item.getCalories() + " calories) - P" + item.getPrice() + " - Quantity: " + itemSlot.getQuantity());
        }
    }

    /**
     * Returns the item slot depending on the input of the user. This indicates the item the user wants to buy.
     *
     * @param number The number associated with the item the user wants to buy
     *
     * @return the item slot containing the item
     */
    public ItemSlot getItemSlotByNumber(int number) {
        int index = number - 1;
        if (index >= 0 && index < itemSlots.size()) {
            return itemSlots.get(index);
        }
        return null;
    }

    /**
     * Accepts payment if payment is in increments of 100 up to only 1000 and if the payment given is greater than the price of the item being bought.
     *
     * @param payment The bill/denomination amount the customer paid
     * @param itemPrice The price of the item the customer is buying
     */
    public int acceptPayment(List<Denomination> payment, int itemPrice) {
        int totalPaymentValue = 0;

        for (Denomination amount : payment) {
            totalPaymentValue += amount.getValue();
        }

        int totalChange = totalPaymentValue - itemPrice;

        if (totalPaymentValue >= itemPrice) {
            // Check if the payment denominations are valid (increments of 100)
            boolean validPayment = true;
            for (Denomination amount : payment) {
                int paymentValue = amount.getValue();
                if (paymentValue < 100 || paymentValue % 100 != 0) {
                    validPayment = false;
                    break;
                }
            }

            if (validPayment) {
                List<Denomination> changeDenominations = findChangeDenominations(totalChange);
                if (changeDenominations != null) {
                    availableChange.addAll(payment);
                } else {
                    System.out.println("Insufficient change available in the machine to provide proper change. Please try again later.");
                    totalPaymentValue = 0; // Set to 0 to indicate insufficient change
                }
            } else {
                System.out.println("Invalid payment denominations. Please provide payment in increments of 100 up to 1000.");
                totalPaymentValue = 0; // Set to 0 to indicate invalid payment
            }
        } else {
            System.out.println("Payment is short. Please provide an amount greater than or equal to P" + itemPrice);
            totalPaymentValue = 0; // Set to 0 to indicate insufficient payment
        }

        return totalPaymentValue;
    }



    /**
     * Prints out all transactions made by the vending machine.
     */
    public void printTransactionList() {
        System.out.println("Transaction summary:");
        for (Transaction transaction : transactionLog) {
            Item item = transaction.getItem();
            System.out.println("- " + item.getName() + " - Amount Paid: P" + transaction.getAmountPaid() + " - Change Given: P" + transaction.getChangeGiven());
        }
        System.out.println("Total Sales: P" + totalSales);
    }

    /**
     * Restocks the item set in the item slot.
     *
     * @param item The item to be restocked
     * @param quantity The amount of that item to be restocked in the item slot
     */
    public void restockItem(Item item, int quantity) {
        ItemSlot itemSlot = findItemSlot(item);
        if (itemSlot != null) {
            itemSlot.setQuantity(itemSlot.getQuantity() + quantity);
            System.out.println("Item restocked: " + item.getName() + " - Quantity: " + itemSlot.getQuantity());
        } else {
            System.out.println("Item slot not found.");
        }
    }

    /**
     * Sets a new price for an item.
     *
     * @param item The item whose price is to be set
     * @param price The new price of the item
     */
    public void setItemPrice(Item item, int price) {
        ItemSlot itemSlot = findItemSlot(item);
        if (itemSlot != null) {
            item.setPrice(price);
            System.out.println("Item price set: " + item.getName() + " - Price: P" + item.getPrice());
        } else {
            System.out.println("Item slot not found.");
        }
    }

    /**
     * Dispenses the item bought and gives back change to the customer(if any).
     *
     * @param item the item to be dispensed by the vending machine
     * @param amountPaid the amount paid by the user
     */
    public void dispenseItem(Item item, int amountPaid) {
        ItemSlot itemSlot = findItemSlot(item);
        if (itemSlot != null) {
            int itemPrice = item.getPrice();
            int quantity = itemSlot.getQuantity();

            if (quantity > 0 && amountPaid >= itemPrice) {

                int change = amountPaid - itemPrice;
                if (change > 0) {

                    List<Denomination> changeDenominations = findChangeDenominations(change);

                    if (changeDenominations != null) {

                        itemSlot.setQuantity(quantity - 1);
                        totalSales += itemPrice;
                        availableChange.removeAll(changeDenominations);

                        Transaction transaction = new Transaction(item, amountPaid, change);
                        transactionLog.add(transaction);

                        System.out.println("Item dispensed: " + item.getName());
                        System.out.println("Change given: P" + change);
                        System.out.println("Change denominations:");
                        printChange(changeDenominations);
                    } else {
                        System.out.println("Insufficient change available in the machine. Please try again later.");
                    }
                } else {

                    itemSlot.setQuantity(quantity - 1);
                    totalSales += itemPrice;

                    Transaction transaction = new Transaction(item, amountPaid, 0);
                    transactionLog.add(transaction);

                    System.out.println("Item dispensed: " + item.getName());
                }
            } else {
                System.out.println("Item out of stock or insufficient amount paid.");
            }
        } else {
            System.out.println("Item slot not found.");
        }
    }

    /**
     * Returns the available bills/change the vending machine has.
     *
     * @return the available bills/change the vending machine has
     */
    public List<Denomination> getSortedChange() {
        List<Denomination> sortedChange = new ArrayList<>(availableChange);
        sortedChange.sort(Comparator.comparingInt(Denomination::getValue).reversed());

        return sortedChange;
    }

    /**
     * Determines the bills needed to be returned by the machine based on the change needed by the customer.
     *
     * @param change The change needed to be given to the customer
     *
     * @return the list of bills/Denomination to be removed from the machine and given to the customer
     */
    protected List<Denomination> findChangeDenominations(int change) {
        List<Denomination> changeDenominations = new ArrayList<>();
        List<Denomination> availableDenominations = new ArrayList<>(availableChange);

        availableDenominations.sort(Comparator.comparingInt(Denomination::getValue).reversed());

        for (Denomination denomination : availableDenominations) {
            int denominationValue = denomination.getValue();

            while (change >= denominationValue && availableChange.contains(denomination)) {
                changeDenominations.add(denomination);
                change -= denominationValue;
                availableChange.remove(denomination);
            }

            if (change == 0) {
                availableChange.addAll(changeDenominations);
                return changeDenominations;
            }
        }


        availableChange.addAll(changeDenominations);
        return null;
    }

    /**
     * Returns the item slot that contains the item.
     *
     * @param item The item whose item slot is being looked for
     *
     * @return the item slot of the item
     */
    protected ItemSlot findItemSlot(Item item) {
        for (ItemSlot itemSlot : itemSlots) {
            if (itemSlot.getItem().equals(item)) {
                return itemSlot;
            }
        }
        return null;
    }
}
