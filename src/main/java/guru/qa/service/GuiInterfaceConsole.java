package guru.qa.service;

import guru.qa.domain.Car;
import guru.qa.domain.Track;
import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;

import javax.swing.*;
import java.util.Scanner;

public class GuiInterfaceConsole {

    private final CarStore carStore;
    private final TrackStore trackStore;

    public GuiInterfaceConsole(CarStore carStore, TrackStore trackStore) {
        this.carStore = carStore;
        this.trackStore = trackStore;
    }

    public Car chooseCarInGui() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите автомобиль:");
        String desiredCar = sc.nextLine();
        return carStore.lookup(desiredCar);
    }

    public Track chooseTrackInGui() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите трек:");
        String desiredTrack = sc.nextLine();
        return trackStore.lookup(desiredTrack);
    }

    public void showResult(Car car, Track track) {
        if (car.isPitstopNeeded(track)) {
            System.out.println("Pit-stop needed in " + car.maxLapsForTrack());

        } else {
            System.out.println("Pit-stop not needed ");
        }
    }
}
