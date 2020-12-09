package br.ufc.crateus.events.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="programation")
public class Programation {
	
	@Id
	@GeneratedValue
	int id;
	String name;
	String beginDate;
	String finishDate;
	String description;
	String startTime;
	String endTime;
	String presenter;
	int workload; //carga-horária
	String beginRegistration;
	String finishRegistration;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
	@JsonIgnore
    public Event event;
		
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getPresenter() {
		return presenter;
	}
	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}
	public int getWorkload() {
		return workload;
	}
	public void setWorkload(int workload) {
		this.workload = workload;
	}
	public String getBeginRegistration() {
		return beginRegistration;
	}
	public void setBeginRegistration(String beginRegistration) {
		this.beginRegistration = beginRegistration;
	}
	public String getFinishRegistration() {
		return finishRegistration;
	}
	public void setFinishRegistration(String finishRegistration) {
		this.finishRegistration = finishRegistration;
	}
	
	@JsonIgnore
	public Event getEvent() {
		return event;
	}
	
	@JsonProperty
	public void setEvent(Event event) {
		this.event = event;
	}
	
	@Override
	public String toString() {
		return "Programation [id=" + id + ", name=" + name + ", beginDate=" + beginDate + ", finishDate=" + finishDate
				+ ", description=" + description + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", presenter=" + presenter + ", workload=" + workload + ", beginRegistration=" + beginRegistration
				+ ", finishRegistration=" + finishRegistration + "]";
	}
	
	public Programation(int id, String name, String beginDate, String finishDate, String description, String startTime,
			String endTime, String presenter, int workload, String beginRegistration, String finishRegistration, Event event) {
		super();
		this.id = id;
		this.name = name;
		this.beginDate = beginDate;
		this.finishDate = finishDate;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.presenter = presenter;
		this.workload = workload;
		this.beginRegistration = beginRegistration;
		this.finishRegistration = finishRegistration;
		this.event = event;
	}
	
	public Programation(String name, String beginDate, String finishDate, String description, String startTime,
			String endTime, String presenter, int workload, String beginRegistration, String finishRegistration, Event event) {
		super();
		this.name = name;
		this.beginDate = beginDate;
		this.finishDate = finishDate;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.presenter = presenter;
		this.workload = workload;
		this.beginRegistration = beginRegistration;
		this.finishRegistration = finishRegistration;
		this.event = event;
	}
	
	public Programation() {
		super();
	}
	
}


