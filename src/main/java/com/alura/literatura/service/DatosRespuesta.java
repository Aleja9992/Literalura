package com.alura.literatura.service;



import com.alura.literatura.dto.DatosLibro;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosRespuesta(

        @JsonAlias("results")
        List<DatosLibro> results

) {
}