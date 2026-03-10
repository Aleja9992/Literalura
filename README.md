# 📚 Literalura — Explorador de Libros con API y Base de Datos

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-Framework-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-yellow)

---

## 🌎 Descripción del Proyecto

**Literalura** es una aplicación desarrollada en **Java con Spring Boot** que permite explorar, registrar y consultar información de libros utilizando una API pública.

El sistema se conecta a la API **Gutendex API**, que proporciona datos provenientes del catálogo de **Project Gutenberg**, una de las bibliotecas digitales más grandes del mundo.

A través de una interfaz de consola interactiva, los usuarios pueden buscar libros por título, almacenarlos en una base de datos y realizar diferentes consultas sobre los libros y autores registrados.

Este proyecto forma parte del programa de formación en **desarrollo backend con Java** promovido por **Alura Latam** en colaboración con **Oracle Corporation**, dentro del ecosistema de aprendizaje **Oracle Next Education (ONE)**.

El objetivo del proyecto es aplicar conceptos fundamentales del desarrollo backend como:

* Consumo de APIs REST
* Persistencia de datos
* Arquitectura basada en capas
* Manipulación de datos con repositorios
* Integración entre servicios y base de datos

---

## 🚀 Funcionalidades

La aplicación permite realizar las siguientes operaciones:

### 🔎 1. Buscar libro por título

Permite buscar un libro en la API externa y almacenarlo en la base de datos local.

### 📚 2. Listar libros registrados

Muestra todos los libros que han sido almacenados en la base de datos.

### 👨‍💼 3. Listar autores registrados

Permite visualizar todos los autores asociados a los libros guardados.

### 📅 4. Listar autores vivos en un año específico

Consulta los autores que estaban vivos durante un año determinado.

### 🌐 5. Listar libros por idioma

Permite filtrar libros según su idioma.

Idiomas soportados:

* EN — Inglés
* ES — Español
* FR — Francés
* PT — Portugués

---

## 🏗️ Arquitectura del Proyecto

El proyecto sigue una arquitectura organizada por capas que separa responsabilidades para mejorar la mantenibilidad y escalabilidad.

```
literatura
 ├─ dto
 ├─ model
 │   ├─ Autor
 │   └─ Libro
 ├─ repository
 │   ├─ AutorRepository
 │   └─ LibroRepository
 ├─ service
 │   ├─ ConsumoAPI
 │   └─ DatosRespuesta
 ├─ principal
 │   └─ Principal
 └─ LiteraturaApplication
```

### Componentes principales

* **Model** → Representa las entidades del dominio (Libro y Autor).
* **Repository** → Maneja el acceso y persistencia en la base de datos.
* **Service** → Gestiona el consumo de la API y procesamiento de datos.
* **Principal** → Controla la interacción con el usuario mediante consola.

---

## 🛠️ Tecnologías Utilizadas

Este proyecto fue desarrollado utilizando las siguientes tecnologías:

* ☕ **Java 17**
* 🌱 **Spring Boot**
* 🗄️ **PostgreSQL**
* 🧩 **Hibernate / JPA**
* 🔗 **HTTP Client de Java**
* 📦 **Maven**

Además, el proyecto consume datos desde:

* **Gutendex API**
* Catálogo de **Project Gutenberg**

---

## 🗄️ Base de Datos

La aplicación utiliza **PostgreSQL** para almacenar los libros y autores registrados.

Configuración básica en `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5434/literalura
spring.datasource.username=postgres
spring.datasource.password=1234

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## ▶️ Cómo Ejecutar el Proyecto

1. Clonar el repositorio

```bash
git clone https://github.com/tuusuario/literalura.git
```

2. Entrar al proyecto

```bash
cd literalura
```

3. Ejecutar la aplicación

```bash
mvn spring-boot:run
```

4. Usar el menú interactivo desde la consola.

---

## 📌 Ejemplo de Uso

```
1 - Buscar libro por titulo
2 - Listar libros registrados
3 - Listar autores registrados
4 - Listar autores vivos en un año
5 - Listar libros por idioma
0 - Salir
```

Ejemplo de búsqueda:

```
1
Dracula
```

Resultado:

```
Título: Dracula
Autor: Bram Stoker
Idioma: en
Descargas: 12000
```

---

## 🎓 Créditos

Este proyecto fue desarrollado como parte del programa educativo:

**Oracle Next Education (ONE)**

En colaboración con:

* **Alura Latam**
* **Oracle Corporation**

El programa busca formar nuevos desarrolladores en tecnologías backend modernas mediante proyectos prácticos y experiencias de aprendizaje aplicadas al mundo real.

---

## 📖 Aprendizajes del Proyecto

Durante el desarrollo de **Literalura** se aplicaron conceptos como:

* Consumo de APIs REST
* Manejo de JSON
* Persistencia de datos con JPA
* Uso de repositorios en Spring Boot
* Arquitectura de aplicaciones backend
* Integración entre servicios y base de datos

---

## 👩‍💻 Autor

Proyecto desarrollado por **Alejandra Hernández**
Como parte del programa **Oracle Next Education (ONE)**.

---

⭐ Si te gusta este proyecto, ¡no olvides darle una estrella al repositorio!
