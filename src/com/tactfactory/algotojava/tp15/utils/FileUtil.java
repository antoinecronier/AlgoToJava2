package com.tactfactory.algotojava.tp15.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {

	public static String getFromFileMemory(String path) throws IOException {
		StringBuilder result = new StringBuilder();
		FileReader in = null;

		try {
			in = new FileReader(path);

			int c;
			while ((c = in.read()) != -1) {
				result.append(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}

		return result.toString();
	}
	
	public static String getFromFilePlainText(String path) throws IOException {
		StringBuilder result = new StringBuilder();
		FileReader in = null;
		BufferedReader br = null;
		try {
			in = new FileReader(path);
			br = new BufferedReader(in);
			String line;
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (br != null) {
				br.close();
			}
		}

		return result.toString();
	}
}
