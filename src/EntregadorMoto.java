public class EntregadorMoto extends Entregador {

    private static final double VELOCIDADE_MEDIA_KMH = 60.0;

    public EntregadorMoto(int id, String nome) {
        super(id, nome);
    }

    @Override
    public double calcularTempoEntrega(double distanciaKm) {
        // Tempo em minutos
        return (distanciaKm / VELOCIDADE_MEDIA_KMH) * 60;
    }

    @Override
    public String getTipoVeiculo() {
        return "Moto";
    }
}
