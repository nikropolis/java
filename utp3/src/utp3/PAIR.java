package utp3;

public class PAIR<T,S>{
	private T m_t;
	private S m_s;
	
	public PAIR(T t, S s){
		m_t = t;
		m_s = s;
	}
	
	public T FST(){
		return m_t;
	}
	public S SND(){
		return m_s;
	}
	
}
