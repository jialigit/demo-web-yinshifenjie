package com.example.yinshifenjie;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Arrays;
import org.junit.Test;

public class JSONUtilTest {

	
	//@Test
	public void testWrite() throws IOException {
		String path = "src/test/resources/db.json";
		Map dict = new HashMap<Integer, List<Integer>>();
		
		List divides = Arrays.asList(new int[] {1,2,3});
		dict.put(10, divides);
		dict.put(20, divides);
		JSONUtil.writeJson2File(dict, path);
		
		
	}
	
	@Test
	public void testRead() throws IOException {
		String path = "src/test/resources/db.json";
		HashMap map = (HashMap) JSONUtil.readJsonFromFile(path);
		System.out.println(map);
	}
	
	
	
	
	
	
}
