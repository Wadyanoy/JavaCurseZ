package ru.stqa.pft.sandbox;

public class Collections {
    public static void main(String[] args) {
        String[] langs = new String[4]; // String[] langs = {"java","c#", "python","php"}; - тоже самое
        langs[0]="Java";
        langs[1]="C#";
        langs[2]="Python";
        langs[3]="PHP";
        for (int i=0;i<langs.length;i++){
            System.out.println("Ya ho4u viu4it " + langs[i]);
        }
        // Eto pravilnee
        for(String l : langs){
            System.out.println("Ya ho4u viu4it " + l);
        }
    }
}
