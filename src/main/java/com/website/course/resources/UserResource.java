package com.website.course.resources;

import com.website.course.entities.User;
import com.website.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
  //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<User> findById(@PathVariable Long id) {
    /*
    * parâmetros de métodos com a anotação @PathVariable
    * informam que elas fazem referência a algum parâmetro da rota
    * */
    User user = userService.findById(id);

    return ResponseEntity.ok().body(user);
  }

  @PostMapping
  public ResponseEntity<User> insert(@RequestBody User user) {
    user = userService.insert(user);

    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequestUri()
            .path("/{id}")
            .buildAndExpand(user.getId())
            .toUri();

    return ResponseEntity.created(uri).body(user);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    userService.delete(id);

    return ResponseEntity.ok().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id) {
    user = userService.update(id, user);

    return ResponseEntity.ok().body(user);
  }
}
