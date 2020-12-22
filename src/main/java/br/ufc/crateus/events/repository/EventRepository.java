package br.ufc.crateus.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.crateus.events.model.Event;

public interface EventRepository extends JpaRepository <Event, Integer> { 

}
