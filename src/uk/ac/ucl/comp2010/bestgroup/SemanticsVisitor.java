package uk.ac.ucl.comp2010.bestgroup;
import java.util.*;

import uk.ac.ucl.comp2010.bestgroup.AST.*;

public class SemanticsVisitor extends Visitor{
	
    LinkedList<HashMap<String, DeclNode>> symbolTables;
    
	public SemanticsVisitor() {
		symbolTables = new LinkedList<HashMap<String, DeclNode>>();
	}
    
    private void insert(String id, DeclNode node){
        symbolTables.getLast().put(id, node);
    }

    private void beginScope() {
        symbolTables.addLast(new HashMap<String, DeclNode>());
    }

    private void endScope(){
        symbolTables.removeLast();
    }

    //Possibly change to boolean return-type?
    private DeclNode lookup(String id){

        for(ListIterator<HashMap<String, DeclNode>> it = symbolTables.listIterator(symbolTables.size()); it.hasPrevious();){
            DeclNode declaration = it.previous().get(id);
            if(declaration != null){
                return declaration;
            }
            //System.out.println("test");
        }

        return null;
        /*
        for(HashMap<String, DeclNode> table: symbolTables){
            if(table.get(id) != null){
                return table.get(id);
            }
        }
        return null;*/
    }
    
    private DeclNode lookupFirst(String id){
    	return symbolTables.getFirst().get(id);
    }

    @Override
    public Object visit(IntNode node) {
        return "int";
    }

    @Override
    public Object visit(NumericOperationNode node) {
        String leftType = (String)visit(node.left);
        String rightType = (String)visit(node.right);
        if(leftType == "int" && rightType == "int") {
            System.out.println("int");
            return "int";
        } else if(leftType == "int" && rightType == "float" || leftType == "float" && rightType == "int" || leftType == "float" && rightType == "float"){
            System.out.println("float");
            return "float";
        } else {
            System.out.println("Cannot understand: " + leftType + " " + node.op + " " + rightType);
            return null;
        }
    }
    
    @Override
    public Object visit(ProgramNode node){
    	beginScope();
    	visit(node.declarations);
    	beginScope();
    	visit(node.main);
    	endScope();
    	endScope();
		return "programnode";
    	
    }

    @Override
    public Object visit(VarDeclNode node){
    	HashMap<String, DeclNode> latestTable = symbolTables.getLast();
    	if(latestTable.get(node.var.id) == null){
    		latestTable.put(node.var.id, node);
    	}else{
    		System.out.println("Can't declare Variable with the same name twice.");
    	}
        
        System.out.println("vardecl");
        return "vardecl";
        //for declaring variables
    }

    @Override
    public Object visit(FuncDeclNode node){
        visit(node.args);
        beginScope();
        System.out.println("Begin Scope");
        visit(node.body);
        endScope();
        System.out.println("End Scope");
        return "funcdecl";
        // for declaring functions
    }

    @Override
    public Object visit(DatatypeDeclNode node){
    	System.out.println(node.id);
    	if(symbolTables.size() == 1){
    		symbolTables.getFirst().put(node.id, node);
    	}else{
    		System.out.println("Error! Can't declare Datatype here. If you see this very message, some programmer has been lazy.");
    	}
        
        return "datatypedecl";
        // for declaring datatypes
    }
    
    //Question: An AccessorNode ever only has two elements in node.path, right?
    //TO-DO: Check the second element. E.g. if it is a tdef, check that you are accessing an element that exists.
    @Override
    public Object visit(AccessorNode node){
    	if(symbolTables.size() > 1){
    		String firstEl = node.path.getFirst();
    		System.out.println("---Start-----");
    		for(String el: node.path){
    			System.out.println(el);
    		}
    		System.out.println("----End-----");
    		//System.out.println(node.path.getFirst());
    		if(lookup(node.path.getFirst()) != null){
    			return "First step successful";
    		}else{
    			System.out.println("Error! Data-type does not exist.");
    		}
    	}else{
    		System.out.println("Error! Can't access data-type here. If you see this very message, some programmer has been lazy.");
    	}
        System.out.println("AccessorNode");
        return "AccessorNode";
        // for accessing variables
    }

    @Override
    public Object visit(FuncCallExprNode node){
        System.out.println("FuncCallExprNode");
        return "FuncCallExprNode";
        // for calling functions
    }

}
