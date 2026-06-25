Trabajo Práctico Integrador – Programación 2

Integrante:

Arnaiz Rodrigo Martín - arnaizrodrigomartin@gmail.com

Descripción del programa
Este programa permite gestionar un Food Store utilizando clases y colecciones como almacenamiento en memoria.

El sistema se ejecuta, crea nuevas entidades precargadas y permite mediante un menú interactivo:

Buscar entidades (Categorías, Productos, Usuarios y Pedidos).
Listar las entidades en memoria.
Agregar entidades.
Editar entidades.
Borrar entidades con permanencia en la memoria (Soft Delete).
El objetivo del proyecto es aplicar las bases de la programación orientada a objetos, modularizar correctamente las funciones de cada clase y agruparlas por su funcionalidad
También se aplican los principios de relaciones UML, herencia, poliformismo y manejo de excepciones.

Funcionalidades principales
Listado
Listar entidades en memoria
Filtrar entidades eliminadas
Listar historial de usuarios eliminados
Listar pedidos de cada usuario
Listar detalles de cada pedido
Adición
Agregar nuevas entidades a las colecciones (generación automática de id)
Validar datos de ingreso con manejo de excepciones
Validar entradas repetidas
Agregar nuevas entidades
Edición
Editar atributos de las entidades
Validaciones de ingreso con manejo de excepciones
Edición de pedidos
Incorporación de productos, eliminación
Modificación de cantidades con actualización automática de totales y subtotales
Eliminación
Eliminación de categorías con validación de productos asociados
Eliminación de productos incluidos en pedidos
Eliminación de usuarios con permanencia en el historial

Dataset
Al margen de los ingresos del usuario hay entidades precargadas en el sistema:

Categoria (nombre, descripcion) (rel 1...n con productos)
Productos (nombre, descripcion, precio, stock, disponibilidad, imagen, Categoria) (rel n...1 con categoria) (rel 1...n con detallePedido)
Usuario (nombre, apellido, mail, celular, contraseña, Rol) (rel 1...n con pedidos)
Pedido (FormaPago, Estado) (rel 1...n con detalles) (rel n...1 con usuario)
DetallePedido (cantidad, Producto) (rel n...1 con pedido) (rel n...1 con producto)

Con ejemplos:

Categoria("Verduras", "Tubérculos, raíces, bulbos, hojas")
Producto("Papa", 5, "Tubérculo", 30, "C:/Imagenes/papa.jpg", true, verduras.getId())
Usuario("Jose", "Mengano", "menganito88@mailfalso.com", "2215558833", "menga123", Rol.ADMIN)
ArrayList<Integer> cantidadesJuan1 = new ArrayList<>();
        cantidadesJuan1.add(5);
        cantidadesJuan1.add(10);
        ArrayList<Producto> productosJuan1 = new ArrayList<>();
        productosJuan1.add(papa);
        productosJuan1.add(carne);
Pedido(FormaPago.EFECTIVO, juanPerez.getId(), cantidadesJuan1, productosJuan1)

El programa incluye validaciones para:

nombres vacíos,
stock negativo,
precios negativos,
formato inválido de correo
tipos de datos inválidos
búsqueda de entidades inexistentes
búsuqeda de atributos inexistentes o vacíos
duplicación de atributos 
duplicación de entidades

Instrucciones de uso
Instalar Java 17.x.
Descargar todos los archivos del repositorio.
Ejecutar desde la consola.
Navegar usando los números del menú principal.

Ejemplos de entrada y salida.

---- Sistema de pedidos ---
   --- MENÚ PRINCIPAL --- 

1- Categorias 
2- Productos 
3- Usuarios
4- Pedidos 
0- Salir 

--- Ejemplo 1 ---

Entrada: 1

----- CATEGORIAS ------
1- Listar 
2- Crear 
3- Editar
4- Eliminar 
0- Volver al menú anterior


Entrada: 4

Salida: 
============================================ 
categoria1 #1 | Nombre : #nombre | Descripcion: #descripcion
categoria1 #2 | Nombre : #nombre | Descripcion: #descripcion
categoria1 #3 | Nombre : #nombre | Descripcion: #descripcion
categoria1 #4 | Nombre : #nombre | Descripcion: #descripcion

Entrada: 2
Salida: 

"Desea eliminar la categoría con id #" + idInput(2) + " (S/N)"

Entrada: S

Salida: 

"Se eliminó la categoria con id: " + id(2).
o
La categoría " + categoriaAEliminar.getNombre() + " tiene productos asociados."


Notas finales
El programa fue desarrollado siguiendo los lineamientos de Programación II aplicando buenas prácticas en:

Modularización.
Manejo de excepciones.
Relaciones 1 a N.
Herencia y polimorfismo.
Validación de datos.
Separación por responsabilidades.
Estructuración del menú interactivo.
