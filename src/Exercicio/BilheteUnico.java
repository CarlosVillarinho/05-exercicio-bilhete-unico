package Exercicio;

import java.util.Random;

public class BilheteUnico {

    //ATRIBUTOS
    long numero;
    static final double TARIFA = 5.20;
    double saldo;
    Usuario usuario;

    //CONSTRUTOR
    public BilheteUnico(String nome, String perfil, double cpf){
        Random random = new Random();
        numero = random.nextLong(1000, 10000);
        usuario = new Usuario((long) cpf, nome, perfil);
    }

    //METODO PARA CARREGAR O BILHETE
    public double carregar(double valor){
        saldo += valor;
        return saldo;
    }

    //METOFO PARA CONSULTAR O SALDO DO BILHETE
    public double consultar(){
        return saldo;
    }

    //METODO PARA PASSAR NA CATRACA
    public String passarCatraca(){
       double debito = TARIFA / 2;
       if(usuario.perfil.equalsIgnoreCase("comum")){
           debito = TARIFA;
       }
       if(saldo >= debito){
           saldo -= debito;
           return "Catraca liberada";
       }
       return "Saldo insuficiente";
    }
}
