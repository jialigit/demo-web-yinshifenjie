package com.example.yinshifenjie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class FactorFileBasedDb {

	private static final String DB_FILE_PATH = "src/main/resources/db.json";

	private Map<Integer, List<Integer>> cache = new HashMap<Integer, List<Integer>>();

	public FactorFileBasedDb() throws IOException {
		// init cache

		cache = JSONUtil.readJsonFromFile(DB_FILE_PATH);
		System.out.println("cache loaded");
		System.out.println(cache);
	}

	public List<Integer> query(Integer num) {
		// TODO Auto-generated method stub
		if (cache.containsKey(num)) {
			return cache.get(num);
		}else {
			System.out.println("not hit");
			return null;
		}

	}

	public void update(int num, ArrayList list) throws Exception {
		// TODO Auto-generated method stub
		cache.put(num, list);
		// write 2 file
		try {
			JSONUtil.writeJson2File(cache, DB_FILE_PATH);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception("json update error ocurr");
		}
	}

}
