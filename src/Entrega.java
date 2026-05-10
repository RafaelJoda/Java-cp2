public class Entrega {

    public enum Status {
        PENDENTE, EM_ROTA, ENTREGUE, CANCELADO
    }

    private int id;
    private String enderecoDestino;
    private double distanciaKm;
    private Status status;
    private Entregador entregador;
    private String observacao;

    public Entrega(int id, String enderecoDestino, double distanciaKm) {
        this.id = id;
        this.enderecoDestino = enderecoDestino;
        this.distanciaKm = distanciaKm;
        this.status = Status.PENDENTE;
        this.observacao = "";
    }


    public void atualizarStatus(Status novoStatus) {
        this.status = novoStatus;
        System.out.println("Entrega #" + id + " -> Status atualizado para: " + novoStatus);
    }


    public void atualizarStatus(Status novoStatus, String observacao) {
        this.status = novoStatus;
        this.observacao = observacao;
        System.out.println("Entrega #" + id + " -> Status: " + novoStatus + " | Obs: " + observacao);
    }

    public void exibirInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Entrega #" + id);
        System.out.println("Destino: " + enderecoDestino);
        System.out.println("Distância: " + distanciaKm + " km");
        System.out.println("Status: " + status);
        System.out.println("Entregador: " + (entregador != null ? entregador.getNome() + " (" + entregador.getTipoVeiculo() + ")" : "Não atribuído"));
        if (!observacao.isEmpty()) {
            System.out.println("Observação: " + observacao);
        }
        if (entregador != null) {
            double tempo = entregador.calcularTempoEntrega(distanciaKm);
            System.out.printf("Tempo estimado: %.0f minutos%n", tempo);
        }
        System.out.println("----------------------------------------");
    }

    // Getters e Setters
    public int getId() { return id; }
    public Status getStatus() { return status; }
    public Entregador getEntregador() { return entregador; }
    public void setEntregador(Entregador entregador) { this.entregador = entregador; }
    public double getDistanciaKm() { return distanciaKm; }
}
