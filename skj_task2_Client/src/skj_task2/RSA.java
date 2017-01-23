package skj_task2;

	import java.security.InvalidKeyException;
	import java.security.KeyPair;
	import java.security.KeyPairGenerator;
	import java.security.NoSuchAlgorithmException;
	import java.security.PrivateKey;
	import java.security.PublicKey;
	import java.security.spec.InvalidKeySpecException;

	import javax.crypto.BadPaddingException;
	import javax.crypto.Cipher;
	import javax.crypto.IllegalBlockSizeException;
	import javax.crypto.NoSuchPaddingException;

	public class RSA {
	    public PublicKey publicKey;
		public PrivateKey privateKey;
		public RSA() 
	    {
			KeyPairGenerator kpairg;
			KeyPair kpair;
			try {
				kpairg = KeyPairGenerator.getInstance("RSA");
				kpairg.initialize(1024);
				kpair = kpairg.genKeyPair();
				
				publicKey = kpair.getPublic();
				privateKey = kpair.getPrivate();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		public byte[] encrypt(String msg) 
	    {
			byte[] encodedMessage = null;
			try {
				Cipher cipherEncode = Cipher.getInstance("RSA/ECB/PKCS1Padding");
				cipherEncode.init(Cipher.ENCRYPT_MODE, publicKey);
				encodedMessage = cipherEncode.doFinal(msg.getBytes());
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        return encodedMessage;
	    }
		public String decrypt(byte[] msg) 
	    {
			String decodedMessage = "";
			try {
				Cipher cipherDecode  = Cipher.getInstance("RSA/ECB/PKCS1Padding");
				cipherDecode.init(Cipher.DECRYPT_MODE, privateKey);
				decodedMessage = new String(cipherDecode.doFinal(msg));
			} catch (IllegalBlockSizeException e) {e.printStackTrace();
			} catch (BadPaddingException e) {e.printStackTrace();
			} catch (InvalidKeyException e) {e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			}
	        return decodedMessage;
	    }		
		public byte[] encrypt(String msg, PublicKey publicKey) 
	    {
			byte[] encodedMessage = null;
			try {
				Cipher cipherEncode = Cipher.getInstance("RSA/ECB/PKCS1Padding");
				cipherEncode.init(Cipher.ENCRYPT_MODE, publicKey);
				encodedMessage = cipherEncode.doFinal(msg.getBytes());
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        return encodedMessage;
	    }
		public String decrypt(byte[] msg, PrivateKey privateKey) 
	    {
			String decodedMessage = "";
			try {
				Cipher cipherDecode  = Cipher.getInstance("RSA/ECB/PKCS1Padding");
				cipherDecode.init(Cipher.DECRYPT_MODE, privateKey);
				decodedMessage = new String(cipherDecode.doFinal(msg));
			} catch (IllegalBlockSizeException e) {e.printStackTrace();
			} catch (BadPaddingException e) {e.printStackTrace();
			} catch (InvalidKeyException e) {e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			}
	        return decodedMessage;
	    }
		
	}


