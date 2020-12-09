package br.ufc.crateus.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.crateus.events.model.Programation;

public interface ProgramationRepository extends JpaRepository <Programation, Integer> { 

}
