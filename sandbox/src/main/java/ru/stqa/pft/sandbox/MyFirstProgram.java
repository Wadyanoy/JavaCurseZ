package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        hello("world");
        hello("Wadya");
        Square s = new Square(5);
        Rectangle r = new Rectangle(4,6);
        System.out.println("Ploshad qadrata so storonoi " +s.len+" = " +area(s));

        System.out.println("Ploshad pryamougolnika so storonami "+r.a+" i "+r.b+" = " +area(r));
    }
    public static  void hello(String somebody){
        System.out.println("Hello, world!");
    }
    public static double area(Square s){
        return s.len*s.len;
    }
    public static double area(Rectangle r){
        return r.a*r.b;
    }
}