package test_cryptography3;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		RSA rsa = new RSA();
		String msg = "hi there";
		byte [] code = rsa.encrypt(msg, rsa.publicKey);
		System.out.println(code.toString());
		System.out.println(rsa.decrypt(code, rsa.privateKey));
	}

}
