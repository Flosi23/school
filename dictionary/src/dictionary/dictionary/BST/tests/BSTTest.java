package dictionary.dictionary.BST.tests;

import dictionary.dictionary.BST.BST;
import dictionary.dictionary.BST.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    private BST<Integer> createBST(int root, int...values){
       BST<Integer> bst = new BST<>();
       bst.insert(root);

       for(int value: values){
           bst.insert(value);
       }

       return bst;
    }

    @Test
    void equals(){
        BST<Integer> tree1 = new BST<>();
        Node<Integer> root1 = new Node<>(10);
        tree1.setRoot(root1);
        BST<Integer> tree2 = new BST<>();
        Node<Integer> root2 = new Node<>(10);
        tree2.setRoot(root2);
        assertEquals(tree1, tree2);

        root1.setLeft(new Node<>(9));
        root2.setLeft(new Node<>(9));
        assertEquals(tree1, tree2);

        root2.setRight(new Node<>(12));
        root1.setRight(new Node<>(13));
        assertNotEquals(tree1, tree2);

        root1.setRight(new Node<>(12));
        assertEquals(tree1, tree2);
    }

    @Test
    void contains() {
        BST<Integer> bst = createBST(12, 1,4,6,8,15,19,13);
        assertTrue(bst.contains(4));
        assertTrue(bst.contains(19));
        assertTrue(bst.contains(8));
        assertTrue(bst.contains(15));
        assertFalse(bst.contains(0));
        assertFalse(bst.contains(-8));
        assertFalse(bst.contains(14));
    }

    /**
     * Stelle sicher:
     *      1. dass korrekt in den dictionary.dictionary.BST eingefügt wird
     *      2. dass keine Duplikate möglich sind
     */
    @Test
    void insert() {
        BST<Integer> expected = new BST<>();
        Node<Integer> root = new Node<>(8);
        expected.setRoot(root);
        root.setLeft(new Node<>(4));
        root.setRight(new Node<>(10));

        BST<Integer> actual = new BST<>();
        actual.insert(8);
        actual.insert(4);
        actual.insert(10);
        assertEquals(expected, actual);

        actual.insert(10);
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        BST<Integer> actual = createBST(12, 11,13);
        BST<Integer> expected = createBST(12, 11);
        actual.remove(13);
        assertEquals(expected, actual);

        actual = createBST(12, 11);
        expected = createBST(12);
        actual.remove(11);
        assertEquals(expected, actual);

        actual = createBST(12, 13);
        expected = createBST(13);
        actual.remove(12);
        assertEquals(expected, actual);

        actual = createBST(12,11,13,8);
        expected = createBST(13,11,8);
        actual.remove(12);
        actual.list();
        assertEquals(expected, actual);
    }
}