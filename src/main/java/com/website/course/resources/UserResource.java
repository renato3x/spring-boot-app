package com.website.course.resources;

import com.website.course.entities.User;
import com.website.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //informa que a classe é um controlador
@RequestMapping("/users") // serve para noemar o recurso/rota
public class UserResource {

  @Autowired
  private UserService userService;

  @GetMapping // informa o método http da rota (GET, POST, DELETE)
  public ResponseEntity<List<User>> findAll() {
    /*
    * o tipo ResponseEntity<T> é um tipo específico do Spring Boot
    * para retorno de respostas de requisições web
    * */

    List<User> users = userService.findAll();

    return ResponseEntity.ok().body(users);

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

  @GetMapping("/{id}") //maneira receber parâmetros pela rota
  public ResponseEntity<User> findById(@PathVariable Long id) {
    /*
    * parâmetros de métodos com a anotação @PathVariable
    * informam que elas fazem referência a algum parâmetro da rota
    * */

    User user = userService.findById(id);

    return ResponseEntity.ok().body(user);
  }
}
