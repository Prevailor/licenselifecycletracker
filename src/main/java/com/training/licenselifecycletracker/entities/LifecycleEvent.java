package com.training.licenselifecycletracker.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
 
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "lifecycle_events")
public class LifecycleEvent {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer eventId;
 
    private Integer relatedId;//can be deviceid or softwareid
 
 
    @Column(name = "event_type")
    private String eventType;
 
    @Column(name = "event_date")
    private Date eventDate;
 
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
 
    @Column(name = "Category", columnDefinition = "TEXT")
    private String category;
    // Constructors, getters, setters
}