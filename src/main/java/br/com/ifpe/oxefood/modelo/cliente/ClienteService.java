package br.com.ifpe.oxefood.modelo.cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.acesso.Perfil;
import br.com.ifpe.oxefood.modelo.acesso.PerfilRepository;
import br.com.ifpe.oxefood.modelo.acesso.UsuarioService;
import br.com.ifpe.oxefood.util.EntidadeNaoEncontradaException;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

    private final EnderecoClienteRepository enderecoClienteRepository;

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private UsuarioService usuarioService;

   @Autowired
   private PerfilRepository perfilUsuarioRepository;


    ClienteService(EnderecoClienteRepository enderecoClienteRepository) {
        this.enderecoClienteRepository = enderecoClienteRepository;
    }

    @Transactional
   public Cliente save(Cliente cliente) {

      usuarioService.save(cliente.getUsuario());

      for (Perfil perfil : cliente.getUsuario().getRoles()) {
           perfil.setHabilitado(Boolean.TRUE);
           perfilUsuarioRepository.save(perfil);
      }

      cliente.setHabilitado(Boolean.TRUE);
      Cliente clienteSalvo = repository.save(cliente);
      return clienteSalvo;
    }

    
    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Cliente obterPorID(Long id) {

        Optional<Cliente> consulta = repository.findById(id);

        if(consulta.isPresent()){
            return consulta.get();
        } else {
            throw new EntidadeNaoEncontradaException("Cliente", id);
        }
    }

    @Transactional
   public void update(Long id, Cliente clienteAlterado) {

      Cliente cliente = repository.findById(id).get();
      cliente.setNome(clienteAlterado.getNome());
      cliente.setDataNascimento(clienteAlterado.getDataNascimento());
      cliente.setCpf(clienteAlterado.getCpf());
      cliente.setFoneCelular(clienteAlterado.getFoneCelular());
      cliente.setFoneFixo(clienteAlterado.getFoneFixo());
	    
      repository.save(cliente);
  }

  @Transactional
   public void delete(Long id) {

       Cliente cliente = repository.findById(id).get();
       cliente.setHabilitado(Boolean.FALSE);

       repository.save(cliente);
   }
   @Transactional
   public EnderecoCliente adicionarEnderecoCliente(Long clienteId, EnderecoCliente endereco) {

       Cliente cliente = this.obterPorID(clienteId);
      
       //Primeiro salva o EnderecoCliente:

       endereco.setCliente(cliente);
       endereco.setHabilitado(Boolean.TRUE);
       enderecoClienteRepository.save(endereco);
      
       //Depois acrescenta o endereço criado ao cliente e atualiza o cliente:

       List<EnderecoCliente> listaEnderecoCliente = cliente.getEnderecos();
      
       if (listaEnderecoCliente == null) {
           listaEnderecoCliente = new ArrayList<EnderecoCliente>();
       }
      
       listaEnderecoCliente.add(endereco);
       cliente.setEnderecos(listaEnderecoCliente);
       repository.save(cliente);
      
       return endereco;
   }

   @Transactional
   public EnderecoCliente atualizarEnderecoCliente(Long id, EnderecoCliente enderecoAlterado) {

       EnderecoCliente endereco = enderecoClienteRepository.findById(id).get();
       endereco.setRua(enderecoAlterado.getRua());
       endereco.setNumero(enderecoAlterado.getNumero());
       endereco.setBairro(enderecoAlterado.getBairro());
       endereco.setCep(enderecoAlterado.getCep());
       endereco.setCidade(enderecoAlterado.getCidade());
       endereco.setEstado(enderecoAlterado.getEstado());
       endereco.setComplemento(enderecoAlterado.getComplemento());

       return enderecoClienteRepository.save(endereco);
   }

   @Transactional
   public void removerEnderecoCliente(Long idEndereco) {

       EnderecoCliente endereco = enderecoClienteRepository.findById(idEndereco).get();
       endereco.setHabilitado(Boolean.FALSE);
       enderecoClienteRepository.save(endereco);

       Cliente cliente = this.obterPorID(endereco.getCliente().getId());
       cliente.getEnderecos().remove(endereco);
       repository.save(cliente);
   }



}
