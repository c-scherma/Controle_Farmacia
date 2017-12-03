import entity.Fornecedor;
import org.junit.Test;
import static org.junit.Assert.*;
public class FornecedorJUnitTest {
    
    public FornecedorJUnitTest() {
    }
    
    // validarCnpj
    @Test
    public void testValidarCnpjOk() {
        Fornecedor f = new Fornecedor("fornecedor", 
                "", "", "", "");
        assertTrue(f.validarCnpj("00776574000741"));
    }
    
    @Test (expected = NullPointerException.class)
    public void testValidarCnpjNull() {
        Fornecedor f = null;
        f.validarCnpj("00776574000741");
    }
    
    @Test
    public void testValidarCnpjNok() {
        Fornecedor f = new Fornecedor("fornecedor", 
                "", "", "", "");
        assertFalse(f.validarCnpj("13642634756318"));
    }
    
    // validarCamposObrigatorios
    @Test
    public void testValidarCamposOk() {
        Fornecedor f = new Fornecedor("fornecedor", 
                "test", "test", "test", "test");
        f.setRepresentantes("test");
        f.setTelRepresentantes("test");
        assertTrue(f.validarCamposObrigatorios());
    }
    
    @Test (expected = NullPointerException.class)
    public void testValidarCamposNull() {
        Fornecedor f = null;
        f.validarCamposObrigatorios();
    }
    
    @Test
    public void testValidarCamposNok() {
        Fornecedor f = new Fornecedor("fornecedor", 
                "", "", "", "");
        assertFalse(f.validarCamposObrigatorios());
    }
    
    // validarTelefone
    @Test
    public void testValidarTelOk() {
        Fornecedor f = new Fornecedor();
        assertTrue(f.validarTelefone("(11) 98877-6655"));
    }
    
    @Test (expected = NullPointerException.class)
    public void testValidarTelNull() {
        Fornecedor f = null;
        f.validarTelefone("(11) 98877-6655");
    }
    
    @Test
    public void testValidarTelNok() {
        Fornecedor f = new Fornecedor();
        assertFalse(f.validarTelefone("(51)a98877-6655"));
    }
    
}
