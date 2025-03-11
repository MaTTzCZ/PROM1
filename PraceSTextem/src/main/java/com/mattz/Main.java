package com.mattz;

import com.mattz.data.analysis.Analyzer;
import com.mattz.data.analysis.CharAnalyzer;
import com.mattz.data.analysis.WordAnalyzer;

import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Analyzer a = new WordAnalyzer();
        Analyzer b = new CharAnalyzer();
        Map<String, Integer> map1 =  a.analyze("FIM UHK byla založena roku 1993, kdy začínala se 78 studenty. Nyní má na svém kontě již přes 9 tisíc absolventů. Fakulta svým studentům nabízí příjemné, moderní a špičkově technologicky vybavené prostředí. Studium probíhá v oborech informatika, management, ekonomie, cestovní ruch a datová věda. Důraz je kladen na inteligentní systémy, využívání chytrých přístupů a technologií v manažerském rozhodování a Data Science. Na fakultu každoročně zavítá na 250 zahraničních studentů. Fakulta je velmi oblíbená i díky zcela nadstandardním možnostem studijních pobytů a stáží na partnerských univerzitách v Evropě, Asii a v Americe.\n" +
                "\n" +
                "Zaměstnanci fakulty prosazují individuální a přátelský přístup ke studentům a posilují také kolektivní identitu. Ne nadarmo byla fakulta opakovaně zvolena Fakultou roku mezi veřejnými fakultami s ekonomickým zaměřením.\n" +
                "\n" +
                "Nedílnou aktivitou fakulty je výzkumná činnost a spolupráce s aplikovanou sférou. Absolventi FIM UHK nacházejí široké uplatnění v soukromých i veřejných institucích. Součástí fakulty je Institut dalšího vzdělávání, který pořádá řadu odborných kurzů a školení pro instituce, firmy i jednotlivce.");
        for(String s : map1.keySet()) {
            System.out.println(s + " " + map1.get(s));
        }
        Map<String, Integer> map2 =  b.analyze("FIM UHK byla založena roku 1993, kdy začínala se 78 studenty. Nyní má na svém kontě již přes 9 tisíc absolventů. Fakulta svým studentům nabízí příjemné, moderní a špičkově technologicky vybavené prostředí. Studium probíhá v oborech informatika, management, ekonomie, cestovní ruch a datová věda. Důraz je kladen na inteligentní systémy, využívání chytrých přístupů a technologií v manažerském rozhodování a Data Science. Na fakultu každoročně zavítá na 250 zahraničních studentů. Fakulta je velmi oblíbená i díky zcela nadstandardním možnostem studijních pobytů a stáží na partnerských univerzitách v Evropě, Asii a v Americe.\n" +
                "\n" +
                "Zaměstnanci fakulty prosazují individuální a přátelský přístup ke studentům a posilují také kolektivní identitu. Ne nadarmo byla fakulta opakovaně zvolena Fakultou roku mezi veřejnými fakultami s ekonomickým zaměřením.\n" +
                "\n" +
                "Nedílnou aktivitou fakulty je výzkumná činnost a spolupráce s aplikovanou sférou. Absolventi FIM UHK nacházejí široké uplatnění v soukromých i veřejných institucích. Součástí fakulty je Institut dalšího vzdělávání, který pořádá řadu odborných kurzů a školení pro instituce, firmy i jednotlivce.");
        for(String s : map2.keySet()) {
            System.out.println(s + " " + map2.get(s));
        }
        LocalDate date = LocalDate.now();
        System.out.println(date);

    }
}