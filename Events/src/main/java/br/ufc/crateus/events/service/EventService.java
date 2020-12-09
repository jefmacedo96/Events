package br.ufc.crateus.events.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.crateus.events.model.Event;
import br.ufc.crateus.events.repository.EventRepository;

@Service
public class EventService {
	
	 @Autowired
	    EventRepository EventRepo;
	 
	 public Event addEvent(String name, String description, String beginDate, String finishDate, 
			 String organizer, String localization) {
	        
	        Event Event = new Event(name, description, beginDate, finishDate, organizer, localization);
	        
	        return EventRepo.save(Event);
	    }
	 
	    public boolean removeEvent(Integer id) {
	        if (EventRepo.existsById(id)) {
	            EventRepo.deleteById(id);
	            return true;
	        }
	 
	        return false;
	    }
	 
	    public List<Event> getEvents() {
	        return EventRepo.findAll();
	    }
	 
	    public Event getEvent(Integer id) {
	        return EventRepo.findById(id).get();
	    }
	 
	    public Event updateEvent(Integer id, String name, String description, String beginDate, 
	    		String finishDate, String organizer, String localization) {
	        
	        Event eventAux = EventRepo.findById(id).get();
	 
	        if (eventAux != null) {
	        	eventAux.setName(name);
	        	eventAux.setDescription(description);
	        	eventAux.setBeginDate(beginDate);
	        	eventAux.setFinishDate(finishDate);
	        	eventAux.setOrganizer(organizer);
	        	eventAux.setLocalization(localization);
	            
	            EventRepo.save(eventAux);
	        }
	 
	        return eventAux;
	    }
	}
