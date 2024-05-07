import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicStore {
    private List<Observer> observers = new ArrayList<>();
    private Map<String, Double> availableAlbums = new HashMap<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(News news) {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    public void addNews(String newsText) {
        News news = new News(newsText);
        notifyObservers(news);
    }

    public void addAlbum(String albumName, double price) {
        availableAlbums.put(albumName, price);
    }

    public void purchaseAlbum(Customer customer, String albumName) {
        if (availableAlbums.containsKey(albumName)) {
            double price = availableAlbums.get(albumName);
            if (customer.hasEnoughBalance(price)) {
                customer.deductBalance(price);
                availableAlbums.remove(albumName);
                System.out.println(customer.getName() + " purchased " + albumName + " for $" + price);
            } else {
                System.out.println(customer.getName() + " does not have enough balance to purchase " + albumName);
            }
        } else {
            System.out.println("Album " + albumName + " is not available in the store.");
        }
    }
}
