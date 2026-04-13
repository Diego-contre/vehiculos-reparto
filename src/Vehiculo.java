// Definimos la clase principal (superclase)
public class Vehiculo {



    // Son private para que nadie los modifique directamente

    private String patente;
    private String marca;
    private String modelo;
    private double capacidadCarga;
    private boolean disponible;

    //CONSTRUCTOR
    // Este metodo se ejecuta cuando creamos un objeto Vehiculo
    public Vehiculo(String patente, String marca, String modelo, double capacidadCarga){

        // Guardamos los datos que vienen al crear el objeto
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadCarga = capacidadCarga;

        // Todos los vehículos parten disponibles automáticamente
        this.disponible = true;
    }

    //devuelve la patente del vehiculo
    public String getPatente(){
        return patente;
    }

    //devuelve la marca
    public  String getMarca(){
        return marca;
    }

    //devuelve el modelo
    public String getModelo(){
        return modelo;
    }

    //devuelve la capacidad de carga
    public double getcapacidadCarga(){
        return capacidadCarga;
    }

    // En boolean se usa "is" en vez de "get"
    public boolean isDisponible() {
        return disponible;
    }

    //SETTERS (MODIFICAR DATOS)
    public void setPatente(String patente) {

        if(patente != null && !patente.isEmpty()){

        }else {
            System.out.println("La patenta no puede estar vacia");
        }
    }

    //cambiar modelo
    public void setModelo(String modelo) {
        if(modelo !=null && !modelo.isEmpty()) {
            this.modelo = modelo;
        }else{
            System.out.println("El modelo no puede estar vacio");
        }
    }

    public void setCapacidadCarga(double capacidadCarga) {
        if(capacidadCarga >=0) {
            this.capacidadCarga = capacidadCarga;
        } else{
            System.out.println("La capacidad no puede ser negativa");
        }
    }
    public void mostrarDetalle(){
        System.out.println("= VEHICULO =");
        System.out.println("Patente " + patente);
        System.out.println("Marca: " +  marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Capacidad de carga: " + capacidadCarga);

        if (disponible) {
            System.out.println("Disponible: Sí");
        } else {
            System.out.println("Disponible: No");
        }

    }
}
