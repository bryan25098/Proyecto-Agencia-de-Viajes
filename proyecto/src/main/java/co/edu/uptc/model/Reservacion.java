package co.edu.uptc.model;

public class Reservacion {
    private Cliente cliente;
    private Destino destino;
    private int numeroPasajeros;

    public Reservacion(Cliente cliente, Destino destino, int numeroPasajeros) {
        this.cliente = cliente;
        this.destino = destino;
        this.numeroPasajeros = numeroPasajeros;
    }

    public Reservacion() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    @Override
    public String toString() {
        return "Reservacion [cliente=" + cliente + ", destino=" + destino + ", numeroPasajeros=" + numeroPasajeros
                + "]";
    }

}