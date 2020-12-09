package br.ufc.crateus.events.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="events")
public class Event {

	@Id
	@GeneratedValue
	int id;
	String name;
	String description;
	String beginDate;
	String finishDate;
	String organizer;
	String localization;
	
	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    public Set<Programation> programations;
    
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	public String getLocalization() {
		return localization;
	}
	public void setLocalization(String localization) {
		this.localization = localization;
	}
	public Set<Programation> getProgramations() {
		return programations;
	}
	public void setProgramations(Set<Programation> programations) {
		this.programations = programations;
	}
	
	@Override
	public String toString() {
		return "Events [id=" + id + ", name=" + name + ", description=" + description + ", beginDate=" + beginDate
				+ ", finishDate=" + finishDate + ", organizer=" + organizer + ", localization=" + localization + "]";
	}
	
	public Event(int id, String name, String description, String beginDate, String finishDate, String organizer,
			String localization) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.beginDate = beginDate;
		this.finishDate = finishDate;
		this.organizer = organizer;
		this.localization = localization;
	}
	
	public Event(String name, String description, String beginDate, String finishDate, String organizer,
			String localization) {
		super();
		this.name = name;
		this.description = description;
		this.beginDate = beginDate;
		this.finishDate = finishDate;
		this.organizer = organizer;
		this.localization = localization;
	}
	
	public Event() {
		super();
	}
	
	
	
}
