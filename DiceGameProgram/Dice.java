import java.util.Random;

public class Dice
{
   private int num;

   public Dice()
   {
      Random random = new Random();
      num = random.nextInt(6) + 1;
      System.out.println(num);
   }

   public int roll()
   {
      Random random = new Random();
      num = random.nextInt(6) + 1;
      return num;
   }

   public void getNum()
   {
      roll();
      System.out.println(num);
   }

}