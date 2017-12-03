package entity;
public class Fornecedor {
    
    private String nome;
    private String numCnpj;
    private String endereco;
    private String email;
    private String telefone;
    private String representantes;
    private String telRepresentantes;
    
    public Fornecedor() {
        
    }
    
    public Fornecedor(String nome, String numCnpj, String endereco, 
                      String email, String telefone) {
        this.nome = nome;
        this.numCnpj = numCnpj;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }
    
    // 5
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    public boolean validarCnpj(String cnpj) {
      if ((cnpj==null)||(cnpj.length()!=14)) return false;

      Integer digito1 = calcularDigito(cnpj.substring(0,12), pesoCNPJ);
      Integer digito2 = calcularDigito(cnpj.substring(0,12) 
              + digito1, pesoCNPJ);
      return cnpj.equals(cnpj.substring(0,12) + digito1.toString() 
              + digito2.toString());
    }
    
    // 6
    public boolean validarCamposObrigatorios() {
        return (nome.length() > 0 &&
                numCnpj.length() > 0 &&
                endereco.length() > 0 &&
                email.length() > 0 &&
                telefone.length() > 0 &&
                representantes.length() > 0 &&
                telRepresentantes.length() > 0);
    }
    
    // 7
    public boolean validarTelefone(String num) {
        return num.matches(".((10)|([1-9][1-9]).)\\s9?[6-9][0-9]{3}-[0-9]{4}")
               || num.matches(".((10)|([1-9][1-9]).)\\s[2-5][0-9]{3}-[0-9]{4}");
    }
    
    //--------------------
    // Auxiliar functions
    //--------------------
    
    private static int calcularDigito(String str, int[] peso) {
      int soma = 0;
      for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
         digito = Integer.parseInt(str.substring(indice,indice+1));
         soma += digito*peso[peso.length-str.length()+indice];
      }
      soma = 11 - soma % 11;
      return soma > 9 ? 0 : soma;
    }
    
    //---------------------
    // Getters ans Setters
    //---------------------

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumCnpj() {
        return numCnpj;
    }

    public void setNumCnpj(String numCnpj) {
        this.numCnpj = numCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRepresentantes() {
        return representantes;
    }

    public void setRepresentantes(String representantes) {
        this.representantes = representantes;
    }

    public String getTelRepresentantes() {
        return telRepresentantes;
    }

    public void setTelRepresentantes(String telRepresentantes) {
        this.telRepresentantes = telRepresentantes;
    }
    
    
}
