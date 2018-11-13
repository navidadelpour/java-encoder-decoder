import java.util.Random;
//it is a class for processing texts
public class Coding {
	private char[] x;
//Constructor takes a string and turn it to char array
	public Coding(String x) {
		this.x = x.toCharArray();
	}
//this method will convert the text to a code
	public String toCode() {
		Random R = new Random();
		char[] randomChars = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k',
				'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm',' ' };
		int rCharsCount = 0, codeLength;
		char[] text = x;
		for (int i = 0; i < text.length; i++)
			if (i % 2 == 0)
				rCharsCount++;
		if ((rCharsCount + text.length) % 2 == 0)
			codeLength = rCharsCount + text.length - 1;
		else
			codeLength = rCharsCount + text.length;
		char[] code = new char[codeLength];

		for (int t = text.length - 1, c = 0, i = 1, r; t >= 0; t--, c++, i++) {
			code[c] = text[t];
			if (i % 2 == 0) {
				c++;
				r = R.nextInt(randomChars.length);
				code[c] = randomChars[r];
			}
		}
		return String.valueOf(code);
	}
//this method will convert the code to text
	public String toText() {
		int rCharsCount = 0;
		char[] code = x;
		for (int i = 1; i <= code.length; i++)
			if (i % 3 == 0)
				rCharsCount++;
		char[] text = new char[code.length - rCharsCount];
		for (int c = code.length - 1, t = 0; c >= 0; c--, t++) {
			if ((c + 1) % 3 == 0) {
				t--;
				continue;
			} else
				text[t] = code[c];
		}
		return String.valueOf(text);
	}
}