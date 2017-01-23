package ppj_19;

public class Word {
	private int i;
	private String s;
	
	public Word(){
		i = 0;
		s = "";
	}
	
	public void addChar(char c){
		s += c;
		i++;
	}
	public String toString(){
		return s;
	}
	public int length(){
		return i;
//		return s.length();
	}
}
