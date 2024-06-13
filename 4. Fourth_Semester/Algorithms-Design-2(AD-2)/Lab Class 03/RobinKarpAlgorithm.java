/**
 * Ques 2 : Write a Java Program to implement Robin-Karp Algorithm for pattern searching in a string.
 */


public class RabinKarp {
	public static void main(String args[]) {
		String text="abbcde";
		String pattern="bcd";
		int pl=pattern.length();
		int p=13;
		long tHash=generateHash(text.substring(0,pattern.length()),p);
		long pHash=generateHash(pattern,p);
		for(int i=pl-1;i<text.length();i++) {
			if(pHash==tHash) {
				if(pattern.equals(text.substring(i-pl+1,i+1))) {
					System.out.println("Pattern Found At Shift "+(i-pl+1));
					System.exit(0);
				}
			}
			if(i+1<text.length())
			tHash=updateHash(tHash,p,pl,text.charAt(i-pl+1),text.charAt(i+1));
		}
		System.out.println("Pattern Not Found");
	}
	static long generateHash(String s,int p) {
		long hashCode=0;
		for(int i=0;i<s.length();i++) {
			hashCode+=(long)(s.charAt(i)*Math.pow(p, i));
		}
		return hashCode;
	}
	static long updateHash(long tHash,int p,int pl,char oldChar,char newChar) {
		long hashCode=(tHash-oldChar)/p;
		hashCode+=newChar*(long)Math.pow(p, pl-1);
		return hashCode;
	}
}
