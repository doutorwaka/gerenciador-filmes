package utils;

import java.util.Scanner;

public class Leitura {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static int LeInt(String msg) {
		System.out.print(msg);
		return sc.nextInt();
	}
	
	public static float LeFloat(String msg) {
		System.out.print(msg);
		return sc.nextFloat();
	}
	
	public static String leStr(String msg) {
		System.out.print(msg);
		sc = new Scanner(System.in);
		return sc.nextLine();
	}

}
