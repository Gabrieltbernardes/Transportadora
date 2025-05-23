//Nome: Pedro Gabriel, Gabriel Teixeira Bernardes, Rafael de Padua Oliveira
//Tema: Transportadora 
//Data: 21/05/2025

package transportadora_;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public abstract class Pessoa_ {
    //Atributos
    private String nome;
    private String telefone;
    private Calendar DataNasc;
    
    
    //Construtor
    public Pessoa_(String nome, String telefone, Calendar DataNasc) {
        this.nome = nome;
        this.telefone = telefone;
        this.DataNasc = DataNasc;
    }
    
    //Gets e sets
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Calendar getDataNasc() {
        return DataNasc;
    }
    public void setDataNasc(int dia, int mes, int ano) {
        this.DataNasc.set(ano, mes-1, dia);
    }
    
    //Metodos Auxiliares
    public int getIdade() {
        Calendar hoje = Calendar.getInstance();
        int idade = hoje.get(Calendar.YEAR) - DataNasc.get(Calendar.YEAR);

        // Ajuste caso a data de aniversário ainda não tenha ocorrido neste ano
        if (hoje.get(Calendar.DAY_OF_YEAR) < DataNasc.get(Calendar.DAY_OF_YEAR)) {
            idade--;
        }

        return idade;
    }
    
    //toString    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = sdf.format(DataNasc.getTime());

        return "Nome: " + nome +
               "\nTelefone: " + telefone +
               "\nData de Nascimento: " + dataFormatada +
               "\nIdade: " + getIdade() + " anos";
    }
    
}//FIM PESSOA
