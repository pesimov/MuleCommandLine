import java.util.ArrayList;
import com.tasks.TaskNode;
import java.util.Iterator;
//import java.util.List;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;


public class recursiveTreeOrderCommands {
	public recursiveTreeOrderCommands(java.util.ArrayList<com.tasks.TaskNode> tasks) {
		
		// following suggestions at:
		// https://stackoverflow.com/questions/30570146/convert-java-arraylist-of-parent-child-relation-into-tree
		// Arrange
        // String corresponds to the Id
		/*        Map<String, TaskNode> hm = new HashMap<>();
		///System.out.println(tasks);
     // you are using MegaMenuDTO as Linked list with next and before link 

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

        // Get the root
        List<TaskNode> DX = new ArrayList<TaskNode>(); 
        for(TaskNode mmd : hm.values()){
            if(mmd.getParentId().equals("null"))
                DX.add(mmd);
        }

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
	public void init() {

	}
}
