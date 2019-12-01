package com.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskNodeHelper {
	
	public static void printTree(List<TaskNode> treeOfTasks) {
		//TODO: re-initialize the isVisited on exit. 
		//Assumes isVisited is set to false for all nodes on start
		
		for(TaskNode rootTask : treeOfTasks) {
	        System.out.println(rootTask.getCommand());
	        rootTask.setIsNodeVisited(true);
	        traverseNode(rootTask);
	    }
	}

	public static void traverseNode ( TaskNode parentNode ) {
		//print 
	    for(TaskNode childNode: parentNode.getChildrenItems()) {
	      // print information from the child nodes
	    		if(!childNode.getIsNodeVisited()) {
	    			List<TaskNode> reqTasks = childNode.getRequiredItems();
	    			boolean isRequiredTaskNotVisitedYet = false;
	    			for (TaskNode task: reqTasks) {
	    				if (task.getIsNodeVisited() == false) {
	    					isRequiredTaskNotVisitedYet = true;
	    					break;
	    				}
	    			}
	    			if(isRequiredTaskNotVisitedYet == false) {
	    				System.out.println( childNode.getCommand());
	    				childNode.setIsNodeVisited(true);
	    			}
	    }}
	    //traverse children nodes
	    for(TaskNode childNode: parentNode.getChildrenItems()) {
		      // print information from the child nodes
	    			traverseNode(childNode);
		    }
	  }
}

