# API REST PARA BANCO BCI

Este proyecto es una prueba de API REST con algunas características específicas que se solicitaron a modo de prueba de ingreso para nuevas contrataciones de Fullstack Java Developers para el Banco BCI.

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

### Pre-requisitos 📋

_Que cosas necesitas para instalar la API REST en Local_

```
Tener instalado Maven en tu carpeta local
Tener espacio en tu disco duro de al menos 50 mb
Tener algún ide de desarrollo como Intellij Idea, Netbeans o Eclipse
```
### Instalación 🔧

_Vamos a lo que nos convoca! Ahora toca realizar la configuración e instalación de nuestra API REST_

_Primero_

```
Instalamos y configuramos Maven en Local (link de ejemplo):                                         		 						https://www.youtube.com/watch?v=rl5-yyrmp-0
```

_Luego_

```
Descargamos la API REST desde GITHUB (Link de Repositorio):                                       https://github.com/andresbluna/apiUsersBCI.git
```
_y por último_

```
Levantamos nuestra API desde el IDE de preferencia, IntelliJ Idea, Netbeans ó Eclipse.
```

## Ejecutando las pruebas ⚙️

_Para realizar las pruebas podemos ocupar un IDE de consulta de APIS como Postman, Bruno, Insomnia, cualquiera que sea de tu gusto. Una vez arranquemos la API en nuestro IDE, creamos nuestra solicitud POST con el siguiente endpoint: http://localhost:8080/api/users  y enviamos lo siguiente en el Body_

```json
{
    "name": "hola",
    "email": "hola@hola.cl",
    "password": "123456",
    "phones": [
        {
            "number": "12334437",
            "citycode": "1",
            "countrycode": "57"
        }
    ]
}
```

### Respuesta 🔩

****201 CREATED Si el usuario se registra correctamente**


```json
{
    "id": "2ea3aa85-5746-41e2-abd6-b1f9b8349a6e",
    "name": "hola",
    "uuid": "40c8c917-f738-4706-bfe4-58b7a0d8d808",
    "email": "hola@hola.cl",
    "token": "q-JueQu9re09UVfbHzfryCsrrerK9Syz",
    "password": "123456",
    "created": "2023-12-15T04:47:44.5187838",
    "modified": "2023-12-15T04:47:44.5187838",
    "lastLogin": "2023-12-15T04:47:44.5187838",
    "phones": [
        {
            "id": 302,
            "number": "12334437",
            "citycode": "1",
            "countrycode": "57"
        }
    ],
    "active": true
}
```


## Casos de prueba (errores) 🛠️

_Si no ingresamos los datos como corresponden nos debería arrojar los siguientes errores_


!! **400 BAD REQUEST Si alguna clave no trae el formato completo**
```json
{
    "password": "Este campo es requerido, porfavor intente otra vez"
}
```
!! **Si el correo ya fue registrado**
```json
{
    "error01": "El correo ya esta registrado en el Banco BCI, por favor intente con uno diferente"
}
```

!! **Si el correo va comn un formato inválido**
```json
{
    "error02": "Formato incorrecto de correo, porfavor ingresar otra vez"
}
```


## Autor ✒️


* **Andrés Luna** - *Java Developer && STUFF * - [andresbluna](https://github.com/andresbluna)

## Licencia 📄

Este proyecto está bajo la Licencia **The Unlicense**

## THANKS FOR ALL!! 🎁

* Gracias enormes y totales, por permitirme participar de este desafío 📢




---
⌨️ con ❤️ por [andresbluna](https://github.com/andresbluna) 😊
