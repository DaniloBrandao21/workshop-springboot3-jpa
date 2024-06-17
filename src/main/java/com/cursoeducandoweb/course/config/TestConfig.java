package com.cursoeducandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursoeducandoweb.course.entities.User;
import com.cursoeducandoweb.course.repositories.UserRepository;

//CommandLineRunner indica pro programa executar o método run sempre que for iniciado 
// configurando a classe de teste -> os comandos da classe serão reconhecidos apenas quando logar como "test"
@Configuration
@Profile("test") 
public class TestConfig implements CommandLineRunner{
	
	
//	@Autowired -> pro spring resolver a injeção de dependencia e associa a instancia do UserRepository na classe TestConfig
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		
		//método para salvar os dados no banco (lista)
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		
	}
	
	
}
