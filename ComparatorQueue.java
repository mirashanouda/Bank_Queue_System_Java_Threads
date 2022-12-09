import java.util.Comparator;

public class ComparatorQueue implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        if (c1.getP() > c2.getP())
            return -1;
        if (c1.getP() == c2.getP()) {
            if (c1.getI() > c2.getI())
                return -1;
            else return 1;
        }
        return 0;
    }
}
