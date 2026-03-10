package com.alura.literatura.principal;

import com.alura.literatura.dto.DTOConvierteDatos;
import com.alura.literatura.dto.DatosLibro;
import com.alura.literatura.model.Autor;
import com.alura.literatura.model.Libro;
import com.alura.literatura.repository.AutorRepository;
import com.alura.literatura.repository.LibroRepository;
import com.alura.literatura.service.ConsumoAPI;
import com.alura.literatura.service.DatosRespuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private DTOConvierteDatos conversor = new DTOConvierteDatos();

    private final String URL = "https://gutendex.com/books/?search=";

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public void mostrarMenu(){

        int opcion = -1;

        while(opcion != 0){

            System.out.println("""
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un año
                    5 - Listar libros por idioma
                    0 - Salir
                    """);

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch(opcion){

                case 1:
                    buscarLibro();
                    break;

                case 2:
                    listarLibros();
                    break;

                case 3:
                    listarAutores();
                    break;

                case 4:
                    autoresVivos();
                    break;

                case 5:
                    librosPorIdioma();
                    break;
            }
        }
    }

    private void buscarLibro(){

        System.out.println("Escriba el nombre del libro");

        String titulo = teclado.nextLine();

        String json = consumo.obtenerDatos(URL + titulo.replace(" ", "+"));

        DatosRespuesta datos = conversor.obtenerDatos(json, DatosRespuesta.class);

        Optional<DatosLibro> libroBuscado = datos.results().stream().findFirst();

        if(libroBuscado.isEmpty()){
            System.out.println("Libro no encontrado");
            return;
        }

        DatosLibro datosLibro = libroBuscado.get();

        // verificar si el libro ya existe
        Optional<Libro> libroExistente = libroRepository.findByTitulo(datosLibro.title());

        if(libroExistente.isPresent()){
            System.out.println("El libro ya está registrado en la base de datos.");
            return;
        }

        String nombreAutor = datosLibro.authors().get(0).name();

        // verificar si el autor ya existe
        Optional<Autor> autorExistente = autorRepository.findByNombre(nombreAutor);

        Autor autor;

        if(autorExistente.isPresent()){
            autor = autorExistente.get();
        } else {

            autor = new Autor(
                    nombreAutor,
                    datosLibro.authors().get(0).birth_year(),
                    datosLibro.authors().get(0).death_year()
            );

            autorRepository.save(autor);
        }

        Libro libro = new Libro(
                datosLibro.title(),
                datosLibro.languages().get(0),
                datosLibro.download_count(),
                autor
        );

        libroRepository.save(libro);

        System.out.println(libro);
    }

    private void listarLibros(){
        List<Libro> libros = libroRepository.findAll();
        libros.forEach(System.out::println);
    }

    private void listarAutores(){
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(System.out::println);
    }

    private void autoresVivos(){

        System.out.println("Ingrese el año");

        int anio = teclado.nextInt();

        List<Autor> autores = autorRepository
                .findByAnioNacimientoLessThanEqualAndAnioFallecimientoGreaterThanEqual(anio, anio);

        autores.forEach(System.out::println);
    }

    private void librosPorIdioma(){

        System.out.println("Ingrese idioma (ES EN FR PT)");

        String idioma = teclado.nextLine().toLowerCase();

        List<Libro> libros = libroRepository.findByIdioma(idioma);

        libros.forEach(System.out::println);
    }
}