public class Camion extends Vehiculo {

    private int numeroEjes;

    public Camion(String patente, String marca, String modelo, double capacidadCarga, int numeroEjes) {
        super(patente, marca, modelo, capacidadCarga);
        this.numeroEjes = numeroEjes;
        System.out.println("Camión registrado: " + marca + " " + modelo + " | Patente: " + patente + " | Ejes: " + numeroEjes);
    }

    public int getNumeroEjes() { return numeroEjes; }

    public void setNumeroEjes(int numeroEjes) {
        if (numeroEjes <= 0) {
            System.out.println("Advertencia: El número de ejes debe ser mayor a 0.");
            return;
        }
        this.numeroEjes = numeroEjes;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("CAMIÓN" +
                " | Patente: " + getPatente() +
                " | Marca: " + getMarca() +
                " | Carga: " + getCapacidadCarga() +
                " | Ejes: " + numeroEjes +
                " | Disponible: " + isDisponible());
    }
}