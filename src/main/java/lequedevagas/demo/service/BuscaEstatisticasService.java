package lequedevagas.demo.service;

import lequedevagas.demo.dto.busca.EstatisticasRespostaDTO;
import lequedevagas.demo.dto.vaga.VagaRespostaDTO;
import lequedevagas.demo.repository.CandidaturaRepository;
import lequedevagas.demo.repository.EmpresaRepository;
import lequedevagas.demo.repository.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscaEstatisticasService {

    private final VagaRepository vagaRepository;
    private final EmpresaRepository empresaRepository;
    private final CandidaturaRepository candidaturaRepository;

    public BuscaEstatisticasService(
            VagaRepository vagaRepository,
            EmpresaRepository empresaRepository,
            CandidaturaRepository candidaturaRepository
    ) {
        this.vagaRepository = vagaRepository;
        this.empresaRepository = empresaRepository;
        this.candidaturaRepository = candidaturaRepository;
    }

    public EstatisticasRespostaDTO calcularEstatisticas() {
        var vagas = vagaRepository.listarTodas();
        int totalEmpresas = empresaRepository.listarTodas().size();
        int totalCandidaturas = candidaturaRepository.listarTodas().size();
        long aceitaIniciante = vagas.stream().filter(v -> Boolean.TRUE.equals(v.getAceitaIniciante())).count();

        return new EstatisticasRespostaDTO(
                vagas.size(),
                totalEmpresas,
                totalCandidaturas,
                aceitaIniciante
        );
    }

    public List<VagaRespostaDTO> buscarVagas(String area, String senioridade) {
        return vagaRepository.listarTodas().stream()
                .filter(v -> area == null || v.getArea().equalsIgnoreCase(area))
                .filter(v -> senioridade == null || v.getSenioridade().equalsIgnoreCase(senioridade))
                .map(VagaRespostaDTO::fromModel)
                .toList();
    }
}