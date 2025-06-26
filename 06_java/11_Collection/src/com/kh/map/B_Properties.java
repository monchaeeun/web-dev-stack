package com.kh.map;

import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class B_Properties {
/*
 * Properties
 * - HashMap 구버전인 Hashtable(Object, Object)를 상속받아 구현한 것
 * - (String, String) 형태로 단순화된 컬렉션 클래스
 * - 주로 환경설정과 관련된 속성(property)을 저장하는데 사용
 * */
	
	//머리아파ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ
	//살려주ㅅ게요
	public static void main(String[] args)
	{
		Properties prop = new Properties();
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap");
		//수정 HashMap -> Properties
		prop.setProperty("Map", "Properties");
		
		System.out.println(prop);
		
		Set<Entry<Object,Object>> entrySet = prop.entrySet();
		for(Entry<Object,Object> e : entrySet)
		{
			System.out.println(e.getKey() + " : "+ e.getValue());
		}
		Set<Object> keySet = prop.keySet();
		System.out.println();
		for(Object key : keySet)
		{
			System.out.println(key + " - " + prop.getProperty((String)key));
		}
		//다음 거 있는지 확인
		
		System.out.println();
		Enumeration en = prop.propertyNames();
		while(en.hasMoreElements())
		{
			String key =(String)en.nextElement();
			System.out.println(key);
		}
	}
}
