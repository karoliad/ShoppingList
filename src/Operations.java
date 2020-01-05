import java.util.ArrayList;
import java.util.Scanner;

public class Operations {
    Scanner scanner = new Scanner(System.in);
    //Lag en arraylist som kan holde Items.
    ArrayList<Item> shoppingList = new ArrayList<Item>();

    //lag meny - generere liste
    public void displayMenu() {
        System.out.println("\n --------------------- \n       - Menu -      \n ---------------------");
        System.out.println("1 - Add item to list");
        System.out.println("2 - Delete item");
        System.out.println("3 - Total cost");
        System.out.println("4 - Find cheapest / most expensive");
        System.out.println("5 - Show shoppinglist");
        System.out.println("6 - Add test groceries");
        System.out.println("7 - Exit");
    }

    //velge fra menyen
    public int getOption () {
        System.out.println("\n Option:");
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return option;
    }

    //velg handling fra meny
    public void readInputFromMenu() {
            do {
                displayMenu();
                int option = getOption();
                if (option == 1) {
                    addItem();
                } else if (option == 2) {
                    removeItem();
                } else if (option == 3) {
                    totalCost();
                } else if (option == 4) {
                    cheapAndExpensive();
                } else if (option == 5 ){
                    showShoppinglist();
                } else if (option == 6) {
                    testGroceries();
                }else if (option == 7){
                    System.out.println("Exiting...");
                    break;
                }
            }while (true);
    }

        //legge til item i shoppinglist
        public void addItem () {
            System.out.println("Name the grocery you want to add");
            String name = scanner.nextLine();
            System.out.println("Whats the price? ");
            double price = scanner.nextDouble();

            Item grocery = new Item(name, price);
            shoppingList.add(grocery);
        }

        //fjerne item fra shoppinglist
        public void removeItem () {
            System.out.println("The following items are on your list:");

            for (Item grocery: shoppingList) {
                System.out.println(  shoppingList.indexOf(grocery)+" - " + grocery.getName());
            }
            System.out.println("Press the number of the item you want to remove");
            int number =  scanner.nextInt();
            shoppingList.remove(number);
        }

        //finne dyreste og billigste vare
        public void cheapAndExpensive () {
            //finn dyreste item
            Item expensive= null;

            for (Item grocery: shoppingList){
                boolean isFirstLap = expensive == null;
                boolean isMoreExpensive = isFirstLap || grocery.getPrice() > expensive.getPrice();

                if(isMoreExpensive){
                    expensive = grocery;
                }
            }
            System.out.println("The most expensive grocery is: " + expensive.getName() +
                                ", it costs " + expensive.getPrice() + " NOK");

            // finn billigste item
            Item cheapest = null;

            for (Item grocery: shoppingList){
                boolean isFirstLap = cheapest == null;
                boolean isLessExpensive = isFirstLap || grocery.getPrice() < cheapest.getPrice();

                if(isLessExpensive){
                    cheapest = grocery;
                }
            }
            System.out.println("the cheapest grocery is: " + cheapest.getName() +
                                    ", it costs " + cheapest.getPrice()+ " NOK");
        }

        // print hele handlelisten
         public void showShoppinglist(){
             System.out.println("Your shopping list: ");
            for (Item grocery: shoppingList) {
                System.out.println(grocery.getName() + " - " + grocery.getPrice());
            }
        }

        //Summer totalsum
        public void totalCost () {
            double sum= 0;
            for (Item grocery: shoppingList){
                sum += grocery.getPrice();
            }
            System.out.println(sum);
        }


        //testliste
        public void testGroceries(){

            Item vare1 = new Item("Eple", 20.5);
            shoppingList.add(vare1);
            Item vare2 = new Item("Pære", 17.1);
            shoppingList.add(vare2);
            Item vare3 = new Item("Banan", 10.5);
            shoppingList.add(vare3);
            Item vare4 = new Item("Jordbær", 30.5);
            shoppingList.add(vare4);
            Item vare5 = new Item("Drue", 5);
            shoppingList.add(vare5);
            Item vare6 = new Item("Plomme", 7.9);
            shoppingList.add(vare6);

            for (Item grocery  : shoppingList) {
                System.out.println(grocery.toString());
            }
        }
    }

