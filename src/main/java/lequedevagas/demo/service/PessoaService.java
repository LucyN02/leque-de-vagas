package lequedevagas.demo.service;

import lequedevagas.demo.dto.pessoa.PessoaRequisicaoDTO;
import lequedevagas.demo.dto.pessoa.PessoaRespostaDTO;
import lequedevagas.demo.exception.EmailJaCadastradoException;
import lequedevagas.demo.model.Pessoa;
import lequedevagas.demo.repository.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaRespostaDTO criar(PessoaRequisicaoDTO dto) {
        if (pessoaRepository.existePorEmail(dto.email())) {
            throw new EmailJaCadastradoException("JÃ¡ existe uma pessoa cadastrada com este e-mail");
        }

        Pessoa pessoa = new Pessoa(
            dto.nome(),
            dto.email(),
            dto.telefone(),
            dto.cidade(),
            dto.areaInteresse()
        );

        return PessoaRespostaDTO.fromModel(pessoaRepository.salvar(pessoa));
    }
}