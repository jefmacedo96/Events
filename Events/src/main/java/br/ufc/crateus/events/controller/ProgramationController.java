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
 
import br.ufc.crateus.events.model.Programation;
import br.ufc.crateus.events.service.ProgramationService;
 
@RestController
@CrossOrigin
@RequestMapping(path = "/api/programations")
public class ProgramationController {
 
    @Autowired
    ProgramationService programationService;
 
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Programation>> getProgramations() {
    	return new ResponseEntity<List<Programation>>(programationService.getProgramations(), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<Programation> getProgramation(@PathVariable("id") Integer id) {
        return new ResponseEntity<Programation>(programationService.getProgramation(id), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Programation> addProgramation(@RequestBody Programation programation) {
        
        return new ResponseEntity<Programation>(programationService.addProgramation(
                programation.getName(),
                programation.getBeginDate(),
                programation.getFinishDate(),
                programation.getDescription(),
                programation.getStartTime(),
                programation.getEndTime(),
                programation.getPresenter(),
                programation.getWorkload(),
                programation.getBeginRegistration(),
                programation.getFinishRegistration()), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity<Programation> updateProgramation(@PathVariable("id") Integer id, @RequestBody Programation programation) {
        return new ResponseEntity<Programation>(programationService.updateProgramation(id, 
                programation.getName(),
                programation.getBeginDate(),
                programation.getFinishDate(),
                programation.getDescription(),
                programation.getStartTime(),
                programation.getEndTime(),
                programation.getPresenter(),
                programation.getWorkload(),
                programation.getBeginRegistration(),
                programation.getFinishRegistration()), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<Void> deleteProgramation(@PathVariable("id") Integer id) {
        if (programationService.removeProgramation(id)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
 
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}