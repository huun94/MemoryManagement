package allocationMemory;

import java.util.ArrayList;
import java.util.List;

public class MemoryManager {
    private List<MemoryBlock> memoryBlocks;
    
    public MemoryManager(int[] sizes) {
        memoryBlocks = new ArrayList<>();
        for (int size : sizes) {
            memoryBlocks.add(new MemoryBlock(size));
        }
    }
    
    public boolean allocate(int size) {
        // Implement First Fit algorithm
        for (MemoryBlock block : memoryBlocks) {
            if (!block.isOccupied() && block.getSize() >= size) {
                block.setOccupied(true);
                return true;
            }
        }
        return false;
    }
    
    public boolean deallocate(int size) {
        for (MemoryBlock block : memoryBlocks) {
            if (block.isOccupied() && block.getSize() == size) {
                block.setOccupied(false);
                return true;
            }
        }
        return false;
    }
}

