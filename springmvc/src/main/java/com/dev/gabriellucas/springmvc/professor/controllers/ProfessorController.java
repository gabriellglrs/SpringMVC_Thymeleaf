package com.dev.gabriellucas.springmvc.professor.controllers;

import com.dev.gabriellucas.springmvc.professor.entities.Professor;
import com.dev.gabriellucas.springmvc.professor.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ProfessorController {

     @Autowired
     private ProfessorRepository professorRepository;

     @GetMapping("/professores")
     public String findAll(Model model) {
          List<Professor> professors = professorRepository.findAll();
          model.addAttribute("professores", professors);
          return "professores/index"; // html
     }

     @GetMapping("/professor/new")
     public String create(@ModelAttribute Professor professor) {
          professorRepository.save(professor);
          return "professores/new"; // html
     }
}
