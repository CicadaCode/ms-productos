package com.exam.ms_productos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(properties = {
		"spring.cloud.vault.enabled=false",
		"spring.cloud.config.enabled=false",
		"eureka.client.enabled=false"
})
class MsProductosApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(true);
	}
}
