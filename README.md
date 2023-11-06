# Interceptores en Spring 🕝

Este proyecto de ejemplo en Spring utiliza un interceptor para mostrar un mensaje de bienvenida a los usuarios que acceden a la aplicación dentro del horario de atención al cliente, y redirige a una página de cierre fuera del horario. 

## 🚀 Funcionalidad

El proyecto consta de tres partes principales:

1. **Controlador (`AppController`):** Este controlador maneja las rutas principales de la aplicación. Si un usuario accede a la raíz (`/`), al inicio (`/index`), o a una ruta vacía (`""`), se muestra un mensaje de bienvenida. Además, se ha definido una ruta "/cerrado" que muestra un mensaje de cierre si el horario de atención al cliente ha finalizado.

2. **Interceptor (`HorarioInterceptor`):** El interceptor `HorarioInterceptor` verifica la hora actual y, según el horario de atención definido en el archivo `application.properties`, decide si mostrar un mensaje de bienvenida o redirigir al usuario a la página de cierre.

3. **Configuración (`MvcConfig`):** En la configuración de Spring MVC, se registra el interceptor para que se aplique a todas las rutas, excepto a "/cerrado", permitiendo el control del horario de atención en toda la aplicación.

## 🔄 Interceptores en Spring

Los interceptores son componentes que permiten agregar lógica personalizada antes y después de que las solicitudes sean manejadas por los controladores en Spring. 

Son útiles para realizar acciones como autenticación, registro, manejo de sesiones, localización, compresión y más.

En este proyecto, el interceptor `HorarioInterceptor` controla el horario de atención al cliente y muestra un mensaje personalizado según esté el usuario dentro o no del horario establecido.

## 💡Esquema explicativo: 

![Esquema Interceptores](https://github.com/Alvarosanchezz3/SpringBoot-Horario/assets/99328696/2bc50f9c-88fb-41b0-9754-c5daf3f7f6bf)


