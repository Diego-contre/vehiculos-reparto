public class Vehiculo {

    public String patente;
    public String marca;
    public String modelo;
    public double capacidadCarga;
    public boolean disponible;

    // === Constructor ===
    public Vehiculo(String patente, String marca, String modelo, double capacidadCarga, boolean disponible) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadCarga = capacidadCarga;
        this.disponible = disponible;
    }

    // === GET ===
    public String getPatente(){
        return patente;
    }
    public String getMarca(){
        return marca;
    }
    public String getModelo(){
        return modelo;
    }
    public double getCapacidadCarga(){
        return capacidadCarga;
    }
    public boolean isDisponible(){
        return disponible;
    }

    // === SET ===

    public void setPatente(){
        this.patente = patente;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        //verificamos que la capacidad de carga no sea negativo
        if (capacidadCarga > 0){
            this.capacidadCarga = capacidadCarga;
        }
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void mostrarDetalle() {
        System.out.println("Patente: "+ patente + " | Marca: " + marca + " | Modelo: " + modelo + " | ");
    }


}
