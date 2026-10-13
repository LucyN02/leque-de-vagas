package lequedevagas.demo.dto.candidatura;

import jakarta.validation.constraints.NotNull;

public record CandidaturaRequisicaoDTO(
    @NotNull(message = "Pessoa ID Ã© obrigatÃ³rio") Long pessoaId,
    @NotNull(message = "Vaga ID Ã© obrigatÃ³rio") Long vagaId
) {}