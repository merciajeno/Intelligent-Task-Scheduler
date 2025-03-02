package com.Task.Scheduler.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Task.Scheduler.entities.Dependency;
import com.Task.Scheduler.entities.Task;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class TaskRepository {

	@Autowired
	EntityManager em;
	
	public List<Task> findAllByDeadline()
	{
		return em.createQuery("SELECT t FROM Task t  LEFT JOIN FETCH t.dependencies ORDER BY t.deadline ASC",Task.class).getResultList();
	}
	
	public Task findTask(Long id)
	{
		return em.find(Task.class, id);
	}
	
    public void addTask(Task task)
    {
    	if(em.find(Task.class, task.getTaskId())!=null)
    		em.merge(task);
    	else
    		em.persist(task);
    }
    
    public void deleteTask(Task task)
    {
    	if(em.find(Task.class, task.getTaskId())!=null)
    		em.remove(task);
    }
    public void addDependency(Task dependentTask, Task dependsOn, Long id)
    {
    	//t1 depends on task dependsOn
    	 Dependency dependency = new Dependency(id,dependsOn);
    	 if(em.find(Dependency.class,dependency.getDependencyId())==null)
 	         em.persist(dependency);
 	    	 else
 	    		 em.merge(dependency);
    	dependentTask.addDependency(dependency);
 	    em.merge(dependentTask);
 	  
    }
    
    
    public Task removeDependencies(Task t, Task dependsOn) {
     t = em.merge(t);
     dependsOn = em.merge(dependsOn);
      for(Dependency d: t.getDependencies())
      {
    	  d = em.merge(d);
    	  if(d.getDependsOn().getTaskId() == dependsOn.getTaskId())
    	  {   
    		  em.remove(em.contains(d) ? d : em.merge(d));
    		  t.removeDependency(d);
    		  System.out.println(t.getDependencies());
    		  break;
    	  }
      }
      return em.merge(t);
    }
 
    public void removeTask(Task t)
    {
    	t = em.merge(t);
    	em.remove(t); // Remove task after dependencies
    }

    public List<Dependency> getDependencies(Task t)
    {
    	return t.getDependencies();
    }
    
    public void debug()
    {
    	System.out.println(em.find(Dependency.class,20002L));
    }
}
