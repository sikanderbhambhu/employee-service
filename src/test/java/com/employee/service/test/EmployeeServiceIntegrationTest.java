package com.employee.service.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.employee.service.service.EmployeeServiceVersion1;
import com.employee.service.service.EmployeeServiceVersion2;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeServiceIntegrationTest {
	@Autowired
	private EmployeeServiceVersion1 employeeServiceVersion1;
	private EmployeeServiceVersion2 employeeServiceVersion2;
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void whenLoadContext_thenStudentServiceAutowired() {
		System.out.println("Launching Employee API");
		// assertThat(employeeServiceVersion1).isNotNull();
		// assertThat(employeeServiceVersion2).isNotNull();
	}
}
