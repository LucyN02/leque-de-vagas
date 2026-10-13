package lequedevagas.demo.repository;

import lequedevagas.demo.model.Candidatura;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CandidaturaRepository {
    private final Map<Long, Candidatura> tabelaCandidaturas = new LinkedHashMap<>();
    private final AtomicLong geradorId = new AtomicLong(1);

    public Candidatura salvar(Candidatura candidatura) {
        if (candidatura.getId() == null) {
            candidatura.setId(geradorId.getAndIncrement());
            candidatura.setEnviadaEm(LocalDateTime.now());
            candidatura.setSituacao("RECEBIDA");
        }
        tabelaCandidaturas.put(candidatura.getId(), candidatura);
        return candidatura;
    }

    public List<Candidatura> listarTodas() {
        return new ArrayList<>(tabelaCandidaturas.values());
    }
}