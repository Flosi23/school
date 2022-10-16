package school.Baum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaumTest {

    public Baum createTree(int ... values) {
        Baum baum = new Baum();

        for(int value: values) {
            baum.insert(new Datenelement(value));
        }

        return baum;
    }

    public Baum createDefaultTree(){
        return createTree(8,5,10,3,7,9,20,1,4,18,30);
    }

    @Test
    void inorder() {
    }

    @Test
    void preorder() {
    }

    @Test
    void postorder() {
    }

    @Test
    void binarySearch() {
    }

    @Test
    void insert() {
        Baum baum = new Baum();
        baum.insert(new Datenelement(2));
        baum.insert(new Datenelement(-3));
        baum.insert(new Datenelement(5));
        baum.insert(new Datenelement(-2));

        Baum expected = createTree(2,-3,5,-2);
        assertTrue(expected.equals(baum));
    }
}
