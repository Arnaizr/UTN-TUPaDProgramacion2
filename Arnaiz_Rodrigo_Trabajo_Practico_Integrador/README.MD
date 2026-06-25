# 🍔 Food Store Management System

Trabajo Práctico Integrador de Programación II desarrollado en Java.

# Trabajo Práctico Integrador – Programación II

## Integrante

**Arnaiz Rodrigo Martín**  
📧 arnaizrodrigomartin@gmail.com

---

# Descripción del programa

Este programa permite gestionar un **Food Store** utilizando clases y colecciones como almacenamiento en memoria.

El sistema se ejecuta, crea entidades precargadas y permite, mediante un menú interactivo:

- Buscar entidades (Categorías, Productos, Usuarios y Pedidos).
- Listar entidades almacenadas en memoria.
- Agregar nuevas entidades.
- Editar entidades existentes.
- Eliminar entidades mediante **Soft Delete** (permanencia en memoria).

El objetivo del proyecto es aplicar los conceptos fundamentales de la **Programación Orientada a Objetos**, modularizando correctamente las responsabilidades de cada clase y agrupándolas según su funcionalidad.

También se aplican conceptos de:

- Relaciones UML.
- Herencia.
- Polimorfismo.
- Manejo de excepciones.
- Validación de datos.

---

# Funcionalidades principales

## Listado

- Listar entidades almacenadas en memoria.
- Filtrar entidades eliminadas.
- Listar historial de usuarios eliminados.
- Listar pedidos de cada usuario.
- Listar detalles de cada pedido.

## Adición

- Agregar nuevas entidades a las colecciones.
- Generación automática de identificadores.
- Validación de datos de ingreso mediante excepciones.
- Validación de atributos repetidos.
- Alta de nuevas entidades.

## Edición

- Modificación de atributos de las entidades.
- Validaciones de ingreso mediante excepciones.
- Edición de pedidos:
  - Incorporación de productos.
  - Eliminación de productos.
  - Modificación de cantidades.
  - Actualización automática de subtotales y totales.

## Eliminación

- Eliminación de categorías con validación de productos asociados.
- Eliminación de productos incluidos en pedidos.
- Eliminación de usuarios conservando el historial.

---

# Dataset

Además de los datos ingresados por el usuario, el sistema cuenta con entidades precargadas.

## Categoría

**Atributos**

- Nombre
- Descripción

**Relaciones**

- 1 a N con Productos

## Producto

**Atributos**

- Nombre
- Descripción
- Precio
- Stock
- Disponibilidad
- Imagen
- Categoría

**Relaciones**

- N a 1 con Categoría
- 1 a N con DetallePedido

## Usuario

**Atributos**

- Nombre
- Apellido
- Mail
- Celular
- Contraseña
- Rol

**Relaciones**

- 1 a N con Pedido

## Pedido

**Atributos**

- Forma de Pago
- Estado

**Relaciones**

- 1 a N con DetallePedido
- N a 1 con Usuario

## DetallePedido

**Atributos**

- Cantidad
- Producto

**Relaciones**

- N a 1 con Pedido
- N a 1 con Producto

---

# Ejemplos de entidades

```java
Categoria verduras =
    new Categoria("Verduras",
                  "Tubérculos, raíces, bulbos, hojas");

Producto papa =
    new Producto("Papa",
                 5,
                 "Tubérculo",
                 30,
                 "C:/Imagenes/papa.jpg",
                 true,
                 verduras.getId());

Usuario usuario =
    new Usuario("Jose",
                "Mengano",
                "menganito88@mailfalso.com",
                "2215558833",
                "menga123",
                Rol.ADMIN);
```

```java
ArrayList<Integer> cantidadesJuan1 = new ArrayList<>();
cantidadesJuan1.add(5);
cantidadesJuan1.add(10);

ArrayList<Producto> productosJuan1 = new ArrayList<>();
productosJuan1.add(papa);
productosJuan1.add(carne);

Pedido pedido =
    new Pedido(FormaPago.EFECTIVO,
               juanPerez.getId(),
               cantidadesJuan1,
               productosJuan1);
```

---

# Validaciones implementadas

El programa contempla validaciones para:

- Nombres vacíos.
- Stock negativo.
- Precios negativos.
- Formato inválido de correo electrónico.
- Tipos de datos inválidos.
- Búsqueda de entidades inexistentes.
- Búsqueda de atributos inexistentes o vacíos.
- Duplicación de atributos.
- Duplicación de entidades.

---

# Instrucciones de uso

## Requisitos

- Java 17 o superior.

## Ejecución

1. Descargar todos los archivos del repositorio.
2. Compilar el proyecto.
3. Ejecutar la aplicación desde consola.
4. Navegar utilizando las opciones del menú principal.

---

# Ejemplos de uso

## Menú principal

```text
---- Sistema de pedidos ----

--- MENÚ PRINCIPAL ---

1- Categorías
2- Productos
3- Usuarios
4- Pedidos
0- Salir
```

## Ejemplo 1: Eliminar categoría

### Entrada

```text
1
```

### Salida

```text
----- CATEGORÍAS ------
1- Listar
2- Crear
3- Editar
4- Eliminar
0- Volver al menú anterior
```

### Entrada

```text
4
```

### Salida

```text
============================================
Categoría #1 | Nombre: nombre | Descripción: descripcion
Categoría #2 | Nombre: nombre | Descripción: descripcion
Categoría #3 | Nombre: nombre | Descripción: descripcion
Categoría #4 | Nombre: nombre | Descripción: descripcion
```

### Entrada

```text
2
```

### Salida

```text
¿Desea eliminar la categoría con id #2? (S/N)
```

### Entrada

```text
S
```

### Resultado posible

```text
Se eliminó la categoría con id: 2
```

### Resultado alternativo

```text
La categoría Verduras tiene productos asociados.
```

---

# Conceptos aplicados

Durante el desarrollo se implementaron los siguientes conceptos de Programación II:

- Programación Orientada a Objetos.
- Modularización.
- Manejo de excepciones.
- Relaciones 1 a N.
- Herencia.
- Polimorfismo.
- Validación de datos.
- Separación de responsabilidades.
- Estructuración mediante menú interactivo.

---

# Autor

**Rodrigo Arnaiz**  
Trabajo Práctico Integrador – Programación II
