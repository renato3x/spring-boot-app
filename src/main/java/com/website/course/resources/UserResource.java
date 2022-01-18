package com.website.course.resources;

import com.website.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //informa que a classe é um controlador
@RequestMapping(value = "/user") // serve para noemar o recurso/rota
public class UserResource {

  @GetMapping // informa o método http da rota (GET, POST, DELETE)
  public ResponseEntity<User> findAll() {
    /*
    * o tipo ResponseEntity<T> é um tipo específico do Spring Boot
    * para retorno de respostas de requisições web
    * */

    User user = new User(1L, "Renato", "renato@mail.com", "92929292", "12345678");

    return ResponseEntity.ok().body(user);

    /*
    * o método ok() do ResponseEntity<T> é equivalente ao status code 200 (OK)
    * os métodos de retorno no spring boot funcionam assim:
    *
    * método badRequest() = status 400
    * método notFound() = status 404
    *
    * o método body() é o corpo da resposta, onde você passa os dados que você deseja enviar
    * */
  }
}
