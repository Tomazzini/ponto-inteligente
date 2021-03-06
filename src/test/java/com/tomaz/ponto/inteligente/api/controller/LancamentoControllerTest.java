package com.tomaz.ponto.inteligente.api.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomaz.ponto.inteligente.api.dto.LancamentoDto;
import com.tomaz.ponto.inteligente.api.entities.Funcionario;
import com.tomaz.ponto.inteligente.api.entities.Lancamento;
import com.tomaz.ponto.inteligente.api.enums.TipoEnum;
import com.tomaz.ponto.inteligente.api.service.FuncionarioService;
import com.tomaz.ponto.inteligente.api.service.LancamentoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class LancamentoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private LancamentoService lancamentoService;
	
	@MockBean
	private FuncionarioService funcionarioService;
	
	private static final String URL_BASE = "/api/lancamentos";
	private static final Long ID_FUNCIONARIO = 2L;
	private static final Long ID_LANCAMENTO = 1L;
	private static final String TIPO = TipoEnum.INICIO_TRABALHO.name();
	private static final Date DATA = new Date(0);
	
	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Test
	public void testCadastrarLancamento() throws Exception{
		Lancamento lancamento = obterDadosLancamento();
		BDDMockito.given(this.funcionarioService.buscarPorId(Mockito.anyLong())).willReturn(Optional.of(new Funcionario()));
		BDDMockito.given(this.lancamentoService.persistir(Mockito.any(Lancamento.class))).willReturn(lancamento);
		
		mockMvc.perform(MockMvcRequestBuilders.post(URL_BASE)
					.content(this.obterJsonRequisicaoPost())
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.data.id").value(ID_LANCAMENTO))
					.andExpect(jsonPath("$.data.tipo").value(TIPO))
					.andExpect(jsonPath("$.data.data").value(this.simpleDateFormat.format(DATA)))
					.andExpect(jsonPath("$.data.funcionarioId").value(ID_FUNCIONARIO))
					.andExpect(jsonPath("$.errors").isEmpty());
	}
	
	@Test
	public void testCadastrarLancamentoFuncionarioIdInvalido() throws Exception {
		BDDMockito.given(this.funcionarioService.buscarPorId(Mockito.anyLong())).willReturn(Optional.empty());

		mockMvc.perform(MockMvcRequestBuilders.post(URL_BASE)
				.content(this.obterJsonRequisicaoPost())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors").value("Funcionário não encontrado. ID inexistente."))
				.andExpect(jsonPath("$.data").isEmpty());
	}
	
//	@Test
//	//@WithMockUser(username = "admin@admin.com", roles = {"ADMIN"})
//	public void testRemoverLancamento() throws Exception {
//		BDDMockito.given(this.lancamentoService.buscaPorId(Mockito.anyLong())).willReturn(Optional.of(new Lancamento()));
//
//		mockMvc.perform(MockMvcRequestBuilders.delete(URL_BASE + ID_LANCAMENTO)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk());
//	}
//	
//	@Test
//	@WithMockUser
//	public void testRemoverLancamentoAcessoNegado() throws Exception {
//		BDDMockito.given(this.lancamentoService.buscarPorId(Mockito.anyLong())).willReturn(Optional.of(new Lancamento()));
//
//		mockMvc.perform(MockMvcRequestBuilders.delete(URL_BASE + ID_LANCAMENTO)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isForbidden());
//	}
	
	
	private String obterJsonRequisicaoPost() throws JsonProcessingException {
		LancamentoDto lancamentoDto = new LancamentoDto();
		lancamentoDto.setId(null);
		lancamentoDto.setData(this.simpleDateFormat.format(DATA));
		lancamentoDto.setTipo(TIPO);
		lancamentoDto.setFuncionarioId(ID_FUNCIONARIO);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(lancamentoDto);
	}

	private Lancamento obterDadosLancamento() {
		Lancamento lancamento = new Lancamento();
		lancamento.setId(ID_LANCAMENTO);
		lancamento.setData(DATA);
		lancamento.setTipo(TipoEnum.valueOf(TIPO));
		lancamento.setFuncionario(new Funcionario());
		lancamento.getFuncionario().setId(ID_FUNCIONARIO);
		return lancamento;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
