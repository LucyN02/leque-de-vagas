package lequedevagas.demo.dto.pessoa;

import lequedevagas.demo.model.Pessoa;

public record PessoaRespostaDTO(
    Long id,
    String nome,
    String email,
    String telefone,
    String cidade,
    String areaInteresse
) {
    public static PessoaRespostaDTO fromModel(Pessoa pessoa) {
        return new PessoaRespostaDTO(
            pessoa.getId(),
            pessoa.getNome(),
            pessoa.getEmail(),
            pessoa.getTelefone(),
            pessoa.getCidade(),
            pessoa.getAreaInteresse()
        );
    }
}