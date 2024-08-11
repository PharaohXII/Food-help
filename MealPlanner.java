
   

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Scanner;

// class Meal {
//     String name;
//     List<String> ingredients;

//     Meal(String name, List<String> ingredients) {
//         this.name = name;
//         this.ingredients = ingredients;
//     }
// }

// class MealPlanner {
//     private Scanner scanner;

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in); // Initialize scanner in main
//         new MealPlanner(scanner).run(); // Pass scanner to MealPlanner
//         scanner.close();
//     }

//     public MealPlanner(Scanner scanner) {
//         this.scanner = scanner;
//     }

//     public void run() {
//         List<Meal> meals = new ArrayList<>();
//         System.out.println("Enter Meals (type 'done' when complete)");
//         while (true) {
//             System.out.print("Enter the name of the meal: ");
//             String mealName = scanner.nextLine();

//             if (mealName.equalsIgnoreCase("done")) {
//                 break;
//             }

//             System.out.print("Enter the ingredients for " + mealName + " (comma separated): ");
//             String ingredientsInput = scanner.nextLine();
//             List<String> ingredients = Arrays.asList(ingredientsInput.split("\\s*,\\s*"));

//             meals.add(new Meal(mealName, ingredients));
//         }

//         // Display the entered meals
//         System.out.println("\nHere are the meals you've entered:");
//         for (Meal meal : meals) {
//             System.out.println("Meal: " + meal.name);
//             System.out.println("Ingredients: " + String.join(", ", meal.ingredients));
//             System.out.println();
//         }
//     }
// }
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Scanner;

// class Meal {
//     String name;
//     List<String> ingredients;

//     Meal(String name, List<String> ingredients) {
//         this.name = name;
//         this.ingredients = ingredients;
//     }
// }

// class MealPlanner {
//     private Scanner scanner;

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in); // Initialize scanner in main
//         new MealPlanner(scanner).run(); // Pass scanner to MealPlanner
//         scanner.close();
//     }

//     public MealPlanner(Scanner scanner) {
//         this.scanner = scanner;
//     }

//     public void run() {
//         // List to store meals
//         List<Meal> meals = new ArrayList<>();
//         // List to store ingredients you have on hand
//         List<String> availableIngredients = new ArrayList<>();

//         System.out.println("Enter the ingredients you have (type 'done' when complete):");

//         // Gather ingredients on hand from the user
//         while (true) {
//             System.out.print("Enter an ingredient: ");
//             String ingredient = scanner.nextLine();

//             if (ingredient.equalsIgnoreCase("done")) {
//                 break;
//             }

//             availableIngredients.add(ingredient);
//         }

//         System.out.println("\nEnter Meals (type 'done' when complete)");

//         // Gather meal information from the user
//         while (true) {
//             System.out.print("Enter the name of the meal: ");
//             String mealName = scanner.nextLine();

//             if (mealName.equalsIgnoreCase("done")) {
//                 break;
//             }

//             System.out.print("Enter the ingredients for " + mealName + " (comma separated): ");
//             String ingredientsInput = scanner.nextLine();
//             List<String> ingredients = Arrays.asList(ingredientsInput.split("\\s*,\\s*"));

//             meals.add(new Meal(mealName, ingredients));
//         }

//         // Display the available ingredients
//         System.out.println("\nIngredients you have:");
//         System.out.println(String.join(", ", availableIngredients));

//         // Display the entered meals
//         System.out.println("\nHere are the meals you've entered:");
//         for (Meal meal : meals) {
//             System.out.println("Meal: " + meal.name);
//             System.out.println("Ingredients: " + String.join(", ", meal.ingredients));
//             System.out.println();
//         }
//     }
// }
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Meal {
    String name;
    List<String> ingredients;

    Meal(String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }
}

class MealPlanner {
    private Scanner scanner;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize scanner in main
        new MealPlanner(scanner).run(); // Pass scanner to MealPlanner
        scanner.close();
    }

    public MealPlanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        // List to store meals
        List<Meal> meals = new ArrayList<>();
        // List to store ingredients you have on hand
        List<String> availableIngredients = new ArrayList<>();

        // Gather ingredients on hand from the user
        System.out.println("Enter the ingredients you have (type 'done' when complete):");
        while (true) {
            System.out.print("Enter an ingredient: ");
            String ingredient = scanner.nextLine();

            if (ingredient.equalsIgnoreCase("done")) {
                break;
            }

            availableIngredients.add(ingredient);
        }

        // Gather meal information from the user
        System.out.println("\nEnter Meals (type 'done' when complete)");
        while (true) {
            System.out.print("Enter the name of the meal: ");
            String mealName = scanner.nextLine();

            if (mealName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter the ingredients for " + mealName + " (comma separated): ");
            String ingredientsInput = scanner.nextLine();
            List<String> ingredients = Arrays.asList(ingredientsInput.split("\\s*,\\s*"));

            meals.add(new Meal(mealName, ingredients));
        }

        // Display the available ingredients
        System.out.println("\nIngredients you have:");
        System.out.println(String.join(", ", availableIngredients));

        // Check and display which meals can be made
        System.out.println("\nYou can make the following meals with your available ingredients:");
        for (Meal meal : meals) {
            if (canMakeMeal(meal, availableIngredients)) {
                System.out.println("- " + meal.name);
            }
        }
    }

    // Method to check if a meal can be made with the available ingredients
    private boolean canMakeMeal(Meal meal, List<String> availableIngredients) {
        for (String ingredient : meal.ingredients) {
            if (!availableIngredients.contains(ingredient)) {
                return false; // If any ingredient is missing, can't make the meal
            }
        }
        return true; // All ingredients are available
    }
}