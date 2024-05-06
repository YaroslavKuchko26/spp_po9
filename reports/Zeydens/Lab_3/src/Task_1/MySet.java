public class MySet {
    private int[] set;
    private int capacity;
    MySet(int setCapacity) {
        this.capacity = 0;
        this.set = new int[setCapacity];
    }
    MySet(int[] set) {
        this.set = set;
        this.capacity = this.set.length;
    }
    public int[] getSet() {return this.set;}
    public int getSetCapacity() {return this.capacity;}
    public void union(int[] set) {
        if(this.isEmpty()) {
            this.set = set;
            this.capacity = this.set.length;
            return;
        }
        for(int i = 0; i < set.length; ++i) {
            this.add(set[i]);
        }
    }
    public void print() {
        if(this.isEmpty()) {
            return;
        }
        for(int i = 0; i < capacity; ++i) {
            System.out.print(String.valueOf(this.set[i]) + ' ');
        }
        System.out.print("\n");
    }
    public boolean contains(int elem) {
        if(this.isEmpty()) {
            return false;
        }
        for(int i = 0; i < capacity; ++i) {
            if(this.set[i] == elem) {
                return true;
            }
        }
        return false;
    }
    public void add(int elem) {
        if(this.contains(elem)) {
            return;
        }
        if(this.capacity == this.set.length) {
            int[] tempSet = new int[this.set.length * 2];
            for(int i = 0; i < this.capacity; ++i) {
                tempSet[i] = this.set[i];
            }
            tempSet[this.capacity] = elem;
            this.set = tempSet;
            ++this.capacity;
        }
        else {
            this.set[this.capacity] = elem;
            ++this.capacity;
        }
    }
    public void remove(int elem) {
        for (int i = 0; i < this.set.length; ++i) {
            if (this.set[i] == elem) {
                for (int j = i + 1; j < this.capacity; ++j) {
                    this.set[j - 1] = this.set[j];
                }
                --this.capacity;
                return;
            }
        }

    }
    public boolean equals(MySet set) {
        if(this.capacity != set.capacity) {
            return false;
        }
        for(int i = 0; i < this.capacity; ++i) {
            if(this.set[i] != set.set[i]) {
                return false;
            }
        }
        return true;
    }
    public boolean isEmpty() {
        return this.capacity == 0;
    }

}
