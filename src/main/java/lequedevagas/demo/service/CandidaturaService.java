package lequedevagas.demo.service;

import lequedevagas.demo.dto.candidatura.CandidaturaRequisicaoDTO;
import lequedevagas.demo.dto.candidatura.CandidaturaRespostaDTO;
import lequedevagas.demo.exception.RecursoNaoEncontradoException;
import lequedevagas.demo.model.Candidatura;
import lequedevagas.demo.repository.CandidaturaRepository;
import lequedevagas.demo.repository.PessoaRepository;
import lequedevagas.demo.repository.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidaturaService {
    private final CandidaturaRepository candidaturaRepository;
    private final PessoaRepository pessoaRepository;
    private final VagaRepository vagaRepository;

    public CandidaturaService(
        CandidaturaRepository candidaturaRepository,
        PessoaRepository pessoaRepository,
        VagaRepository vagaRepository
    ) {
        this.candidaturaRepository = candidaturaRepository;
        this.pessoaRepository = pessoaRepository;
        this.vagaRepository = vagaRepository;
    }

    public CandidaturaRespostaDTO candidatar(CandidaturaRequisicaoDTO dto) {
        pessoaRepository.buscarPorId(dto.pessoaId())
            .orElseThrow(() -> new RecursoNaoEncontradoException(
                "Pessoa com ID " + dto.pessoaId() + " nÃ£o encontrada"
            ));

        vagaRepository.buscarPorId(dto.vagaId())
            .orElseThrow(() -> new RecursoNaoEncontradoException(
                "Vaga com ID " + dto.vagaId() + " nÃ£o encontrada"
            ));

        Candidatura candidatura = new Candidatura(dto.pessoaId(), dto.vagaId());
        return CandidaturaRespostaDTO.fromModel(candidaturaRepository.salvar(candidatura));
    }

    public List<CandidaturaRespostaDTO> listarTodas() {
        return candidaturaRepository.listarTodas().stream()
            .map(CandidaturaRespostaDTO::fromModel)
            .toList();
    }
}