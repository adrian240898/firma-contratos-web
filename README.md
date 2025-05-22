# Formulario QA Integration

Este proyecto demuestra cómo ejecutar tests automatizados con Playwright desde un programa en Java.

## Estructura

- `tests-playwright/`: contiene los tests escritos en Playwright (TypeScript).
- `src/Main.java`: ejecuta los tests desde Java.
- Requiere Node.js, npm y Java 11+ instalados.

## Uso

1. Instala dependencias:
    ```bash
    cd tests-playwright
    npm install
    ```

2. Corre el programa Java:
    ```bash
    javac src/Main.java
    java -cp src Main
    ```

3. Los resultados estarán en `tests-playwright/playwright-report/test-result.json`
