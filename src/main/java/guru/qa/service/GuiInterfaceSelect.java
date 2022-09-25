package guru.qa.service;

import guru.qa.domain.Car;
import guru.qa.domain.Track;
import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;

import javax.swing.*;

public class GuiInterfaceSelect {

    private final CarStore carStore;
    private final TrackStore trackStore;

    public GuiInterfaceSelect(CarStore carStore, TrackStore trackStore) {
        this.carStore = carStore;
        this.trackStore = trackStore;
    }

    public Car chooseCarInGui() {
        //String desiredCar = JOptionPane.showInputDialog("Car:");
        String[] car = {"Ferrari", "Mercedes"};
        String desiredCar = (String) JOptionPane.showInputDialog(null,
                "Выберите автомобиль:",
                "Выбор авто",
                JOptionPane.OK_OPTION,
                null,
                car,
                car[0]);
        return carStore.lookup(desiredCar);
    }

    public Track chooseTrackInGui() {
        // String desiredTrack = JOptionPane.showInputDialog("Track:");
        String[] track = {"Spa", "Nurburgring"};
        String desiredTrack = (String) JOptionPane.showInputDialog(null,
                "Выберите трек:",
                "Выбор трека",
                JOptionPane.OK_OPTION,
                null,
                track,
                track[0]);
        return trackStore.lookup(desiredTrack);
    }

    public void showResult(Car car, Track track) {
        if (car.isPitstopNeeded(track)) {
            JOptionPane.showMessageDialog(
                    null,
                    "Pit-stop needed in " + car.maxLapsForTrack(),
                    "Результат:",
                    1
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Pit-stop not needed ",
                    "Результат:",
                    1
            );
        }
    }
}
