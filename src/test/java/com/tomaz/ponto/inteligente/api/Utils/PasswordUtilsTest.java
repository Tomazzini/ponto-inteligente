package com.tomaz.ponto.inteligente.api.Utils;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tomaz.ponto.inteligente.api.util.PasswordUtils;

public class PasswordUtilsTest {
	
	private static final String SENHA = "123456";
	private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	@Test
	public void TestSenhaNula() {
		assertNull(PasswordUtils.gerarBCrypt(null));
	}
	
	@Test
	public void TestGerarHashSenha() {
		String hash = PasswordUtils.gerarBCrypt(SENHA);
		
		assertTrue(bCryptPasswordEncoder.matches(SENHA, hash));
	}
}
