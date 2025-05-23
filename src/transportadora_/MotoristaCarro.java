//Nome: Pedro Gabriel, Gabriel Teixeira Bernardes, Rafael de Padua Oliveira
//Tema: Transportadora 
//Data: 21/05/2025

package transportadora_;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MotoristaCarro extends Motorista {
    // Atributos específicos
    private String rota_designada;    // Lista de pontos/paradas ou nome da rota
    private double capacidade_carga;  // Peso ou volume máximo que o carro pode levar (em kg)
    
    // Construtor
    public MotoristaCarro(String cnh, String placa, String nome, String telefone, Calendar DataNasc,
                        String rota_designada, double capacidade_carga, String cpf) {
        super(cnh, placa, nome, telefone, DataNasc, cpf);
        this.rota_designada = rota_designada;
        this.capacidade_carga = capacidade_carga;
    }
    
    // Métodos getters e setters
    public String getRota_designada() {
        return rota_designada;
    }
    
    public void setRota_designada(String rota_designada) {
        this.rota_designada = rota_designada;
    }
    
    public double getCapacidade_carga() {
        return capacidade_carga;
    }
    
    public void setCapacidade_carga(double capacidade_carga) {
        this.capacidade_carga = capacidade_carga;

    }

    // Sobrescreve o método toString da classe pai
    @Override
    public String toString() {
        // Obtém os dados da superclasse usando o método toString dela
        String dadosSuperclasse = super.toString();
        
        // Adiciona as informações específicas desta classe
        return dadosSuperclasse + "\n" +
               "Rota Designada: " + rota_designada + "\n" +
               "Capacidade de Carga: " + capacidade_carga + " kg";
    }
}
