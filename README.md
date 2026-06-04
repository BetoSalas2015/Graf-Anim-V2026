# Separando la responsabilidad del dibujo (versión 0.0.2)

## Compilar y ejecutar

Desde la carpeta de trabajo:

- Compilar: `javac Ventana.java`
- Ejecutar: `java Ventana`

---

En esta versión se refactoriza la solución para **separar la ventana (UI/contendor)** de la **lógica de dibujo (renderizado)**, aplicando una organización más limpia y escalable.

## ¿Qué se actualiza?

- Se crea una nueva clase dedicada al dibujo (por ejemplo, `Dibujo`).
- La nueva clase de dibujo se convierte en un componente gráfico reutilizable al **extender `Canvas`**.
- La lógica de renderizado (lo que antes vivía en `paint()` dentro de la ventana) **se mueve al `paint()` del `Canvas`**.
- La clase `Ventana` deja de “saber dibujar” directamente:
	- Se elimina su método `paint()`.
	- En su lugar, instancia el componente de dibujo y lo monta en la interfaz.
- El componente de dibujo se agrega a la ventana usando el sistema de layout de AWT (por defecto `BorderLayout`), colocándolo en la zona **Center**.

## Mejoras logradas

- **Separación de responsabilidades (SRP)**: `Ventana` se enfoca en ciclo de vida/UI; `Dibujo` se enfoca en renderizado.
- **Código más mantenible**: ahora es más fácil modificar el dibujo sin tocar la ventana.
- **Reutilización**: el `Canvas` puede reutilizarse en otras ventanas o interfaces.
- **Extensibilidad**: prepara el proyecto para agregar nuevos elementos (controles, más componentes, diferentes escenas) sin volver “monolítica” la clase de la ventana.
- **Mejor estructura para futuras secciones**: esta base facilita integrar interacción, parámetros, múltiples figuras y migraciones posteriores (por ejemplo, a Java2D).
