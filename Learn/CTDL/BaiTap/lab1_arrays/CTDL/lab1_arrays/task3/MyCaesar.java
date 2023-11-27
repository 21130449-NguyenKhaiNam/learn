package lab1_arrays.task3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MyCaesar {
	// 65
	public static final char[] ALPHABET = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
			'v', 'w', 'x', 'y', 'z' };
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	// Encrypt a character according to the given shif steps.
	// Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the ALPHABET
	// array
	public char encryptChar(char c) {
		// TODO
		int index = c - 0;
		if (index <= 57) {
			return ALPHABET[(index - 48 + n) % 62];
		} else if (index <= 90) {
			return ALPHABET[(index - 65 + 10 + n) % 62];
		} else {
			return ALPHABET[(index - 97 + 36 + n) % 62];
		}
	}

	// Encrypt a text using the above function for encrypting a charater.
	public String encrypt(String input) {
		// TODO
		String encrypt = "";
		for (char ch : input.toCharArray()) {
			if (ch != ' ' && ch != '-' && ch != '.' && ch != ',' && ch != ';' & ch != '?' && ch != '!' && ch != ':') {
				encrypt += encryptChar(ch);
			} else {
				encrypt += ch;
			}
		}
		return encrypt;
	}

	// Decrypt a character according to the given shif steps.
	// Decrypt: Dn(x) = (x – n) mod 26. x represents the index of c in the ALPHABET
	// array
	public char decryptChar(char c) {
		// TODO
		int index = c - 0;
		if (index <= 57) {
			return ALPHABET[(index - 48 - n + 62) % 62];
		} else if (index <= 90) {
			return ALPHABET[(index - 65 + 10 + 62 - n) % 62];
		} else {
			return ALPHABET[(index - 97 + 36 + 62 - n) % 62];
		}
	}

	// Decrypt a encrypted text using the above function for decrypting a charater.
	public String decrypt(String input) {
		// TODO
		String decrypt = "";
		for (char ch : input.toCharArray()) {
			if (ch != ' ' && ch != '-' && ch != '.' && ch != ',' && ch != ';' & ch != '?' && ch != '!' && ch != ':') {
				decrypt += decryptChar(ch);
			} else if (ch == '-') {
				decrypt += "\n";
			} else {
				decrypt += ch;
			}
		}
		return decrypt;
	}

	public String readText(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = "";
		while (reader.ready()) {
			line += reader.readLine() + "-";
			System.out.println(line);
		}
		reader.close();
		return line;
	}

	// write the text to the fileName
	public void writeTextEncrypt(String fileName, String s) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(fileName);
		writer.println(encrypt(s));
		writer.close();
	}

	public void writeTextDecrypt(String fileName, String s) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(fileName);
		writer.println(decrypt(s));
		writer.close();
	}

	// Encrypt a encrypted the text content in the srcfile and save it into desFile.
	public void encrypt(String srcFile, String desFile) throws IOException {
		// TODO
		String s = readText(srcFile);
		writeTextEncrypt(desFile, s);
	}

	// Decrypt a encrypted the text content in the srcfile and save it into desFile.
	public void decrypt(String srcFile, String desFile) throws IOException {
		// TODO
		String s = readText(srcFile);
		writeTextDecrypt(desFile, s);
	}

	public static void main(String[] args) throws IOException {
		MyCaesar myCaesar = new MyCaesar(3);

		// 57 90 122

//		System.out.println('a' - 0);
//
//		// Ma hoa mot ky tu
//		System.out.println(myCaesar.encryptChar('D'));
//
//		System.out.println("--------------");
//
//		// Ma hoa mot chuoi
//		System.out.println(myCaesar.encrypt("Dai hoc Nong Lam Tp.HCM-Khoa Cong nghe Thong tin-Thuc hanh CTDL DH18DT-"));
//
//		System.out.println("--------------");
//
//		// Giai ma mot ky tu
//		System.out.println(myCaesar.decryptChar('2'));
//
//		System.out.println("--------------");
//
//		// Giai ma mot chuoi
//		System.out.println(myCaesar.decrypt("Gdl krf Qrqj Odp Ws1KFP-Nkrd Frqj qjkh Wkrqj wlq-Wkxf kdqk FWGO GK4BGW-"));

		// Test voi file
		myCaesar.encrypt("C:\\Users\\PC\\OneDrive\\Desktop\\Code\\java\\lab1_arrays\\TestFile\\testFile.txt",
				"C:\\Users\\PC\\OneDrive\\Desktop\\Code\\java\\lab1_arrays\\TestFile\\testFile2.txt");
		myCaesar.decrypt("C:\\Users\\PC\\OneDrive\\Desktop\\Code\\java\\lab1_arrays\\TestFile\\testFile2.txt", "C:\\Users\\PC\\OneDrive\\Desktop\\Code\\java\\lab1_arrays\\TestFile\\testFile3.txt");

	}
}
