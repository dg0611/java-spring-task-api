package todo_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import todo_api.dto.FormDto;
import todo_api.model.Tarefa;
import todo_api.repository.TarefaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    TarefaRepository repository;

    public List<Tarefa> listar() {
        return repository.findAll();
    }

    public ResponseEntity cadastrar(FormDto dto) {
        Tarefa t = repository.save(new Tarefa(dto.descricao(), dto.titulo(), dto.concluida()));
        return ResponseEntity.ok(t);
    }

    public Optional<Tarefa> buscarPorId(Long id) {
        return repository.findById(id);
    }


    public void deletarPorId(Long id) {
         var retornoSeExiste = repository.findById(id);
         if (retornoSeExiste.isPresent()){
             repository.deleteById(id);
         }
        else
            ResponseEntity.notFound();
    }

    public List<Tarefa> getTarefasMArcadasComoConcluidas() {
       return repository.findAll()
                .stream().filter(it -> it.isConcluida()).toList();
    }

    public List<Tarefa> getTarefasMarcadasComoPendente() {
        return repository.findAll()
                .stream().filter(pendentes -> !pendentes.isConcluida()).toList();
    }
}