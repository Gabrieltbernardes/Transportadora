//Nome: Pedro Gabriel, Gabriel Teixeira Bernardes, Rafael de Padua Oliveira
//Tema: Transportadora 
//Data: 21/05/2025

package transportadora_;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;


public class Cliente extends Pessoa_ {    // Atributos 
    private String cnpj;            
    private String endereco;        
    private boolean prioridade;

    // Construtor 
    public Cliente(String nome, String telefone, Calendar dataNasc, String endereco) {
        super(nome, telefone, dataNasc); // Chamada ao construtor da superclasse Pessoa_
        this.endereco = endereco;        // Define o endereço informado
        this.prioridade = false;         // Define padrão como não prioritário
    }

    // Métodos getters e setters
    public String getCnpj() {
        return cnpj;
    }

    // Define o CNPJ do cliente com validação básica (14 dígitos numéricos)
    public void setCnpj(String cnpj) {
        if (cnpj != null && cnpj.matches("\\d{14}")) { // Verifica se o CNPJ tem 14 números
            this.cnpj = cnpj; // CNPJ válido, atribui ao atributo
        } else {
            // Exibe mensagem de erro se o CNPJ estiver inválido
            JOptionPane.showMessageDialog(null,
                "CNPJ inválido! Deve conter exatamente 14 dígitos numéricos.",
                "ERRO!!!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isPrioridade() {
            return prioridade;
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }

    // Método toString para exibir os dados do cliente formatados
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Define o formato da data
        String dataFormatada = sdf.format(getDataNasc().getTime()); // Formata a data de nascimento

        // Retorna a string com todos os dados formatados
        return "=== Cliente ===\n" +
               "Nome: " + getNome() + "\n" +
               "Telefone: " + getTelefone() + "\n" +
               "Data de Nascimento: " + dataFormatada + "\n" +
               "Idade: " + getIdade() + " anos\n" +
               "CNPJ: " + (cnpj != null ? cnpj : "Não informado") + "\n" +
               "Endereço: " + endereco + "\n" +
               "Cliente Prioritário: " + (prioridade ? "Sim" : "Não");
    }

}//FIM CLASSE PESSOA
