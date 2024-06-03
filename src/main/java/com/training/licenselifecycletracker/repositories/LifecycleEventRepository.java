package com.training.licenselifecycletracker.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.licenselifecycletracker.entities.LifecycleEvent;
@Repository
public interface LifecycleEventRepository extends CrudRepository<LifecycleEvent, Integer> {
	
	public List<LifecycleEvent> findByCategory(String category);
	public List<LifecycleEvent> findByRelatedId(Integer relatedId);
	public List<LifecycleEvent> findByEventType(String eventType);
	public List<LifecycleEvent> findByEventDate(Date eventDate);
	public List<LifecycleEvent> findByDescription(String description);
}