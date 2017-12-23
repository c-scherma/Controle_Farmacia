package entity;

import misc.Funcionario;
import java.util.Date;

public class Ponto {
    private Funcionario funcionario;
    private Date horaEntrada;
    private Date horaSaida;
    
    public Ponto(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    // 8
    public boolean registrarEntrada(Date horario) {
        if(horario == null || this.funcionario == null) return false;
        if(horario.equals(this.horaSaida)) return false;
        this.setHoraEntrada(horario);
        return true;
    }
    
    // 9
    public boolean registrarSaida(Date horario) {
        if(horario == null || this.funcionario == null) return false;
        if(horario.equals(this.horaEntrada)) return false;
        this.setHoraSaida(horario);
        return true;
    }
    
    //---------------------
    // Getters and Setters
    //---------------------

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Date horaSaida) {
        this.horaSaida = horaSaida;
    }
    
    
}
