# UNSPLAHS-PHOTO

Dada una API externa (unsplash.com) a la que llamaremos para traer una colección de datos, crear un servicio web con un parámetro que actuará de filtrado sobre los datos obtenidos de dicha API.
La API externa pertenece a la empresa UNSPLASH, el usuario es vivelibre y la contraseña v1v3l1br3. Se necesita crear un token de acceso y llamar al siguiente endpoint:
https://unsplash.com/documentation#list-collections

Se requiere crear un servicio montado sobre springboot 2 y JAVA 11 que recupere la colección de la API externa y 
se filtren los datos obtenidos en función del parámetro filter. Este campo tiene que ser de tipo string y ser capaz de hacer un 
like sobre los campos id, title, description y cover_photo.id. El resultado debe ser presentado siguiendo el formato descrito a continuación:

### Filtrar colección externa de datos
Recuperar una lista con todos los datos filtrados:


```
GET /collection/all
```


#### Parámetros
```
filter :> Filtro aplicado. (Optional; default: null)
```

### Ejemplo

_Request_

```
GET /collections/all?filter=1020971
```

_Response_

```
200 OK [
[
    {
        "id": "1020971",
        "title": "Halloween",
        "description": null,
        "cover_photo_id": null
    }
]
```


### Pasos a seguir para su funcionamiento

> docker pull rocruz92/unsplashapp:v1
> docker run rocruz92/unsplashapp:v1
> docker ps -a
  bcd2ba6edb3b        rocruz92/unsplashapp:v1   "/bin/sh -c 'java -D…"   5 minutes ago       Exited (1) 3 minutes ago   
> docker start bcd2ba6edb3b
  bcd2ba6edb3b        rocruz92/unsplashapp:v1   "/bin/sh -c 'java -D…"   5 minutes ago       Up 3 seconds        8080/tcp, 8778/tcp, 9779/tcp   optimistic_kilby
> docker ps
  bcd2ba6edb3b        rocruz92/unsplashapp:v1   "/bin/sh -c 'java -D…"   5 minutes ago       Up 3 seconds        8080/tcp, 8778/tcp, 9779/tcp   optimistic_kilby


### Construido con 🛠️

* [Java 11](https://www.oracle.com/es/java/technologies/javase-jdk11-downloads.html) - Versión de Java.
* [Maven](https://maven.apache.org/) - Manejador de dependencias

