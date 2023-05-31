package managementMemory;

// Java program to implement Quick Fit algorithm
import java.util.*;

class QuickFit {

    // Number of block sizes
    static int n = 5;

    // Block sizes
    static int blockSize[] = { 50, 100, 200, 300, 400 };

    // Lists for each block size
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    // Function to initialize the lists
    static void initialize() {
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }
    }

    // Function to allocate memory to a process
    static void allocate(int processSize) {
        // Find the list that has the closest block size
        int index = -1;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (blockSize[i] >= processSize && blockSize[i] - processSize < minDiff) {
                minDiff = blockSize[i] - processSize;
                index = i;
            }
        }

        // If no suitable list is found, print "Not allocated"
        if (index == -1) {
            System.out.println("Process size " + processSize + " is not allocated");
            return;
        }

        // If the list is empty, create a new block and add it to the list
        if (lists.get(index).isEmpty()) {
            lists.get(index).add(blockSize[index]);
        }

        // Allocate the first block in the list to the process
        int allocated = lists.get(index).remove(0);
        System.out.println("Process size " + processSize + " is allocated " + allocated);

        // If there is remaining space in the block, create a new block of that size and add it to the appropriate list
        int remaining = allocated - processSize;
        if (remaining > 0) {
            for (int i = 0; i < n; i++) {
                if (blockSize[i] == remaining) {
                    lists.get(i).add(remaining);
                    break;
                }
            }
        }
    }

    // Function to deallocate memory from a process
    static void deallocate(int processSize) {
        // Find the list that has the closest block size
        int index = -1;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (blockSize[i] >= processSize && blockSize[i] - processSize < minDiff) {
                minDiff = blockSize[i] - processSize;
                index = i;
            }
        }

        // If no suitable list is found, print "Not deallocated"
        if (index == -1) {
            System.out.println("Process size " + processSize + " is not deallocated");
            return;
        }

        // Add the block size to the list
        lists.get(index).add(blockSize[index]);
        System.out.println("Process size " + processSize + " is deallocated");
    }

    // Driver code
    public static void main(String[] args) {
        
        initialize();

        allocate(100);
        allocate(200);
        allocate(300);
        
        deallocate(100);
        
        allocate(250);
        
    }
}
