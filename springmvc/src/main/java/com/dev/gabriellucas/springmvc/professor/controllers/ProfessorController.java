package com.dev.gabriellucas.springmvc.professor.controllers;

import com.dev.gabriellucas.springmvc.professor.entities.Professor;
import com.dev.gabriellucas.springmvc.professor.enums.StatusProfessor;
import com.dev.gabriellucas.springmvc.professor.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfessorController {

     @Autowired
     private ProfessorRepository professorRepository;

     // Listar todos os professores
     @GetMapping("/professores")
     public String findAll(Model model) {
          model.addAttribute("findAll", professorRepository.findAll());
          return "professores/index"; // Arquivo HTML
     }

     // Formulário para criar um novo professor
     @GetMapping("/professor/new")
     public String statusProfessor(Model model) {
          model.addAttribute("statusProfessor", StatusProfessor.values());
          return "professores/new"; // Arquivo HTML
     }

     // Criar um novo professor
     @PostMapping("/professores")
     public String create(Professor professor) {
          professorRepository.save(professor);
          return "redirect:/professores";
     }

     // Exibir detalhes de um professor específico
     @GetMapping("/professor/{id}")
     public String findById(@PathVariable Long id, Model model) {
          Professor professor = professorRepository.findById(id)
                  .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado: " + id));
          model.addAttribute("professor", professor);
          return "professores/show"; // Arquivo HTML
     }

     // Formulário para editar um professor existente
     @GetMapping("/professor/edit/{id}")
     public String edit(@PathVariable Long id, Model model) {
          Professor professor = professorRepository.findById(id)
                  .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado: " + id));
          model.addAttribute("professor", professor);
          model.addAttribute("statusProfessor", StatusProfessor.values());
          return "professores/edit"; // Arquivo HTML
     }

     // Atualizar um professor existente
     @PostMapping("/professor/update/{id}")
     public String update(@PathVariable Long id, Professor professorAtualizado) {
          Professor professor = professorRepository.findById(id)
                  .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado: " + id));

          professor.setNome(professorAtualizado.getNome());
          professor.setSalario(professorAtualizado.getSalario());
          professor.setStatusProfessor(professorAtualizado.getStatusProfessor());
          professorRepository.save(professor);

          return "redirect:/professores";
     }

     // Excluir um professor
     @GetMapping("/professor/delete/{id}")
     public String delete(@PathVariable Long id) {
          Professor professor = professorRepository.findById(id)
                  .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado: " + id));
          professorRepository.delete(professor);
          return "redirect:/professores";
     }

}

