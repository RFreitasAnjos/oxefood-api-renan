package br.com.ifpe.oxefood.api.editora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.editora.Editora;
import br.com.ifpe.oxefood.modelo.editora.EditoraService;
import br.com.ifpe.oxefood.modelo.editora.Livro;

@RestController
@RequestMapping("/api/editora")
@CrossOrigin
public class EditoraController {
   
   @Autowired
   private EditoraService editoraService;

   @PostMapping
   public ResponseEntity<Editora> save(@RequestBody EditoraRequest request){
      Editora editora = editoraService.save(request.build());
      return new ResponseEntity<Editora>(editora, HttpStatus.CREATED);
   }
   @GetMapping
   public List<Editora> listaEditoras(){
      return editoraService.listarTodos(null);
   }

   @PutMapping("/{editoraId}")
   public ResponseEntity<Editora> updateEditora(@PathVariable("editoraId") Long editoraId, @RequestBody EditoraRequest request){
      editoraService.update(editoraId,request.build());
      return ResponseEntity.ok().build();
   }

   @DeleteMapping("/{editoraId}")
   public ResponseEntity<Editora> deleteEditora(@PathVariable("editoraId") Long editoraId){
      editoraService.delete(editoraId);
      return ResponseEntity.noContent().build();
   }
   
   @PostMapping("/livro/{editoraId}")
   public ResponseEntity<Livro> createLivro(@PathVariable("editoraId") Long editoraId, @RequestBody LivroRequest request){
      Livro livro = editoraService.createBook(editoraId, request.build());
      return new ResponseEntity<Livro>(livro, HttpStatus.CREATED);
   }

   @PutMapping("/livro/{livroId}")
   public ResponseEntity<Livro> updateLivro(@PathVariable("livroId") Long livroId, @RequestBody LivroRequest request){
      Livro livro = editoraService.updateBook(livroId,request.build());
      return new ResponseEntity<Livro>(livro, HttpStatus.OK);
   }

   @DeleteMapping("/livro/{livroId}")
   public ResponseEntity<Void> removeLivro(@PathVariable("livroId") Long livroId){
      editoraService.removeLivro(livroId);
      return ResponseEntity.noContent().build();
   }

   // @GetMapping
   // public List<Livro> listarTodosLivros(){
   //    return editoraService.listLivros();
   // }
}
