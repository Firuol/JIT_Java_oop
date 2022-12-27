
package animal;
interface World{
    void displayDetails();
    void canMove();
    void canEat();
    void canSleep();
    int getTotalNuber(int...x);
}
abstract class LivingThings{
    String name;
    int amount;
        
    void displayThings(){
        System.out.println("This is display method.\n");
    }


 int calcTotal(int...t){
        int sum=0;
        for(int i=0;i<t.length;i++){
            sum+=t[i];
}
        return  sum;
 }
     void displayDetails(){
         System.out.println("This is the detail method.");
     }
    void canMove(){
        System.out.println("they can move.");
    }
    void canEat(){
        System.out.println("they can eat.");
}
    void canSleep(){
        System.out.println("they sleep.");
}
    int getTotalNumber(int...x){
    int sum=0;
        for(int i=0;i<x.length;i++){
            sum+=x[i];
}
        return  sum;
 }
}
public class Animal extends LivingThings implements World{
   
    
 Animal (String n, int num){
    this.animalname=n;
    this.amount=num;
}
}

    public static void main(String[] args) {
       Animal an1=new Animal();
        Animal an2=new Animal("Human",600);
int totalnum=an1.calcTotal(100,499,44);
    }
    

