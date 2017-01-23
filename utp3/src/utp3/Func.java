package utp3;

import java.util.ArrayList;
import java.util.List;

public class Func{
	
	public static <A, B, C> List<C> map( List<A> list, List<B> list2, IBFunc<A, B, C> f){
		List<C> result = new ArrayList<>(list.size());
		
		for(int i=0; i < list.size(); i++){
			result.add( f.call(list.get(i), list2.get(i)) );
		}
		return result;
	}	
}

