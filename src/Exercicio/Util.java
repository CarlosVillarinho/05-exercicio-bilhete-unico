package Exercicio;

 // import javax.swing*; (maneira antiga, fica repetinfdo -- JOptionPane.)
import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*; //(USAMOS ESSA MANEIRA PARA NAO FICAR REPETINDO -- JOptionPane. -- Static pq é metodo)
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {
    //METODOS - BANCO DE DADOS

    private BilheteUnico[] bilhete = new BilheteUnico[5];
    private int index = 0;

    public void menuPrincipal(){
        //VARIAVEIS
        int opcao = 0;
        String menu = "1. Administrador\n2. Usuario\n3. Finalizar"; //(\n, para quebrar a linha, passar para proxima)

        //REPETICAO
        do {
            //JOptionPane.showInputDialog(menu); (maneira antiga, fica repetinfdo -- JOptionPane.)
            opcao = parseInt(showInputDialog(menu));
            if(opcao < 1 || opcao > 3){
                showMessageDialog(null, "Opcao invalida.");
            }
            if (opcao == 1) {
                menuAdmin();
            }else{
                if (opcao ==2){
                menuUsuario();
                }else {

                }
            }
        } while(opcao != 3);
    }

    //METODOS PARA OS DEMAIS -- ADM E USER

    //metodo privado - ADM
    private void menuAdmin(){
        int opcao = 0;
        String menuAdmin = "MENU ADMINISTRADOR\n1. Emitir bilhete\n2. Listar bilhetes\n3. Excluir bilhete\n4. Sair";

        do{
            if(opcao == 1){
                emitirBilhete();
            }else{
                if (opcao == 2){
                    listarBilhete();
                }else{
                    if(opcao == 3){
                        //excluirBilhete();
                    }else{

                    }
                }
            }
            opcao = parseInt(showInputDialog(menuAdmin));
            if(opcao < 1 || opcao > 4){
                showMessageDialog(null, "Opcao invalida.");
            }
        }while(opcao != 4);
    }

    //metodo privado - ADM
    private void emitirBilhete(){
        String nome, perfil;
        long cpf;

        if(index < bilhete.length){
            nome = showInputDialog("Nome do usuario: ");
            perfil = showInputDialog("Perfil do usuario: ");
            cpf = parseLong(showInputDialog("CPF: "));
            bilhete[index] = new BilheteUnico(nome, perfil, cpf);
            index++;
        }else{
            showMessageDialog(null, "Procure um posto de atendimento");
        }
    }

    //metodo privado - ADM
    private void listarBilhete(){
        DecimalFormat df = new DecimalFormat("0.00");
        String aux = "";

        for(int i=0;i<index;i++){
            aux += "Numero do bilhete: " + bilhete[i].numero + "\n";
            aux += "Saldo do bilhete: " + df.format(bilhete[i].saldo) + "\n";
            aux += "Nome do usuario: " + bilhete[i].usuario.nome + "\n";
            aux += "Perfil do usuario: " + bilhete[i].usuario.perfil + "\n";
            aux += "CPF do usuario: " + bilhete[i].usuario.cpf + "\n" + "\n";
        }
        showMessageDialog(null, aux);
    }

    //metodo privado - USER
    private void menuUsuario(){
        int opcao = 0;
        String menuUsuario = "MENU USUARIO\n1. Carregar Bilhete\n2. Consultar saldo\n3. Passar na catraca \n4. Sair";

        do{
            if(opcao == 1){
                carregarBilhete();
            }else{
                if(opcao == 2){
                   consultarSaldo();
                }else{
                    if(opcao == 3){
                      passarCatraca();
                    }else{

                    }
                }
            }
            opcao = parseInt(showInputDialog(menuUsuario));
            if(opcao < 1 || opcao > 4){
                showMessageDialog(null, "Opcao invalida.");
            }
        }while(opcao != 4);
    }

    //metodo privado - USER
    private int pesquisar(){
        long cpf = parseLong(showInputDialog("CPF"));

        for(int i=0;i<index;i++){
            if(bilhete[i].usuario.cpf == cpf){
                return i;
            }
        }
        showMessageDialog(null, cpf + "nao encontrado.");
        return -1;
    }

    //metodo privado - USER
    private void carregarBilhete(){
        int indice = pesquisar();
        double valor;
        if(indice != -1){
            valor = parseDouble(showInputDialog("Valor da recarga"));
            bilhete[indice].carregar(valor);
        }
    }

    //metodo privado - USER
    private void consultarSaldo(){
        int indice = pesquisar();
        if(indice != -1){
            showMessageDialog(null, "Saldo = R$ " + bilhete[indice].consultar());
        }
    }

    //metodo privado - USER
    private void passarCatraca(){
        int indice = pesquisar();
        if(indice != -1){
            showMessageDialog(null,  bilhete[indice].passarCatraca());
        }
    }
}