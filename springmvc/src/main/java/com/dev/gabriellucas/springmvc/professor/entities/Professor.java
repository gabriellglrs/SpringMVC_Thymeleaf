package com.dev.gabriellucas.springmvc.professor.entities;

import com.dev.gabriellucas.springmvc.professor.enums.StatusProfessor;
import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "tb_professor")
public class Professor {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String nome;
     private Double salario;
     @Enumerated(EnumType.STRING)
     private StatusProfessor statusProfessor;

     public Professor() {
     }

     public Professor(String nome, Double salario, StatusProfessor statusProfessor) {
          this.nome = nome;
          this.salario = salario;
          this.statusProfessor = statusProfessor;
     }

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getNome() {
          return nome;
     }

     public void setNome(String nome) {
          this.nome = nome;
     }

     public Double getSalario() {
          return salario;
     }

     public void setSalario(Double salario) {
          this.salario = salario;
     }

     public StatusProfessor getStatusProfessor() {
          return statusProfessor;
     }

     public void setStatusProfessor(StatusProfessor statusProfessor) {
          this.statusProfessor = statusProfessor;
     }
}
