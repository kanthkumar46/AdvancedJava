package com.rit.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class YourCollections<T extends Comparable<T>> implements Comparator<T>{

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("kanth");
		l.add("hangal");
		l.add("suman");
		l.add("joker");
		l.add("kumar");
		System.out.println(l);
		new YourCollections<String>().sort(l, new YourCollections<String>());
		System.out.println(l);
	}

	public void sort(List<T> l, Comparator<T> c){
		for(int i=1; i<l.size(); i++){
			T cur = l.get(i);
			int j = i;
			while(j>0 && c.compare(l.get(j-1), cur)>0){
				l.set(j, l.get(j-1));
				j--;
			}
			l.set(j, cur);
		}
	}

	@Override
	public int compare(T o1, T o2) {
		return o1.compareTo(o2);
	}

}
