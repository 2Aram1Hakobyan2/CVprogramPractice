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

}