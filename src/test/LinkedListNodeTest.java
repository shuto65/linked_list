package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;

import org.junit.Test;

import DataStructure.LinkedList;
import DataStructure.LinkedList.Counter;
import DataStructure.LinkedList.Node;
public class LinkedListNodeTest {

	@Test
	public void addとaddheadとappendTailのテスト() {
		LinkedList list = new LinkedList(1, 2);
		
		Node node = list.findNode(0);
		assertThat(node.getItem(), is(1));

		list.addHead(10);
		node = list.findNode(0);
		assertThat(node.getItem(), is(10));
		
		list.appendTail(5);
		node = list.findNode(3);
		assertThat((Integer)node.getItem(), is(5));
		
		list.add(2,3);
		node = list.findNode(4);
		assertThat((Integer)node.getItem(), is(5));
		
	}

	@Test
	public void equalsのテスト() {
		LinkedList list = new LinkedList(1, 2);
		
		Node node = list.findNode(0);
		assertThat(node.getItem(), is(1));
		
		list.appendTail(1);
		Node node2 = list.findNode(2);
		assertTrue(node.equals(node2));
		
	}
	
	@Test
	public void dedupのテスト(){
		LinkedList list = new LinkedList(1,2,3,3);
		
		assertThat(list.size(), is(4));
		
		list.dedup();
		
		assertThat(list.size(), is(3));
		assertThat(list.findNode(0).getItem(), is(1));
		assertThat(list.findNode(1).getItem(), is(2));
		assertThat(list.findNode(2).getItem(), is(3));
		
	}
	
	@Test
	public void hmapのテスト(){
		HashSet<Node> hset = new HashSet<Node>();
		LinkedList list = new LinkedList(1,2,3,3);
		hset.add(list.findNode(2));
		hset.add(list.findNode(1));

		assertTrue(hset.contains(list.findNode(3)));
		
		
	}
	
	@Test
	public void getXthFromTailのテスト(){
		LinkedList list = new LinkedList(1,2,3,4,5);
		
		Node node = list.getXthFromTail(5);
		assertThat(node.getItem(), is(1));
	}
	
	@Test
	public void getXthFromTailesRecursiveのテスト(){
		LinkedList list = new LinkedList(1,2,3,4,5);
		
		Counter c = list.new Counter();
		Node node = list.getXthFromTailRecursive(list.getHead(), 5, c);
		assertThat(node.getItem(), is(1));
	}
	
}
