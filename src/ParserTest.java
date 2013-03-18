import java.io.FileReader;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import java_cup.runtime.Symbol;
import uk.ac.ucl.comp2010.bestgroup.QCup;
import uk.ac.ucl.comp2010.bestgroup.QLex;
import uk.ac.ucl.comp2010.bestgroup.AST.Node;

public class ParserTest {

	public static void main(String[] args) throws Exception {
		//String str = "fdef sum(i: int, j:int) : int { i = i; } {}";
		//System.out.println("Testing string:\n" + str + "\n");
		//testString(str);
		
		int nrTests = 1;
		for (int i = 1; i <= nrTests; i++) {
			System.out.println("\n\n\n--------Running now test 0" + i + "--------");
			testFile("./testfiles/test0" + i);
		}
	}
	
	public static void testParser(QCup parser) throws Exception {
		Symbol parse_tree = parser.parse();
		displayTree(parse_tree.value, 0);
	}
	
	public static void testFile(String fileName) throws Exception {
		QLex scanner = new QLex(new FileReader(fileName));
		QCup parser = new QCup(scanner);
		testParser(parser);
	}
	
	public static void testString(String str) throws Exception {
		QLex scanner = new QLex(new StringReader(str));
		QCup parser = new QCup(scanner);
		testParser(parser);
	}
	
		
	public static void displayTree(Object node, int i) {
		System.out.println(node.getClass().getSimpleName());
		Field[] nodeFields = node.getClass().getFields();

		for(Field field: nodeFields) {
			try {
				
				if(Node.class.isInstance(field.get(node)) && field.get(node) != null) {
					System.out.print(indent(i+2) + field.getName() + " = ");
					displayTree(field.get(node), i+2 + field.getName().length() + 3);
				} else if(List.class.isInstance(field.get(node)) && field.get(node) != null){
					System.out.print(indent(i+2) + field.getName() + " = ");
						
					ListIterator<Object> li = ((List) field.get(node)).listIterator();
					while(li.hasNext()) {
						if(li.hasPrevious()) {System.out.print(indent(i+2 + field.getName().length() + 3));}
						System.out.print("*");
						Object o = li.next();
						displayTree(o, i+2 + field.getName().length() + 4);
					}
					if(!li.hasPrevious()) {
						System.out.println();
					}
					//System.out.println(indent(i+2 + field.getName().length() + 3) + "]");
					
				} else {
					System.out.println(indent(i+2) + field.getName() + " = " + field.get(node));
				}
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String indent(int level) {
		String s = "";
		for(int i=0; i<level; i++) {
			s = s + " ";
		}
		return s;
	}
}
