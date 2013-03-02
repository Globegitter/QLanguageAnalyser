import sun.org.mozilla.javascript.internal.Token;
import uk.ac.ucl.comp2010.bestgroup.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.lang.reflect.Field;

import java_cup.runtime.*;
import uk.ac.ucl.comp2010.bestgroup.*;

public class ScannerTest {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Testing Scanner:\n");
		//QLex scanner = new QLex(new StringReader("Test String"));
		QLex scanner = new QLex(new FileReader("./testfiles/test01"));
		
		
		
		Field[] tokenFields = QSym.class.getFields();
		while(true) {
			Symbol w = scanner.next_token();
			if(w.value == null) break;
			
			for(Field field: tokenFields) {
				if(w.sym == (int) field.get(QSym.class)) {
					System.out.println(field.getName() + ":	" + w.value);
				}
			}
		}
	}

}
