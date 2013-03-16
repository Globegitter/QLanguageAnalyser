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
		System.out.print("Testing Scanner:");
		//QLex scanner = new QLex(new StringReader("Test String"));
		int nrTests = 5;
		for (int i = 1; i <= nrTests; i++) {
			int linebreak = 0;
			System.out.println();
			System.out.println();
			System.out.println("--------Running now test 0" + i + "--------");
			System.out.println();
			QLex scanner = new QLex(new FileReader("./testfiles/test0" + i));
			
			Field[] tokenFields = QSym.class.getFields();
			while(true) {
				Symbol w = scanner.next_token();
				if(w.value == null) break;
				
				for(Field field: tokenFields) {
					if(w.sym == (int) field.get(QSym.class)) {
						System.out.print(field.getName() + ": " + w.value + "\t");
						linebreak++;
						if(linebreak == 5){
							System.out.println();
							linebreak = 0;
						}
					}
				}
			}
		}		
	}

}
