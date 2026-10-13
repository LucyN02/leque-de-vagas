package lequedevagas.demo.repository;

import lequedevagas.demo.model.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PessoaRepository {
    private final Map<Long, Pessoa> tabelaPessoas = new LinkedHashMap<>();
    private final AtomicLong geradorId = new AtomicLong(1);

    public List<Pessoa> listarTodas() {
        return new ArrayList<>(tabelaPessoas.values());
    }

    public Optional<Pessoa> buscarPorId(Long id) {
        return Optional.ofNullable(tabelaPessoas.get(id));
    }

    public boolean existePorEmail(String email) {
        return tabelaPessoas.values().stream()
            .anyMatch(pessoa -> pessoa.getEmail().equalsIgnoreCase(email));
    }

    public Pessoa salvar(Pessoa pessoa) {
        if (pessoa.getId() == null) {
            pessoa.setId(geradorId.getAndIncrement());
        }
        tabelaPessoas.put(pessoa.getId(), pessoa);
        return pessoa;
    }
}