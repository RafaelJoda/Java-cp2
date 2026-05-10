import java.util.ArrayList;
import java.util.List;

public class SistemaLogistica {

    private List<Entregador> entregadores;
    private List<Entrega> entregas;
    private int proximoIdEntregador;
    private int proximoIdEntrega;

    public SistemaLogistica() {
        this.entregadores = new ArrayList<>();
        this.entregas = new ArrayList<>();
        this.proximoIdEntregador = 1;
        this.proximoIdEntrega = 1;
    }



    public void cadastrarEntregador(String nome, String tipo) {
        Entregador entregador;
        switch (tipo.toLowerCase()) {
            case "moto":
                entregador = new EntregadorMoto(proximoIdEntregador++, nome);
                break;
            case "bicicleta":
                entregador = new EntregadorBicicleta(proximoIdEntregador++, nome);
                break;
            case "carro":
                entregador = new EntregadorCarro(proximoIdEntregador++, nome);
                break;
            default:
                System.out.println("Tipo de veículo inválido. Use: moto, bicicleta ou carro.");
                return;
        }
        entregadores.add(entregador);
        System.out.println("Entregador cadastrado com sucesso! ID: " + entregador.getId());
    }

    public void listarEntregadores() {
        if (entregadores.isEmpty()) {
            System.out.println("Nenhum entregador cadastrado.");
            return;
        }
        System.out.println("\n===== ENTREGADORES =====");
        for (Entregador e : entregadores) {
            e.exibirInfo(true);
        }
    }

    public void listarEntregadoresDisponiveis() {
        System.out.println("\n===== ENTREGADORES DISPONÍVEIS =====");
        boolean algumDisponivel = false;
        for (Entregador e : entregadores) {
            if (e.isDisponivel()) {
                e.exibirInfo();
                algumDisponivel = true;
            }
        }
        if (!algumDisponivel) {
            System.out.println("Nenhum entregador disponível no momento.");
        }
    }



    public void criarEntrega(String endereco, double distanciaKm) {
        Entrega entrega = new Entrega(proximoIdEntrega++, endereco, distanciaKm);
        entregas.add(entrega);
        System.out.println("Entrega criada com sucesso! ID: " + entrega.getId());
    }

    public void listarEntregas() {
        if (entregas.isEmpty()) {
            System.out.println("Nenhuma entrega cadastrada.");
            return;
        }
        System.out.println("\n===== ENTREGAS =====");
        for (Entrega e : entregas) {
            e.exibirInfo();
        }
    }

    public void atribuirEntrega(int idEntrega, int idEntregador) {
        Entrega entrega = buscarEntrega(idEntrega);
        Entregador entregador = buscarEntregador(idEntregador);

        if (entrega == null) {
            System.out.println("Entrega não encontrada.");
            return;
        }
        if (entregador == null) {
            System.out.println("Entregador não encontrado.");
            return;
        }
        if (!entregador.isDisponivel()) {
            System.out.println("Entregador indisponível no momento.");
            return;
        }
        if (entrega.getStatus() != Entrega.Status.PENDENTE) {
            System.out.println("Entrega não está pendente.");
            return;
        }

        entrega.setEntregador(entregador);
        entrega.atualizarStatus(Entrega.Status.EM_ROTA);
        entregador.setDisponivel(false);
        entregador.atualizarLocalizacao("Em rota para: " + entrega.hashCode()); // simulação

        double tempo = entregador.calcularTempoEntrega(entrega.getDistanciaKm());
        System.out.printf("Entrega #%d atribuída a %s. Tempo estimado: %.0f minutos.%n",
                idEntrega, entregador.getNome(), tempo);
    }

    public void atualizarStatusEntrega(int idEntrega, String novoStatus, String observacao) {
        Entrega entrega = buscarEntrega(idEntrega);
        if (entrega == null) {
            System.out.println("Entrega não encontrada.");
            return;
        }

        Entrega.Status status;
        try {
            status = Entrega.Status.valueOf(novoStatus.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Status inválido. Use: PENDENTE, EM_ROTA, ENTREGUE, CANCELADO");
            return;
        }

        if (observacao == null || observacao.isBlank()) {
            entrega.atualizarStatus(status);
        } else {
            entrega.atualizarStatus(status, observacao);
        }


        if ((status == Entrega.Status.ENTREGUE || status == Entrega.Status.CANCELADO)
                && entrega.getEntregador() != null) {
            entrega.getEntregador().setDisponivel(true);
            entrega.getEntregador().atualizarLocalizacao("Base");
        }
    }


    private Entrega buscarEntrega(int id) {
        for (Entrega e : entregas) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    private Entregador buscarEntregador(int id) {
        for (Entregador e : entregadores) {
            if (e.getId() == id) return e;
        }
        return null;
    }
}
