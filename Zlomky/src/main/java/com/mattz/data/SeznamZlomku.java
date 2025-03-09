package com.mattz.data;

import java.util.ArrayList;
import java.util.List;

public class SeznamZlomku {
    List<Zlomek> zlomky;

    public SeznamZlomku() {
        zlomky = new ArrayList<>();
    }

    public void pridatZlomek(Zlomek zlomek) {
        zlomky.add(zlomek);
    }

    public Zlomek odebratZlomek(int index) {
        return zlomky.remove(index);
    }

    public Zlomek vratZlomek(int index) {
        return zlomky.get(index);
    }

    public void vypisZlomky() {
        for (Zlomek zlomek : zlomky) {
            System.out.println(zlomek.toString());
        }
    }

    public Zlomek spoctiSoucet() {
        Zlomek soucet = vratZlomek(0);
        for (int i = 1; i < zlomky.size(); i++) {
            soucet = soucet.secist(zlomky.get(i));
        }
        return Zlomek.zkrat(soucet);
    }

    public Zlomek spoctiPrumer() {
        Zlomek soucet = spoctiSoucet();
        return Zlomek.zkrat(soucet.vydelit(new Zlomek(zlomky.size(), 1)));
    }
    public int getSize() {
        return zlomky.size();
    }
}
