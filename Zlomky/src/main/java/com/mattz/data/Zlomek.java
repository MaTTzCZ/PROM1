package com.mattz.data;

public class Zlomek {
    private final int citatel;
    private final int jmenovatel;

    public Zlomek(int citatel, int jmenovatel) {
        this.citatel = citatel;
        this.jmenovatel = jmenovatel;
    }

    public Zlomek secist(Zlomek zlomek) {
        if (this.jmenovatel == zlomek.jmenovatel) {
            return zkrat(new Zlomek(this.citatel + zlomek.citatel, this.jmenovatel));
        }
        int spolecnyJmenovatel = this.jmenovatel * zlomek.jmenovatel;
        int citatel1 = spolecnyJmenovatel / this.jmenovatel * this.citatel;
        int citatel2 = spolecnyJmenovatel / zlomek.jmenovatel * zlomek.citatel;
        return zkrat(new Zlomek(citatel1 + citatel2, spolecnyJmenovatel));
    }

    public Zlomek odecist(Zlomek zlomek) {
        if (this.jmenovatel == zlomek.jmenovatel) {
            return new Zlomek(this.citatel - zlomek.citatel, this.jmenovatel);
        }
        int spolecnyJmenovatel = this.jmenovatel * zlomek.jmenovatel;
        int citatel1 = spolecnyJmenovatel / this.jmenovatel * this.citatel;
        int citatel2 = spolecnyJmenovatel / zlomek.jmenovatel * zlomek.citatel;
        return zkrat(new Zlomek(citatel1 - citatel2, spolecnyJmenovatel));
    }

    public Zlomek vynasob(Zlomek zlomek) {
        return zkrat(new Zlomek(this.citatel * zlomek.citatel, this.jmenovatel * zlomek.jmenovatel));
    }

    public Zlomek vydelit(Zlomek zlomek) {
        return zkrat(new Zlomek(this.citatel * zlomek.jmenovatel, this.jmenovatel * zlomek.citatel));
    }

    public static Zlomek zkrat(Zlomek zlomek) {
        int min = Math.min(zlomek.citatel, zlomek.jmenovatel);
        for (int i = min; i > 1; i--) {
            if (zlomek.citatel % i == 0 && zlomek.jmenovatel % i == 0) {
                return new Zlomek(zlomek.citatel / i, zlomek.jmenovatel / i);
            }
        }
        return zlomek;
    }

    public int getCitatel() {
        return citatel;
    }

    public int getJmenovatel() {
        return jmenovatel;
    }

    @Override
    public String toString() {
        return this.citatel + "/" + this.jmenovatel;
    }
}
