import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class Person
{
   private String name;
   private int age;
   
   public Person()
   {
      getPersonInfo();
   }
   
   public void getPersonInfo()
   {
      Scanner keyboard = new Scanner(System.in);
   
      System.out.println("Enter your full name ");//asks for users full name
      name = keyboard.nextLine();
   
      System.out.println("Enter your age ");//asks for users age
      age = keyboard.nextInt();

      if (age<21)//if user is not 21 they can not play
      {
         System.out.println("You are not eligible to play the game");
         System.exit(1); //non zero value to exit says abnormal termination of JVM
      }
      
      displayPerson();
   }
   
   public void displayPerson()
   {
      System.out.println("Name: " + name);
      System.out.println("Age: " + age + "\n");
   }
   
}