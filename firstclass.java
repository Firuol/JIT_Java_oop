public class firstclass {
        float x;//field variable
        float y;
        float calculate(float x, float y) { // function to add x & y are parameters
        float sum ;// local variable
        sum= x+y;
        return (sum);
        }
        public firstclass ()
        { x=1;y=5;}
        public firstclass(float a ,float b){   /*constructor (doesn't t have return type and 
        use name of the class )*/
           a=x;
           b=y;
        }
        public static void main(String[] args){
            firstclass f1;  //declaration of new object
             f1 = new firstclass(5,7);//intantation
          f1.calculate(4,6);
        }
}
