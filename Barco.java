// Clase Barco (herencia simple)
class Barco {
    private int longitud;
    private int[] coordenadas;

    public Barco(int longitud) {
        this.longitud = longitud;
        this.coordenadas = new int[longitud];
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(int[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public void mostrarBarco() {
        System.out.println("Barco de longitud: " + longitud);
    }
}

// Interfaces para herencia múltiple
interface Ataque {
    void atacar();
}

interface Defensa {
    void defender();
}

interface Transporte {
    void transportar();
}
