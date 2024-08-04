import java.util.Random;
import java.util.Scanner;

/**
 * Clase Solicitud Una solicitud de compra
 * @Param ticket numero aleatorio entre 1 y 33000
 * @Param valid validez
 * @Param boletos cantidad de boletos
 * @Param presupuesto el presupuesto del comprador
 */
public class Solicitud {
    private int ticket;
    public boolean valid;
    public int boletos;
    public int presupuesto;

    /**
     * Constructor de solicitud, crea el ticket de la solicitud especifica
     */
    public Solicitud(){
        this.ticket = (int)Math.floor(Math.random() * (33000) + 1);
    }

    /**
     * Metodo para validar si el ticket puede realizar la compra o no
     */
    public void validate(){
        int a = (int)Math.floor(Math.random() * (15000) + 1);
        int b = (int)Math.floor(Math.random() * (15000) + 1);
        int suma = ticket + a + b;
        if (suma % 2 == 0){
            this.valid = true;
            System.out.println("Solicitud Aprobada");
        }
        else {
            this.valid = false;
        }
    }

    /**
     * Metodo para pedirle al usuario los detalles de la solicitud
     */
    public void getDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de tickets por comprar");
        this.boletos = scanner.nextInt();
        System.out.println("Ingrese el presupuesto");
        this.presupuesto = scanner.nextInt();
    }

    /**
     * Metodo que resta un boleto al numero de boletos inicialmente deseado
     * y actualiza el presupuesto restante
     * @param precio el precio de cada boleto
     */
    public void vender(int precio){
        this.boletos--;
        this.presupuesto = this.presupuesto - precio;
    }
    //Método para terminar la compra, coloca los boletos como 0
    public void end(){
        this.boletos = 0;
    }
}
