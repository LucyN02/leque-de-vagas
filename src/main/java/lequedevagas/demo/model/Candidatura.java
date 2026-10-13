package lequedevagas.demo.model;

import java.time.LocalDateTime;

public class Candidatura {
    private Long id;
    private Long pessoaId;
    private Long vagaId;
    private String situacao;
    private LocalDateTime enviadaEm;

    public Candidatura(Long pessoaId, Long vagaId) {
        this.pessoaId = pessoaId;
        this.vagaId = vagaId;
    }

    public Candidatura(Long id, Long pessoaId, Long vagaId, String situacao, LocalDateTime enviadaEm) {
        this.id = id;
        this.pessoaId = pessoaId;
        this.vagaId = vagaId;
        this.situacao = situacao;
        this.enviadaEm = enviadaEm;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPessoaId() { return pessoaId; }
    public void setPessoaId(Long pessoaId) { this.pessoaId = pessoaId; }
    public Long getVagaId() { return vagaId; }
    public void setVagaId(Long vagaId) { this.vagaId = vagaId; }
    public String getSituacao() { return situacao; }
    public void setSituacao(String situacao) { this.situacao = situacao; }
    public LocalDateTime getEnviadaEm() { return enviadaEm; }
    public void setEnviadaEm(LocalDateTime enviadaEm) { this.enviadaEm = enviadaEm; }
}