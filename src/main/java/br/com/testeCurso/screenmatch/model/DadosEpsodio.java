package br.com.testeCurso.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpsodio(
        @JsonAlias("Title") String titulo,
        @JsonAlias("imdbRating")  String avaliacao,
        @JsonAlias("Released") String dataLancamento

) {
}
