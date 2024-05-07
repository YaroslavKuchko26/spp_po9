public class Main {
    public static void main(String[] args) {
        MusicStore store = new MusicStore();

        Customer customer1 = new Customer("Dima", 100);
        Customer customer2 = new Customer("Zakhar", 50);

        store.addObserver(customer1);
        store.addObserver(customer2);

        store.addAlbum("Album 1", 20.0);
        store.addAlbum("Album 2", 30.0);
        store.addAlbum("Album 3", 30.0);

        store.addNews("New albums added to the store!");

        store.purchaseAlbum(customer1, "Album 1");
        store.purchaseAlbum(customer2, "Album 2");

        store.purchaseAlbum(customer1, "Album 2");
    }
}
