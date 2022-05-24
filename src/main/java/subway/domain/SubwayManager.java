package subway.domain;

import subway.domain.Section.SectionRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.exception.NoSuchStationException;
import subway.exception.SameStationException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayManager {
    public void startProgram(Scanner scanner) {
        SceneState sceneState = SceneState.MAIN_SCENE;

        while (sceneState != SceneState.QUIT) {
            sceneState = viewMainScene(scanner, sceneState);
            sceneState = viewPathScene(scanner, sceneState);
            sceneState = viewFindInformationByDistanceScene(scanner, sceneState);
            sceneState = viewFindInformationByTimeScene(scanner, sceneState);
        }
    }

    private SceneState viewMainScene(Scanner scanner, SceneState sceneState) {
        if (sceneState == SceneState.MAIN_SCENE) {
            OutputView.printMainScene();

            return InputView.inputMainSceneChoice(scanner);
        }

        return sceneState;
    }

    private SceneState viewPathScene(Scanner scanner, SceneState sceneState) {
        if (sceneState == SceneState.PATH_SCENE) {
            OutputView.printPathScene();

            return InputView.inputPathSceneChoice(scanner);
        }

        return sceneState;
    }

    private SceneState viewFindInformationByDistanceScene(Scanner scanner, SceneState sceneState) {
        try {
            return executeFindInformationByDistanceScene(scanner, sceneState);
        }
        catch (NoSuchStationException e) {
            OutputView.printStationErrorMessage();
            return viewFindInformationByDistanceScene(scanner, sceneState);
        }
    }

    private SceneState executeFindInformationByDistanceScene(Scanner scanner, SceneState sceneState) {
        try {
            if (sceneState == SceneState.DISTANCE_MIN_SCENE) {
                return showPathByDistance(StationRepository.findStationByName(InputView.inputDepartureStation(scanner))
                        , StationRepository.findStationByName(InputView.inputArrivalStation(scanner)));
            }

            return sceneState;
        }
        catch (SameStationException e) {
            OutputView.printSameStationErrorMessage();
            return executeFindInformationByDistanceScene(scanner, sceneState);
        }
    }