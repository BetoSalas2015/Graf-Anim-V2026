# Programación de Gráficos en Java (versión 0.0.1)

Este repositorio documenta **solo la sección “Programación de Gráficos en Java” (versión 0.0.1)** del material del curso. El objetivo es crear una ventana básica con **AWT**, poder ejecutarla, cerrarla correctamente y dejar listo el punto de entrada para dibujar con `paint()`.

## Requisitos

- JDK instalado
- Un editor/IDE (por ejemplo, VS Code)
- Consola/terminal

## 1) Crear carpeta de trabajo

1. Crea una carpeta de trabajo en tu sistema de archivos.
2. En Windows PowerShell, por ejemplo:

- `md GraficaciónAnimación`

## 2) Crear el archivo del proyecto

1. Abre la carpeta en tu editor/IDE.
2. Crea un archivo nuevo llamado **Ventana.java**.

## 3) Crear una ventana AWT

1. Declara la clase `Ventana`.
2. Importa el paquete `java.awt`.
3. Haz que la clase herede de `Frame` para que represente una ventana del sistema operativo.

## 4) Programar el constructor

En el constructor:

1. Invoca el constructor de la clase padre (`Frame`) usando `super("Dibujo")` para poner título a la ventana.
2. Define dimensiones con `setSize(...)`.
3. Muestra la ventana con `setVisible(true)`.

## 5) Agregar `main()` para ejecutar

1. Implementa `main()`.
2. Crea una instancia de `Ventana` para que se ejecute el constructor.

## 6) Manejar el cierre de la ventana

Cuando ejecutas una ventana AWT, necesitas manejar el evento de cierre.

1. Importa `java.awt.event`.
2. Crea una **clase interna** (por ejemplo `CloseWin`).
3. Haz que esa clase herede de `WindowAdapter`.
4. Implementa el método `windowClosing(...)`.
5. Dentro de `windowClosing(...)`:
	- Oculta la ventana con `setVisible(false)`
	- Libera recursos con `dispose()`
6. En el constructor de `Ventana`, registra el listener con `addWindowListener(new CloseWin())`.

## 7) Preparar el método `paint()`

El método `paint(Graphics gc)` es el punto donde se realizan los dibujos en la ventana. En esta versión **solo se agrega como base**, para usarlo en secciones posteriores.

## Compilar y ejecutar

Desde la carpeta de trabajo:

- Compilar: `javac Ventana.java`
- Ejecutar: `java Ventana`
