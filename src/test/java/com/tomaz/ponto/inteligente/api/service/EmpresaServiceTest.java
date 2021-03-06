package com.tomaz.ponto.inteligente.api.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.tomaz.ponto.inteligente.api.entities.Empresa;
import com.tomaz.ponto.inteligente.api.repositories.EmpresaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaServiceTest {

	@MockBean
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	private static final String CNPJ = "1234567890";
	
	@Before
	public void setUp() {
		BDDMockito.given(this.empresaRepository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
		BDDMockito.given(this.empresaRepository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
	}
	
	@Test
	public void TestBuscarEmpresaPorCnpj() {
		Optional<Empresa> empresa = this.empresaService.buscaEmpresaPorCnpj(CNPJ);
		
		assertTrue(empresa.isPresent());
	}
	
	@Test
	public void testPersistirEmpresa() {
		var empresa = this.empresaService.persistir(new Empresa());
		
		assertNotNull(empresa);
	}
	
}
