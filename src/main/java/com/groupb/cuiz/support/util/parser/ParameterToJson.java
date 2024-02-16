package com.groupb.cuiz.support.util.parser;

public class ParameterToJson {

	public static String parameterToJson(String parameter) {
		String[] params = parameter.split("&");
		for(int i = 0 ; i < params.length ; ++i) {
			String[] keyAndValue = params[i].split("=");
			String str = String.format("\"%s\":\"%s\"", keyAndValue[0], keyAndValue[1]);
			params[i] = str;
		}
		
		return "{" +String.join(",", params) + "}";
	}
}
