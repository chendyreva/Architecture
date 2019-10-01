package ru.geekbrains.client.Behavioral patterns

import java.util.ArrayList;
import java.util.List;

public class Observer1 {
    public static void main(String[] args) {
        Observer observer = new Observer("first");
        Observer observer2 = new Observer("second");
        Observer observer3 = new Observer("third");
        observer.setStatus("new status");
        observer2.setStatus("hello");
        observer3.setStatus("status not updated");
    }
}

interface  Observale {
    void update();
}

  class Observer implements Observale{
    static List<Observer> observers = new ArrayList<>();
    String name;
    String status;

    public Observer(String name) {
        this.name = name;
        observers.add(this);
    }

      public void setStatus(String status) {
          this.status = status;
          notifyAllObservers();
      }

      void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
      }

    @Override
       public void update() {
          System.out.println(name + " change status: " + status);
      }
  }