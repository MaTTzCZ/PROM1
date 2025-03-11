import static org.junit.jupiter.api.Assertions.*;

import com.mattz.data.SeznamZlomku;
import com.mattz.data.Zlomek;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SeznamZlomkuTest {
    static SeznamZlomku seznamZlomku;
    @BeforeEach
    public void setUp() {
        seznamZlomku = new SeznamZlomku();
        seznamZlomku.pridatZlomek(new Zlomek(1,2));
        seznamZlomku.pridatZlomek(new Zlomek(2,3));
        seznamZlomku.pridatZlomek(new Zlomek(3,4));
        seznamZlomku.pridatZlomek(new Zlomek(4,5));
    }
    @Test
    public void pridatZlomek() {
        int sizeBefore = seznamZlomku.getSize();
        Zlomek zlomek = new Zlomek(1,2);
        seznamZlomku.pridatZlomek(zlomek);
        int sizeAfter = seznamZlomku.getSize();
        assertEquals(sizeBefore + 1, sizeAfter, "Zlomek nebyl přidán");
        assertEquals(zlomek, seznamZlomku.vratZlomek(sizeBefore), "Zlomek nebyl přidán");
    }
    @Test
    public void odebratZlomek() {
        int sizeBefore = seznamZlomku.getSize();
        seznamZlomku.odebratZlomek(0);
        int sizeAfter = seznamZlomku.getSize();
        assertEquals(sizeBefore - 1, sizeAfter, "Zlomek nebyl odebrán");
    }
    @Test
    public void vratZlomek() {
        int sizeBefore = seznamZlomku.getSize();
        Zlomek zlomek = seznamZlomku.vratZlomek(0);
        int sizeAfter = seznamZlomku.getSize();
        assertEquals(sizeBefore, sizeAfter, "Velikost seznamu se změnila");
        assertEquals(1, zlomek.getCitatel(), "Byl vrácen špatný zlomek");
        assertEquals(2, zlomek.getJmenovatel(), "Byl vrácen špatný zlomek");
    }
    @Test
    public void spoctiSoucet() {
        Zlomek zlomek = seznamZlomku.spoctiSoucet();
        assertEquals(163, zlomek.getCitatel(), "Špatný čitatel");
        assertEquals(60, zlomek.getJmenovatel(), "Špatný jmenovatel");
    }
    @Test
    public void spoctiPrumer() {
        Zlomek zlomek = seznamZlomku.spoctiPrumer();
        assertEquals(163, zlomek.getCitatel(), "Špatný čitatel");
        assertEquals(240, zlomek.getJmenovatel(), "Špatný jmenovatel");
    }
}
