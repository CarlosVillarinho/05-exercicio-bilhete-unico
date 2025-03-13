package Exercicio;

import java.util.Random;

public class Teste {
    public static void main(String[] args) {
        //VETOR
        int[] inteiros = new int[10];
        carregaNumeros(inteiros);
        imprimir(inteiros);

    }
    //METODOS
    public static void imprimir(int[] inteiros){
        for(int i=0;i< inteiros.length;i++){
            System.out.println(inteiros[i]);
        }

        for(int i : inteiros){
            System.out.println(i);
        }
    }

    public static void carregaNumeros(int[] inteiros){
        Random random = new Random();
        for(int i=0;i<inteiros.length;i++){
          inteiros[i] = random.nextInt(15);
        }
    }
}
