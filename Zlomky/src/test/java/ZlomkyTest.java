import com.mattz.data.Zlomek;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ZlomkyTest {
    @Test
    public void testScitani() {
        Zlomek zlomek1 = new Zlomek(4, 5);
        Zlomek zlomek2 = new Zlomek(2, 7);
        Zlomek zlomek3 = zlomek1.secist(zlomek2);
        assertEquals(38, zlomek3.getCitatel(), "Špatný čitatel");
        assertEquals(35, zlomek3.getJmenovatel(), "Špatný jmenovatel");
    }
    @Test
    public void testOdcitani() {
        Zlomek zlomek1 = new Zlomek(4, 5);
        Zlomek zlomek2 = new Zlomek(2, 7);
        Zlomek zlomek3 = zlomek1.odecist(zlomek2);
        assertEquals(18, zlomek3.getCitatel(), "Špatný čitatel");
        assertEquals(35, zlomek3.getJmenovatel(), "Špatný jmenovatel");
    }
    @Test
    public void testNasobeni() {
        Zlomek zlomek1 = new Zlomek(4, 5);
        Zlomek zlomek2 = new Zlomek(2, 7);
        Zlomek zlomek3 = zlomek1.vynasob(zlomek2);
        assertEquals(8, zlomek3.getCitatel(), "Špatný čitatel");
        assertEquals(35, zlomek3.getJmenovatel(), "Špatný jmenovatel");
    }
    @Test
    public void testDeleni() {
        Zlomek zlomek1 = new Zlomek(4, 5);
        Zlomek zlomek2 = new Zlomek(2, 7);
        Zlomek zlomek3 = zlomek1.vydelit(zlomek2);
        assertEquals(14, zlomek3.getCitatel(), "Špatný čitatel");
        assertEquals(5, zlomek3.getJmenovatel(), "Špatný jmenovatel");
    }
    @Test
    public void testKraceni() {
        Zlomek zlomek1 = new Zlomek(100, 24);
        Zlomek zlomek2 = Zlomek.zkrat(zlomek1);
        assertEquals(25, zlomek2.getCitatel(), "Špatný čitatel");
        assertEquals(6, zlomek2.getJmenovatel(), "Špatný jmenovatel");
    }
}
