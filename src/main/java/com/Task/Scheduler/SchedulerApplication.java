package com.Task.Scheduler;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Task.Scheduler.Service.TaskBatch;
import com.Task.Scheduler.entities.Task;
import com.Task.Scheduler.repository.TaskRepository;

@SpringBootApplication
public class SchedulerApplication implements CommandLineRunner{

	@Autowired
	TaskRepository taskRepo;
	
	@Autowired
	TaskBatch taskBatch;
	public static void main(String[] args) {
		SpringApplication.run(SchedulerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Task t1 = new Task(10001L, "Write Poem", 1, LocalDateTime.now().plusDays(3));
        Task t2 = new Task(10002L, "Research Poem Topic", 2, LocalDateTime.now());
        Task t3 = new Task(10003L, "Search Title", 1, LocalDateTime.now().plusDays(2));

        // Add tasks to repository
        taskRepo.addTask(t1);
        taskRepo.addTask(t2);
        taskRepo.addTask(t3);

        // Add dependencies
        taskRepo.addDependency(t1, t2,20001L); // Write Poem depends on Research Poem Topic
        taskRepo.addDependency(t1, t3,20002L); // Proofread Poem depends on Writing Poem
//       

        // Call scheduling function (assume 3 tasks per day)
//        t1 = taskRepo.removeDependencies(t1, t2);
//        System.out.println(taskRepo.getDependencies(t1));
//       taskRepo.removeTask(t1);
//       taskRepo.debug();
		
	}

}
