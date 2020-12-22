package br.ufc.crateus.events.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.crateus.events.model.Event;
import br.ufc.crateus.events.service.EventService;

@RestController
@CrossOrigin
    @RequestMapping(path = "/api/events")
public class EventController {
 
    @Autowired
    EventService eventService;
 
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getEvents() {
    	return new ResponseEntity<List<Event>>(eventService.getEvents(), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<Event> getProgramation(@PathVariable("id") Integer id) {
        return new ResponseEntity<Event>(eventService.getEvent(id), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        
        return new ResponseEntity<Event>(eventService.addEvent(
                event.getName(),
                event.getDescription(),
                event.getBeginDate(),
                event.getFinishDate(),
                event.getOrganizer(),
                event.getLocalization()), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable("id") Integer id, @RequestBody Event event) {
        return new ResponseEntity<Event>(eventService.updateEvent(id, 
        		event.getName(),
                event.getDescription(),
                event.getBeginDate(),
                event.getFinishDate(),
                event.getOrganizer(),
                event.getLocalization()), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("id") Integer id) {
        if (eventService.removeEvent(id)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
 
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}