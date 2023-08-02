import java.util.*;

/**
 * The SpecialVendingMachine class represents a Vending Machine with its features
 * @author Tiaro Molina
 * @author Bernardo Javier
 */
public class SpecialVendingMachine extends VendingMachine {

    /**
     * Constructor to initialize the Special Vending Machine with pre-defined items and quantities.
     * Calls the constructor of the parent class to initialize attributes.
     */
    public SpecialVendingMachine() {
        super();

        // Add the individual items that can be sold in the Special Vending Machine
        addItemSlot(new ItemSlot(new Item("Hotdog", 150, 200), 5));
        addItemSlot(new ItemSlot(new Item("Tapa", 150, 200), 5));
        addItemSlot(new ItemSlot(new Item("Corned Beef", 150, 200), 5));
        addItemSlot(new ItemSlot(new Item("Tocino", 150, 200), 5));
        addItemSlot(new ItemSlot(new Item("Fried Rice", 50, 100), 5));
        addItemSlot(new ItemSlot(new Item("Egg", 10, 100), 5));
        addItemSlot(new ItemSlot(new Item("Coke", 100, 200), 5));
        addItemSlot(new ItemSlot(new Item("Sprite", 100, 200), 5));
    }

    /**
     * Retrieves a list of ulam available for the Special Silog Meal.
     *
     * @return A list of ulam for the Special Silog Meal.
     */
    private List<Item> getCustomizableItems() {
        List<Item> customizableItems = new ArrayList<>();
        customizableItems.add(new Item("Hotdog", 150, 200));
        customizableItems.add(new Item("Tapa", 150, 200));
        customizableItems.add(new Item("Corned Beef", 150, 200));
        customizableItems.add(new Item("Tocino", 150, 200));
        return customizableItems;
    }

    /**
     * Calculates the total calories of the selected items for the Special Silog Meal.
     *
     * @param items The list of items for which to calculate the total calories.
     * @return The total calories of the items.
     */
    private int calculateTotalCalories(List<Item> items) {
        int totalCalories = 0;
        for (Item item : items) {
            totalCalories += item.getCalories();
        }
        return totalCalories;
    }

    /**
     * Calculates the total price of the selected items for the Special Silog Meal.
     *
     * @param items The list of items for which to calculate the total price.
     * @return The total price of the items.
     */
    private int calculateTotalPrice(List<Item> items) {
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    /**
     * Finds the ItemSlot in the vending machine that contains the item with the given name.
     *
     * @param itemName The name of the item to search for in the item slots.
     * @return The ItemSlot containing the item, or null if not found.
     */
    protected ItemSlot findItemSlotByName(String itemName) {
        List<ItemSlot> itemSlots = getItemSlots();
        for (ItemSlot itemSlot : itemSlots) {
            if (itemSlot.getItem().getName().equals(itemName)) {
                return itemSlot;
            }
        }
        return null;
    }


    /**
     * Allows the user to customize a Special Silog Meal by letting them choose from different options.
     *
     * @return The customized item representing the Special Silog Meal, or null if the transaction failed.
     */
    public Item customizeProduct() {
        Scanner scanner = new Scanner(System.in);
        List<Item> availableItems = getCustomizableItems();
        List<Item> selectedItems = new ArrayList<>();

        System.out.println("Welcome to the Special Silog Meal customization!");
        System.out.println("Please take a look at our Secret Menu!");
        System.out.println("Available Ulam:");
        int ulamNumber = 1;
        for (Item item : availableItems) {
            System.out.println(ulamNumber + ". " + item.getName() + " (" + item.getCalories() + " calories) - P" + item.getPrice());
            ulamNumber++;
        }

        System.out.println("Choose your Ulam (Enter the number of your choice):");
        int ulamChoice = scanner.nextInt();
        scanner.nextLine();

        int itemIndex = ulamChoice - 1;
        if (itemIndex >= 0 && itemIndex < availableItems.size()) {
            selectedItems.add(availableItems.get(itemIndex));
            System.out.println("Fried and Added " + availableItems.get(itemIndex).getName() + " to your Special Silog.");
        } else {
            System.out.println("Invalid choice. Please try again.");
        }

        // Add rice to selectedItems
        selectedItems.add(new Item("Fried Rice", 50, 100));
        System.out.println("Fried and Added Fried Rice to your Special Silog.");

        // Add egg to selectedItems
        selectedItems.add(new Item("Egg", 10, 100));
        System.out.println("Fried and Added Egg to your Special Silog.");

        System.out.println("Do you want a drink? (1. Yes, 2. No):");
        int drinkChoice = scanner.nextInt();
        scanner.nextLine();

        if (drinkChoice == 1) {
            System.out.println("Choose your drink (1. Coke, 2. Sprite):");
            int drinkSelection = scanner.nextInt();
            scanner.nextLine();

            if (drinkSelection == 1) {
                selectedItems.add(new Item("Coke", 100, 200));
                System.out.println("Poured and Added Coke to your meal.");
            } else if (drinkSelection == 2) {
                selectedItems.add(new Item("Sprite", 100, 200));
                System.out.println("Poured and Added Sprite to your meal.");
            } else {
                System.out.println("Invalid choice. No drink added.");
            }
        } else if (drinkChoice != 2) {
            System.out.println("No drink added.");
        }

        // Choose condiments if desired
        System.out.println("Do you want any condiments? (1. Yes, 2. No):");
        int condimentsChoice = scanner.nextInt();
        scanner.nextLine();


        // Remove on of each of the selected items in the vending machine since used in the Special Silog
        boolean transactionSuccessful = true;
        for (Item selectedItem : selectedItems) {
            ItemSlot itemSlot = findItemSlotByName(selectedItem.getName());
            if (itemSlot != null && itemSlot.getQuantity() > 0) {
                itemSlot.setQuantity(itemSlot.getQuantity() - 1);
            } else {
                // Item is out of stock or quantity is 0, cancel the transaction
                transactionSuccessful = false;
                break;
            }
        }

        // If transaction unsuccessful, cancel transaction and revert back the quantity of selected items
        if (!transactionSuccessful) {
            System.out.println("One or more items are out of stock. Transaction canceled.");
            for (Item selectedItem : selectedItems) {
                ItemSlot itemSlot = findItemSlotByName(selectedItem.getName());
                if (itemSlot != null) {
                    itemSlot.setQuantity(itemSlot.getQuantity() + 1);
                }
            }
            return null;
        }

        if (condimentsChoice == 1) {
            System.out.println("Choose your condiment (1. Ketchup, 2. Fried Garlic, 3. Vinegar):");
            int condimentChoice = scanner.nextInt();
            scanner.nextLine();

            if (condimentChoice == 1) {
                selectedItems.add(new Item("Ketchup", 10, 0));
                System.out.println("Added Ketchup to your Special Silog.");
            } else if (condimentChoice == 2) {
                selectedItems.add(new Item("Fried Garlic", 10, 0));
                System.out.println("Added Fried Garlic to your Special Silog.");
            } else if (condimentChoice == 3) {
                selectedItems.add(new Item("Vinegar", 10, 0));
                System.out.println("Added Vinegar to your Special Silog.");
            } else {
                System.out.println("Invalid choice. No condiments added.");
            }
        }

        return new Item("Customized Special Silog", calculateTotalCalories(selectedItems), calculateTotalPrice(selectedItems));
    }

    /**
     * Dispenses an item based on the user's selection and handles the change.
     *
     * @param item      The item to be dispensed.
     * @param amountPaid The amount of money paid by the user.
     */
    @Override
    public void dispenseItem(Item item, int amountPaid) {
        if (item.getName().equals("Customized Special Silog")) {

            int itemPrice = item.getPrice();

            if (amountPaid >= itemPrice) {
                int change = amountPaid - itemPrice;
                if (change > 0) {

                    List<Denomination> changeDenominations = findChangeDenominations(change);
                    if (changeDenominations != null) {
                        setTotalSales(getTotalSales() + itemPrice);
                        getAvailableChange().removeAll(changeDenominations);

                        Transaction transaction = new Transaction(item, amountPaid, change);
                        getTransactionLog().add(transaction);

                        System.out.println("Dispensing Customized Special Silog...");
                        System.out.println("Thank you for your purchase!");
                        System.out.println("Change given: P" + change);
                        System.out.println("Change denominations:");
                        printChange(changeDenominations);
                    } else {
                        System.out.println("Insufficient change available in the machine. Please try again later.");
                    }
                } else {
                    setTotalSales(getTotalSales() + itemPrice);

                    Transaction transaction = new Transaction(item, amountPaid, change);
                    getTransactionLog().add(transaction);
                    System.out.println("Dispensing Customized Special Silog...");
                    System.out.println("Thank you for your purchase!");
                    System.out.println("Change given: P0");
                }
            } else {
                System.out.println("Insufficient amount paid.");
            }
        } else {
            // Handle regular items here as before
            ItemSlot itemSlot = findItemSlot(item);
            if (itemSlot != null) {
                super.dispenseItem(item, amountPaid);
            } else {
                System.out.println("Item slot not found.");
            }
        }
    }

    /**
     * Displays the item slots along with their items.
     */
    @Override
    public void displayItemSlots() {
        List<ItemSlot> itemSlots = getItemSlots();
        System.out.println("Available Items:");
        for (int i = 0; i < itemSlots.size(); i++) {
            ItemSlot itemSlot = itemSlots.get(i);
            Item item = itemSlot.getItem();
            System.out.println((i + 1) + ". " + item.getName() + " - Price: " + item.getPrice() + " - Quantity: " + itemSlot.getQuantity());
        }
        System.out.println("9. Create Customized Silog Order");
    }

}
