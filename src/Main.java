import com.company.controllers.RestaurantController;
import com.company.entity.Drink;
import com.company.entity.Food;
import com.company.entity.Restaurant;
import com.company.interfaces.Item;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    static RestaurantController controller;
    public static Item chooseItem() {
        System.out.println("Choose your: drink or food (f/d)");
        String str = scanner.next();
        if(str.equalsIgnoreCase("f")) {
            System.out.println("Write a name of the food");
            String name = scanner.next();
            System.out.println("Write a type of the food");
            String type = scanner.next();
            System.out.println("Write a price of the food");
            int price = scanner.nextInt();
            return new Food(controller.getSize(), name, type, price);
        } else if(str.equalsIgnoreCase("d")) {
            System.out.println("Write a name of the drink");
            String name = scanner.next();
            System.out.println("Write a type of the drink");
            String type = scanner.next();
            System.out.println("Write a price of the drink");
            int price = scanner.nextInt();
            return new Drink(controller.getSize(), name, type, price);
        }
        System.out.println("Incorrect choose");
        return null;
    }
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(1, "GLOBAL COFFEE", 1000);
        System.out.println(restaurant.toString());

        controller = new RestaurantController(restaurant);

        while(true) {

            System.out.println("PRESS [1] TO ADD ITEM\n" +
                    "PRESS [2] TO LIST ALL ITEMS\n" +
                    "PRESS [3] TO LIST FREE DRINKS\n" +
                    "PRESS [4] TO FIND ITEMS \n" +
                    "PRESS [5] TO sell ITEM\n" +
                    "PRESS [6] TO EDIT ITEM\n" +
                    "PRESS [7] TO DELETE ITEM\n" +
                    "PRESS [0] TO EXIT");
            int number = scanner.nextInt();

            switch(number) {
                case 1:
                    Item item = chooseItem();
                    if(item != null) {
                        controller.addItem(item);
                    }
                    break;
                case 2:
                    System.out.println(restaurant.toString());
                    break;
                case 3:
                    for(Item drink : controller.getFreeDrinks()) {
                        System.out.println(drink.toString());
                    }
                    break;
                case 4:
                    System.out.println("Write name");
                    String str = scanner.next();
                    for(Item food : controller.searchList(str)) {
                        System.out.println(food.toString());
                    }
                    break;
                case 5:
                    System.out.println("Write id of the product");
                    int id = scanner.nextInt();
                    controller.sellItem(id);
                    System.out.println(restaurant.toString());
                    break;
                case 6:
                    System.out.println("Write id of the item");
                    id = scanner.nextInt();
                    int index = controller.searchItem(id);
                    item = chooseItem();
                    if(item != null) {
                        controller.editItem(index, item);
                    }
                    break;
                case 7:
                    System.out.println("Write id of the product");
                    id = scanner.nextInt();
                    controller.deleteItem(id);
                    System.out.println(restaurant.toString());
                    break;
                default:
                    System.out.println("Exit from the program");
                    System.out.println("Thanks!-Kaylie");
                    return;
            }
        }
    }
}
