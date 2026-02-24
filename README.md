# Proyecto de pruebas web Omnicanalidad personas

Este proyecto contiene pruebas automatizadas para e-banca personas, desarrolladas con IntelliJ IDEA, Serenity BDD, Cucumber y Java.

## Herramientas utilizadas y accesos
- IntelliJ IDEA community Edition 2024 o superior
  **Pagina de descarga: https://www.jetbrains.com/es-es/idea/download/
  **Agregar los plugins de Cucumber for java, Gherkin y Sonarlint (no es obligatorio) : Para esto se ingresa desde la aplicación al menú File-->Settings-->Plugins y en la opción de búsqueda ingresamos el nombre de cada uno de los plugins a instalar.
  -Java JDK 11
  **Pagina de descarga: https://www.java.com/es/download/
- Gradle 8.8 o superior
  **Pagina de descarga : https://gradle.org/releases/
  **Guía de instalación: https://gradle.org/install/#manually

Importante: Recordar descargar el driver de chrome correspondiente a la versión que se tiene en el equipo , esto para temas de compatibilidad durante la ejecución,
el link de busqueda de drivers para chrome es: https://chromedriver.chromium.org/


## Estructura del proyecto

````````````````````````````````````````````````````````````````````````````````````
OmniCanalPersonasWebAppPaycore_TestQA
|__ src
|   |__ main
|   |  |__ java
|   |  |   |__ com.bancoagricola.certificacion.omnicanalidadpersonas.web
|   |  |    |__interactions
|   |  |    |__models
|	|  | 	|__questions
|	|  |	|__task
|	|  |	|__userinterface
|	|  |	|__utils
|	|  |
|	|	test
|   |  |__ java
|   |       |__ com.bancoagricola.certificacion.omnicanalidadpersonas.web
|   |       |     |__runners
|   |       |     |__stepdefinitions         
|   |       |          
|   |       |           
|   |       |
			resources
|	|	    |__ featueres
|   |
|   |__ src
|       |__ main
|           |__ java
|               |__ com.bancoagricola.certificacion.omnicanalidadpersonas.movil
|                   |__ builders
|                   |__ exceptions
|                   |__ interactions
|                   |__ models
|                   |__ questions
|                   |__ tasks
|                   |__ userinterface
|                   |__ utils
|__ target
   |__ site
        |__ serenity (informes)
|
|_build.gradle
|_README.md
|_serenity.properties (archivo de configuración de Serenity BDD)
|_setings.gradle
		
````````````````````````````````````````````````````````````````````````````````````

# NAVEGADOR UTILIZADO PARA EL DESARROLLO DE ESTOS ESCENARIOS

Por defecto, los tests se ejecutan en el navegador Google Chrome versión mas actual tanto para Windows como Mac.
Se ejecutarán adicionalmente como ruta alternativa todos los tests en Mozilla Firefox versión mas actual tanto para Windows como Mac.

# FRAMEWORK

Se utiliza BDD como framework de automatización para la automatización de los escenarios de prueba.

# Gherkin

Se utiliza Gherkin como lenguaje de desarrollo de las funcionalidades dado que es un lenguaje comprensible por humanos y por ordenadores, con el vamos a definir el comportamiento de la página que vamos a automatizar.
sentencias con las que vamos a describir las funcionalidades:
- Feature: Indica el nombre de la funcionalidad que vamos a probar. Debe ser un título claro y explícito.
- Scenario: Describe cada escenario que vamos a probar.
-	Given: Incluye los pasos necesarios para poner al sistema en el estado que se desea probar.
-	When: Especifica el conjunto de acciones que lanzan el test.
-	Then: Especifica el resultado esperado en el test.

# Cucumber

Se utiliza cucumber como herramienta para automatizar las pruebas en BDD. Cucumber nos va permitir ejecutar descripciones funcionales en texto plano como pruebas de software automatizadas.

# Compilador

Se crea el proyecto sobre Gradle, es una herramienta de automatización de la construcción de nuestro código.

### Patrones de desarrollo

Para el desarrollo de la automatización se utilizaron los siguientes patrones de desarrollo:
Variables: camelCase
Funciones: camelCase
Clases: PascalCase
Paquetes: camelCase

# EJECUCIÓN DEL PROYECTO

Nota: La ejecucion se ejecuta en paralelo con la cantidad maxima de procesadores de la maquina.
1. Asegúrese de tener IntelliJ, Java/JDK y Gradle instalados en su sistema.
2. Descargue el proyecto Omnicanalidad Personas Web
3. Abra el proyecto en su IDE, para ejecutar las pruebas y generar los informes usando el siguiente comando.

Normalmente el proyecto se puede ejecutar desde cualquier IDE, desde las opciones de ejecución que éste posea. Sin embargo, si se desea ejecutar podemos usar las siguientes instrucciones desde la terminal:
-----------------------------------	
MICROSERVICIOS QA 
-----------------------------------
# firefox
-Denvironment=qa
-Dwebdriver.driver="firefox"
-Dcucumber.filter.tags="(@QA)"
# chrome
-Denvironment=qa
-Dcucumber.filter.tags="(@QA)"
# edge
-Denvironment=qa
-Dwebdriver.driver="edge"
-Dcucumber.filter.tags="(@QA)"

-----------------------------------
MICROSERVICIOS DEV 
-----------------------------------
# firefox
-Denvironment=dev
-Dwebdriver.driver="firefox"
-Dcucumber.filter.tags="(@DEV)"
# chrome
-Denvironment=dev
-Dcucumber.filter.tags="(@DEV)"
# edge
-Denvironment=dev
-Dwebdriver.driver="edge"
-Dcucumber.filter.tags="(@DEV)"
-----------------------------------

Se generará el reporte en la carpeta /target/site/serenity/.
En caso de no generarse el archivo index.html , ejecutar en la terminal el comando:
•	gradlew aggregate

# DETALLES GENERALES DE LA IMPLEMENTACIÓN

La estructura completa del proyecto es la siguiente:

	models: clases relacionadas con el modelo de dominio y sus respectivos builder cuando es necesario
	tasks: clases que representan tareas que realiza el actor a nivel de proceso de negocio
	interactions: clases que representan las interacciones directas con la interfaz de usuario
	userinterfaces: mapean los objetos de la interfaz de usuario
	questions: donde se verifican los resultados de las operaciones realizadas en la aplicación
	utils: clases de utilidad que se pueden reusar
	runners: clases que permiten ejecutar los tests
	stepdefinitions: clases que mapean las líneas Gherkin a código java
	features: la representación de las historias de usuario en lenguaje Gherkin

# HERRAMIENTA DE AUTOMATIZACION UTILIZADO

Se utiliza el IDE de IntelliJ para el desarrollo de la automatización. 

