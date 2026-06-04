# Creando la interfaz de Usuario (versión 0.0.3)

## Compilar y ejecutar

Desde la carpeta de trabajo:

- Compilar: `javac Ventana.java`
- Ejecutar: `java Ventana`

---

En esta versión el proyecto evoluciona de “mostrar una ventana” a **interactuar con el usuario**: se construye una interfaz gráfica (AWT) para capturar parámetros y disparar el dibujo desde el componente responsable del renderizado.

## ¿Qué se actualiza?

- Se define un prototipo de interfaz con tres zonas:
	- **Entrada de datos** (parte superior)
	- **Área de dibujo** (centro)
	- **Acción principal** (parte inferior)
- Se agregan componentes AWT para captura de coordenadas y ejecución:
	- `Panel` para agrupar controles
	- `Label` para identificar campos
	- `TextField` para capturar valores
	- `Button` para ejecutar “graficar”
- Se organiza la ventana con `BorderLayout` usando regiones (por ejemplo: **North / Center / South**) para separar responsabilidades visuales.
- Se incorpora manejo de eventos para el botón:
	- Se implementa un `ActionListener` mediante una clase interna.
	- Al hacer click, se leen los valores de los `TextField` y se convierten a enteros.
- Se implementa el “puente” entre la UI y el dibujo:
	- El componente de dibujo expone un método para recibir los parámetros.
	- Se llama a `repaint()` para forzar el repintado y reflejar el nuevo estado.

## Mejoras logradas

- **Interactividad real**: el usuario controla qué se dibuja a partir de datos ingresados.
- **Flujo claro de actualización**: *capturar datos → asignar al modelo de dibujo → repaint → paint*.
- **Mejor separación de roles**: la ventana coordina la interacción; el componente de dibujo renderiza.
- **Escalabilidad**: la estructura queda lista para agregar más controles (colores, múltiples figuras, listas de puntos, carga de archivos, etc.) sin desordenar la aplicación.
