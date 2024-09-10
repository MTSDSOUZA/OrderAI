package com.example.orderAI.pagamento;

import com.example.orderAI.usuario.Usuario;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    public List<Pagamento> findAll() {
        return repository.findAll();
    }

    public List<Pagamento> findByUsuario(Usuario usuario) {
        return repository.findByUsuario(usuario);
    }

    public Pagamento create(Pagamento pagamento) {
        return repository.save(pagamento);
    }

    public Pagamento getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pagamento not found with ID: " + id));
    }

    public Pagamento update(Long id, Pagamento updatedPagamento) {
        Pagamento existingPagamento = getById(id);
        existingPagamento.setNum_cartao(updatedPagamento.getNum_cartao());
        existingPagamento.setNome_cartao(updatedPagamento.getNome_cartao());
        existingPagamento.setData_validade(updatedPagamento.getData_validade());
        existingPagamento.setCvv(updatedPagamento.getCvv());
        existingPagamento.setApelido_cartao(updatedPagamento.getApelido_cartao());
        existingPagamento.setUsuario(updatedPagamento.getUsuario());

        return repository.save(existingPagamento);
    }

    public void delete(Long id) {
        Pagamento pagamento = getById(id);
        repository.delete(pagamento);
    }
}

