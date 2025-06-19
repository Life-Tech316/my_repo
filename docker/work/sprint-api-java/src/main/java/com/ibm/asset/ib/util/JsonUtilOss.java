package com.ibm.asset.ib.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class JsonUtilOss {
	static public Object convertObjectFromJson(JsonElement elm) {
		Object ret = null;
		if (elm.isJsonObject()) {
			Map<String, Object> elmMap = new HashMap<String, Object>();
			JsonObject obj = elm.getAsJsonObject();
			for (String key : obj.keySet()) {
				elmMap.put(key, convertObjectFromJson(obj.get(key)));
			}
			ret = elmMap;
		} else if (elm.isJsonArray()) {
			List<Object> elmList = new ArrayList<Object>();
			JsonArray list = elm.getAsJsonArray();
			for (JsonElement o : list) {
				elmList.add(convertObjectFromJson(o));
			}
			ret = elmList;
		} else if (elm.isJsonPrimitive()) {
			JsonPrimitive prim = elm.getAsJsonPrimitive();
			if (prim.isBoolean()) {
				Boolean b = prim.getAsBoolean();
				ret = b;
			} else if (prim.isNumber()) {
				Number n = prim.getAsNumber();
				ret = n;
			} else if (prim.isString()) {
				String s = prim.getAsString();
				ret = s;
			}
		} else if (elm.isJsonNull()) {
			;
		}
		return ret;
	}
}
