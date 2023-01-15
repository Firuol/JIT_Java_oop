package lecturetwo;



class overload_Rectangle {
	double height;
	double width;
	overload_Rectangle(double h,double w){
		height=h;
		width=w;
	}
	void Calculate_area(double h, double w) {
		double area;
		area=h*w;
		System.out.println("this is the double double function area ="+area);
	}
	void Calculate_area() {
		System.out.println("this is the parameterless "+ height + width);
		
	}
	void Calculate_area(int h, int w) {
		int area=h*w;
		System.out.println("this is the int int function area ="+area);
		
	}
	void Calculate_area(int h) {
		int w=1;
		int area=h*w;
		System.out.println("this is the  int function area ="+area);
	}
}
class multi_constr{ // class for constructor overloading
	double height;
	int length;
	double width;
	multi_constr(){
		System.out.println("parameter less constructor");
	}
	multi_constr(double height){
		this.height=height;
		System.out.println("double ");
	}
	multi_constr(double height,int length){
		this.height=height;
		this.length=length;
		System.out.println("double int ");
	}
	multi_constr(double height,int length,double width){
		this.height=height;
		this.length=length;
		this.width=width;
		System.out.println("double int double");
	}
}
class var_arg{
	void sum(int ...a) {
		int sum=0;
		for(int i=0;i<a.length;i++)
			sum=sum+a[i];
		System.out.println("sum of this numbers is "+ sum);
	}
	void multiply(int ...a) {
		int multi=1;
		for(int i=0;i<a.length;i++)
			multi=multi*a[i];
		System.out.println("product  of these numbers is "+ multi );
	}
	
}
class shape{
	static class Rectangle{
     Rectangle() {
			
			System.out.println("the static nested class created successfully");
		}	
	}
	class Triangle{    //non static
		Triangle() {
			
			System.out.println("the non static nested class created successfully");
		}
	}
	}
class Array_process{
	
}

public class display {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		overload_Rectangle rec1= new overload_Rectangle(0,0);

		rec1.Calculate_area();
		rec1.Calculate_area(1);
		rec1.Calculate_area(1100, 12);
		rec1.Calculate_area(1.2 ,3.2);
		multi_constr c1=new multi_constr();
		multi_constr c2=new multi_constr(1.3);
		multi_constr c3=new multi_constr(1.2,3);
		multi_constr c4=new multi_constr(1.4,5,1.33);
		var_arg v1=new var_arg();
		v1.sum(1,3,4,5,68,8);
		v1.multiply(1,3,4,5,68,8);
	    shape.Rectangle rect1 =new shape.Rectangle (); //object creation for static nested class
	    
	    shape sh=new shape();
	     shape.Triangle t1 =sh.new Triangle();
	}

}
