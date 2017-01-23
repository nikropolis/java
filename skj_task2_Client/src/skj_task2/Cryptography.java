package skj_task2;

import java.math.BigInteger;
import java.util.Random;

public class Cryptography {
	private int bit_size;
    private BigInteger P, Q, phiN;
    public BigInteger PrivateKey,
    				  PublicKey,
    				  modN;
    
	Cryptography(int bitBize)//Key Generator Function
    {
		bit_size = bitBize;
		
    	P = BigInteger.probablePrime(bit_size, new Random());	//p
    	Q = BigInteger.probablePrime(bit_size, new Random());	//q
    	modN = P.multiply(Q);	//n=pq
    	phiN = P.subtract(BigInteger.valueOf(1)).multiply(Q.subtract(BigInteger.valueOf(1)));//phi(n)=(p-1)(q-1)
        // Next choose e, coprime to and less than PhiN ,,1 < e < ϕ(n),gcd(e,ϕ(n))=1, e is Public Key
        do
        {
        	PublicKey = new BigInteger(2 * bit_size, new Random());
            if((PublicKey.compareTo(phiN) == -1) && (PublicKey.compareTo(BigInteger.ONE) == 1) && (PublicKey.gcd(phiN).compareTo(BigInteger.ONE) == 0))
                break;
        } while (true);
        PrivateKey = PublicKey.modInverse(phiN);//de ≡ 1 (mod ϕ(n)).
    }
	
	public String encrypt(String str, BigInteger privateKey)
    {
        return encryptMessage(convertStringToHex(str), modN, privateKey);
    }
	public String decrypt(String str, BigInteger publicKey)
    {
        return convertHexToString(decryptMessage(str, modN, publicKey));
    }
	public String convertHexToString(String hex)
    {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        //49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for( int i=0; i<hex.length()-1; i+=2 ){
            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char)decimal);
            temp.append(decimal);
        }
        return sb.toString();
    }
	public String convertStringToHex(String str)
    {
        char[] chars = str.toCharArray();
        StringBuilder hex = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            hex.append(Integer.toHexString((int)chars[i]));
        }
        return hex.toString();
    }
	private String encryptMessage(String sHexString, BigInteger N, BigInteger e)
    {
        if(sHexString.length()==0 || sHexString == null)
            return null;
        int iMaxCharLenInOneStr = bit_size/2;
        if (iMaxCharLenInOneStr <= sHexString.length())
        {
            String sRetOutStr = "";
            String sOutStr = null;
            int iBeginIndex = 0;
            int iEndIndex = iMaxCharLenInOneStr - 1;
            while (iBeginIndex < sHexString.length())
            {
                if (iEndIndex < sHexString.length()) {
                    sOutStr = (new BigInteger(sHexString.substring(iBeginIndex, iEndIndex), 16)).modPow(e, N).toString(16);
                    iBeginIndex = iEndIndex;
                    iEndIndex += (iMaxCharLenInOneStr - 1);
                }
                else
                {
                    sOutStr = (new BigInteger(sHexString.substring(iBeginIndex), 16)).modPow(e, N).toString(16);
                    iBeginIndex = sHexString.length();
                }
                if(sOutStr.length() < iMaxCharLenInOneStr)
                {
                    int iLen = iMaxCharLenInOneStr - sOutStr.length();
                    for(int k = 0;k < iLen;k++)
                        sOutStr = "0" + sOutStr;
                }
                sRetOutStr += sOutStr;
            }
            return sRetOutStr;
        }
        else
            return (new BigInteger(sHexString, 16)).modPow(e, N).toString(16);
    }
    private String decryptMessage(String sHexString, BigInteger N, BigInteger d)
    {
        if(sHexString.length()==0 || sHexString == null)
            return null;
        int iMaxCharLenInOneStr = bit_size/2;
        if (iMaxCharLenInOneStr < sHexString.length())
        {
            String sRetOutStr = "";
            int iBeginIndex = 0;
            int iEndIndex = iMaxCharLenInOneStr;
            while (iBeginIndex < sHexString.length())
            {
                if (iEndIndex < sHexString.length())
                {
                    sRetOutStr += (new BigInteger(sHexString.substring(iBeginIndex, iEndIndex), 16)).modPow(d, N).toString(16);
                    iBeginIndex = iEndIndex;
                    iEndIndex += iMaxCharLenInOneStr;
                }
                else
                {
                    sRetOutStr += (new BigInteger(sHexString.substring(iBeginIndex), 16)).modPow(d, N).toString(16);
                    break;
                }
            }
            return sRetOutStr;
        }
        else
            return (new BigInteger(sHexString, 16)).modPow(d, N).toString(16);
    }
}
