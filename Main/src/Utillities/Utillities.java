package Utillities;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Utillities {

	private static Utillities utilInstance;
	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	final int CLEAR_SCREEN = 1;

	public static Utillities getInstance() {
		if (utilInstance == null) {
			utilInstance = new Utillities();
		}
		return utilInstance;
	}

	public Character generateCharacter() {
		return (char) (rand.nextInt(26) + 'A');
	}

	public String generateInitial() {
		return generateCharacter().toString() + generateCharacter().toString();
	}

	public int nextInt() {
		return scan.nextInt();
	}

	public String nextLine() {
		return scan.nextLine();
	}

	public void cls() {
		for (int i = 0; i < CLEAR_SCREEN; i++) {
			System.out.println();
		}
	}

	public void print(String s, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(s);
		}
		System.out.println();
	}

	public void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.out.println("Can't sleep error on util + " + e);
		}
	}

	public int rand(int bound) {
		return rand.nextInt(bound);
	}

	public int max(int a, int b, int c) {
		if (a >= b && a >= c)
			return a;
		if (b >= a && b >= c)
			return b;
		if (c >= a && c >= b)
			return c;
		return -1;
	}

	public Vector<String> read(String fileName) {
		Vector<String> dataList = new Vector<String>();
		try {
			File file = new File(fileName);
			Scanner fileScanner = new Scanner(file);
			while (fileScanner.hasNextLine()) {
				String data = fileScanner.nextLine();
				dataList.add(data);
			}
			fileScanner.close();
		} catch (Exception e) {
			System.out.println("error reading file ");
			e.printStackTrace();
		}
		return dataList;
	}

	public void write(Vector<String> dataList, String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName);
			for (String str : dataList) {
				fw.write(str + "\n");
			}
			fw.close();
		} catch (Exception e) {
			System.out.println("Error write file ");
			e.printStackTrace();
		}

	}
}
