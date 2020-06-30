package com.tomaz.ponto.inteligente.api.serviceImpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tomaz.ponto.inteligente.api.entities.Lancamento;
import com.tomaz.ponto.inteligente.api.repositories.LancamentoRepository;
import com.tomaz.ponto.inteligente.api.service.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService{

	//private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Override
	public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
	}

	@Override
	public Optional<Lancamento> buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return this.lancamentoRepository.findById(id);
	}

	@Override
	public Lancamento persistir(Lancamento lancamento) {
		// TODO Auto-generated method stub
		return this.lancamentoRepository.save(lancamento);
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		this.lancamentoRepository.deleteById(id);
	}


}
