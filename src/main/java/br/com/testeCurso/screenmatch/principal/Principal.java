package br.com.testeCurso.screenmatch.principal;

import br.com.testeCurso.screenmatch.service.ConsumoApi;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System);
    private ConsumoApi consumo = new ConsumoApi();
    private final String ENDERECO="https://omdbapi.com/?t=";
    private final String API_KEY="&apikey=85e9f2b9&\";

    public void exibeManu(){
        System.out.println("Digite o nome da séria");

        var nome = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO+nome.replace(" ","+")+API_KEY);

        //"https://omdbapi.com/?t=gilmore+girls&apikey=85e9f2b9&");
        //

    }
}
