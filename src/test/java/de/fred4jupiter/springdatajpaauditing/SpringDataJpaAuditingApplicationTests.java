package de.fred4jupiter.springdatajpaauditing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJpaAuditingApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private AppUserRepository appUserRepository;

	@Test
	public void contextLoads() {
		AppUser appUser = new AppUser();
		appUser.setUsername("fred");
		appUserRepository.save(appUser);

		Product product = new Product();
		product.setName("One");

		productRepository.save(product);

		product.setName("Two");

		productRepository.save(product);


	}

}
