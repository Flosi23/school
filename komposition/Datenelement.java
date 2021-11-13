package school.komposition;

class Datenelement
{

    int weight;
    /**
     * Constructor for objects of class Datenelement
     */
    Datenelement (int weight)
    {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Datenelement{" +
                "weight=" + weight +
                '}';
    }
}
