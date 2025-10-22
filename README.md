# Parcial Tercio 2 - AREP

Link video funcionamiento local

[Link Video](https://pruebacorreoescuelaingeduco-my.sharepoint.com/:v:/g/personal/juan_dgomez_mail_escuelaing_edu_co/EaxI8U5XTYRPvjALwB9UMrABT5LcgokfhiJC5t-TD640bg?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJPbmVEcml2ZUZvckJ1c2luZXNzIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXciLCJyZWZlcnJhbFZpZXciOiJNeUZpbGVzTGlua0NvcHkifX0&e=PswZBm)

## Problema

Diseñe un prototipo de sistema de microservicios que tenga un servicio (En la figura se representa con el nombre Math Services) para computar las funciones numéricas.  El servicio de las funciones numéricas debe estar desplegado en al menos dos instancias virtuales de EC2. Adicionalmente, debe implementar un service proxy que reciba las solicitudes de llamado desde los clientes  y se las delegue a las dos instancias del servicio numérico usando un algoritmo de activo-pasivo. Si uno de los servicios está caido debe dirigirla al otro.  El proxy deberá estar desplegado en otra máquina EC2. Asegúrese de poder configurar las direcciones y puertos de las instancias del servicio en el proxy usando variables de entorno del sistema operativo.  Finalmente, construya un cliente Web mínimo con un formulario que reciba el valor y de manera asíncrona invoke el servicio en el PROXY. Puede hacer un formulario para cada una de las funciones. El cliente debe ser escrito en HTML y JS.

## Detalles adicionales de la arquitectura y del API

Construya una aplicación web para investigar este problema. La aplicación debe tener esta arquitectura:
Cliente asíncrono que corra en el browser escrito en HTML5 y JS (No use librerías, solo html JS básico). 
El cliente NO COMPUTA LA SECUENCIA DIRECTAMENTE, sino que la delega a un servicio REST corriendo en AWS.
El servicio REST puede ser GET o POST.
Se debe construir la aplicación usando Spring Boot y desplegarla en un contenedor corriendo en AWS.
Cree un solo repositorio en github para toda la aplicación
Use los mejores estándares de diseño, arquitectura y programación.

## Problema matemático 

### Números de Catalan

Sus servicios matemáticos deben incluir una función para calcular los números de Catalan desde C0​ hasta Cn​: catalan(n) retorna un JSON con la lista C0​,…,Cn​. (Recibe solo enteros no negativos).

**Implementación requerida**
Implemente programación dinámica con la recurrencia anterior, calculando cada Cn​ a partir de los previos. Use aritmética de enteros (en Java, BigInteger si es necesario). No use funciones de librerías que ya entreguen Catalan o combinatorias cerradas.

**Detalles adicionales de la arquitectura y del API**
Implemente el servicio para responder al método HTTP GET. Use el nombre de la función especificado y pase el parámetro en la variable de query con nombre "value".


## Solución

En la carpeta /src/main/resources tenemos nuestra interfaz de usuario, es una pagina sencilla que calcula los números de catalan desde 1 hasta un número dado como vemos en la siguiente imagen.

![alt text](/img/image.png)

El calculo de este número se realiza en el servicio MathService, que se invoca desde el controlador MathController que llamamos desde nuestro front estático. El número catalan se calcula así:

```java
@Service
public class MathService {

    public List numerosCatalan(int numero) {
        List resultado = new ArrayList<>();

        for (int n = 0; n < numero; n++) {
            int catalan = factorial(2 * n)/(factorial(n + 1) * (factorial(n)));
            resultado.add(catalan);
        }

        return resultado;
    }

    private int factorial(int n) {
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial = factorial * (i);
        }
        return factorial;
    }
}
```

Este calculo debería realizarse usando BigInteger pero por motivos prácticos no se pudo usar BigInteger entonces se usaron enteros normales.

## Proxy

Para nuestro proxy vamos a crear un proxyController en el que vamos a manejar la redirección.
En AWS vamos a crear 3 instancias EC2. Nuestra principal se llamará maquinaProxy y de esta vamos a redireccionar el tráfico hacia las otras 2.

![alt text](/img/image1.png)

