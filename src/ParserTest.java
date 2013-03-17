import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ListIterator;

import java_cup.runtime.Symbol;
import uk.ac.ucl.comp2010.bestgroup.QCup;
import uk.ac.ucl.comp2010.bestgroup.QLex;
import uk.ac.ucl.comp2010.bestgroup.AST.Node;

public class ParserTest {

	public static void main(String[] args) throws Exception {
		String str = "tdef person: name:string, age:int; rawr:int = 4;fdef func(arg1:int, arg2:bool):person {}{}";
		System.out.println("Testing string:\n" + str);
		
		/*System.out.println("\nLexer outputs:");
		ScannerTest.testString(str);*/
		
		System.out.println("\nParser outputs:");
		QLex scanner = new QLex(new StringReader(str));
		QCup parser = new QCup(scanner);
		Symbol parse_tree = parser.parse();
		
		displayTree(parse_tree.value, 0);
	}
	
	public static void displayTree(Object node, int i) {
		System.out.println(node.getClass().getSimpleName());
		Field[] nodeFields = node.getClass().getDeclaredFields();
		for(Field field: nodeFields) {
			try {
				
				if(Node.class.isInstance(field.get(node))) {
					System.out.print(indent(i+2) + field.getName() + " = ");
					displayTree(field.get(node), i+2 + field.getName().length() + 3);
				} else if(List.class.isInstance(field.get(node))){
					System.out.print(indent(i+2) + field.getName() + " = [");
						
					ListIterator<Object> li = ((List) field.get(node)).listIterator();
					while(li.hasNext()) {
						if(li.hasPrevious()) {System.out.print(indent(i+2 + field.getName().length() + 4));}
						Object o = li.next();
						displayTree(o, i+2 + field.getName().length() + 4);
					}
					System.out.println(indent(i+2 + field.getName().length() + 3) + "]");
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
