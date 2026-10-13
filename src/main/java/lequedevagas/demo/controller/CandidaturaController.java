package lequedevagas.demo.controller;

import jakarta.validation.Valid;
import lequedevagas.demo.dto.candidatura.CandidaturaRequisicaoDTO;
import lequedevagas.demo.dto.candidatura.CandidaturaRespostaDTO;
import lequedevagas.demo.service.CandidaturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/candidaturas")
public class CandidaturaController {
    private final CandidaturaService candidaturaService;

    public CandidaturaController(CandidaturaService candidaturaService) {
        this.candidaturaService = candidaturaService;
    }

    @PostMapping
    public ResponseEntity<CandidaturaRespostaDTO> criar(@RequestBody @Valid CandidaturaRequisicaoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidaturaService.candidatar(dto));
    }

    @GetMapping
    public ResponseEntity<List<CandidaturaRespostaDTO>> listar() {
        return ResponseEntity.ok(candidaturaService.listarTodas());
    }
}