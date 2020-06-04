package com.tomaz.ponto.inteligente.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.tomaz.ponto.inteligente.api.entities.Empresa;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaRepositoryTest {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	private static final String CNPJ = "12345678912345";
	
	@Before
	public void setUp(String cnpj) {
		var empresa = new Empresa();
		empresa.setRazaoSocia("empresa de teste");
		empresa.setCnpj(CNPJ);
		this.empresaRepository.save(empresa);
	}
	
	@After
	public final void tearDown() {
		empresaRepository.deleteAll();
	}
	
	@Test
	public void testBuscarPorCnpj() {
		var empresa = this.empresaRepository.findByCnpj(CNPJ);
		
		assertEquals(CNPJ, empresa.getCnpj());
		
	}
}
