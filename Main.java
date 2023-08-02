import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        VendingMachine vendingMachine = null;

        while (true) {
            System.out.println("Vending Machine Factory Menu:");
            System.out.println("1. Create a Vending Machine");
            System.out.println("2. Test a Vending Machine");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Select Vending Machine Class:");
                System.out.println("1. Regular Vending Machine");
                System.out.println("2. Special Vending Machine");
                System.out.print("Enter your choice: ");
                int machineChoice = scanner.nextInt();
                scanner.nextLine();

                if (machineChoice == 1) {
                    vendingMachine = createRegularVendingMachine();
                    System.out.println("Regular Vending Machine created.");
                } else if (machineChoice == 2) {
                    vendingMachine = createSpecialVendingMachine(); // Create the Special Vending Machine
                    System.out.println("Special Vending Machine created.");
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } else if (choice == 2) {
                if (vendingMachine == null) {
                    System.out.println("No Vending Machine created yet. Please create one first before testing.");
                    continue;
                }

                while (true) {
                    System.out.println("Test a Vending Machine:");
                    System.out.println("1. Vending Features");
                    System.out.println("2. Maintenance Features");
                    System.out.println("3. End Vending Features Test");
                    System.out.print("Enter your choice: ");
                    int testChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (testChoice == 1) {
                        testVendingFeatures(vendingMachine, scanner);
                    } else if (testChoice == 2) {
                        testMaintenanceFeatures(vendingMachine, scanner);
                    } else if (testChoice == 3) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                }
            } else if (choice == 3) {
                System.out.println("Exiting code...");
                System.out.println("Destroying all vending machines(if any)...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static VendingMachine createSpecialVendingMachine() {
        return new SpecialVendingMachine();
    }

    private static VendingMachine createVendingMachine() {
        Scanner scanner = new Scanner(System.in);
        VendingMachine vendingMachine = new VendingMachine();

        int numItemSlots;
        do {
            System.out.print("Enter the number of item slots in the vending machine (minimum 8): ");
            numItemSlots = scanner.nextInt();
            scanner.nextLine();

            if (numItemSlots < 8) {
                System.out.println("Number of item slots must be at least 8. Please try again.");
            }
        } while (numItemSlots < 8);

        for (int i = 0; i < numItemSlots; i++) {
            System.out.println("Enter details for Item Slot " + (i + 1) + ":");
            System.out.print("Enter item name: ");
            String itemName = scanner.nextLine();

            System.out.print("Enter item calories: ");
            int itemCalories = scanner.nextInt();
            scanner.nextLine();

            int itemPrice;
            do {
                System.out.print("Enter item price (a multiple of 100, not more than 1000): ");
                itemPrice = scanner.nextInt();
                scanner.nextLine();

                if (itemPrice < 100 ||  itemPrice % 100 != 0) {
                    System.out.println("Item price must be a multiple of 100 and not more than 1000. Please try again.");
                }
            } while (itemPrice < 100 || itemPrice % 100 != 0);

            System.out.print("Enter item quantity: ");
            int itemQuantity = scanner.nextInt();
            scanner.nextLine();

            ItemSlot itemSlot = new ItemSlot(new Item(itemName, itemCalories, itemPrice), itemQuantity);
            vendingMachine.addItemSlot(itemSlot);
        }

        return vendingMachine;
    }

    // for demo checking only
    private static VendingMachine createRegularVendingMachine() {
        VendingMachine vendingMachine = new VendingMachine();

        ItemSlot itemSlot1 = new ItemSlot(new Item("Tocino", 150, 300), 5);
        ItemSlot itemSlot2 = new ItemSlot(new Item("Tapa", 150, 300), 5);
        ItemSlot itemSlot3 = new ItemSlot(new Item("Hotdog", 150, 200), 5);
        ItemSlot itemSlot4 = new ItemSlot(new Item("Corned Beef", 150, 200), 5);
        ItemSlot itemSlot5 = new ItemSlot(new Item("Fried Rice", 50, 100), 5);
        ItemSlot itemSlot6 = new ItemSlot(new Item("Egg", 10, 100), 5);
        ItemSlot itemSlot7 = new ItemSlot(new Item("Coke", 100, 200), 5);
        ItemSlot itemSlot8 = new ItemSlot(new Item("Sprite", 100, 200), 5);

        vendingMachine.addItemSlot(itemSlot1);
        vendingMachine.addItemSlot(itemSlot2);
        vendingMachine.addItemSlot(itemSlot3);
        vendingMachine.addItemSlot(itemSlot4);
        vendingMachine.addItemSlot(itemSlot5);
        vendingMachine.addItemSlot(itemSlot6);
        vendingMachine.addItemSlot(itemSlot7);
        vendingMachine.addItemSlot(itemSlot8);

        return vendingMachine;
    }

    private static void testVendingFeatures(VendingMachine vendingMachine, Scanner scanner) {
        vendingMachine.displayItemSlots();
        System.out.println("0. To cancel transaction");
        System.out.print("Enter the number of the item you want to purchase: ");
        int itemNumber = scanner.nextInt();
        scanner.nextLine();

        if (itemNumber == 0) {
            System.out.println("Transaction canceled.");
            return;
        }

        if (itemNumber == 9 && vendingMachine instanceof SpecialVendingMachine) {
            // SpecialVendingMachine allows customization of Silog
            SpecialVendingMachine specialVendingMachine = (SpecialVendingMachine) vendingMachine;
            Item customizedSilog = specialVendingMachine.customizeProduct();
            if (customizedSilog != null) {
                System.out.println("Special Silog Created:");
                System.out.println("- Name: " + customizedSilog.getName());
                System.out.println("- Calories: " + customizedSilog.getCalories());
                System.out.println("- Price: " + customizedSilog.getPrice());

                System.out.print("Enter the number of payment denominations: ");
                int numDenominations = scanner.nextInt();
                scanner.nextLine();

                List<Denomination> payment = new ArrayList<>();
                for (int i = 0; i < numDenominations; i++) {
                    System.out.print("Enter denomination " + (i + 1) + ": ");
                    int denominationValue = scanner.nextInt();
                    scanner.nextLine();
                    payment.add(new Denomination(denominationValue));
                }

                // Check if the payment is sufficient
                int totalPaymentValue = vendingMachine.acceptPayment(payment, customizedSilog.getPrice());
                if (totalPaymentValue >= customizedSilog.getPrice()) {
                    vendingMachine.dispenseItem(customizedSilog, totalPaymentValue);
                    System.out.println("Payment successful. Dispensing your customized Special Silog...");

                } else {
                    System.out.println("Payment failed. Cannot dispense your customized Special Silog.");
                }
            } else {
                System.out.println("Customization failed.");
            }
        } else {
            ItemSlot itemSlot = vendingMachine.getItemSlotByNumber(itemNumber);
            if (itemSlot != null) {
                System.out.print("Enter the number of payment denominations: ");
                int numDenominations = scanner.nextInt();
                scanner.nextLine();

                List<Denomination> payment = new ArrayList<>();
                for (int i = 0; i < numDenominations; i++) {
                    System.out.print("Enter denomination " + (i + 1) + ": ");
                    int denominationValue = scanner.nextInt();
                    scanner.nextLine();
                    payment.add(new Denomination(denominationValue));
                }

                Item itemToPurchase = itemSlot.getItem();
                int totalPaymentValue = vendingMachine.acceptPayment(payment, itemToPurchase.getPrice());
                if (totalPaymentValue > 0) {
                    vendingMachine.dispenseItem(itemToPurchase, totalPaymentValue);
                } else {
                    System.out.println("Transaction failed.");
                }
            } else {
                System.out.println("Item not found.");
            }
        }
    }



    private static void testMaintenanceFeatures(VendingMachine vendingMachine, Scanner scanner) {
        while (true) {
            System.out.println("Maintenance Features:");
            System.out.println("1. Restock an item");
            System.out.println("2. Set item price");
            System.out.println("3. Collect available change");
            System.out.println("4. Replenish money denominations");
            System.out.println("5. Print transaction summary");
            System.out.println("6. Exit Maintenance Features Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    vendingMachine.displayItemSlots();

                    System.out.print("Enter the number of the item to restock: ");
                    int itemNumber = scanner.nextInt();
                    scanner.nextLine();

                    ItemSlot itemSlot = vendingMachine.getItemSlotByNumber(itemNumber);
                    if (itemSlot != null) {
                        System.out.print("Enter the quantity to restock: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();

                        Item itemToRestock = itemSlot.getItem();
                        vendingMachine.restockItem(itemToRestock, quantity);
                    } else {
                        System.out.println("Invalid item number.");
                    }
                    break;

                case 2:
                    vendingMachine.displayItemSlots();

                    System.out.print("Enter the number of the item to set the price: ");
                    itemNumber = scanner.nextInt();
                    scanner.nextLine();

                    itemSlot = vendingMachine.getItemSlotByNumber(itemNumber);
                    if (itemSlot != null) {
                        System.out.print("Enter the new price for the item: ");
                        int newPrice = scanner.nextInt();
                        scanner.nextLine();

                        if (newPrice >= 0) {
                            Item itemToSetPrice = itemSlot.getItem();
                            vendingMachine.setItemPrice(itemToSetPrice, newPrice);
                        } else {
                            System.out.println("Invalid price. Please enter a non-negative value.");
                        }
                    } else {
                        System.out.println("Invalid item number.");
                    }
                    break;

                case 3:
                    System.out.println("Collecting all bills in the machine... ");
                    vendingMachine.clearAvailableChange();
                    break;

                case 4:
                    System.out.println("Replenish money denominations in the vending machine:");
                    System.out.print("Enter the denomination value: ");
                    int denominationValue = scanner.nextInt();
                    scanner.nextLine();

                    if (denominationValue <= 0) {
                        System.out.println("Invalid denomination value. Please enter a positive value greater than 0.");
                        break;
                    }

                    System.out.print("Enter the quantity of denominations to insert: ");
                    int quantityToReplenish = scanner.nextInt();
                    scanner.nextLine();

                    if (quantityToReplenish <= 0) {
                        System.out.println("Invalid quantity. Please enter a positive value greater than 0.");
                        break;
                    }

                    vendingMachine.addAvailableChange(denominationValue, quantityToReplenish);

                    System.out.println("Denominations in available change:");
                    List<Denomination> availableChange1 = vendingMachine.getSortedChange();
                    vendingMachine.printChange(availableChange1); // Call the printChange method here

                    break;


                case 5:
                    System.out.println("Printing Transaction List...");
                    vendingMachine.printTransactionList();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice. Try again");
                    break;
            }
        }
    }
}

