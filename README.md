# Trabajando con Puntos (versión 0.0.4)

## Compilar y ejecutar

Desde la carpeta de trabajo:

- Compilar: `javac Ventana.java`
- Ejecutar: `java Ventana`

---

En esta versión se deja de manejar las coordenadas como variables sueltas (`x1`, `y1`, `x2`, `y2`) y se migra el proyecto a un modelo más orientado a objetos usando **Puntos** como entidad.

## ¿Qué se actualiza?

- Se introduce una nueva clase de dominio llamada `Punto`.
	- Encapsula las coordenadas `x` e `y`.
	- Incluye constructor y métodos de acceso (getters/setters).
- El flujo de la interfaz cambia:
	- En lugar de enviar números sueltos al dibujo, se construyen objetos `Punto` a partir de los valores capturados en los `TextField`.
	- El componente de dibujo recibe ahora **dos objetos punto** (punto inicial y punto final) para trazar la línea.
- El componente de dibujo se adapta al nuevo modelo:
	- Sustituye variables primitivas por referencias a `Punto`.
	- El renderizado consulta las coordenadas a través de los getters del objeto.
- Se refuerza el control de estado inicial:
	- Al arrancar la aplicación, todavía no hay puntos definidos.
	- Se agrega una validación antes de dibujar para evitar errores cuando los puntos aún no existen.

## Mejoras logradas

- **Mejor diseño OO**: las coordenadas pasan a ser un objeto con significado (no solo números).
- **Legibilidad y mantenimiento**: el código es más claro al hablar en términos de “punto 1” y “punto 2”.
- **Extensibilidad**: facilita evolucionar a colecciones de puntos (polígonos), transformaciones, o integración posterior con `Point` de Java2D.
- **Robustez al iniciar**: se evita que el primer repintado intente dibujar con datos inexistentes.
