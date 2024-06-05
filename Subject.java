// Behavioural Pattern

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers();
}

class NewsPublisher implements Subject {
    private List<Observer> subscribers;
    private String news;

    public NewsPublisher() {
        subscribers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer subscriber : subscribers) {
            subscriber.update(news);
        }
    }

    public void publishNews(String news) {
        this.news = news;
        notifyObservers();
    }
}

interface Observer {
    void update(String news);
}

class EmailSubscriber implements Observer {
    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String news) {
        System.out.println("News sent to email: " + email + "\n" + news);
    }
}

class SMSSubscriber implements Observer {
    private String phonenumber;

    public SMSSubscriber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public void update(String news) {
        System.out.println("News sent to SMS: " + phonenumber + "\n" + news);
    }
}