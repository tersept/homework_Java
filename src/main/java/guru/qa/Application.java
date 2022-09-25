package guru.qa;

import guru.qa.domain.Car;
import guru.qa.domain.Track;

public class Application {

    private final guru.qa.service.GuiInterfaceConsole userInterface;

    public Application(guru.qa.service.GuiInterfaceConsole userInterface) {
        this.userInterface = userInterface;
    }

    void run() {
        Car car = userInterface.chooseCarInGui();
        Track track = userInterface.chooseTrackInGui();
        userInterface.showResult(car, track);
    }
}
