# Usando Java2D (versión 0.0.6)

## Compilar y ejecutar

Desde la carpeta de trabajo:

- Compilar: `javac Ventana.java`
- Ejecutar: `java Ventana`

---


En esta versión el proyecto migra a **Java2D** para usar primitivas de dibujo más avanzadas y mejorar la calidad/consistencia del render.

### ¿Qué se actualiza?

- Se utiliza **`Graphics2D`** (casting desde `Graphics`) para dibujar con la API Java2D.
- Se crea el método **`planoCoordenado(Graphics gc)`** en `Dibujo` para dibujar un plano cartesiano:
	- Fondo en color verde claro.
	- Cálculo de `w` y `h` como mitades del ancho/alto del `Canvas`.
	- **Traslación del origen** al centro del `Canvas` con `translate(w, h)`.
	- Rejilla con líneas cada **20 px**.
	- Ejes X/Y con mayor grosor y color más oscuro.
- Los trazos pasan de `drawLine()` a `draw(...)` con **`Line2D`** y `setStroke(...)` para controlar el grosor.
- Se reemplaza el objeto `Punto` del proyecto por **`java.awt.Point`** (Java2D):
	- `Vector<Punto>`  `Vector<Point>`.
	- Las líneas se dibujan usando el constructor `new Line2D.Float(Point p1, Point p2)`.

### Mejoras logradas

- **Render más consistente** y con mayor control (grosor, color y primitivas 2D).
- **Independencia del tamaño de la ventana**: al centrar el origen y recalcular el plano, el dibujo se adapta al redimensionamiento.
- **Código más estándar** al usar clases nativas (`Point`, `Line2D`) en lugar de tipos propios.
