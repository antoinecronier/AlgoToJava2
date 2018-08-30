package com.tactfactory.algotojava.tp18bis.utils;

import java.util.List;
import java.util.Random;

import com.tactfactory.algotojava.tp18bis.model.Player;

public class ListUtil {

	public static Object next(List<Object> list, Object current) {
		Object result = null;

		if (list.indexOf(current) + 1 < list.size()) {
			result = list.get(list.indexOf(current) + 1);
		}else{
			result = list.get(0);
		}

		return result;
	}

	public static Object previous(List<Object> list, Player current) {
		Object result = null;

		if (list.indexOf(current) - 1 >= 0) {
			result = list.get(list.indexOf(current) - 1);
		}else{
			result = list.get(list.size()-1);
		}

		return result;
	}
	
	public static Object draft(List<Object> list) {
		Object result = null;
		Random rand = new Random();

		for (int i = 0; i < list.size(); i++) {
			Object itemToMove = list.get(rand.nextInt(list.size())%(list.size()));
			list.remove(itemToMove);
			list.add(rand.nextInt(list.size())%(list.size()),itemToMove);
		}

		return result;
	}
}
