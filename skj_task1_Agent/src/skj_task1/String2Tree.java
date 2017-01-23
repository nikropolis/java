package skj_task1;

import java.util.ArrayList;

public class String2Tree {
	
	private int it ;
	private ArrayList<Tree>trees;
	
	public String2Tree(String str){
		it = 0;
		trees = tree_parser(str);
		System.out.println(" . set local Tree");
	}
	
	public Tree getTree(){
		return trees.get(0);
	}
	
	private ArrayList<Tree> tree_parser(String str){
		char [] chars = str.toCharArray();
		ArrayList<Tree> TreeList = new ArrayList<>();
		Tree newTree = null;
		int iterator = 0;
		
		for(;it<chars.length;it++){
			if(chars[it] == '"'){
				it++;	//start "
				String name = "";
				while(chars[it] != '"')
				{	
					name += chars[it];
					it++;
				}
				newTree = new Tree(name);
				TreeList.add(iterator, newTree);
			}
			if(chars[it] == ','){
				iterator++;
			}
			if(chars[it] == ')'){ //end ')'
				break;
			}
			if(chars[it] == '('){
				it++; //start '('
				newTree.setChilds( tree_parser( str ) );
			}
		}
		return TreeList;
	} //  tree_parser() END
	
}
