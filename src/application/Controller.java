package application;

public class Controller {

	public static String encode(String txt) {
		String result = "";
		StringBuffer sb = new StringBuffer();
		int count = 1;
		char separator = ',';
		
		if(txt.length() > 1) {
					} else {
			sb.append(txt);
			sb.append(count);
		}
		
		
		result = sb.toString();
		
		System.out.println(result);
		return result;
	}

	public static String decode(String txt) {

		return null;
	}
}
