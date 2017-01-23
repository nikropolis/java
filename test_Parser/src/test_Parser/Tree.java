package test_Parser;

import java.util.ArrayList;

public class Tree {
	private String name;
	private ArrayList<Tree> forest;
	
	public Tree(String name){
		this.forest = new ArrayList<>();
		this.name = name;
	}
	
	//SET
	public void setChild(Tree tr){
		this.forest.add(tr);
	}
	public void setChilds(ArrayList<Tree> tr){
		for(int i = 0; i < tr.size(); i++){
			this.forest.add(tr.get(i));
		}
	}
	public void setChilds(Tree [] tr){
		for(int i = 0; i < tr.length; i++){
			this.forest.add(tr[i]);
		}
	}
	public void setName(String name){
		this.name = name;
	}
	//GET
	public int getChildSize(){
		return this.forest.size();
	}
	public String getName(){
		return this.name;
	}
	public Tree getChild(String name){
		Tree tmp = null;
		for(int i = 0; i < this.forest.size(); i++){
			if( forest.get(i).getName().equals(name) )
				tmp = forest.get(i);
		}
		return tmp;
	}
	//REMOVE
	public void removeChild(String name){
		for(int i = 0; i < this.forest.size(); i++){
			if( forest.get(i).getName().equals(name) )
				this.forest.remove(i);
		}
	}
	//SHOW
	public String showFamily(){
		String tmp = "";
		
		if(this.forest.size() > 0)
		{
			for(int i=0; i < forest.size(); i++){
				tmp += this.name+"->";
				tmp += forest.get(i).getName();
				tmp += "; ";
				tmp += forest.get(i).showFamily();
			}
		}
		return tmp;
	}
}
