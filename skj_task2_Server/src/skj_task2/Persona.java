package skj_task2;

import java.io.Serializable;
import java.security.PublicKey;

public class Persona  implements Serializable {
	private static final long serialVersionUID = 1L;
	public String ip;
	public int port;
	public String alias;
	public PublicKey publicKey;
}
