import misc.Funcionario;
import entity.Ponto;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class PontoJUnitTest {
    
    public PontoJUnitTest() {
    }
    
    // registrarEntrada
    @Test
    public void testRegEntradaOk() {
        Funcionario f = new Funcionario();
        Ponto p = new Ponto(f);
        assertTrue(p.registrarEntrada(new Date()));
    }
    
    @Test (expected = NullPointerException.class)
    public void testRegEntradaNull() {
        Funcionario f = new Funcionario();
        Ponto p = null;
        p.registrarEntrada(new Date());
    }
    
    @Test
    public void testRegEntradaNok() {
        Funcionario f = null;
        Ponto p = new Ponto(f);
        assertFalse(p.registrarEntrada(new Date()));
    }
    
    // registrarSaida
    @Test
    public void testRegSaidaOk() {
        Funcionario f = new Funcionario();
        Ponto p = new Ponto(f);
        assertTrue(p.registrarSaida(new Date()));
    }
    
    @Test (expected = NullPointerException.class)
    public void testRegSaidaNull() {
        Funcionario f = new Funcionario();
        Ponto p = null;
        p.registrarSaida(new Date());
    }
    
    @Test
    public void testRegSaidaNok() {
        Funcionario f = null;
        Ponto p = new Ponto(f);
        assertFalse(p.registrarSaida(new Date()));
    }
}
