import java.util.Scanner;
import  java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
public class  Main {
    public static String filePath="C:\\Users\\ar1ha\\OneDrive\\Desktop\\CVprogramGIT\\userData.txt";
    static Scanner scanner = new Scanner(System.in);

    /*A method to insert the data in the file
    I suppose this will be used frequently, so creating a function was viable
    to reduce the length of the code as much as possible*/
    public static void fileWriting(String phrase,String inputData) {
        try {
            FileWriter dataWrite = new FileWriter(filePath);
            dataWrite.write(phrase+inputData);
            dataWrite.close();
        }catch(IOException e){
            System.out.println("an Error has occurred!\n(Writing error)");
            e.printStackTrace();
        }
    }

    public static void fileReader(){
        try{
            File fileReader = new File(filePath);
            Scanner theReader = new Scanner(fileReader);
            while(theReader.hasNextLine()){
                String data = theReader.nextLine();
                System.out.println(data);
            }
            theReader.close();
        }catch(IOException e){
            System.out.println("an Error has occurred!\n(Reading error)");
            e.printStackTrace();
        }
    }


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
        //Creating a file to store all the info
        try{
            File userData = new File(filePath);
            if(userData.createNewFile()){
                System.out.println("File has been created:" + userData.getName());
            }
            else{
                System.out.println("File already exists.");
            }
        }catch(IOException e){
            System.out.println("an Error has occurred!");
            e.printStackTrace();
        }
        //The End of the File stuff
        System.out.println("Do you want create a professional CV?");
        System.out.print("Write Yes or No\n-");
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
        int age = integerInput();
        newUser1.age = String.valueOf(age);
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
            newUser1.edPresent();
        }
        System.out.print("(Yes/No)\nDo you have a work Experience : ");
        answer = scanner.nextLine();
        answer = answer.toLowerCase();
        if (answer.equals("yes")) {
            newUser1.experienceChecker = true;
            newUser1.ExpPresent();
        }
        //File has been created, information has been inserted. Time to write all of it to a file then display it.
        fileWriting("Name : ",newUser1.name);
        fileWriting("Surname : ",newUser1.surname);
        fileWriting("Age : ",newUser1.age);
        fileReader();
        //First of all, understand how all of this works
        //Secondly, the fileWriting function writes over previous line
    }
}