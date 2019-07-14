package com.alg.rev.array.toplogical.tpnode;

import java.util.ArrayList;
import java.util.List;

public class NewChinnesFuckerTpSort {

	public static void main(String[] args) {
		
		
		 List<TPNode> p=new ArrayList<TPNode>();
		 p.add( new TPNode(null,null,"A"));
		 p.add( new TPNode(null,null,"B"));
		 List<TPNode> ch2=new ArrayList<TPNode>();
		 p.add( new TPNode(null,null,"F"));
		 p.add( new TPNode(null,null,"G"));
		 
		 List<TPNode> ch1=new ArrayList<TPNode>();
		 p.add( new TPNode(null,null,"D"));
		 p.add( new TPNode(ch2,null,"E"));
		
		 
		 
		 new TPNode(ch1,p,"C");
	}

}
