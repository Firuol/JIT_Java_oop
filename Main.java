import java.util.Scanner;

interface Movies {
   void  displayDetails();
   int getNumberofMovies();
   void displayCategory();
}
class ActionMovies implements Movies {
    Scanner scan1=new Scanner(System.in);
    String id;
    String Category;
    String title;
    String Studio;
    int rating;
    public void  displayDetails(){
        System.out.println("the detials of "+title+" is :");
        System.out.println("id "+id);
        System.out.println("category : "+Category);
        System.out.println("tittle : "+title);
        System.out.println("studio : "+Studio);
        System.out.println("rating :"+rating);
    }
    public int getNumberofMovies() {
        System.out.println(" total enter number of movies ");
        int n =scan1.nextInt();
        System.out.println("the number of movies action movies is "+ n);
        return n;
    }
    public void displayCategory( ){
        System.out.println("the category of ur film is :" +Category);
    }
    ActionMovies(String id, String Category, String title, String studio, int rating) {
        this.id = id;
        this.title=title;
        this.Category = Category;
        this.Studio = Studio;
        this.rating = rating;
    }
    ActionMovies(String i, String title,String Studio, int rating) {
        this.id = ("unset" + i);
        this.Category = "unset";
        this.title=title;
        this.Studio = Studio;
        this.rating = rating;
    }
}
    class RomanticMovies  implements Movies{
        String id;
        String Category;
        String Studio;
        String title;
        int rating;
        public void  displayDetails(){
                System.out.println("the detials of the romance film is  "+title+" is :");
                System.out.println("id "+id);
                System.out.println("category : "+Category);
                System.out.println("tittle : "+title);
                System.out.println("studio : "+Studio);
                System.out.println("rating :"+rating);
        }
        public int getNumberofMovies() {
            int n=1;
            System.out.println("the number of movies romantic  movies is "+ n);
            return n;
        }
        public void displayCategory( ){
            System.out.println("the category of ur film is :" +Category);
        }
        RomanticMovies() {
            this.id = "12";
            this.Category ="romio and julet";
            this.title="the women king";
            this.Studio = "mountain";
            this.rating = 12;
        }
    }
   class ActionRomance extends RomanticMovies , {
    void calculateTotalMovies(int... x){
        int total=0;
        for (int i=0;i<x.length;i++){
            total+=i;
        }
        System.out.println("total number of movies are: "+ total);
    }
   }


public class Main {

    public static void main(String[] args) {
        ActionMovies fast_and_furious=new ActionMovies("1","action","fast_and_furious","marvels", 89);
        RomanticMovies forever=new RomanticMovies();
        Scanner scan=new Scanner(System.in);
        System.out.println("enter the id of the action film ");
        String id=scan.nextLine();
        System.out.println("enter the category of the film:");
        String category=scan.nextLine();
        System.out.println("enter the tittle of the film");
        String title=scan.nextLine();
        System.out.println("enter the studio where the film is created");
        String studio= scan.next();
        System.out.println("enter the rating of the film ot of 100 :");
        int rating=scan.nextInt();
        ActionMovies film1 =new ActionMovies(id,category,title,studio,rating);
        film1.displayDetails();

    }
}