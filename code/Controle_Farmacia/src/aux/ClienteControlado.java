package aux;

import aux.Cliente;
import java.util.Date;

public class ClienteControlado extends Cliente {
    private String nomeMedico;
    private String crmMedico;
    
    public ClienteControlado(String nome, String endereco, String email, 
                             String cpf, String telefone, String convenio, 
                           Date dataNasc, String nomeMedico, String crmMedico) {
        super(nome, endereco, email, cpf, telefone, convenio, dataNasc);
        this.nomeMedico = nomeMedico;
        this.crmMedico = crmMedico;
    }
    
    //---------------------
    // Getters and Setters
    //---------------------

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(String crmMedico) {
        this.crmMedico = crmMedico;
    }
       
}
