public class PassArray
{
   public static void main(String[] args)
   {
      final int SIZE = 10;    // Size of the array

      // Create an array.
      int[] list = new int[SIZE];

      // Fill array with random values
      for (int i = 0; i < list.length; i++)
      {
         list[i] = (int) (Math.random() * 100);
      }

      int max = 0;    // hold index number of largest number

      // Finding largest value.
      for (int i = 0; i < list.length; i++)
      {
         if (list[i] > list[max])
         {
            max = i;
         }
      }

      // Show all elements of array
      System.out.print("Elements are : ");

      for (int i = 0; i < list.length; i++)
      {
         System.out.print(list[i] + " ");
      }

      System.out.println();

      // Show largest value of array
      System.out.println("Largest value is " + list[max]);
   }
}
