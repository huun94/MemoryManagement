package allocationMemory;

/**
 *
 * @author Dell
 */
public class Main {
    public static void main(String[] args) {
    int[] sizes = {150000, 150000, 350000};
    MemoryManager manager = new MemoryManager(sizes);
    boolean success = manager.allocate(300000);
    System.out.println(success); // should print true
    success = manager.allocate(25000);
    System.out.println(success); // should print true
    success = manager.allocate(125000);
    System.out.println(success); // should print false
}

}
