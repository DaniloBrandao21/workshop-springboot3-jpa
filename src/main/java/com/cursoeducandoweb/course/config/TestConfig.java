package com.cursoeducandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursoeducandoweb.course.entities.Category;
import com.cursoeducandoweb.course.entities.Order;
import com.cursoeducandoweb.course.entities.User;
import com.cursoeducandoweb.course.entities.enums.OrderStatus;
import com.cursoeducandoweb.course.repositories.CategoryRepository;
import com.cursoeducandoweb.course.repositories.OrderRepository;
import com.cursoeducandoweb.course.repositories.UserRepository;

//CommandLineRunner indica pro programa executar o método run sempre que for iniciado 
// configurando a classe de teste -> os comandos da classe serão reconhecidos apenas quando logar como "test"
@Configuration
@Profile("test") 
public class TestConfig implements CommandLineRunner{
	
	
//	@Autowired -> pro spring resolver a injeção de dependencia e associa a instancia do UserRepository na classe TestConfig
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT,u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u1); 
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers");
		
		//método para salvar os dados no banco (lista)
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
	}
	
	
}
