public class Vuelo {

    private String numero;
    private String origen;
    private String destino;
    private int capacidadMaxima;
    private Asiento[] asientos; //PRIMERA PARTE DE LA COMPOSICIÓN, EL VUELO CREA Y POSEE SUS ASIENTOS 

    //CONSTRUCTORES
    public Vuelo(){
    }

    public Vuelo(String numero, String origen, String destino){
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
    }

    //AL CONSTRUIR EL VUELO CON CAPACIDAD, SE CREAN AUTOMATICAMENTE LOS ASIENTOS
    public Vuelo(String numero, String origen, String destino, int capacidadMaxima){
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        this.capacidadMaxima = capacidadMaxima;
        //EL VUELO CREA SUS ASIENTOS - SEGUNDA PARTE DE LA COMPOSICIÓN
        asientos = new Asiento[capacidadMaxima];
        for (int i = 0; i < capacidadMaxima; i++){
            asientos[i] = new Asiento("A" + (i + 1));
        }
    }


    //GETTERS
    public String getNumero(){
        return this.numero;
    }

    public String getOrigen(){
        return this.origen;
    }

    public String getDestino(){
        return this.destino;
    }

    public int getCapacidadMaxima(){
        return this.capacidadMaxima;
    }

    //METODOS
    public void mostrarInfo(){
        System.out.println("---- VUELO " + this.numero + " ----");
        System.out.println("Ruta: " + this.origen + " -> " + this.destino);
        System.out.println("Capacidad: " + this.capacidadMaxima + " asientos");
    }

    //Muestra el estado de cada asiento
    public void mostrarAsientos(){
        System.out.println("Estado de asientos - Vuelo " + this.numero + ":");
        for (Asiento a : asientos){
            a.mostrarEstado();
        }
    }

    //Busca un asiento por codigo y lo ocupa
    public void embarcar(String codigoAsiento){
        for (Asiento a : asientos){
            if (a.getCodigo().equals(codigoAsiento)){
                a.ocupar();
                return;
            }
        }
    }

    public void desembarcar(String codigoAsiento){
        for (Asiento a : asientos){
            if (a.getCodigo().equals(codigoAsiento)){
                a.liberar();
                return;
            }
        }        
    }
}
