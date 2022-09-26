# Activos de una empresa

Prueba activos de una empresa - servicio api rest

### Prerrequisitos
Debemos tener los siguientes programas instalados:
~~~
* Maven
* Git
* Java
~~~
# Instalando 
Para descargar el proyecto realizaremos los siguientes pasos desde el **Simbolo del sistema** o **Command prompt**:  
1. Nos dirigimos a la ubicación donde queremos descargar el proyecto desde el simbolo del sistema.  
2. Escribimos el siguiente comando para realizar la descarga:  
`git clone https://github.com/JoseGutierrezMairn/gasd-activosEmpresa.git`

# Probando
Para probar el proyecto podemos correr las pruebas que se encuentran en configuradas en la aplicacion 
usando maven podemos correr las pruebas mencionadas digitando desde la linea de comandos situados dentro de la carpeta raiz del proyecto
`mvn test`
![Pruebas desde maven](https://github.com/JoseGutierrezMairn/gasd-activosEmpresa/blob/master/img/pruebas.png?raw=true) 

Para generar el javadoc ejecutamos el siguiente codigo desde la consola dentro de la carpeta raiz del proyecto: `mvn javadoc:javadoc`  
![generando javadoc](https://github.com/JoseGutierrezMairn/gasd-activosEmpresa/blob/master/img/javadoc.png?raw=true) 

Podemos consultar la documentación generada el archivo: `target\site\apidocs`  
*Este es un ejemplo de como se ve la documentación generada en este proyecto*
![check javadoc2](https://github.com/JoseGutierrezMairn/gasd-activosEmpresa/blob/master/img/javadoc2.png?raw=true)


# Consideraciones
La aplicacion se conecta a una base de datos MySql y se encuentra configurada de manera local, para que la aplicacion funcione de la manera esperada  
es necesario montar una base de datos MySql en el ambiente local, para esto descargar e instalar [xampp](https://www.apachefriends.org/es/download.html).

Una vez instalado xampp abrirlo e iniciar los servicios de apache y MySql
![Inicio](https://github.com/JoseGutierrezMairn/gasd-activosEmpresa/blob/master/img/apacheymysql.png?raw=true)

Dirigirse a la siguiente url en el navegador:
~~~
http://localhost/phpmyadmin/
~~~

Hacer clic en "New" y configurar el nombre de la base de datos como "activos_empresa" y dar clic en el boton create

![Crear base de datos](https://github.com/JoseGutierrezMairn/gasd-activosEmpresa/blob/master/img/creardbl.png?raw=true)


instalar [dbeaver](https://dbeaver.io/download/)

una vez instalado abrir y crear la conexión a la base de datos que se creó

![Tipo base de datos](https://github.com/JoseGutierrezMairn/gasd-activosEmpresa/blob/master/img/tipobd.png?raw=true)

Configurar las credenciales para completar la conexión y hacer clic en finalizar.  

![credenciales](https://github.com/JoseGutierrezMairn/gasd-activosEmpresa/blob/master/img/credenciales.png?raw=true)


Ejecutar el script que se encuentra en la carpeta **dataBase** en la base de datos "activos_empresa" desde Dbeaver.

# Archivos vital importancia
* Entregable PDF: Se encuentra en la carpeta **Entregables** con el nombre "Entregable prueba técnica.pdf".
* Coleccion Postman: Se encuentra en la carpeta **Coleccion**.
* JAR: Se encuentra en la carpeta **Entregables** con el nombre "activos-0.0.1-jar-with-dependencies.jar"

# Desarrollo  
Construido con:
* [Maven](https://maven.apache.org/)
* [Java](https://www.java.com/es/)

# Autor
* [Jose Gutierrez](https://github.com/JoseGutierrezMairn)