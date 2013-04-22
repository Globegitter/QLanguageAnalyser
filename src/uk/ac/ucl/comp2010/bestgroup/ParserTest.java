package uk.ac.ucl.comp2010.bestgroup;
import java.io.FileReader;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ListIterator;

import java_cup.runtime.Symbol;
import uk.ac.ucl.comp2010.bestgroup.AST.*;

public class ParserTest {

	public static void main(String[] args) throws Exception {
		/*String str = "fdef sum(i: int, j:int) : int { i = i; } {}";
		System.out.println("Testing string:\n" + str + "\n");
		testString(str);*/
		//testFile("./testfiles/test");
		
		
		int nrTests = 11;
		for (int i = 1; i <= nrTests; i++) {
			System.out.println("----------------Running now test " + i + "----------------");
			testFile("./testfiles/test" + i);
			System.out.println("\n\n\n\n\n");
		}
		//testString(" a:list = [1,2]; {}");
		//testFile("./testfiles/test4");
	}
	
	public static void testParser(QCup parser) throws Exception {
		System.out.println("Parsing\n-------");
		Symbol parse_tree = parser.parse();

		System.out.println("\nRepeating code\n--------------");
		new CodeOutputVisitor().visit((ProgramNode)parse_tree.value);
		
		System.out.println("\nAST\n---");
		displayTree(parse_tree.value, 0);
		
		System.out.println("\n\nRunning Semantics Visitor\n---------------------");
		new SemanticsVisitor().visit((ProgramNode)parse_tree.value);
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
		if(node == null) {
			System.out.println("null");
			return;
		}
		
		
		System.out.println(node.getClass().getSimpleName());
		
		Field[] nodeFields = node.getClass().getFields();
		for(Field field: nodeFields) {
			if(java.lang.reflect.Modifier.isStatic(field.getModifiers()) || field.getName() == "lineNumber" || field.getName() == "charNumber") {
				continue;
			}
			
			try {
				if(Node.class.isInstance(field.get(node))) {
					System.out.print(indent(i+2) + field.getName() + " = ");
					displayTree(field.get(node), i+2 + field.getName().length() + 3);
					
				} else if(List.class.isInstance(field.get(node)) && field.get(node) != null){
					System.out.print(indent(i+2) + field.getName() + " = ");
					
					ListIterator<Object> li = ((List) field.get(node)).listIterator();
					if(! li.hasNext()) {
						System.out.println("[empty list]");
					} else {
						while(li.hasNext()) {
							if(li.hasPrevious()) {System.out.print(indent(i+2 + field.getName().length() + 3));}
							System.out.print("*");
							Object o = li.next();
							if(Node.class.isInstance(o)) {
								displayTree(o, i+2 + field.getName().length() + 4);
							} else {
								System.out.println(o);
							}
						}
					}
				//} else if(ExprOperationNode.class.isInstance(node) && field.getName() == "op") {
					
					
				} else if(! (field.getName()=="type" && field.get(node) == null)){
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
