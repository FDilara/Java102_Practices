package example_lambda_expressions.example3;

public class Main {
    public static void main( String[] args ) {

        //Note that we can declare a reference of an interface, but we cannot instantiate an interface.
        //Because 'IMyInterface' is abstract; cannot be instantiated!!!

        // it will throw an error
        //IMyInterface ref = new IMyInterface();

        // it is valid
        //IMyInterface ref;

        //declare a reference to IMyInterface
        IMyInterface ref;

        //lambda expression
        ref = () -> 3.1415;

        System.out.println("Value of Pi = " + ref.getPiValue());
    }
}
