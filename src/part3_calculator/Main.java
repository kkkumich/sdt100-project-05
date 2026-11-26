package part3_calculator;

import common.Input;
public class Main {
    public static double add(double a,double b) { return a+b; }
    public static double subtract(double a,double b) { return a-b; }
    public static double multiply(double a,double b) { return a*b; }
    public static double divide(double a,double b) {
        if(b==0) throw new IllegalArgumentException("Cannot divide by zero");
        return a/b;
    }
    public static double calculate(double a,String op,double b) {
        switch(op) {
            case "+": return add(a,b); case "-": return subtract(a,b);
            case "*": return multiply(a,b); case "/": return divide(a,b);
            default: throw new IllegalArgumentException("Unknown operation");
        }
    }
    public static void main(String[] args) {
        double first=Input.number("First operand: ");
        while(true) {
            String op=Input.text("Operation (+ - * /): ");
            double second=Input.number("Second operand: ");
            try {
                double result=calculate(first,op,second);
                if(!Double.isFinite(result)) throw new IllegalArgumentException("Result is not finite");
                System.out.printf(java.util.Locale.US,"%.4f %s %.4f = %.4f%n",first,op,second,result);
                first=result;
            } catch(IllegalArgumentException e) { System.out.println(e.getMessage()); continue; }
            String next=Input.text("C: continue with result; N: new calculation; anything else: quit: ");
            if(next.equalsIgnoreCase("n")) first=Input.number("First operand: ");
            else if(!next.equalsIgnoreCase("c")) break;
        }
    }
}
