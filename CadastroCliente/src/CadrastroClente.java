import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CadrastroClente {
    private static Scanner input = new Scanner (System.in);
    private static ArrayList<Modelo> modelos ;
    private static Map<Modelo, Integer> carrinho ;
    public static void main(String[] args) {

        modelos = new ArrayList<>();
        carrinho = new HashMap<>();
        menu();
    }

    private static void menu () {

        System.out.println("--------------------------------------------------");
        System.out.println("-----------------Bem vindo -----------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("-----Selecione a operação que deseja Realizar-----");
        System.out.println("--------------------------------------------------");
        System.out.println("----Opção  1  Cadastrar   ------------------------");
        System.out.println("----Opção  2  Listar   ---------------------------");
        System.out.println("----Opção  3  Comprar   --------------------------");
        System.out.println("----Opção  4  Carrinho   -------------------------");
        System.out.println("----Opção  5  Sair   -----------------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");

        int option = input.nextInt();

        switch (option){
             case 1:
                 cadrastarModelos();
                 break;
             case 2:
                 listarModelos();
                 break;
             case 3:
                 comprarModelos();
                 break;
             case 4:
                 verCarriho();
                 break;
             case 5:
                 System.out.println(" Ate a proxima  |-| ");
                 System.exit(0);

             default:
                 System.out.println(" Opção invalida tente novamente ");
                 menu();
                 break;

         }
    }


    private static void  cadrastarModelos(){
        System.out.println(" Nome do Modelo   ");
        String nome = input.next();

        System.out.println(" Preço do Modelo  ");
        Double preco = input.nextDouble();


        Modelo modelo = new Modelo(nome , preco );
        modelos.add(modelo);

        System.out.println(modelo.getNome() + "Cadastrado com sucesso ");
        menu();
    }

    private static void listarModelos(){

     if (modelos.size() > 0){
         System.out.println("Lista de Modelos \n");

         for (Modelo m : modelos){
             System.out.println(m);
         }
        }else {
         System.out.println("Nunhum Modelo Cadastrado !!");
              }
          menu();
        }

     private  static  void comprarModelos() {
         if (modelos.size() > 0) {
             System.out.println("Codigo do Modelo \n");

             System.out.println("---------Produtos Disponiveis ----------");
             for (Modelo m : modelos) {
                 System.out.println(m + "\n");
             }
             int id = Integer.parseInt(input.next());
             boolean isPresnt = false;

             for (Modelo m : modelos) {
                 if (m.getId() == id) {
                     int qtb = 0;
                     try {
                         qtb = carrinho.get(m);
                         //checa se o modelo esta no carrinho
                         carrinho.put(m, qtb + 1);
                     } catch (NullPointerException e) {
                         // so se o modelo for  o primeiro no carrinho
                         carrinho.put(m, +1);
                     }

                     System.out.println(m.getNome() + "Adicionada no Carrinho");
                     isPresnt = true;

                     if (isPresnt) {
                         System.out.println("Deseja Adiconar outro Modelo ao Carrinho ?");
                         System.out.println("Digite 1 para Sim, ou 0 para Continuar");
                         int option = Integer.parseInt(input.next());

                         if (option == 1) {
                             comprarModelos();
                         } else {
                             finalizarCompra();

                         }

                     }
                 }else {
                     System.out.println("Modelo nao encontrado ");
                    menu();
                 }
             }

         }else {
             System.out.println("Não existe esse Modelo cadastrado  ");
             menu();
         }
     }

     private static void verCarriho(){

         System.out.println("------Modelos no Carrinho ------- ");
         if (carrinho.size() > 0 ){
             for (Modelo m : carrinho.keySet()) {
                 System.out.println("Modelo :" + m + "\n Quantidade :" + carrinho.get(m));

             }
         }else {
             System.out.println("Carrinho vazio  ");

         }

         menu();
     }

    private static void finalizarCompra(){

        Double valorComprado = 0.0;
        System.out.println(" Seus Modelos ");

        for (Modelo m : carrinho.keySet()){
            int qtb = carrinho.get(m);
            valorComprado +=m.getPreco() * qtb;
            System.out.println(m);
            System.out.println("Quantidade"+ qtb );
            System.out.println("------------------------");


        }
        System.out.println(" O Valor da sua compra é;" + Utils.doubleToString(valorComprado));
        carrinho.clear();
        System.out.println("Obrigado pela Confiança");
        menu();
    }

}