public abstract class Entregador implements Rastreavel {

    private int id;
    private String nome;
    private boolean disponivel;
    private String localizacaoAtual;

    public Entregador(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.disponivel = true;
        this.localizacaoAtual = "Base";
    }

    // Método abstrato - cada tipo calcula à sua maneira
    public abstract double calcularTempoEntrega(double distanciaKm);

    // Método abstrato - cada tipo tem sua descrição
    public abstract String getTipoVeiculo();

    // Implementação da interface Rastreavel
    @Override
    public void atualizarLocalizacao(String local) {
        this.localizacaoAtual = local;
        System.out.println("[" + nome + "] Localização atualizada para: " + local);
    }

    @Override
    public String getLocalizacaoAtual() {
        return localizacaoAtual;
    }

    // Sobrecarga: exibir info simples
    public void exibirInfo() {
        System.out.println("ID: " + id + " | Nome: " + nome + " | Veículo: " + getTipoVeiculo()
                + " | Disponível: " + (disponivel ? "Sim" : "Não"));
    }

    // Sobrecarga: exibir info com localização
    public void exibirInfo(boolean mostrarLocalizacao) {
        exibirInfo();
        if (mostrarLocalizacao) {
            System.out.println("   Localização atual: " + localizacaoAtual);
        }
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
}
