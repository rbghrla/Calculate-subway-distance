package subway.domain.section;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.view.OutputView;

import java.util.List;

public class SectionRepository {
    private static final WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    private static final  WeightedMultigraph<Station, DefaultWeightedEdge> timeGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    static {
        StationRepository.stations().forEach(SectionRepository::addStation);

        addSectionInformation("설화명곡", "화원", new SectionInformation(1, 2));
        addSectionInformation("화원", "대곡", new SectionInformation(2, 3));
        addSectionInformation("대곡", "진천", new SectionInformation(3, 4));
        addSectionInformation("진천", "월배", new SectionInformation(2, 3));
        addSectionInformation("월배", "상인", new SectionInformation(1, 1));
        addSectionInformation("상인", "월촌", new SectionInformation(2, 8));
        addSectionInformation("월촌", "송현", new SectionInformation(2, 3));
        addSectionInformation("송현", "서부정류장", new SectionInformation(1, 3));
        addSectionInformation("서부정류장", "대명", new SectionInformation(2, 3));
        addSectionInformation("대명", "안지랑", new SectionInformation(3, 4));
        addSectionInformation("안지랑", "현충로", new SectionInformation(2, 3));
        addSectionInformation("현충로", "영대병원", new SectionInformation(2, 4));
        addSectionInformation("영대병원", "교대", new SectionInformation(1, 3));
        addSectionInformation("교대", "명덕", new SectionInformation(1, 2));
        addSectionInformation("명덕", "반월당", new SectionInformation(3, 5));
        addSectionInformation("반월당", "중앙로", new SectionInformation(2, 3));
        addSectionInformation("중앙로", "대구역", new SectionInformation(2, 4));
        addSectionInformation("대구역", "칠성시장", new SectionInformation(1, 2));
        addSectionInformation("칠성시장", "신천", new SectionInformation(2, 4));
        addSectionInformation("신천", "동대구역", new SectionInformation(2, 3));
        addSectionInformation("동대구역", "동구청", new SectionInformation(1, 3));
        addSectionInformation("동구청", "아양교", new SectionInformation(4, 6));
        addSectionInformation("아양교", "동촌", new SectionInformation(2, 3));
        addSectionInformation("동촌", "해안", new SectionInformation(1, 3));
        addSectionInformation("해안", "방촌", new SectionInformation(2, 3));
        addSectionInformation("방촌", "용계", new SectionInformation(3, 5));
        addSectionInformation("용계", "율하", new SectionInformation(2, 3));
        addSectionInformation("율하", "신기", new SectionInformation(2, 3));
        addSectionInformation("신기", "반야월", new SectionInformation(1, 2));
        addSectionInformation("반야월", "각산", new SectionInformation(2, 4));
        addSectionInformation("각산", "안심", new SectionInformation(2, 3));
    }

    public static void addStation(Station station) {
        distanceGraph.addVertex(station);
        timeGraph.addVertex(station);
    }

    public static void addSectionInformation(String stationName
            , String nextStationName
            , SectionInformation sectionInformation) {
        Station station = StationRepository.findStationByName(stationName);
        Station nextStation = StationRepository.findStationByName(nextStationName);

        addDistanceEdgeWeight(station, nextStation, sectionInformation.getDistance());
        addTimeEdgeWeight(station, nextStation, sectionInformation.getTime());
    }

    private static void addDistanceEdgeWeight(Station station, Station nextStation, double distance) {
        distanceGraph.setEdgeWeight(distanceGraph.addEdge(station, nextStation), distance);
    }

    private static void addTimeEdgeWeight(Station station, Station nextStation, double time) {
        timeGraph.setEdgeWeight(timeGraph.addEdge(station, nextStation), time);
    }

    public static List<Station> getSectionDistanceStations(Station departureStation, Station arrivalStation) {
        try {
            DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);

            return dijkstraShortestPath.getPath(departureStation, arrivalStation).getVertexList();
        }
        catch (NullPointerException e) {
            OutputView.printSectionEmptyErrorMessage();

            return null;
        }
    }

    public static int getSectionDistance(Station departureStation, Station arrivalStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);

        return (int) dijkstraShortestPath.getPath(departureStation, arrivalStation).getWeight();
    }

    public static List<Station> getSectionTimeStations(Station departureStation, Station arrivalStation) {
        try {
            DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);

            return dijkstraShortestPath.getPath(departureStation, arrivalStation).getVertexList();
        }
        catch (NullPointerException e) {
            OutputView.printSectionEmptyErrorMessage();

            return null;
        }
    }

    public static int getSectionTime(Station departureStation, Station arrivalStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);

        return (int) dijkstraShortestPath.getPath(departureStation, arrivalStation).getWeight();
    }
}
