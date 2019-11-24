package com.tasks;
import java.util.List;
import java.util.*;

public class TaskNode {
	    private String name;
	    private String command;
	    private ArrayList<String> requires;//should change to an ArrayList!
	    private List<TaskNode> childrenItems=new ArrayList<TaskNode>();
	    
	    public String getName() {
	        return name;
	    }
	    public void setName(String _name) {
	        this.name = _name;
	    }
	    public String getCommand() {
	        return command;
	    }
	    public void setCommand(String _command) {
	        this.command = _command;
	    }	    
	    public ArrayList<String> getRequiresTasks() {
	        return requires;
	    }
	    public void setRequiresTasks(ArrayList<String> _requires) {
	        this.requires = _requires;
	    }
	    public List<TaskNode> getChildrenItems() {
	        return childrenItems;
	    }
	    public void setChildrenItems(List<TaskNode> _childrenItems) {
	        this.childrenItems = _childrenItems;
	    }
}
