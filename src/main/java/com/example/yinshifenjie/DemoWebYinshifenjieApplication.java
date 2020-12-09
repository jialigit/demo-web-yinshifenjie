package com.example.yinshifenjie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoWebYinshifenjieApplication {
	@Autowired
	private Factor factor;

	@RequestMapping("/divide")
	public Map<String, Object> divide(int num) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			res.put("data", factor.factor(num));
			res.put("code", 0);
			return res;
		} catch (Exception e) {
			res.put("code", -1);
			return  res;
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoWebYinshifenjieApplication.class, args);
	}

}
