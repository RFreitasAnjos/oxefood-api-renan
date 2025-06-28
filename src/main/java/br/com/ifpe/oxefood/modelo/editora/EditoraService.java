package br.com.ifpe.oxefood.modelo.editora;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EditoraService {
   
   private final LivroRepository livroRepository;

   @Autowired
   private EditoraRepository repository;

   EditoraService(LivroRepository livroRepository){
      this.livroRepository = livroRepository;
   }

   @Transactional
   public Editora save(Editora editora){
      editora.setHabilitado(Boolean.TRUE);
      return repository.save(editora);
   }

   @Transactional
   public List<Editora> listarTodos(Editora editora){
      return repository.findAll();
   }

   @Transactional
   public Editora obterPorId(Long id){
      return repository.findById(id).get();
   }

   @Transactional
   public void delete(Long id){
      Editora editora = repository.findById(id).get();
      editora.setHabilitado(Boolean.FALSE);

      repository.save(editora);
   }

   @Transactional
   public void update(long id, Editora editoraAlterado){
      Editora editora = repository.findById(id).get();
      editora.setNome(editoraAlterado.getNome());
      editora.setAnoFundacao(editoraAlterado.getAnoFundacao());
      editora.setEndereco(editoraAlterado.getEndereco());

      repository.save(editora);
   }



   @Transactional 
   public Livro createBook(Long editoraId, Livro livro){
      Editora editora = this.obterPorId(editoraId);

      livro.setEditora(editora);
      livro.setHabilitado(Boolean.TRUE);
      livroRepository.save(livro);

      List<Livro> listLivro = editora.getLivros();

      if(listLivro == null) listLivro = new ArrayList<Livro>();

      listLivro.add(livro);
      editora.setLivros(listLivro);
      repository.save(editora);

      return livro;
   }

   @Transactional
   public Livro updateBook(Long id, Livro livroAlterado){
      Livro livro = livroRepository.findById(id).get();
      livro.setAutor(livroAlterado.getAutor());
      livro.setTitulo(livroAlterado.getTitulo());
      livro.setQtdPaginas(livroAlterado.getQtdPaginas());
      livro.setAnoLancamento(livroAlterado.getAnoLancamento());
      livro.setPreco(livroAlterado.getPreco());

      return livroRepository.save(livro);
   }

   @Transactional
   public void removeLivro(Long idLivro){
      Livro livro = livroRepository.findById(idLivro).get();
      livro.setHabilitado(Boolean.FALSE);
      livroRepository.save(livro);

      Editora editora = this.obterPorId(livro.getEditora().getId());
      editora.getLivros().remove(livro);
      repository.save(editora);
   }

   @Transactional
   public List<Livro> listLivros(){
      return livroRepository.findAll();
   }
}
