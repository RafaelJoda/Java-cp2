public class EntregadorBicicleta extends Entregador {

    private static final double VELOCIDADE_MEDIA_KMH = 20.0;

    public EntregadorBicicleta(int id, String nome) {
        super(id, nome);
    }

    @Override
    public double calcularTempoEntrega(double distanciaKm) {
        // Tempo em minutos
        return (distanciaKm / VELOCIDADE_MEDIA_KMH) * 60;
    }

    @Override
    public String getTipoVeiculo() {
        return "Bicicleta";
    }
}
