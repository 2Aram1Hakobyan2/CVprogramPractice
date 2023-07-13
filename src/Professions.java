import java.util.Scanner;

public class Professions {
    static Scanner scanner1 = new Scanner(System.in);
    boolean experienceChecker;
    int experienceYear;
    int experienceMonths;
    public void ExpPresent(){
        if(experienceChecker==true){
            System.out.print("How many years of Experience do you have?\nYear : ");
            experienceYear = scanner1.nextInt();
            System.out.print("Months : ");
            experienceMonths = scanner1.nextInt();
        }
    }
}
