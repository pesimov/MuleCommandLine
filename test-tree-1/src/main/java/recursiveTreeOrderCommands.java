import java.util.ArrayList;
import java.util.Collection;

import com.tasks.TaskNode;
import com.tasks.TaskNodeHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

public class recursiveTreeOrderCommands {
	public recursiveTreeOrderCommands(java.util.ArrayList<com.tasks.TaskNode> tasks) {

		// Evaluated suggestions at:
		// https://stackoverflow.com/questions/30570146/convert-java-arraylist-of-parent-child-relation-into-tree
		
		List<TaskNode> treeOfTasks = getTree(tasks);
		com.tasks.TaskNodeHelper.printTree(treeOfTasks);

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
					final TaskNode nodeC = allMap.get(next.getName());
					final TaskNode nodeP = allMap.get(parentTaskName);
					if (nodeP != null) {
						nodeP.getChildrenItems().add(nodeC);
						nodeC.getRequiredItems().add(nodeP);
					}
					
				}
				} else {
					next.setRoot(true);
					result.add(next);
				}
		}
		return result;
	}

}
