// Clase Jugador
class Jugador {
    private String nombre;
    private int[] coordenadas;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    // Métodos públicos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos protegidos
    protected int[] getCoordenadas() {
        return coordenadas;
    }

    protected void setCoordenadas(int[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    // Métodos privados
    private void mostrarMensaje() {
        System.out.println("Jugador: " + nombre);
    }
}
