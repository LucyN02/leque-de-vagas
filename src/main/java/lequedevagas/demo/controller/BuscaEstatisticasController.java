package lequedevagas.demo.controller;

import lequedevagas.demo.dto.busca.EstatisticasRespostaDTO;
import lequedevagas.demo.dto.vaga.VagaRespostaDTO;
import lequedevagas.demo.service.BuscaEstatisticasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuscaEstatisticasController {

    private final BuscaEstatisticasService service;

    public BuscaEstatisticasController(BuscaEstatisticasService service) {
        this.service = service;
    }

    @GetMapping("/estatisticas")
    public ResponseEntity<EstatisticasRespostaDTO> getEstatisticas() {
        return ResponseEntity.ok(service.calcularEstatisticas());
    }

    @GetMapping("/vagas/busca")
    public ResponseEntity<List<VagaRespostaDTO>> buscar(
            @RequestParam(required = false) String area,
            @RequestParam(required = false) String senioridade
    ) {
        return ResponseEntity.ok(service.buscarVagas(area, senioridade));
    }
}