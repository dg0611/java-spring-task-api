package todo_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todo_api.dto.FormDto;
import todo_api.model.Tarefa;
import todo_api.service.TarefaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    TarefaService service;

    @GetMapping
    public List<Tarefa> listarTarefas() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity cadastarTarefa(@RequestBody FormDto dto) {
        ResponseEntity<Tarefa> t = service.cadastrar(dto);
        return ResponseEntity.ok(t);
    }

    @GetMapping("/{id}")
    public Optional<Tarefa> buscarTarefaPorID(@PathVariable(value = "id") Long id) {
        Optional<Tarefa> retorno = service.buscarPorId(id);
        if (!retorno.isEmpty()) {
            return ResponseEntity.ok(retorno).getBody();
        } else
            return Optional.empty();
        //melhorar isso aki e colocar para retornar notfound
    }

    @DeleteMapping("/{id}")
    public void deletarTarefaPorId(@PathVariable(value = "id") Long id) {
        service.deletarPorId(id);
    }

    @GetMapping("/concluidas")
    public List<Tarefa> getTarefasConcluidas() {
        return service.getTarefasMArcadasComoConcluidas();
    }

    @GetMapping("/pendentes")
    public List<Tarefa> getTarefasPendentes(){
       return service.getTarefasMarcadasComoPendente();
    }


}
