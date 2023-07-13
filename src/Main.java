import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static int integerInput() {
        int intInput;
        try {
            System.out.print("Age : ");
            intInput = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong input!\n(Try with Numbers)");
                /*In order to be able to input again via recursion,
                 the input stream should be cleared first.
                 In order to do so the scanner.nextLine() should be created.
                 Somehow adding .nextLine() to your scanner clears the input stream*/
            scanner.nextLine();
            return integerInput();
        }
        return intInput;
    }

    public static int Checker() {
        System.out.println("Do you want create a professional CV?");
        System.out.print("Write Yes or No\n-");
        String decision = scanner.nextLine();
        String checker = decision.toLowerCase();
        if (checker.equals("yes")) {
            System.out.println("Nice!\nLets begin.\nInsert all the requested information.");
        } else {
            if (!checker.equals("no")) {
                System.out.println("Wrong Input!\nTry again.");
                return Checker();
            }

            System.out.println("Understood.\nSee ya.");
            System.out.println("The Program is Shutting Down.");
            System.exit(0);
        }

        return 0;
    }

    public static void main(String[] args) {
        String answer;
        Checker();
        System.out.println("First, we should create a personal account for you, to be able to save your CV\nAnd access it anytime.");
        User newUser1 = new User();
        System.out.print("Create a username, an original one\nUsername : ");
        newUser1.username = scanner.nextLine();
        System.out.println("*To make your password Strong try using symbols and capital letters.");
        System.out.print("Password : ");
        String passwordCreation = scanner.nextLine();
        newUser1.setterPassword(passwordCreation);
        passwordCreation = null;
        System.gc();
        System.out.println("Great Job!\nNow time to fill out all the fields.");
        System.out.print("Name : ");
        newUser1.name = scanner.nextLine();
        System.out.print("Surname : ");
        newUser1.surname = scanner.nextLine();
        newUser1.age = integerInput();
        scanner.nextLine();//To prevent the program from ignoring nextLine() after nextInt()
        System.out.print("Country : ");
        newUser1.country = scanner.nextLine();
        System.out.print("City : ");
        newUser1.city = scanner.nextLine();
        System.out.print("(Yes/No)\nDo you have a higher education : ");
        answer = scanner.nextLine();
        answer = answer.toLowerCase();
        if (answer.equals("yes")) {
            newUser1.educationChecker = true;
        }

    }
}