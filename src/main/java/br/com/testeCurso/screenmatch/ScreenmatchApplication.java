package br.com.testeCurso.screenmatch;

import br.com.testeCurso.screenmatch.model.DadosEpsodio;
import br.com.testeCurso.screenmatch.model.DadosSerie;
import br.com.testeCurso.screenmatch.model.DadosTemporada;
import br.com.testeCurso.screenmatch.service.ConsumoApi;
import br.com.testeCurso.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi() ;
		var json= consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&apikey=85e9f2b9&");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados=conversor.obterDados(json,DadosSerie.class);
		System.out.println(dados);
		json=consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=85e9f2b9&");
		DadosEpsodio dadosEpsodio=conversor.obterDados(json,DadosEpsodio.class);
		System.out.println(dadosEpsodio);
		json=consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&apikey=85e9f2b9&");

		List<DadosTemporada> temporadas = new ArrayList();
 		for(int i=1; i <=dados.totalTeporadas();i++){
		json=consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&season="+i+"&apikey=85e9f2b9&");
		DadosTemporada dadosTemporada = conversor.obterDados(json,DadosTemporada.class);
		temporadas.add(dadosTemporada);
	}
	temporadas.forEach(System.out::println);
	}
}
