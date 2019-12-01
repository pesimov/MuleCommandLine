package com.tasks;
import java.util.*;

public class TaskNode {
	    private String name;
	    private String command;
	    private ArrayList<String> requires;
	    private boolean isRoot = false;
	    private List<TaskNode> childrenItems=new ArrayList<TaskNode>();
	    private Integer nodeLevel = -1;
	    private boolean isNodeLevelInitialized = false;
	    
	    public String getName() {
	        return name;
	    }
	    public void setName(String _name) {
	        this.name = _name;
	    }
	    public String getCommand() {
	        return command;
	    }
	    public void setRoot(boolean _isRoot) {
	    		this.isRoot = _isRoot;
	    		this.nodeLevel = 0;
	    		this.isNodeLevelInitialized = true;
	    }
	    public boolean getRoot() {
    			return isRoot;
	    }
	    public Integer getNodeLevel() {
			return nodeLevel;
    }	    
	    public void setCommand(String _command) {
	        this.command = _command;
	    }
	    //TODO: investigate use of Optional, an error in getTree was traced to it
	    public ArrayList<String> getRequiresTasks() {
	    		if(requires == null) {
	    			return null;
	    		} else {
	    			return requires;
	    		}
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
