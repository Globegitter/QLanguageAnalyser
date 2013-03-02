import uk.ac.ucl.comp2010.bestgroup.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;

import java_cup.runtime.*;
import uk.ac.ucl.comp2010.bestgroup.*;

public class ScannerTest {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Testing Scanner:\n");
		//QLex scanner = new QLex(new StringReader("Test String"));
		QLex scanner = new QLex(new FileReader("./testfiles/test01"));
		
		while(true) {
			Symbol w = scanner.next_token();
			if(w.value == null) break;
			System.out.println("Sym: " + w.sym + "		Value: " + w.value);
		}
	}

}
