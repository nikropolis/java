package test_Parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static int it = 0;
	
	public static ArrayList<Tree> tree_parser(String str){
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
	

	public static void command_parser(String str, Tree tree){
		char [] chars = str.toCharArray();
		ArrayList<String> words = new ArrayList<>();

		//parse the command
		String command = "";
		for(int i = 0; i < str.length(); i++){
			if(chars[i] == ' ')
				break;
			command += chars[i];	
		}
		System.out.print("-"+command+"-");
		//check the command
	    if( !command.equals("ADD")  && !command.equals("REMOVE") && !command.equals("MODIFY") )
	    {
	    	System.out.println("wrond command1");
	    	return;
	    }
	    //parse the after-words
		for(int i = command.length(); i < chars.length; i++){
			if(chars[i] == '"'){
				i++;	//start "
				String word = "";
				while(chars[i] != '"') 
				{	
					word += chars[i];
					i++;
				}		//end "
				words.add(word);
			}
		}
		System.out.println(Arrays.toString(words.toArray()));
	    //check for correct ROOT name
	    if( !words.get(0).equals(tree.getName()) )
	    {
	    	System.out.println("wrong ROOT NODE name");
	    	return;
	    }
    	Tree tree_link = tree;
    	String value = words.get(words.size()-1);
    	
	    switch(command){
		    case "ADD":
		    	Tree new_tree = new Tree(value);
		    	
			    if(words.size() == 1)
			    {
			    	System.out.println("can ADD another ROOT NODE");
			    	return;
			    }
			    for(int i = 1; i < words.size()-1; i++){ //start from the second word to the penultimate
			    	tree_link = tree_link.getChild(words.get(i));
			    	
			    	if(tree_link == null){
			    		System.out.println("wrong path");
			    		return;
			    	}
			    }		    
			    tree_link.setChild(new_tree);
			    break;
		    
		    case "REMOVE":
		    	
		    	if(words.size() == 1)
			    {
			    	System.out.println("can REMOVE the ROOT NODE");
			    	return;
			    }
		    	for(int i = 1; i < words.size()-1; i++){ //start from the second word to the penultimate
			    	tree_link = tree_link.getChild(words.get(i));
			    	
			    	if(tree_link == null){
			    		System.out.println("wrong path");
			    		return;
			    	}
			    }	
		    	tree_link.removeChild(value);
		    	break;
		    
		    case "MODIFY":
		    	for(int i = 1; i < words.size()-1; i++){ 
			    	tree_link = tree_link.getChild(words.get(i));
			    	
			    	if(tree_link == null){
			    		System.out.println("wrong path");
			    		return;
			    	}
			    }	
		    	tree_link.setName(value);
		    	break;
		    	
		    default:
		    	System.out.println("wrond comand");
	    }
	} // command_parser() END
	
    public static void main(String[] args) throws IOException {

    	File f = new File("src//test_Parser//file.txt");
    	FileReader reader = new FileReader(f);
    	
	    char[] buffer = new char[ (int)f.length() ];
	    
	    reader.read(buffer);
	    String sentence = new String(buffer);
	    reader.close();
	    
	    System.out.println(sentence);
        
	    ArrayList<Tree> localTree = tree_parser(sentence);

	    String command1 = "ADD \"agent 1\" \"ip\" \"127.0.0.1\"";
	    String command2 = "MODIFY \"agent 1\" \"ip\" \"ips\"";
	    String command3 = "REMOVE \"agent 1\" \"ips\" \"192.67.4.1\"";

	    command_parser(command1, localTree.get(0));
	    command_parser(command2, localTree.get(0));
	    command_parser(command3, localTree.get(0));
	    System.out.println();
	    
	    String family = localTree.get(0).showFamily();
	    System.out.println(family);
	    
//	    final Graphviz viz = Graphviz.fromString("digraph g { \"a\\b'c\" -> b; }");
//        viz.renderToFile(new File("target/g2.png"));
//        System.out.println(viz.createSvg());
    }

}
