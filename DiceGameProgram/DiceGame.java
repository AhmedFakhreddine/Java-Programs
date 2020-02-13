import java.util.*;
import java.text.DecimalFormat;//formats decimal

public class DiceGame
{
   private double total;//total winnings with finalPrize variable
   private double finalPrize;//final pize only if you win
   private double multiplier;//every code unlocked you get a *2 money per lock
   private double betAmount;//user bet amount
   
   private int correctCount;//for checking the numbers guessed corretly
   private int num;//used for the dice method to randomly lock code
   private int chances; //for calculating the number of chances remaining
   private int userGuess;//user guess 
   private int userGuess2;//user guess 2
   
   Dice dice = new Dice();//Dice Class Call
   
   Scanner keyboard = new Scanner(System.in);//allows for input
   DecimalFormat df = new DecimalFormat("#.##");//Formats the decimal to look like money and cents
   
   //Default Constructor
   public DiceGame()
   {     
      total = 0;//sets total cash to 0
      finalPrize = 2500;//sets final prize if you win 
      multiplier = 2;//multiplies every code cracked by cash bet
      betAmount = 0;//sets betting cash to 0   
      correctCount = 0;//every code correct set to 0
      chances = 4;//for chances to get the answer right
   }
   
   public void introToBreifCase()
   {
      int choice;
           
      System.out.println("The breif case is locked. The lock contains 6 combination numbers to be unlocked. The case is locked with random numbers");
      System.out.println("You have 3 tries to unlock the 6 combos. If you have some how rolled the correct number you move to the next combo");
      System.out.println("however, if you dont roll the correct number you lose your betting stake and go home with no money.");
      System.out.println("Betting with be multiplied by two every time you roll the correct number and the final prize is $50,000\n");
      
      System.out.println("Enter 1 to place bet or enter 2 to exit: ");
      choice = keyboard.nextInt();
      switch(choice)//game menu
      {
         case 1:
            placeBet();
            break;
         case 2:
            System.out.println("Thank you for playing, Good Bye!!!");
            System.exit(1);
         default:
            System.out.println("Wrong selection!"); 
            break;     
      }
   }
   
   public void placeBet()//places cash bet
   {
      System.out.println("Enter The Amount You Want To Bet: ");
      betAmount = keyboard.nextDouble();
      System.out.println("Bet Placed: " + df.format(betAmount));
      decoddingCase();   
   }
   
   public void decoddingCase()//displaying image
   {
      System.out.println("---------------------");
      System.out.println("|                    |");
      System.out.println("|                    |");
      System.out.println("| [?][?][?][?][?][?] |"+ " Find the Locked Numbers");
      System.out.println("|                    |");
      System.out.println("|                    |");
      System.out.println("---------------------");
      gameScript();
      
   }
    
    public void gameScript()//start game method
    {
      for(int x=1; x<=6; x++)//loop for generating 6 random numbers
      {   
         num = dice.roll(); //generating a number 1-6
         System.out.println("Number generated: " + num);//to see the number generated for developer purposes
      
         userGuess = check();//taking input from user by the method
         
         if(userGuess==num)//checking the number guessed correctly or not
         { 
            correctCount++; //counting the number of correctly guessed numbers
            System.out.println("YOU GUESSED CORRECTLY");
            betAmount = betAmount * multiplier;
            System.out.println("New Bet Amount: " + df.format(betAmount));
            System.out.println("Correct Counter: " + df.format(correctCount));
         }
         else
         {
           chances--; //reducing the chances if wrong
           System.out.println("YOU GUESSED WRONG");
           System.out.println("Number of chances left:" + chances); //showing the number of chances remaining
          
           for(int i=1; i<4; i++)//loop to check for the remaining 3 chances left
           { 
               System.out.println("Number generated: " + num);//to see the number generated for developer purposes

               userGuess2 = check(); //taking input from user by the method
               
               if(userGuess2==num)//checking the number guessed correctly or not
               { 
                   correctCount++;
                   System.out.println("YOU GUESSED CORRECTLY\n");
                   betAmount = betAmount * multiplier;
                   System.out.println("New Bet Amount: " + df.format(betAmount));
                   System.out.println("Correct Counter: " + df.format(correctCount));                                
               }    
               else
               {
                   chances--; //reducing the chances allowed if wrong again
                   System.out.println("YOU GUESSED WRONG");
                   System.out.println("Number of chances left: " + chances); 
                   
                   if(chances==0)//exiting if no chances are remaining
                   { 
                       System.out.println("YOU GUESSED " + correctCount + " NUMBERS CORRECTLY");
                       System.out.println("YOU LOST ALL YOUR MONEY!");
                       betAmount = 0; 
                       System.out.println("Total: " + df.format(betAmount));
                       System.exit(0);
                   }
               }
           }//end for loop
       }//end else statment
       
         if(correctCount==6)//if all are right then you win the prize
         {      
            System.out.println("YOU WON!!!");
            total = betAmount + finalPrize;
            System.out.println("FINAL WINNINGS: " + df.format(total) + " CONGRATS!");
            System.exit(0);
         }
      }//end for loop to generate random numbers
     }//end game script function
 
   public static int check()//user input function
   {
      Scanner in=new Scanner(System.in);
      System.out.print("Guess the number: ");
      int guess=in.nextInt();
      return guess;
   }
  
}//end class



