package chapone;
import java.util.Scanner;

class if_state {
	void compare (int x , int y)
	{
	if(x>y) {
	
	System.out.println("x is great than y");}
	
	else if(x<y)
		{System.out.println("y is great than x");}
	else {
		System.out.println("x is equal to y");
	}
	}
}
class switch_state {
void grade(char  a) {
	switch (a){
	case'A':
		System.out.println("excellent");
		break;
	case 'B':
		System.out.println("good ");
		break;
	case 'C':
		System.out.println("not bad");
		break;
	case'F':
		System.out.println("fail");
		break;
		
	
	}
}
}
class ternary_op{
	void  ternary_max (int x,int y) {
        
        System.out.println ("max is " + ( (x > y ) ? x : y));
	
	}
}
class while_loop{
 static void whilestar(int x){
int counter;
counter = 0;
while (counter <= x)
{
for (int i=0;i<counter;i++)
	System.out.print("*");
counter++;
System.out.println();
}
}
}
class nested_for{
	void unlabeled_break() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.println("i ="+i +" j= "+ j);
				if(i==2&&j==3) {
					break ;
				}
			}
		}
	}
	void labeled_break() {
		lab:for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.println("i ="+i +" j= "+ j);
				if(i==2&&j==3) {
					break lab ;
				}
			}
		}
	}
}

public class control_stats {
	
	
	
	public static void main(String[] args) {
	if_state c =new if_state ();
		c.compare(1,7);
	switch_state s=new switch_state();
	   s.grade('F');
	   ternary_op ter= new ternary_op();
	   ter.ternary_max(3,4);
	   while_loop lo= new while_loop ();
	   System.out.println("enter any number");
	   Scanner scan =new Scanner(System.in);
	   int x=scan.nextInt();
	   while_loop.whilestar(x);
	   nested_for f1=new nested_for();
	   f1.unlabeled_break();
	   f1.labeled_break();
	}

}
