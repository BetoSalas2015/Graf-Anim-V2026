# Graficando múltiples Puntos (versión 0.0.5)

## Compilar y ejecutar

Desde la carpeta de trabajo:

- Compilar: `javac Ventana.java`
- Ejecutar: `java Ventana`

---

En esta versión el proyecto deja de trabajar con **dos puntos** y evoluciona a un modelo que permite capturar y graficar **múltiples puntos** (una secuencia) para formar una figura/polígono.

## ¿Qué se actualiza?

- La interfaz cambia para capturar **un solo punto (x, y)** por vez.
- Se agrega un botón para **“Agregar punto”** a una colección interna.
- Se introduce una estructura de datos para almacenar puntos (por ejemplo, un **`Vector`** de puntos).
	- Cada click en “Agregar punto” inserta un nuevo punto en la colección.
- El botón “Graficar” ya no manda dos puntos: ahora manda **toda la colección** al componente de dibujo.
- El componente de dibujo cambia su lógica de renderizado:
	- Recorre la colección y dibuja segmentos entre el punto *i* y el punto *i+1*.
	- Al final, cierra la figura uniendo el **último punto** con el **primero**.

## Mejoras logradas

- **Mayor expresividad**: permite dibujar figuras formadas por varios vértices, no solo una línea.
- **Modelo de datos escalable**: la colección de puntos habilita mejoras posteriores (edición de puntos, borrar, reordenar, cargar desde archivo, etc.).
- **Separación más clara de responsabilidades**:
	- La UI se encarga de capturar y acumular puntos.
	- El componente de dibujo se encarga de renderizar la colección.
- **Base para evolucionar a Java2D**: al manejar listas de puntos, es más natural migrar después a primitivas de dibujo más avanzadas y transformaciones.
