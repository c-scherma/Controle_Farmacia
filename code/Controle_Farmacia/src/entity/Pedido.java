package entity;

import aux.Medicamento;
import aux.ClienteControlado;
import aux.Cliente;
import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    private int pedidoID;
    private ArrayList<Medicamento> medicamentos;
    private Cliente cliente;
    private String enderecoEntrega;
    private String formaPagamento;
    private Date dataPagamento;
    private float total = 0;
    private String status = "ABERTO";
    
    // 1
    public void fecharPedido() {
        if(medicamentos != null && medicamentos.size() > 0) {
            for(Medicamento m : medicamentos)
            {
                this.total += m.getValor();
            }
            this.status = "FECHADO";
        }
    }
    
    // 2
    public void pagarPedido() {
        if(this.status.equals("FECHADO"))
        {
            dataPagamento = new Date();
            this.status = "PAGO";
        }
    }
    
    // 3
    public boolean conferirCpfCliente(String cpf) {
        return cliente.getCpf().equals(cpf);
    }
    
    // 4
    public boolean conferirCrmMedico(String crm) {
        if(cliente instanceof ClienteControlado)
        {
            return ((ClienteControlado)cliente).getCrmMedico().equals(crm);
        }
        else
        {
            return false;
        }
    }

    //---------------------
    // Getters and Setters
    //---------------------
    
    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
