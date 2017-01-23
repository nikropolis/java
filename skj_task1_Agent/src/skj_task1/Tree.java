package skj_task1;

import java.io.Serializable;
import java.util.ArrayList;

public class Tree  implements Serializable {
	private static final long serialVersionUID = 1L;
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
	public Tree getChild(int index){
		return forest.get(index);
	}
	public String getValue(){
		return forest.get(0).name;
	}
	public String getFamily(){
		String tmp = "";
		
		if(this.forest.size() > 0)
		{
			for(int i=0; i < forest.size(); i++){
				tmp += this.name+"->";
				tmp += forest.get(i).getName();
				tmp += "; ";
				tmp += forest.get(i).getFamily();
			}
		}
		return tmp;
	}
	public String getFamilyHtml(){
		String tmp = "";
		tmp += "<div><span>"+this.name+"</span>";
		if(forest.size() > 0)
		{
			for(int i=0; i < forest.size(); i++){
				tmp += forest.get(i).getFamilyHtml();
			}
		}
		tmp += "</div>";
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
	public void showFamily(){
		System.out.println(" : " + this.getFamily() );
	}
}
