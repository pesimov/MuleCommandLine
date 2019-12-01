package com.tasks;

import java.util.List;

public class TaskNodeHelper {
	
	public static void printTree(List<TaskNode> treeOfTasks) {
		
		for(TaskNode rootTask : treeOfTasks) {
	        System.out.println(rootTask.getName()+"::"+ rootTask.getCommand());
	        traverseNode(rootTask);
	    }
	}

	public static void traverseNode ( TaskNode parentNode ) {
		//print 
	    for(TaskNode childNode: parentNode.getChildrenItems()) {
	      // print information from the child nodes
	      System.out.println( childNode.getName()+"::"+ childNode.getCommand());
	    }
	    //traverse children nodes
	    for(TaskNode childNode: parentNode.getChildrenItems()) {
		      // print information from the child nodes
	    			traverseNode(childNode);
		    }
	  }
}

