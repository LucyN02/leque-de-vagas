package lequedevagas.demo.dto.busca;

public record EstatisticaRespostaDTO(
        int totalVagas,
        int totalEmpresas,
        int totalCandidaturas,
        long vagasParaIniciantes
) {}
