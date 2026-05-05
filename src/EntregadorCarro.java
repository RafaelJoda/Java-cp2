public class EntregadorCarro extends Entregador {

    private static final double VELOCIDADE_MEDIA_KMH = 40.0; // Mais lento que moto no trânsito urbano

    public EntregadorCarro(int id, String nome) {
        super(id, nome);
    }

    @Override
    public double calcularTempoEntrega(double distanciaKm) {
        // Tempo em minutos
        return (distanciaKm / VELOCIDADE_MEDIA_KMH) * 60;
    }

    @Override
    public String getTipoVeiculo() {
        return "Carro";
    }
}
