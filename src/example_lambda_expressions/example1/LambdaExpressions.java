package example_lambda_expressions.example1;

public class LambdaExpressions {
    public static void main(String args[]) {

        //with type declaration
        IMathOperation addition = (int a, int b) -> a + b;

        //without type declaration
        IMathOperation subtraction = (a, b) -> a - b;

        //with return statement along with "curly braces"
        IMathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        IMathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + operate(10, 5, addition));
        System.out.println("10 - 5 = " + operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + operate(10, 5, division));

        //without parenthesis
        IGreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        //with parenthesis
        IGreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Fatma");
        greetService2.sayMessage("Dilara");
    }

    public static int operate(int a, int b, IMathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

}
