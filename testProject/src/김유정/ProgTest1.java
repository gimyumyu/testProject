package ±Ë¿Ø¡§;

public class ProgTest1 {
	public int cVar = 0;
	String[] iStr = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	double iDouble;
	boolean iBool = false;
	char iChar = 'a';

	String getGugudan(int dan) {
		String gugu = "";
		for (int i = dan; i <= dan; i++) {
			for (int j = 1; j < iStr.length; j++) {
				gugu += dan + "*" + j + "=" + dan * j + "\t";
			}
		}
		return gugu;
	}
}
