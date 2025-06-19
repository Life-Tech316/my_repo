package com.ibm.asset.ib.model.user;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserAuthManagement {
	private static Map<String, String> loginUser = new HashMap<String, String>();
	private static Map<String, Date> loginDateTime = new HashMap<String, Date>();
	
	public static String getUserFromSession(String session) {
		if (loginUser.containsKey(session)) {
			return loginUser.get(session);
		} else {
			return null;
		}
	}
	
	public static boolean pushUserAndSession(String session, String user) {
		if (loginUser.size() > 10) {
			for (String s : loginDateTime.keySet()) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				cal.add(Calendar.MINUTE, -5);
				if (loginDateTime.get(s).before(cal.getTime())) {
					loginUser.remove(s);
					loginDateTime.remove(s);
					System.out.println("loginuser removed");
				}
			}
		}
		loginUser.put(session, user);
		loginDateTime.put(session, new Date());
		return true;
	}
}
