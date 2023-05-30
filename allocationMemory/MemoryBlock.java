package allocationMemory;

public class MemoryBlock {
    private int size;
    private boolean occupied;

    public MemoryBlock(int size) {
        this.size = size;
        this.occupied = false;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
