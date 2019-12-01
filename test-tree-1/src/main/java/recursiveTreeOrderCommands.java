import java.util.ArrayList;
import java.util.Collection;

import com.tasks.TaskNode;
import java.util.Iterator;
//import java.util.List;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

public class recursiveTreeOrderCommands {
	public recursiveTreeOrderCommands(java.util.ArrayList<com.tasks.TaskNode> tasks) {

		// following suggestions at:
		// https://stackoverflow.com/questions/30570146/convert-java-arraylist-of-parent-child-relation-into-tree
		// Arrange
		// String corresponds to the Id
		HashMap<String, TaskNode> hashMapTasks = new HashMap<String, TaskNode>();
		ArrayList<TaskNode> childrenTasks = new ArrayList<TaskNode>(); // TODO: invetigate another object, adding to
																		// ArrayList is not optimal
		// Find the available roots
		ArrayList<TaskNode> rootNodes = new ArrayList<TaskNode>();
		for (TaskNode task : tasks) {
			if (task.getRequiresTasks() == null) {
				rootNodes.add(task);
			} else {
				childrenTasks.add(task);
			}
		}		
		List<TaskNode> treeOfTasks = getTree(tasks);
		printTree(treeOfTasks);

	}

	public Map<String, TaskNode> buildIdMap(Collection<TaskNode> targets) {
		Map<String, TaskNode> result = new HashMap<String, TaskNode>();
		if (targets != null && !targets.isEmpty()) {
			final Iterator<TaskNode> iterator = targets.iterator();
			while (iterator.hasNext()) {
				final TaskNode next = iterator.next();
				result.put(next.getName(), next);
			}
		}
		return result;
	}

	public List<TaskNode> getTree(List<TaskNode> all) {
		final List<TaskNode> result = new ArrayList<TaskNode>();
		final Map<String, TaskNode> allMap = buildIdMap(all);
		final Iterator<TaskNode> iterator = all.iterator();
		while (iterator.hasNext()) {
			final TaskNode next = iterator.next();
			ArrayList<String> requiredTasks = next.getRequiresTasks();
			if (requiredTasks != null) {
				for(String parentTaskName: requiredTasks) {
				//TODO: validation
					final TaskNode node = allMap.get(next.getName());
					final TaskNode nodeP = allMap.get(parentTaskName);
					if (nodeP != null) {
						nodeP.getChildrenItems().add(node);
					}
				}
				} else {
					next.setRoot(true);
					result.add(next);
				}
			//check
		}
		return result;
	}
	
	public void printTree(List<TaskNode> treeOfTasks) {
		
		for(TaskNode rootTask : treeOfTasks) {
	        System.out.println(rootTask.getName()+"::"+ rootTask.getCommand());
	        traverseNode(rootTask);
	    }
	}
	
	public void traverseNode ( TaskNode parentNode ) {
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
