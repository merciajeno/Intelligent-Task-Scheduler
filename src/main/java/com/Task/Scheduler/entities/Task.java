package com.Task.Scheduler.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Task {

	@Id
	private Long taskId;
	
	private String name;
	private int priority;
	private LocalDateTime deadline;
	
	
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy="dependsOn",cascade = CascadeType.REMOVE)
	List<Dependency> dependencies  = new ArrayList<>();

	public Task()
	{
		super();
	}
	
	public Task(Long taskId, String name, int priority, LocalDateTime deadline) {
		super();
		this.taskId = taskId;
		this.name = name;
		this.priority = priority;
		this.deadline = deadline;
	}

	public Long getTaskId() {
		return taskId;
	}

	public String getName() {
		return name;
	}

	public int getPriority() {
		return priority;
	}

	public LocalDateTime getDeadline() {
		return deadline;
	}

	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public List<Dependency> getDependencies() {
		return dependencies;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}

	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public void addDependency(Dependency dependency)
	{
		this.dependencies.add(dependency);
	}
	
	public void removeDependency(Dependency dependency)
	{
		this.dependencies.remove(dependency);
	}
	
	public String toString()
	{
		return "" +getName()+"";
	}
}

