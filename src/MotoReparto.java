public class MotoReparto extends Vehiculo {
    //Se agrega variable solo de caja termica
    //las demas ya estan agregadas
    private boolean cajaTermica;


    public MotoReparto(String patente, String marca, String modelo, double capacidadCarga, boolean disponible) {
        super(patente, marca, modelo, capacidadCarga);
        this.cajaTermica = cajaTermica;

    }
    // === get ===
    public boolean isCajaTermica() {
        return cajaTermica;
    }
    // === set ===
    public void setCajaTermica(boolean cajaTermica) {
        this.cajaTermica = cajaTermica;
    }

    public void mostrarDetalle(){
        super.mostrarDetalle();
        System.out.println("Tipo: Moto de reparto");
        System.out.println("Caja térmica: "+ (cajaTermica ? "Sí": "No"));
    }


// Agregar en el Main para que funcione con Listas
//        import java.util.ArrayList;
//     ArrayList<Vehiculo> vehiculos = new ArrayList<>();
//        MotoReparto moto = new MotoReparto("XD-66-99","Honda","Yaris",40,true);
//        vehiculos.add(moto);
//        moto.mostrarDetalle();
}
