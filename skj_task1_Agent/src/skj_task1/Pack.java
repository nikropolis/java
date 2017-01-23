package skj_task1;

import java.io.Serializable;


public class Pack  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public String ip;
	public int port;
	
	public String type;
	private Object obj;

//	public Pack(){}
	public Pack(String ip, int port){
		this.ip = ip;
		this.port = port;
	}
	//	SET
	public void setPack(Object obj){
		this.obj = obj;
	}
	public void setType(String str){
		this.type = str;
	}
	//	GET
	public Object getPack(){
		return obj;
	}
	public String getType(){
		return type;
	}
}
