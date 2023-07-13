import java.util.Scanner;

public class mainData {
    static Scanner scanner2 = new Scanner(System.in);
    public String name;
    public String surname;
    public int age;
    public String country;
    public String city;
    boolean educationChecker;
    String higherName;
    String higherSphere;
    String higherAddress;
    public void edPresent(){
        if(educationChecker==true){
            System.out.print("Name of the establishment : ");
            higherName = scanner2.nextLine();
            System.out.print("Name of the Faculty/Sphere : ");
            higherSphere = scanner2.nextLine();
            System.out.print("The Address of the establishment : ");
            higherAddress = scanner2.nextLine();
        }
    }
    static Scanner scanner1 = new Scanner(System.in);
    boolean experienceChecker;
    String WorkPosition;
    String WorkSphere;
    String WorkAddress;
    int experienceYear;
    int experienceMonths;

    public void ExpPresent() {
        if (experienceChecker == true) {
            System.out.print("In which sphere have you worked?\nSphere : ");
            WorkSphere = scanner1.nextLine();
            System.out.print("What position did you hold?\n Position : ");
            WorkPosition = scanner1.nextLine();
            System.out.print("The address of the Establishment\nAddress : ");
            WorkAddress = scanner1.nextLine();
            System.out.print("How many years of Experience do you have?\nYear : ");
            experienceYear = scanner1.nextInt();
            System.out.print("Months : ");
            experienceMonths = scanner1.nextInt();
        }
    }
}