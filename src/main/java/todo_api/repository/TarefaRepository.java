package todo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todo_api.model.Tarefa;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
    List<Tarefa> findByConcluida(Boolean concluida);
}
