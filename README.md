# Laboratorio 4. Polimorfismo
## Autor: Jose Merida | 19 de Noviembre 2023
### Instrucciones: 

Una reconocida biblioteca lo ha contratado para desarrollar una aplicación en la que se puedan
prestar libros. Los usuarios pueden registrarse para poder comprar y programar la entrega de sus
productos. La estrategia de mercadeo es tener 2 planes diferentes; el primero denominado “base”
que es gratis y el “premium” que es pagado. El premium permite extender la funcionalidad para
mejorar la experiencia de compra.

El objetivo es incentivar a los usuarios a pagar por el servicio premium.

El cliente le pide que haga un demo de como va a funcionar el sitio incluyendo toda la funcionalidad
descrita a continuación:

- Modo registro:

  - Crear un usuario nuevo utilizando usuario y contraseña.

  - Seleccionar plan (gratis o Premium)

- Ingresar/Salir
   
- Modo selección:
   
  - Agregar un libro.

    - Los usuarios premium pueden prestar 5 libros como máximo.

    - Los usuarios base pueden prestar 3 libros como máximo.
      
  - Agregar revista (las revistas no tienen restricción de cantidad)
    
  - Vaciar lista.
    
- Modo prestamo:
  
  - Definir días de entrega.
    
    - Los usuarios premium pueden prestar a un plazo máximo de 50 días.
      
    - Los usuarios base pueden prestar a un plazo máximo de 30 días.
      
  - Definir horario de entrega (AM/PM). (Premium)
    
  - Definir sucursal para recoger el préstamo (No premium).
    
  - Imprimir listado de préstamo.
    
  - Seleccionar dirección de envío (Premium).
    
  - Definir si va a pasar por el préstamo a las 12 o 24 horas de haber realizado la solicitud (No premium).
    
- Modo perfil:
  
  - Modificar el tipo de cliente. (No premium)
    
  - Aplicar cupón de 15 días adicionales (Premium).
    
  - Cambiar contraseña.
 ### Diagrama UML
![image](https://github.com/user-attachments/assets/cbfc7084-2c80-41d7-829a-b0e07a9bc8f7)
