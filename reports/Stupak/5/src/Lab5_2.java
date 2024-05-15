abstract class Tree {
    private static int nextId = 1;
    private int id;
    private int age;

    boolean isFruiting;

    public Tree (){
        this.id = nextId++;
        this.age = 0;
    }

    public void setFruiting(boolean isFruiting) {
        this.isFruiting = isFruiting;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    public abstract void grow();
    public int getId(){
        return id;
    }

    public String toString() {
        return "Садовое дерево #" + id + " (" + getAge() + " лет, " + (isFruiting ? "плодоносит" : "не плодоносит") + ")";
    }
    public abstract boolean replace();
}

class AppleTree extends Tree{
    public AppleTree(){
        super();
    }

    @Override
    public void grow() {
        setAge(getAge() + 1);
        if (getAge() >= 2) {
            setFruiting(true);
        }
    }
    @Override
    public boolean replace() {
        return getAge() >=3;
    }
    @Override
    public String toString() {
        return super.toString() + ":Яблоня";
    }
}

class CherryTree extends Tree{
    public CherryTree(){
        super();
    }

    @Override
    public void grow() {
        setAge(getAge() + 1);
        if (getAge() >= 3) {
            setFruiting(true);
        }
    }
    @Override
    public boolean replace() {
        return getAge() >=5;
    }
    @Override
    public String toString() {
        return super.toString() + ":Вишня";
    }
}

class PearTree extends Tree{
    public PearTree(){
        super();
    }
    @Override
    public void grow() {
        setAge(getAge() + 1);
        if (getAge() >= 4) {
            setFruiting(true);
        }
    }
    @Override
    public boolean replace() {
        return getAge() >=7;
    }
    @Override
    public String toString() {
        return super.toString() + ":Груша";
    }
}


public class Lab5_2 {
    public static void main(String[] args) {
        Tree[] trees = new Tree[3];
        trees[0] = new AppleTree();
        trees[1] = new CherryTree();
        trees[2] = new PearTree();

        for (int i = 1; i < 5; i++) {
            for (Tree tree : trees) {
                tree.grow();
                System.out.println(tree);
            }
        }

        System.out.println("Деревья, которые нужно пересадить:");
        for (Tree tree : trees) {
            if (tree.replace() && !tree.isFruiting) {
                System.out.println(tree);
            }
        }

    }
}
