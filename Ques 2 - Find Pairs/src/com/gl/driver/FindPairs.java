package com.gl.driver;

import java.util.HashSet;
import java.util.Set;

public class FindPairs {
	// Binary Tree Node
	class Node {
		private Node left;
		private Node right;
		private int data;

		Node(int key) {
			left = right = null;
			data = key;
		}
	}

	// For Inserting Values
	public Node insert(Node root, int value) {
		if (root == null) {
			return new Node(value);
		}
		if (value < root.data) {
			root.left = insert(root.left, value);
		} else {
			root.right = insert(root.right, value);
		}
		return root;
	}

	// Finding Pair Function
	public static boolean findPair(Node current, int sum, Set<Integer> set) {
		if (current == null) {
			return false;
		} else {
			boolean isPresent = findPair(current.left, sum, set);
			if (isPresent) {
				return isPresent;
			}

			if (set.contains(sum - current.data)) {
				System.out.println("The pair exist with values of " + (sum - current.data) + "," + (current.data));
				return true;
			} else {
				set.add(current.data);
			}
			return findPair(current.right, sum, set);
		}
	}

	public static void findPairWithGivenSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		boolean isPresent = findPair(root, sum, set);
		if (!isPresent) {
			System.out.println("Pair Does not exits");
		}
	}

	// Driver Code
	public static void main(String[] args) {
		Node root = null;
		FindPairs findPairs = new FindPairs();
		root = findPairs.insert(root, 40);
		root = findPairs.insert(root, 20);
		root = findPairs.insert(root, 60);
		root = findPairs.insert(root, 10);
		root = findPairs.insert(root, 30);
		root = findPairs.insert(root, 50);
		root = findPairs.insert(root, 70);

		findPairWithGivenSum(root, 130);
	}
}
