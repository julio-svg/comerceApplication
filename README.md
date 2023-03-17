# Storage AP
Microservicio realizado con Spring Boot.

Microservicio Seasons
get de precios para una temporada de los productos

En cuanto al api, se quería realizar el siguiente endpoint:

---

> GET /v1/corporates/{corporateId}/products/{productId}/seasons

Parámetros:

> **corporate-id**: identificador de empresa, String (Obligatorio)
>
> **product-id**: identificador de producto String (Obligatorio)
>
> **date**: String fecha del sistema (Opcional), En posteriores versiones se puede suprimir para obtener un listado,
esta version por logica de negocio siempre lo va a llevar

###Servicios disponibles
Una vez lanzado el microservicio se podrá acceder al API accediendo a la siguiente URL:

local: http://localhost:8080/swagger-ui/

---

###Buenas prácticas
Siempre se realizará el contrato del API antes de implementar nada y deberá ser validado por el equipo. Para el contrato se tendrán en cuenta las siguientes consideraciones:

Recursos: Serán las entidades sobre las que actuamos. Las acciones sobre estas entidades se realizarán con los métodos HTTP. En inglés, minúsculas. Siempre nombres y nunca acciones ni verbos. URIs cortas para mejorar posicionamiento.

Path parameters: Siempre seguidos de la entidad a la que hacen referencia. Nunca usar varios seguidos.

Query parameters: Sólo se usarán para los métodos GET que devuelvan una lista. Su propósito sólo puede ser filtrar, paginar, expandir o similares.

Para la salida de los servicios se usará JSON, camelCase, y se incluirá siempre un objeto data que envolverá la salida de cualquier petición.

Se deben respetar los objetos de las diferentes capas y nunca saltárselos ni pasar el mismo objeto por varias capas.

Se debe mapear el objeto de salida y de entrada.

Todo lo que se diseñe debe tener responsabilidad única, estar lo más desacoplado posible y estar lo más preparado para ser reutilizable.