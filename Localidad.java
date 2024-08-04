/**
 * Clase Localidad utilizada para almacenar y actualizar los datos de cada localidad
 * @Param precio el precio por boleto de cada localidad
 * @Param lugares los lugares disponibles por cada localidad
 * @Param ingresos los ingresos generados por cada localidad
 */
public class Localidad {
    public int precio;
    public int lugares;
    public int ingresos;

    /**
     * Constructor de localidad
     * @param precio El precio por boleto
     * @param lugares Los lugares inicialmente disponibles
     */
    public Localidad(int precio, int lugares){
        this.precio = precio;
        this.lugares = lugares;
        //Ingresos iniciales en 0
        this.ingresos = 0;
    }

    /**
     * Método que resta un lugar a los disponibles y suma el precio de un boleto a los ingresos
     */
    public void vender(){
        this.lugares--;
        this.ingresos = this.ingresos + this.precio;
    }

    /**
     * Método que muestra la disponibilidad de lugares
     */
    public void showAvailability(){
        System.out.println("La localidad cuenta con " + this.lugares + " lugares disponibles");
    }
}

