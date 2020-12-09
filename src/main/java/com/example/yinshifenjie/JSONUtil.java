package com.example.yinshifenjie;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;

public class JSONUtil {

	public static Map<Integer, List<Integer>> readJsonFromFile(String path) {
		File f = new File(path);
		try {
			String content = FileUtils.readFileToString(f, "UTF-8");

			HashMap map = JSON.parseObject(content, HashMap.class);
			if(map == null) {
				return new HashMap<Integer, List<Integer>>();
			}
			return map;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new HashMap<Integer, List<Integer>>();
		}
	}

	public static void writeJson2File(Map<Integer, List<Integer>> dict, String path) throws IOException {
		String jsonString = JSON.toJSONString(dict);
		System.out.println(jsonString);
		File f = new File(path);
		FileUtils.writeStringToFile(f, jsonString, "utf-8", false);
	}
}
