package sql;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	
	 private static final String EMAIL_PATTERN
     = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
     + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

public static boolean validarEmail(String email) {
 Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
 Matcher matcher = pattern.matcher(email);
 return matcher.matches();
}

public static boolean validarNome(String nome) {
 String[] nome2 = nome.split(" ");
 System.out.println(nome2.toString());
 System.out.println(nome2.length);
 return nome2.length > 1;
}

}
