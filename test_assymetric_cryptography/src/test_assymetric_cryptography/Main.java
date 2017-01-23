package test_assymetric_cryptography;

import java.util.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.Cipher;

public class Main {
	public static void main(String[] args) throws Exception {
		// Example: basic RSA encoding/decryption
		// ---- Key generation ---
		// Generate public/private keys
		KeyPairGenerator kpairg = KeyPairGenerator.getInstance("RSA");
		kpairg.initialize(1024);
		KeyPair kpair = kpairg.genKeyPair();
		Key publicKey = kpair.getPublic();
		Key privateKey = kpair.getPrivate();

		// Key factory, for key-key specification transformations
		KeyFactory kfac = KeyFactory.getInstance("RSA");

		// Generate plain-text key specification
		RSAPublicKeySpec keyspec = (RSAPublicKeySpec) kfac.getKeySpec(publicKey, RSAPublicKeySpec.class);

		System.out.println("Public key, RSA modulus: " + keyspec.getModulus() + "\nexponent: "
				+ keyspec.getPublicExponent() + "\n");

		// Building public key from the plain-text specification
		Key recoveredPublicFromSpec = kfac.generatePublic(keyspec);

		// Encode a version of the public key in a byte-array
		System.out.print("Public key encoded in " + kpair.getPublic().getFormat() + " format: ");
		byte[] encodedPublicKey = kpair.getPublic().getEncoded();
		System.out.println(Arrays.toString(encodedPublicKey) + "\n");

		// Building public key from the byte-array
		X509EncodedKeySpec ksp = new X509EncodedKeySpec(encodedPublicKey);
		Key recoveredPublicFromArray = kfac.generatePublic(ksp);

		// ---- Using RSA Cipher to encode simple messages ---
		// Encoding using public key. Warning - ECB is unsafe
		String message = "Please encode me now!";
		Cipher cipherEncode = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipherEncode.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] encodedMessage = cipherEncode.doFinal(message.getBytes());
		System.out.println("Encoded \"" + message + "\" as: " + Arrays.toString(encodedMessage) + "\n");

		// Decoding using private key
		Cipher cipherDecode = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipherDecode.init(Cipher.DECRYPT_MODE, privateKey);
		String decodedMessage = new String(cipherDecode.doFinal(encodedMessage));
		System.out.println("Decoded: " + decodedMessage);

	}
}