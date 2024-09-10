package dev.lucas.bleachapi.service;

import dev.lucas.bleachapi.model.Shinigami;
import dev.lucas.bleachapi.repository.ShinigamiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ShinigamiService {

    @Autowired
    ShinigamiRepository repository;

    public Shinigami adicionarShinigami(Shinigami shinigami){
        return repository.save(shinigami);
    }

    public List<Shinigami> buscarTodosShinigamis(){
        return repository.findAll();
    }

    public void deletarShinigamiPorId(Long id){
        repository.deleteById(id);
    }

    public Optional<Shinigami> procurarShinigamiPorId(Long id) {
        return repository.findById(id);
    }

    public Shinigami atualizarShinigami(Long id, Shinigami shinigami){
        Optional<Shinigami> shinigamiBuscadoParaAtualizar = repository.findById(id);
        if(shinigamiBuscadoParaAtualizar.isPresent()){
                Shinigami shinigamiAtualizado = shinigamiBuscadoParaAtualizar.get();

                shinigamiAtualizado.setNome( shinigami.getNome() != null ? shinigami.getNome() : shinigamiAtualizado.getNome() );
                shinigamiAtualizado.setTier( shinigami.getTier() != null ? shinigami.getTier() : shinigamiAtualizado.getTier() );
                shinigami.setZanpakuto(shinigamiAtualizado.getZanpakuto());
                return repository.save(shinigamiAtualizado);
            }
        else{
            throw new RuntimeException("Shinigami com id:" + id + " não encontrado!");
        }
    }


    }



