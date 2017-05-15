package CHP09_OBJECTS;

import java.util.Scanner;

/**
 * Created by Lechu on 2017-05-09.
 */
/*
* (Algebra: quadratic equations) Design a class named CHP09_OBJECTS.QuadraticEquation for
a quadratic equation ax2 + bx + x = 0. The class contains:
 ■ Private data fields a, b, and c that represent three coefficients.
 ■ A constructor for the arguments for a, b, and c.
 ■ Three getter methods for a, b, and c.
 ■ A method named getDiscriminant() that returns the discriminant, which is
b2 - 4ac.
 ■ The methods named getRoot1() and getRoot2() for returning two roots of
the equation
r1 = -b + 2b2 - 4ac
2a
and r2 = -b - 2b2 - 4ac
2a
These methods are useful only if the discriminant is nonnegative. Let these methods
return 0 if the discriminant is negative.
Draw the UML diagram for the class and then implement the class. Write a test
program that prompts the user to enter values for a, b, and c and displays the result
based on the discriminant. If the discriminant is positive, display the two roots. If
the discriminant is 0, display the one root. Otherwise, display “The equation has
no roots.”
*/
public class Programming_Ex_10_Quad_Eq {

    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a value for a: ");
        double a = in.nextDouble();
        System.out.println();
        System.out.print("Enter a value for b: ");
        double b = in.nextDouble();
        System.out.println();
        System.out.print("Enter a value for c: ");
        double c = in.nextDouble();
        System.out.println();

        QuadraticEquation equation = new QuadraticEquation(a,b,c);

        System.out.println("THe discriminant is: "+ equation.getDiscriminant() );
        if (equation.getDiscriminant() < 0)
            System.out.println("Equation without roots");
        else if (equation.getDiscriminant() == 0)
            System.out.printf("Equation has one root: %.2f", equation.getRoot1() );
        else
            System.out.println("Equation has two root: "+equation.getRoot1()+"  "+ equation.getRoot2() );

        in.close();

    }
}
class QuadraticEquation
{
    private double a,b,c;

    public QuadraticEquation(double a, double b, double c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant()
    {
        return Math.pow(getB(), 2) - 4*getA()*getC();
    }
    /*
    * r1 = -b + 2b2 - 4ac
    * */
    public double getRoot1()
    {
        if (getDiscriminant() < 0)
            return 0;
        else
            return -getB() + 2*Math.pow(getB(),2) - 4*getC()*getA();
    }
    /*
    * r2 = -b - 2b2 - 4ac
    * */
    public double getRoot2()
    {
        if (getDiscriminant() < 0)
            return 0;
        else
            return -getB() - 2*Math.pow(getB(),2) - 4*getC()*getA();
    }
}

