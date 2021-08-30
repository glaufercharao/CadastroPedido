package br.com.cadastro.services;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.cadastro.dtos.ProdutoDTO;
import br.com.cadastro.entities.Produto;
import br.com.cadastro.exception.DatabaseException;
import br.com.cadastro.exception.ResourceNotFoundException;
import br.com.cadastro.mapper.Mappable;
import br.com.cadastro.repositories.ProdutoRepository;

@Service
public class ProdutoService implements Mappable {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Page<ProdutoDTO> listarTodosProduto(Pageable pageable) {
		return map(produtoRepository.findAll(pageable), ProdutoDTO.class);
	}

	public void removerProduto(String uuid) {
		try {
			Produto prod = produtoRepository.findByUuid(uuid);
			if(prod == null)
				throw new ResourceNotFoundException("UUID não encontrado " + uuid);
			produtoRepository.delete(prod);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("UUID não encontrado " + uuid);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade.");
		}
	}
	
	public ProdutoDTO listarProdutoPorUuid(String uuid) {
		try {
			Produto prod = produtoRepository.findByUuid(uuid);
			if(prod == null)
				throw new ResourceNotFoundException("UUID não encontrado " + uuid);
			return map(prod, ProdutoDTO.class);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("UUID não encontrado " + uuid);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade.");
		}
	}

	@Transactional
	public ProdutoDTO salvarProduto(ProdutoDTO produto) {
		return map(produtoRepository.save(map(produto, Produto.class)), ProdutoDTO.class);
	}

	@Transactional
	public ProdutoDTO atualizarProduto(ProdutoDTO produto, String uuid) {
        try {
    		Produto prod = produtoRepository.findByUuid(uuid);
    		prod.setNome(produto.getNome());
    		prod.setDescricao(produto.getDescricao());
    		prod.setPrecoUnitario(produto.getPrecoUnitario());
    		produto.setTipoCadastro(produto.getTipoCadastro());

    		return map(produtoRepository.save(prod), ProdutoDTO.class);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("UUID não encontrado "+ uuid);
        }
	}
}
