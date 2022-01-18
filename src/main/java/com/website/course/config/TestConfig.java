package com.website.course.config;

import com.website.course.entities.User;
import com.website.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration //informa que essa classe serve como configuração
@Profile("test")
/*
 * o decorator @Profile informa para que perfil a classe deve ser usada.
 * nesse caso, a classe sera usada para o perfil "test".
 * para informar o perfil, basta colocar o nome do perfil em uma String
 * de uma das duas seguintes formas
 *
 * @Profile("perfil")
 * @Profile(value = "perfil")
 * */
public class TestConfig implements CommandLineRunner {

  /*
   * a interface CommandLineRunner é uma interface que possui um método
   * que permite a execução de algum código quando a aplicação é iniciada.
   * Esse método da interface CommandLineRunner é o método run()
   * */

  @Autowired
  /*
   * a anotação @Autowired faz a injeção de dependência de maneira automática em alguma
   * propriedade da classe. Nesse caso, a injeção está sendo feita na propriedade userRepository,
   * do tipo UserRepository, que é a propriedade que faz a manipulação da tabela "users" no banco de dados
   * */
  private UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {
    User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
    User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

    userRepository.saveAll(Arrays.asList(user1, user2));

    /*
     * o método saveAll() salva várias entidades de um banco de dados de uma vez
     * */
  }
}
