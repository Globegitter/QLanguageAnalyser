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
		System.out.println("Testing Scanner:");
		int nrTests = 5;
		for (int i = 1; i <= nrTests; i++) {
			System.out.println("\n\n\n--------Running now test 0" + i + "--------");
			testFile("./testfiles/test0" + i);
		}		
	}

	public static void testFile(String fileName) throws Exception {
		QLex scanner = new QLex(new FileReader(fileName));
		testScanner(scanner);
	}
	
	public static void testString(String str) throws Exception {
		QLex scanner = new QLex(new StringReader(str));
		testScanner(scanner);
	}
	
	public static void testScanner(QLex scanner) throws Exception {
		Field[] tokenFields = QSym.class.getFields();
		int linebreak = 0;
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
		System.out.println();
	}	
	
}
