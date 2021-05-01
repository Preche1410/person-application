package com.precheflorian.person.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "Person")
public class Person{
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private long id;
  private String firstName;
  private String lastName;

@Override
public String toString(){
  return "Person[id=" + id + ", firstName=" +firstName+", lastName="+lastName+ "]";
}


}
