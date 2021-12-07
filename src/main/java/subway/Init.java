package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Init {
	public static void init() {
		StationRepository.addStation(new Station("교대역"));
		StationRepository.addStation(new Station("강남역"));
		StationRepository.addStation(new Station("역삼역"));
		StationRepository.addStation(new Station("남부터미널역"));
		StationRepository.addStation(new Station("양재역"));
		StationRepository.addStation(new Station("양재시민의숲역"));
		StationRepository.addStation(new Station("매봉역"));

		LineRepository.addLine(new Line("2호선"));
		LineRepository.addLine(new Line("3호선"));
		LineRepository.addLine(new Line("신분당선"));


	}
}
