package com.tasks;

import java.util.List;

public class TaskNodeHelper {
	
	public static void printTree(List<TaskNode> treeOfTasks) {
		//TODO: re-initialize the isVisited on exit. 
		//Assumes isVisited is set to false for all nodes on start
		
		for(TaskNode rootTask : treeOfTasks) {
	        System.out.println(rootTask.getName()+"::"+ rootTask.getCommand());
	        rootTask.setIsNodeVisited(true);
	        traverseNode(rootTask);
	    }
	}

	public static void traverseNode ( TaskNode parentNode ) {
		//print 
	    for(TaskNode childNode: parentNode.getChildrenItems()) {
	      // print information from the child nodes
	    		if(!childNode.getIsNodeVisited()) {
	    			System.out.println( childNode.getName()+"::"+ childNode.getCommand());
	    			childNode.setIsNodeVisited(true);
	    }}
	    //traverse children nodes
	    for(TaskNode childNode: parentNode.getChildrenItems()) {
		      // print information from the child nodes
	    			traverseNode(childNode);
		    }
	  }
}

