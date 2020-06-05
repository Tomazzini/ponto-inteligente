package com.tomaz.ponto.inteligente.api.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tomaz.ponto.inteligente.api.entities.Lancamento;
import com.tomaz.ponto.inteligente.api.repositories.LancamentoRepository;
import com.tomaz.ponto.inteligente.api.service.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService{

	@Autowired
	private LancamentoRepository lancamentoRepository;

	//@Override
	//public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest){
	//	return Optional.ofNullable(this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest));
	//}
	
	@Override
	public Optional<Lancamento> buscaPorId(Long id) {
		
		return this.lancamentoRepository.findById(id);
	}

	@Override
	public Lancamento persistir(Lancamento lancamento) {
		
		return this.lancamentoRepository.save(lancamento);
	}

	@Override
	public void remover(Long id) {
		this.lancamentoRepository.deleteById(id);
	}

}
