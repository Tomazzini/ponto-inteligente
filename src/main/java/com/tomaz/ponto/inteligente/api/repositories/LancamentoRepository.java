package com.tomaz.ponto.inteligente.api.repositories;

import java.awt.print.Pageable;
import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tomaz.ponto.inteligente.api.entities.Funcionario;
import com.tomaz.ponto.inteligente.api.entities.Lancamento;

@Repository
@Transactional(readOnly = true)
@NamedQueries({ 
	@NamedQuery( name = "LancamentoRepository.findByFuncionarioId",
			query = "select lanc from lancamento lanc where lanc.funcionario.id = :funcionarioId") })
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

	List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);
	
	//Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
	
}
