import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Conversor {

    public static void main(String[] args) throws IOException {

        Boolean percorrer = true;
        do {

        HashMap<Integer, String> codigoDasMoedas = new HashMap<Integer, String>();

            // Adicionando Código Das Moedas
            codigoDasMoedas.put(1, "USD");
            codigoDasMoedas.put(2, "ARS");
            codigoDasMoedas.put(3, "USD");
            codigoDasMoedas.put(4, "BRL");
            codigoDasMoedas.put(5, "ARS");
            codigoDasMoedas.put(6, "EUR");


            String do_Codigo;
            int opcaoEscolhida;
            double quantia;

            Scanner leitura = new Scanner(System.in);

            System.out.println("=======================================");
            System.out.println("Bem-vindo(a) ao conversor de moedas");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileiro");
            System.out.println("4) Real brasileiro => Dólar");
            System.out.println("5) Peso Argentino => Peso colombiano");
            System.out.println("6) Euro => Dólar");
            System.out.println("7) Sair");
            System.out.println("Escolha Uma Opção Válida (1-7)");
            System.out.println("=======================================");

            opcaoEscolhida = leitura.nextInt();

            do_Codigo = codigoDasMoedas.get(opcaoEscolhida);


                while (opcaoEscolhida < 1 || opcaoEscolhida > 7){
                    System.out.println("Por favor selecione uma opção válida (1-7)");
                    System.out.println("1) Dólar => Peso argentino");
                    System.out.println("2) Peso argentino => Dólar");
                    System.out.println("3) Dólar => Real brasileiro");
                    System.out.println("4) Real brasileiro => Dólar");
                    System.out.println("5) Peso Argentino => Peso colombiano");
                    System.out.println("6) Euro => Dólar");
                    System.out.println("7) Sair");
                    System.out.println("Escolha Uma Opção Válida");
                    System.out.println("=======================================");

                    opcaoEscolhida = leitura.nextInt();

                    do_Codigo = codigoDasMoedas.get(opcaoEscolhida);

                } if(opcaoEscolhida == 7){
                    percorrer = false;
                }else {
                    System.out.println("Insira o valor: ");

                    quantia = leitura.nextDouble();

                    // Esses preços são em relação ao Dólar como moeda base
                    double precoDolar = 1;
                    double precoPesoArgentino = 876.24;
                    double precoRealBrasileiro = 5.11;
                    double precoEuro = 1.07;

                    // Aqui é o preço de 1 peso argentino convertido em 1 peso colombiano
                    double conversao_ARS_COP = 4.47;

                    if (opcaoEscolhida == 1) {
                        double resultado = precoPesoArgentino * quantia;
                        System.out.println(quantia + " Dólar(s) é igual a " + resultado + " Peso(s) Argentino");
                    }

                    if (opcaoEscolhida == 2) {
                        double resultado = (precoDolar / precoPesoArgentino) * quantia;
                        System.out.println(quantia + " Peso(s) Argentino é igual a " + resultado + " Dólar(s)");
                    }

                    if (opcaoEscolhida == 3) {
                        double resultado = precoRealBrasileiro * quantia;
                        System.out.println(quantia + " Dólar(s) é igual a R$ " + resultado);
                    }

                    if (opcaoEscolhida == 4) {
                        double resultado = (precoDolar / precoRealBrasileiro) * quantia;
                        System.out.println("R$ " + quantia + " é igual a " + resultado + " Dólar(s)");
                    }

                    if (opcaoEscolhida == 5) {
                        double resultado = conversao_ARS_COP * quantia;
                        System.out.println(quantia + " Peso(s) Argentino é igual a " + resultado + " Peso(s) Colombiano");
                    }

                    if (opcaoEscolhida == 6) {
                        double resultado = precoEuro * quantia;
                        System.out.println(quantia + " Euro(s) é igual a " + resultado + " Dólar(s)");
                    }


                    ConsultaMoeda consultaMoeda = new ConsultaMoeda();

                    try {
                        Moeda conversao = consultaMoeda.buscaMoeda(do_Codigo);

                        GeradorDeArquivo gerador = new GeradorDeArquivo();
                        gerador.salvaJson(conversao);
                    } catch (RuntimeException | IOException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Erro !!!! Fechando a aplicação");
                    }

                    System.out.println("Você gostaria de fazer outra conversão?");
                    System.out.println("1: Sim \t Qualquer outra tecla = NÃO");
                    if (leitura.nextInt() != 1) {
                        percorrer = false;
                    }

                }
            } while (percorrer);






        System.out.println("Obrigado por usar o conversor de moeda !");
    }

}