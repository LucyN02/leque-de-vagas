package lequedevagas.demo.controller;

import jakarta.validation.Valid;
import lequedevagas.demo.dto.pessoa.PessoaRequisicaoDTO;
import lequedevagas.demo.dto.pessoa.PessoaRespostaDTO;
import lequedevagas.demo.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<PessoaRespostaDTO> criar(@RequestBody @Valid PessoaRequisicaoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.criar(dto));
    }
}