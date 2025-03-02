package com.Task.Scheduler.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Task.Scheduler.entities.Dependency;
import com.Task.Scheduler.entities.Task;
import com.Task.Scheduler.repository.TaskRepository;

@Service
public class TaskBatch {

	@Autowired
	TaskRepository taskRepo;
	public void scheduleTask()
	{
		
	}
	
}
