package lequedevagas.demo.dto.busca;

public record EstatisticasRespostaDTO(
        int totalVagas,
        int totalEmpresas,
        int totalCandidaturas,
        long vagasParaIniciantes
) {}
