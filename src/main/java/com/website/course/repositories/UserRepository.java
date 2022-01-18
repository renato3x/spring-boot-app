package com.website.course.repositories;

import com.website.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  /*
  * a interface JpaRepository<T, ID> é uma interface que possui vários métodos
  * para manipular uma entidade no banco de dados.
  *
  * para ela funcionar, basta informar que entidade deve ser manipulada e o tipo
  * do id dela no banco.
  * */
}
