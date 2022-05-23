package subway.domain;

import subway.exception.NoSuchChoiceException;

import java.util.Arrays;

public enum SceneState {
    MAIN_SCENE("PATH_SCENE_b"),
    PATH_SCENE("MAIN_SCENE_1"),
    DISTANCE_MIN_SCENE("PATH_SCENE_1"),
    TIME_MIN_SCENE("PATH_SCENE_2"),
    QUIT("MAIN_SCENE_q");
