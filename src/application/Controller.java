package application;

public class Controller {

	//******** Encode *****************************************
	public static String encode(String txt) {
		StringBuffer sb = new StringBuffer();
		String str = "";
		int count = 1;
		char separator = ',';
		char current = txt.charAt(0);

		if (txt.length() > 1) { // jeśli ciąg znaków jest większy niż 1

			for (int next = 1; next < txt.length(); next++) {
				if (current == txt.charAt(next)) { // jężeli następny element jest równy z poprzednim
					count++;
					current = txt.charAt(next);

					if (next == txt.length() - 1) { // jeżeli ostatni i przed ostatni element są równe muszą zostać dodane do sb
						str = "" + current + count + separator;
						sb.append(str);
					}
				} else { // jeżeli sąsiednie elementy nie są równe
					
					if (count > 1) { // jeżeli było wicej niż jeden taki sam element
						str = "" + current + count + separator;
						sb.append(str);
						count = 1;
						current = txt.charAt(next);
					} else { // dodawanie pojedyńczych elementów
						str = "" + current + count + separator;
						sb.append(str);
						current = txt.charAt(next);
					}
					if (next == txt.length() - 1) { // dodane do sb ostatniego pojedyńczego elementu
						str = "" + current + count + separator;
						sb.append(str);
					}
				}
			}

		} else {
			str = "" + current + count + separator;
			sb.append(str);
		}

		return sb.toString();
	}

	//******** Decode *****************************************
	public static String decode(String txt) {
		StringBuffer sb = new StringBuffer();
		
		String[] parts = txt.split(",");
		
		for(int index = 0; index < parts.length; index++) {
			char character = parts[index].charAt(0);
			Integer number = Integer.parseInt(parts[index].substring(1));
			
			for(int i = 0; i < number; i++) {
				sb.append(character);
			}
		}
		
		return sb.toString();
	}
}
