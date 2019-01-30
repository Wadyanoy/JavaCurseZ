package ru.stqa.pft.sandbox;

public class Square {
    public double len;
    public Square(double l){
      this.len =l;
    }
    public double area() {
        return this.len * this.len;
    }
}
