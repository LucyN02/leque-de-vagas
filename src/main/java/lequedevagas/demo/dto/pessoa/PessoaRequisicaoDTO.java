package lequedevagas.demo.dto.pessoa;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PessoaRequisicaoDTO(
    @NotBlank(message = "Nome Ã© obrigatÃ³rio") String nome,
    @NotBlank(message = "E-mail Ã© obrigatÃ³rio") @Email(message = "Informe um e-mail vÃ¡lido") String email,
    @NotBlank(message = "Telefone Ã© obrigatÃ³rio") String telefone,
    @NotBlank(message = "Cidade Ã© obrigatÃ³ria") String cidade,
    @NotBlank(message = "Ãrea de interesse Ã© obrigatÃ³ria") String areaInteresse
) {}