import java.util.Scanner;
import  java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
/*The IOException is simply an exception that is thrown when an I/O error occurs.
It is also the base class of such exceptions which
occur while reading or accessing files, directories and streams.*/
public class  Main {
    public static String FilePath="C:\\Users\\ar1ha\\OneDrive\\Desktop\\CVprogramGIT";
    public static String passwordPath = "C:\\Users\\ar1ha\\OneDrive\\Desktop\\CVprogramGIT\\CVprogram3\\Password.txt";
    static Scanner scanner = new Scanner(System.in);

    /*A method to insert the data in the file
    I suppose this will be used frequently, so creating a function was viable
    to reduce the length of the code as much as possible*/

    public static void fileCreatorChecker(String filePath,String fileName){
        //Creating a file or checking the existing of it.
        String createdFile = filePath+"\\"+fileName;
        System.out.println(createdFile);
        try{
            File user = new File(createdFile);
            if(user.createNewFile()){//The file will be created if and only if file with that name does not exist
                System.out.println("File has been created:" + user.getName());
            }
            else{//Else, the file exists
                System.out.println("File already exists.");
            }
        }catch(IOException e){
            System.out.println("an Error has occurred!");
            e.printStackTrace();
        }
    }

    public static void fileWriting(String filePath,String inputData) {
        try {
            FileWriter dataWrite = new FileWriter(filePath, true);
            dataWrite.write(inputData);
            dataWrite.close();
        }catch(IOException e){
            System.out.println("an Error has occurred!\n(Writing error)");
            e.printStackTrace();
        }
    }

    public static void fileReader(String filePath){
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

    public static int pWordChecker() {
        System.out.print("Password : ");
        String pWordToCheck = scanner.nextLine();
        try {
            File fileReader = new File(passwordPath);
            Scanner theReader = new Scanner(fileReader);
            while (theReader.hasNextLine()) {
                String pWord = theReader.nextLine();
                if (pWordToCheck.equals(pWord)) {
                    System.out.println("Valid password.\nAccess approved.");
                } else {
                    System.out.println("Invalid password!");
                    return pWordChecker();
                }
            }
            theReader.close();
        } catch (IOException e) {
            System.out.println("an Error has occurred!\n(Reading error)");
            e.printStackTrace();
        }
        return 0;
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
        fileCreatorChecker(FilePath,"user");
        System.out.println("Do you want create a professional CV?");
        System.out.print("Write Yes or No\n-");
        String answer;
        Checker();
        System.out.println("Account");
        User newUser1 = new User();
        System.out.print("Username : ");
        newUser1.username = scanner.nextLine();
        String createdFile = FilePath+"\\"+newUser1.username;
        System.out.println(createdFile);
        try{
            File user = new File(createdFile);
            if(user.createNewFile()){//The file will be created if and only if file with that name does not exist
                System.out.println("Account has been created:" + user.getName());
                System.out.println("Create a password");
                System.out.print("Password : ");
                String passwordChecker = scanner.nextLine();
                newUser1.setterPassword(passwordChecker);
                passwordChecker = null;
                System.gc();
                fileWriting(passwordPath,newUser1.getterPassword());
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
                fileWriting(createdFile,"Name : "+newUser1.name);
                fileWriting(createdFile,"Surname : "+newUser1.surname);
                fileWriting(createdFile,"Age : "+newUser1.age);
                fileWriting(createdFile,"Country  : " + newUser1.country);
                fileWriting(createdFile,"City : "+newUser1.city);
                fileReader(createdFile);
            }
            else{//Else, the file exists
                System.out.println("Account already exists.");
                pWordChecker();
            }
        }catch(IOException e) {
            System.out.println("an Error has occurred!");
            e.printStackTrace();
        }
    }
}