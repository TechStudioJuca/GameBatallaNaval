// Clase BarcoDeGuerra que hereda de Barco e implementa múltiples interfaces
class BarcoDeGuerra extends Barco implements Ataque, Defensa, Transporte {
    public BarcoDeGuerra(int longitud) {
        super(longitud);
    }

    @Override
    public void atacar() {
        System.out.println("Barco de guerra atacando!");
    }

    @Override
    public void defender() {
        System.out.println("Barco de guerra defendiendo!");
    }

    @Override
    public void transportar() {
        System.out.println("Barco de guerra transportando!");
    }
}

// Ejemplo de uso de instanceof
class RevisionHerencia {
    public void verificarHerencia(Object obj) {
        if (obj instanceof Barco) {
            System.out.println("El objeto es una instancia de Barco");
        }
    }
}
