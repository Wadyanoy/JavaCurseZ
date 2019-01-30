package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        hello("world");
        hello("Wadya");
        Square s = new Square(5);
        Rectangle r = new Rectangle(4, 6);

        Point p1= new Point (3,2);
        Point p2 = new Point (5,6);

        System.out.println("Ploshad qadrata so storonoi " + s.len + " = " + s.area());

        System.out.println("Ploshad pryamougolnika so storonami " + r.a + " i " + r.b + " = " + r.area());
        System.out.println(Math.sqrt((5-3)*(5-3)+(6-2)*(6-2)));
        System.out.println("Otvet = "+ distance(p1,p2));

    }

    public static void hello(String somebody) {
        System.out.println("Hello, world!");
    }


 public static double distance (Point p1, Point p2){

        return  Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
    }

}


