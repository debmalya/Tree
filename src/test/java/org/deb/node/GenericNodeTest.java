package org.deb.node;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class GenericNodeTest {
	/**
	 * This is a String node. It will contain only string values.
	 */
	private static GenericNode<String> stringNode = new GenericNode<>();

	/**
	 * This is an Integer node. It will maintain only integer values.
	 */
	private static GenericNode<Integer> integerNode = new GenericNode<>();

	/**
	 * This is initialize, this will run before executing test method.
	 */
	@BeforeClass
	public static void initialize() {

		stringNode.addNode("A");
		stringNode.addNode("B");
		stringNode.addNode("C");
		
		integerNode.addNode(100);
		integerNode.addNode(90);
		integerNode.addNode(110);
		integerNode.addNode(120);
	}

	@Test
	public void testFindNode() {
		GenericNode<String> foundNodeString = stringNode.findNode(stringNode, "A");
		Assert.assertNotNull(foundNodeString);
		Assert.assertEquals("A", foundNodeString.getValue());

		Assert.assertNotNull(foundNodeString.getRight());
		Assert.assertEquals("B", foundNodeString.getRight().getValue());

		Assert.assertNotNull(foundNodeString.getRight().getRight());
		Assert.assertEquals("C", foundNodeString.getRight().getRight().getValue());
		
		GenericNode<Integer> foundNodeInteger = integerNode.findNode(integerNode, 100);
		Assert.assertNotNull(foundNodeInteger);
		Assert.assertNotNull(foundNodeInteger.getLeft());
		Assert.assertNotNull(foundNodeInteger.getRight());
		
		Assert.assertEquals(Integer.valueOf(90), foundNodeInteger.getLeft().getValue());
		Assert.assertEquals(Integer.valueOf(110), foundNodeInteger.getRight().getValue());
		Assert.assertEquals(Integer.valueOf(120), foundNodeInteger.getRight().getRight().getValue());
	}

}
