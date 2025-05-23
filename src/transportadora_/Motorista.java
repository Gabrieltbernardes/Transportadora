//Nome: Pedro Gabriel, Gabriel Teixeira Bernardes, Rafael de Padua Oliveira
//Tema: Transportadora 
//Data: 21/05/2025

package transportadora_;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import primeirojava.Pessoa;

public class Motorista extends Pessoa_{
    //Atributos
    private String cnh;    private String placa;
    private String cpf;
    
    //Construtor
    public Motorista(String cnh, String placa, String nome, String telefone, Calendar DataNasc, String cpf) {
        super(nome, telefone, DataNasc);
        this.cnh = cnh;
        this.placa = placa;
        this.cpf = cpf; 
    }
    
    //Gets e Sets
    public String getCnh() {
        return cnh;
    }
    
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    // Método auxiliar: verifica se motorista está pronto para dirigir
    public boolean prontoParaDirigir() {
        return (cnh != null && !cnh.isEmpty()) &&  //isEmpy for verdadeiro a string esta vazia
               (placa != null && !placa.isEmpty());
    }
      public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {

        this.cpf = cpf;    
    } 
    
    // Método estático para validar o CPF e mostrar mensagens de erro
    public static String validarCPF() {
        String cpf;
        int statusCpf;
        do {
            cpf = JOptionPane.showInputDialog("Digite o CPF:");
            if(cpf == null) return null; // Usuário cancelou
            
            statusCpf = Pessoa.validaCpf(cpf);
            switch(statusCpf){
                case 1: JOptionPane.showMessageDialog(null,
                        "CPF inválido! Número de dígitos diferente de 11.",
                        "ERRO!!!", JOptionPane.ERROR_MESSAGE);
                    break;
                case 2: JOptionPane.showMessageDialog(null,
                        "CPF inválido! Presença de caractere não numérico.",
                        "ERRO!!!", JOptionPane.ERROR_MESSAGE);
                    break;
                case 3: JOptionPane.showMessageDialog(null,
                        "CPF inválido! Dígitos todos iguais.",
                        "ERRO!!!", JOptionPane.ERROR_MESSAGE);
                    break;
                case 4: JOptionPane.showMessageDialog(null,
                        "CPF inválido! Dígitos verificadores não conferem.",
                        "ERRO!!!", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while(statusCpf != 0);
        return cpf;
    }
    
    //toString
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = sdf.format(getDataNasc().getTime());

        return "=== Motorista ===\n" +
               "Nome: " + getNome() + "\n" +
               "Telefone: " + getTelefone() + "\n" +
               "CPF: " + cpf + "\n" +
               "Data de Nascimento: " + dataFormatada + "\n" +
               "Idade: " + getIdade() + " anos\n" +
               "CNH: " + cnh + "\n" +
               "Placa do Veículo: " + placa;
    }
    
}//FIM MOTORISTA
