package lequedevagas.demo.dto.candidatura;

import lequedevagas.demo.model.Candidatura;
import java.time.LocalDateTime;

public record CandidaturaRespostaDTO(
    Long id,
    Long pessoaId,
    Long vagaId,
    String situacao,
    LocalDateTime enviadaEm
) {
    public static CandidaturaRespostaDTO fromModel(Candidatura candidatura) {
        return new CandidaturaRespostaDTO(
            candidatura.getId(),
            candidatura.getPessoaId(),
            candidatura.getVagaId(),
            candidatura.getSituacao(),
            candidatura.getEnviadaEm()
        );
    }
}