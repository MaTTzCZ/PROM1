package com.mattz;

import com.mattz.data.SeznamZlomku;
import com.mattz.data.Zlomek;

public class Main {
    public static void main(String[] args) {
        SeznamZlomku seznamZlomku = new SeznamZlomku();
        Zlomek zlomek1 = new Zlomek(1, 5);
        Zlomek zlomek2 = new Zlomek(9, 5);
        Zlomek zlomek3 = new Zlomek(2, 7);
        Zlomek zlomek4 = new Zlomek(9, 11);
        Zlomek zlomek5 = new Zlomek(3, 5);
        Zlomek zlomek6 = new Zlomek(2, 7);
        System.out.println("Součet zlomků " + zlomek1 + " a " + zlomek2 + " je " + zlomek1.secist(zlomek2));
        System.out.println("Součin zlomků " + zlomek1 + " a " + zlomek4 + " je " + zlomek1.vynasob(zlomek4));
        seznamZlomku.pridatZlomek(zlomek1);
        seznamZlomku.pridatZlomek(zlomek2);
        seznamZlomku.pridatZlomek(zlomek3);
        seznamZlomku.pridatZlomek(zlomek4);
        seznamZlomku.pridatZlomek(zlomek5);
        seznamZlomku.pridatZlomek(zlomek6);
        System.out.println("Tohle jsou všechny zlomky v seznamu: ");
        seznamZlomku.vypisZlomky();
        System.out.println("Součet zlomků v seznamu je " + seznamZlomku.spoctiSoucet());
        System.out.println("Průměr zlomků v seznamu je " + seznamZlomku.spoctiPrumer());


    }
}