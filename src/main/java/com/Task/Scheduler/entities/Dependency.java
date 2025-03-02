package com.Task.Scheduler.entities;

import jakarta.persistence.*;

@Entity
public class Dependency {

    @Id
    private Long dependencyId;

    @ManyToOne
    @JoinColumn(name = "depends_on_task_id")
    private Task dependsOn;

    public Dependency() {
        super();
    }

    public Dependency(Long dependencyId,Task dependsOn) {
    	this.dependencyId = dependencyId;
        this.dependsOn = dependsOn;
    }
    
    public void setDependencyId(Long dependencyId) {
		this.dependencyId = dependencyId;
	}

	public Long getDependencyId() {
        return dependencyId;
    }

    public Task getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(Task dependsOn) {
        this.dependsOn = dependsOn;
    }

    @Override
    public String toString() {
        return "[Task Name:" + this.dependsOn.getName() + "]";
    }
    
}
