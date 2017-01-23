/**
 *
 *  @author Lazariev Mykyta S15928
 *
 */

package zadGenerics;



import java.util.*;

public class Main {
  public Main() {
    List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12); 
    System.out.println(test1(src1));

    List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv");
//    List<String> src2 = Arrays.asList("Hello", "World!", "How", "Are", "You");
    System.out.println(test2(src2));
  }

  public List<Integer> test1(List<Integer> src) {
    Selector sel = new Selector(){
    	public <T> boolean get(T arg){
    		if((int)arg < 10)
    			return true;
    		else
    			return false;
    	}
    };
    Mapper map = new Mapper(){
    	public <T> Integer maper(T arg){
    		return (int) arg + 10;
    	}
    };
    return   ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public List<Integer> test2(List<String> src) {
	    Selector sel = new Selector(){
	    	public <T> boolean get(T arg){
	    		if(((String)arg).length() > 3)
	    			return true;
	    		else
	    			return false;
	    	}
	    };
	    Mapper map = new Mapper(){
	    	public <T> Integer maper(T arg){
	    		return ((String) arg).length() + 10;
	    	}
	    };
    return    ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public static void main(String[] args) {
    new Main();
  }
}
