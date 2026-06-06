# Archivos (versión 0.0.7)

## Compilar y ejecutar

Desde la carpeta de trabajo:

- Compilar: `javac Ventana.java`
- Ejecutar: `java Ventana`

---


## Cambios y mejoras (v0.0.7)

En esta versión se agrega **carga de puntos desde archivo** (I/O) para automatizar la captura de coordenadas.

### ¿Qué se actualiza?

- Se incorporan paquetes de **entrada/salida** y utilidades:
	- `java.io.*` (por ejemplo, `FileReader`, `BufferedReader`).
	- `java.util.*` (por ejemplo, `Vector`, `StringTokenizer`).
- La UI agrega el botón **`btnCargar`** ("Cargar Puntos") y se deshabilita/retira el flujo manual de agregar puntos (por ejemplo, comentando `btnAgregar`).
- Se implementa el manejador de eventos **`BotonCargar`** que:
	- Inicializa `vectorPuntos = new Vector<Point>()` en cada carga.
	- Abre el archivo **`coordenadas.txt`** con `BufferedReader(new FileReader("coordenadas.txt"))`.
	- Lee el archivo línea por línea.
	- Separa cada línea con `StringTokenizer` usando la coma `,` como delimitador.
	- Convierte `x` e `y` a enteros y agrega cada punto a `vectorPuntos`.
	- Cierra el flujo con `entrada.close()`.
	- Envía el vector a `Dibujo` con `dibujo.asignaPuntos(vectorPuntos)` y repinta con `dibujo.repaint()`.
- Se añade manejo de errores con `try/catch` para capturar `IOException` cuando el archivo no se pueda abrir/leer.

### Mejoras logradas

- **Captura reproducible**: permite cargar la misma figura/polígono múltiples veces sin reescribir puntos a mano.
- **Separación de datos vs. UI**: las coordenadas quedan desacopladas de la interfaz (pueden versionarse y compartirse).
- **Base para extensiones**: facilita añadir escalamiento, múltiples archivos, o validación de formato.
