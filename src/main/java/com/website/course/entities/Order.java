package com.website.course.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity()
@Table(name = "orders") // informa o nome da tabela no banco de dados
public class Order implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Instant moment;

  @ManyToOne() //informa o tipo de associação
  @JoinColumn(name = "client_id") // informa o nome da coluna do banco que vai possuir a chave estrangeira
  private User client;

  public Order() {}

  public Order(Long id, Instant moment, User client) {
    this.id = id;
    this.moment = moment;
    this.client = client;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Instant getMoment() {
    return moment;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public User getClient() {
    return client;
  }

  public void setClient(User client) {
    this.client = client;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return Objects.equals(id, order.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
