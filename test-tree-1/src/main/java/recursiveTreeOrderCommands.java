import java.util.ArrayList;
import com.tasks.TaskNode;
import java.util.Iterator;
//import java.util.List;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class recursiveTreeOrderCommands {
	public recursiveTreeOrderCommands(java.util.ArrayList<com.tasks.TaskNode> tasks) {
		
		// following suggestions at:
		// https://stackoverflow.com/questions/30570146/convert-java-arraylist-of-parent-child-relation-into-tree
		// Arrange
        // String corresponds to the Id
	     Map<String, TaskNode> hashMapTasks = new HashMap<String, TaskNode>();
		
		// Find the available roots
		List<TaskNode> rootNodes = new ArrayList<TaskNode>(); 
		for(TaskNode task : tasks){
			if(task.getRequiresTasks() != null) {
				rootNodes.add(task);
			}
		}
		/*
        // populate a Map
        for(TaskNode tn:tasks){

            //  ----- Child -----
        	TaskNode mmdChild ;
            if(hm.containsKey(tn.getChildId())){
                mmdChild = hm.get(tn.getChildId());
            }
            else{
                mmdChild = new TaskNode();
                hm.put(tn.getChildId(),mmdChild);
            }           
            mmdChild.setId(tn.getChildId());
            mmdChild.setParentId(tn.getParentId());
            // no need to set ChildrenItems list because the constructor created a new empty list



            // ------ Parent ----
            TaskNode mmdParent ;
            if(hm.containsKey(tn.getParentId())){
                mmdParent = hm.get(tn.getParentId());
            }
            else{
                mmdParent = new TaskNode();
                hm.put(tn.getParentId(),mmdParent);
            }
            mmdParent.setName(tn.getParentId());
            mmdParent.setParentId("null");                              
            mmdParent.addChildrenItem(mmdChild);


        }


/*
        // Print 
        for(TaskNode mmd: DX){
            System.out.println("DX contains "+DX.size()+" that are : "+ mmd);
        

    }
		/*Iterator<LinkedHashMap<String, String>> i = commands.iterator();
	      System.out.println("The ArrayList elements are:");
	      while (i.hasNext()) {
	         System.out.println(i.next());
	      }
*/
	}

}
