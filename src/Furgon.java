public class Furgon extends Vehiculo {

    private double volumenInterior;

    public Furgon(String patente, String marca, String modelo, double capacidadCarga, boolean disponible, double volumenInterior) {
        super(patente, marca, modelo, capacidadCarga, disponible);
        setVolumenInterior(volumenInterior);
    }

    public double getVolumenInterior() {
        return volumenInterior;
    }

    public void setVolumenInterior(double volumenInterior) {
        if (volumenInterior < 0) {
            throw new IllegalArgumentException("El volumen interior no puede ser negativo.");
        }
        this.volumenInterior = volumenInterior;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("=== FURGÓN ===");
        System.out.println("Patente: " + getPatente());
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Capacidad de carga: " + getCapacidadCarga() + " kg");
        System.out.println("Disponible: " + (isDisponible() ? "Sí" : "No"));
        System.out.println("Volumen interior: " + volumenInterior + " m3");
        System.out.println("---------------------------");
    }
}