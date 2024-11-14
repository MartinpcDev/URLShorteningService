# URL Shortening Service API

Challenge basado en [Shortening Service](https://roadmap.sh/projects/url-shortening-service)

Este proyecto es una API RESTful para un servicio de acortamiento de URLs. Permite a los usuarios
crear URLs cortas, recuperar la URL original, actualizar o eliminar URLs cortas, y obtener
estadísticas de acceso. El objetivo es proporcionar una interfaz sencilla para gestionar y redirigir
URLs largas a versiones cortas y amigables.

## Base de Datos

![db image](/src/main/resources/static/db_model.png)

## Características

La API soporta las siguientes operaciones:

1. **Crear una URL corta**: Genera una URL corta a partir de una URL original.
2. **Recuperar la URL original**: Devuelve la URL original a partir de una URL corta.
3. **Actualizar una URL corta**: Permite actualizar la URL original de una URL corta existente.
4. **Eliminar una URL corta**: Elimina una URL corta de la base de datos.
5. **Obtener estadísticas**: Muestra estadísticas de una URL corta, incluyendo el conteo de accesos.