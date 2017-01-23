/**
 *
// *  @author Lazariev Mykyta S15928
 *
 */

package zadGenerics;

import java.util.List;
import java.util.ArrayList;

public class ListCreator<T>{ // Uwaga: klasa musi być sparametrtyzowana
	
	public List<T> list;
	public ArrayList<T> selList = new ArrayList<>();
	
	
	public ListCreator(List<T> list){
		this.list = list;
	}
	
	
	public static <T> ListCreator<T> collectFrom(List<T> src)
	{
		return new ListCreator<T>(src);
	}
	
	public ListCreator<T> when(Selector sel){
		for(int i = 0; i < list.size(); i++){
			T tmp = list.get(i);
			if(sel.get(tmp))
				selList.add(tmp);
		}
		return this;
	}
	
	public ArrayList mapEvery(Mapper map){
		ArrayList<T> mapList = new ArrayList<>();
		
		for(int j = 0; j < selList.size(); j++){
			mapList.add((T) map.maper(selList.get(j)));
		}
		return mapList;
	}
}  
