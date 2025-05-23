//Nome: Pedro Gabriel, Gabriel Teixeira Bernardes, Rafael de Padua Oliveira
//Tema: Transportadora 
//Data: 21/05/2025

package transportadora_;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MotoristaMoto extends Motorista {
    // Atributos específicos
    private int entregas_dia;      // Número de entregas realizadas no dia
    private String zona_atuacao;   // Bairro ou região onde atua
    
    // Construtor
    public MotoristaMoto(String cnh, String placa, String nome, String telefone, Calendar DataNasc, 
                        String zona_atuacao, String cpf) {
        super(cnh, placa, nome, telefone, DataNasc, cpf);
        this.zona_atuacao = zona_atuacao;
        this.entregas_dia = 0;    // Por padrão, inicia com zero entregas no dia
    }
    
    // Métodos getters e setters
    public int getEntregas_dia() {
        return entregas_dia;
    }
    
    public void setEntregas_dia(int entregas_dia) {
        if (entregas_dia >= 0) {  // Valida se o número de entregas não é negativo
            this.entregas_dia = entregas_dia;
        }
    }
    
    public String getZona_atuacao() {
        return zona_atuacao;
    }
    
    public void setZona_atuacao(String zona_atuacao) {
        this.zona_atuacao = zona_atuacao;
    }
    
    
    // Sobrescreve o método toString da classe pai
    @Override
    public String toString() {
        // Obtém os dados da superclasse usando o método toString dela
        String dadosSuperclasse = super.toString();
        
        // Adiciona as informações específicas desta classe
        return dadosSuperclasse + "\n" +
               "Zona de Atuação: " + zona_atuacao + "\n" +
               "Entregas realizadas hoje: " + entregas_dia;
    }
}
