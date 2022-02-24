
import java.io.IOException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


import Classe.Produto;
import Classe.Venda;

public class App {
    
    public static void main(String[] args) throws InterruptedException, IOException {

        

        
       
        int opcao;
        Scanner in = new Scanner(System.in);
        ArrayList <Produto> objetos = new ArrayList<>();
        ArrayList <Venda> vendas = new ArrayList<>();

        do 
        {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Incluir produto");
            System.out.println("2 - Consultar produtos");
            System.out.println("3 - Listagem de produtos ");
            System.out.println("4 - Realizar venda");
            System.out.println("5 - Vendas por período - detalhado");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = in.nextInt();
            in.nextLine();

            if (opcao == 1) 
            {

                System.out.println("\nCadastro de produto: ");
                System.out.println("------------------------");

                System.out.println("\nNome: ");
                String nome = in.nextLine();

                System.out.println("\nCódigo: ");
                String codigo = in.nextLine();

                System.out.println("\nValor: ");
                double valor = in.nextDouble();
                in.nextLine();

                System.out.println("\nQuantidade em estoque: ");
                int qtddEstoque = in.nextInt();
                in.nextLine();

                //------------------------------------------------------------

                Produto obj1 = new Produto(nome, codigo, valor, qtddEstoque);

                objetos.add(obj1);

                voltarMenu(in);
                continue;

            
            } 
            
            else if (opcao == 2) 
            {
                 
                System.out.println("Código para consulta: ");
                String codig = in.nextLine();

                
                for (int i = 0; i < objetos.size(); i++) {
              
                    if(codig.equals(objetos.get(i).getCodigo())){


                        System.out.println("\nO produto é: \n\n"+objetos.get(i));
                    }

                }

                voltarMenu(in);
            
            } 

            else if (opcao == 3) 
            {
                System.out.println("\n----------- PRODUTOS CADASTRADOS: -----------\n "); 
                double conta = 0;
                double preco = 0;
                int estoque = 0;
                double resp;
                
              
                for (int i = 0; i < objetos.size(); i++) 
                {

                    estoque = estoque + objetos.get(i).getQtddEstoque();
                    preco = preco + objetos.get(i).getValor();
                    conta = conta + objetos.get(i).getValor();
                    resp = conta / estoque;
                   
                    System.out.println("\nO Produto é\n: " +objetos+ "." );
                    System.out.println("\nA média de todos os Produtos é: $" +resp+ "." );
                    System.out.println("\nA máxima de todos os Produtos é: $" +preco * estoque + "." );
                    System.out.println("\nO mínimo de todos os Produto é: $" +preco+ ".\n\n" );
                }
                
                
                voltarMenu(in);
            } 
            
            else if (opcao == 4) 
            {
                
                System.out.println("----------- VENDA -----------");

                System.out.println("Código do produto: ");
                String pdtVend = in.nextLine();

                System.out.println("Quantidade em unidade: ");
                int qtddVend = in.nextInt();
                in.nextLine();

                System.out.println("Data : dd/mm/aaaa");
                int dtVenda = in.nextInt();
                in.nextLine();

            

                
                //int Estoq = 0;
                for (int i = 0; i < objetos.size(); i++) {

                    objetos.get(i).subtrairEstoque(qtddVend);

                    if (qtddVend > objetos.get(i).getQtddEstoque()){
                    
                        System.out.println("\nPRODUTOS INSUFICIENTES");
                    }

                    if(pdtVend.equals(objetos.get(i).getCodigo()) && objetos.get(i).getQtddEstoque() >= qtddVend){
                        
                    }if (i == -1){
                
                        System.out.println("\nPRODUTO NÃO ENCONTRADO");

                    }

                 /*       
                        Estoq = objetos.get(i).getQtddEstoque;
                        venda = Estoq - comp;
                */
                        System.out.println("Vendido " +qtddVend+" unidades de "+objetos.get(i).getNome());
                        System.out.println("\n ESTOQUE \n");
                        System.out.println("Ainda em estoque: " +objetos.get(i).getQtddEstoque());
                
                        
                

                            Venda v = new Venda(qtddVend, objetos.get(i), dtVenda);
                            
                            vendas.add(v);
                        }
                    
                    
                    voltarMenu(in);
            }


            else if (opcao == 5) 
            {
                
                
                
                System.out.println("RELATÓRIO DE VENDAS");
                System.out.println("Informe o período de emissão: ");
                System.out.println("------------------------------");

                System.out.println("Data inicial: dd/mm/aaaa: ");
                String dataI = in.nextLine();
                System.out.println("Data final: dd/mm/aaaa: ");
                String dataF = in.nextLine();
                
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
                LocalDate datai = LocalDate.parse(dataI, formato);     
                LocalDate dataf = LocalDate.parse(dataF, formato); 
                
                System.out.println(formato.format(datai));
                System.out.println(formato.format (dataf));
                
                
                Calendar now = Calendar.getInstance();
                LocalDateTime localDateTime = toLocalDateTime(now);
                System.out.println(localDateTime);
                
                for (int i = 0; i < vendas.size(); i++) {
                

                    if (localDateTime.equals(vendas.get(i).getDtVenda()))
                    {
                        System.out.println ("Relatorio feito no periodo do: " + vendas.get(i).getDtVenda());
                    } else 
                    {
                        System.out.println("Não há dados para emissão do relatório.");
                    }

                   
                
            }

        }
            
        } while (opcao != 0);

    }

    

    private static LocalDateTime toLocalDateTime(Calendar now) {
        return null;
    }



    private static void voltarMenu(Scanner in) throws InterruptedException, IOException 
    {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();
    }
            


}

