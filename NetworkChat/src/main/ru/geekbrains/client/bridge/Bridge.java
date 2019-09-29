package ru.geekbrains.client.bridge;
public class Bridge {
    public static void main(String[] args) {
        ICar car = new BMW(new CarBridge());
        car.drive();

        ICar track = new AudiTrack(new TrackBridge());
        track.drive();

    }
}
abstract class ICar{
    IBridge iBridge;

    public  ICar(IBridge iBridge) {
        this.iBridge = iBridge;
    }

    public abstract  void drive();
}

abstract class ITrack {
    abstract void drive();
}

interface IBridge {
    void drive();
}

class CarBridge implements IBridge {
    @Override
    public void drive() {
        System.out.println("drive car");
    }
}

class TrackBridge implements IBridge {
    @Override
    public void drive() {
        System.out.println("drive track");
    }
}


class BMW extends ICar {
    public BMW(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive BMW(car)");
    }
}
class AudiTrack extends ICar {
    public AudiTrack(TrackBridge trackBridge) {
        super(trackBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive audi(track)");
    }
}

