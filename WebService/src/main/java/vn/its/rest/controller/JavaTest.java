package vn.its.rest.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaTest {
	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date lich = new Date();
		System.out.println(df.format(lich));
	}
}
