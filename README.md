# Ejercicio 1. Overloading y Relaciones entre Clases
## Autor: Jose Merida | 15 de Agosto 2023
### Instrucciones: 
La administración de Tomorrowland está solicitando ayuda de programadores para hacer un
experimento en las ventas de tickets. Debido a la inconformidad de los fans en los eventos
anteriores por lo rápido que se vendieron los boletos se decidió implementar un nuevo algoritmo
de compra aleatorio que sea justo y de las mismas posibilidades a todos.
Para poder comprar los boletos se debe hacer lo siguiente:
1. Solicitar una compra de un boleto. Para hacer esto se debe ingresar el nombre, dpi,
cantidad de boletos a comprar y presupuesto máximo.
2. Cuando se hace la solicitud de compra se genera un número aleatorio de 1 a 33,000.
3. Ese número generado es el “ticket” y, para determinar si un ticket puede comprar boletos
se debe generar 2 números aleatorios (a y b) adicionales dentro del mismo rango (1 a
15,000). Se debe validar que la suma del ticket y los otros 2 números sea par. Si esto se
cumple, el ticket es apto para comprar boletos.
4. Debido a que este proceso es más complejo solo se piensa utilizar como piloto para vender
60 entradas. distribuidas de forma igualitaria en 3 localidades diferentes:
a. Localidad 1 - La más alejada del escenario pero la más barata con un precio de
$400.
b. Localidad 5 - En medio y con una mejor vista al escenario pero con un precio de
$695.
c. Localidad 10 - Hasta adelante, la mejor vista del concierto pero la más cara con un
precio de $2350.
5. Cuando un ticket es apto para compra se debe seleccionar de forma aleatoria la localidad a
asignarle dentro de las 3 disponibles.
Universidad del Valle de Guatemala
CC2008 - Introducción a la Programación Orientada a Objetos
Semestre II, 2023
Ejercicio 1 - Overloading y relaciones entre clases
6. Al tener la localidad definida se deben realizar 3 validaciones:
a. Validar espacio: no es posible vender los tickets si la localidad no tiene espacio, es
decir si ya se vendieron los 20 espacios disponibles.
b. Validar disponibilidad de los boletos deseados: Se debe validar que exista espacio
para la cantidad de boletos que el comprador quiere comprar. Si no es así se le
vende la mayor cantidad posible sin exceder el límite deseado.
c. Validar precio: si el precio de la sección es mayor al presupuesto no se puede
comprar el boleto y se termina el proceso para ese comprador.
7. Si pasan las validaciones anteriores, se le vende al usuario la cantidad de boletos
determinada.
