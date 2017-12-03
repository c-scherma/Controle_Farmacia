import aux.Cliente;
import aux.ClienteControlado;
import aux.Medicamento;
import entity.Pedido;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class PedidoJUnitTest {
    
    public PedidoJUnitTest() {
    }    
    
    // fecharPedido
    @Test
    public void testFecharPedidoOk() {
        ArrayList<Medicamento> meds = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Medicamento med = new Medicamento();
            med.setValor(10);
            meds.add(med);
        }
        Pedido ped = new Pedido();
        ped.setMedicamentos(meds);
        ped.fecharPedido();
        assertTrue(ped.getTotal() == 100 && ped.getStatus().equals("FECHADO")); 
    }
    
    @Test(expected = NullPointerException.class)
    public void testFecharPedidoNull() {
        ArrayList<Medicamento> meds = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Medicamento med = new Medicamento();
            med.setValor(10);
            meds.add(med);
        }
        Pedido ped = null;
        ped.setMedicamentos(meds);
        ped.fecharPedido();
    }
    
    @Test
    public void testFecharPedidoNok() {
        ArrayList<Medicamento> meds = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            Medicamento med = new Medicamento();
            med.setValor(10);
            meds.add(med);
        }
        Pedido ped = new Pedido();
        ped.setMedicamentos(meds);
        ped.fecharPedido();
        assertFalse(ped.getTotal() == 100 && ped.getStatus().equals("FECHADO"));
    }
    
    // pagarPedido
    @Test
    public void testPagarPedidoOk() {
        Pedido ped = new Pedido();
        Medicamento med = new Medicamento();
        med.setValor(10);
        ArrayList<Medicamento> meds = new ArrayList<>();
        meds.add(med);
        ped.setMedicamentos(meds);
        ped.fecharPedido();
        ped.pagarPedido();
        assertTrue(ped.getStatus().equals("PAGO"));
    }
    
    @Test(expected = NullPointerException.class)
    public void testPagarPedidoNull() {
        Pedido ped = null;
        ped.fecharPedido();
        ped.pagarPedido();
    }
    
    @Test
    public void testPagarPedidoNok() {
        Pedido ped = new Pedido();
        ped.pagarPedido();
        assertTrue(ped.getStatus().equals("ABERTO"));
    }
    
    //conferirCpfCliente
    @Test
    public void testConferirCpfOk() {
        Pedido ped = new Pedido();
        Cliente cli = new Cliente("Cliente", "End", "email",
                "11122233344", "", "", new Date());
        ped.setCliente(cli);
        assertTrue(ped.conferirCpfCliente("11122233344"));
    }
    
    @Test(expected = NullPointerException.class)
    public void testConferirCpfNull() {
        Pedido ped = new Pedido();
        Cliente cli = null;
        ped.setCliente(cli);
        ped.conferirCpfCliente("11122233344");
    }
    
    @Test
    public void testConferirCpfNok() {
        Pedido ped = new Pedido();
        Cliente cli = new Cliente("Cliente", "End", "email",
                "11122233344", "", "", new Date());
        ped.setCliente(cli);
        assertFalse(ped.conferirCpfCliente("55566677788"));
    }
    
    //conferirCrmMedico
    @Test
    public void testConferirCrmOk() {
        Pedido ped = new Pedido();
        ClienteControlado cli = new ClienteControlado("Cliente", "End", "email",
                "", "", "", new Date(), "", "112233-4");
        ped.setCliente(cli);
        assertTrue(ped.conferirCrmMedico("112233-4"));
    }
    
    @Test
    public void testConferirCrmNull() {
        Pedido ped = new Pedido();
        ClienteControlado cli = null;
        ped.setCliente(cli);
        assertFalse(ped.conferirCrmMedico("112233-4"));
    }
    
    @Test
    public void testConferirCrmNok() {
        Pedido ped = new Pedido();
        ClienteControlado cli = new ClienteControlado("Cliente", "End", "email",
                "", "", "", new Date(), "", "112233-4");
        ped.setCliente(cli);
        assertFalse(ped.conferirCrmMedico("556677-8"));
    }
}
