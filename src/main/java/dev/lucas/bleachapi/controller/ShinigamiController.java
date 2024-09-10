package dev.lucas.bleachapi.controller;

import dev.lucas.bleachapi.model.Shinigami;
import dev.lucas.bleachapi.service.ShinigamiService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/shinigami")
public class ShinigamiController {

    @Autowired
    private ShinigamiService service;

    @Operation( tags = "CRUD", summary = "Adicionar um Shinigami", description = "Adicione um novo shinigami!!")
    @PostMapping("/adicionar")
    public ResponseEntity<Shinigami> adicionarShinigami(@RequestBody Shinigami shinigami){
        Shinigami novoShinigami = service.adicionarShinigami(shinigami);
        return new ResponseEntity<>(novoShinigami, HttpStatus.CREATED);
    }

    @Operation(tags = "CRUD", summary ="Buscar Todos Shinigamis", description = "Veja todos os Shinigamis que foram Adicionados!")
    @GetMapping("/buscartodos")
    public ResponseEntity<List<Shinigami>> buscarTodos(){
        List<Shinigami> todosShinigamis = service.buscarTodosShinigamis();
        return new ResponseEntity<>(todosShinigamis, HttpStatus.OK);
    }

    @Operation(tags = "CRUD" , summary = "Buscar um Shinigami por ID", description = "Busque um shinigami salvo pelo ID")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Shinigami> shinigamiOptional = service.procurarShinigamiPorId(id);
        if (shinigamiOptional.isPresent()) {
            return new ResponseEntity<>(shinigamiOptional.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Shinigami não Encontrado");
        }
    }

    @Operation(tags = "CRUD", summary = "Deletar um Shinigami por ID", description = "Remova um shinigami da aplicação")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletarShinigamiPorId(@PathVariable Long id){
        service.deletarShinigamiPorId(id);
        if (service.procurarShinigamiPorId(id).isPresent()) {
            return new ResponseEntity<>("Shinigami deletado Com Sucesso!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Shinigami não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarShinigami(@PathVariable Long id, @RequestBody Shinigami shinigami){
        try{
            Shinigami shinigamiBuscadoParaAtualizar = service.atualizarShinigami(id, shinigami);
            return new ResponseEntity<>(shinigamiBuscadoParaAtualizar, HttpStatus.OK);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
