package br.com.ifpe.oxefood.api.comprador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.oxefood.modelo.comprador.Comprador;
import br.com.ifpe.oxefood.modelo.comprador.CompradorService;

@Controller
@RequestMapping("/api/comprador")
@CrossOrigin
public class CompradorController {

    @Autowired
    private CompradorService compradorService;

    @PostMapping
    public ResponseEntity<Comprador> save(@RequestBody CompradorRequest compradorRequest){
        Comprador comprador = compradorService.save(compradorRequest.build());
        return new ResponseEntity<Comprador>(comprador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comprador> update(@PathVariable("id") Long id, @RequestBody CompradorRequest compradorRequest){
        compradorService.update(id, compradorRequest.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        compradorService.delete(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping
    public List<Comprador> listarTodos(){
        return compradorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Comprador obterPorId(@PathVariable("id") Long id){
        return compradorService.obterPorId(id);
    }
    
}

