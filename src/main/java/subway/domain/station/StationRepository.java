package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    static {
    	stations.add(new Station("설화명곡"));
        stations.add(new Station("화원"));
        stations.add(new Station("대곡"));
        stations.add(new Station("진천"));
        stations.add(new Station("월배"));
        stations.add(new Station("상인"));
        stations.add(new Station("월촌"));
        stations.add(new Station("송현"));
        stations.add(new Station("서부정류장"));
        stations.add(new Station("대명"));
        stations.add(new Station("안지랑"));
        stations.add(new Station("현충로"));
        stations.add(new Station("영대병원"));
        stations.add(new Station("교대"));
        stations.add(new Station("명덕"));
        stations.add(new Station("반월당"));
        stations.add(new Station("중앙로"));
        stations.add(new Station("대구역"));
        stations.add(new Station("칠성시장"));
        stations.add(new Station("신천"));
        stations.add(new Station("동대구역"));
        stations.add(new Station("동구청"));
        stations.add(new Station("아양교"));
        stations.add(new Station("동촌"));
        stations.add(new Station("해안"));
        stations.add(new Station("방촌"));
        stations.add(new Station("용계"));
        stations.add(new Station("율하"));
        stations.add(new Station("신기"));
        stations.add(new Station("반야월"));
        stations.add(new Station("각산"));
        stations.add(new Station("안심"));
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    public static Station findStationByName(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findFirst()
                .orElseThrow(NoSuchStationException::new);
    }
}

