### 🚇 프로그램 기능 


### 지하철 역 거리 계산
- 지하철 역과 역 사이의 거리를 계산하고  프로그램을 만든다.
<br>

## 🚀 기능 요구사항

### 지하철 역사이의 거리를 설정, 계산후 제공 해준다.
+ 지하철의 거리를 계산하기 위해 jgraph를 이용해준다
- 지하철 역 이름을 제공해준다.
+ 역과 역사이의 거리를 임의로 설정 & 그에 따른 거리를 계산한다.
- 거리별 메세지를 출력한다. 

## 실제 노선의 역간 & 누적 거리

+아래는 실제 거리이지만 편의상 임의의 거리를 설정하였다.


#### ![실제 노선](https://user-images.githubusercontent.com/102271711/170051812-e77ff23b-730e-41c7-ad8c-645e1eb2b4d5.PNG)

##### ![image](https://user-images.githubusercontent.com/102271645/170043247-8c4ad82f-dc22-4eb3-85c6-0d714672bf42.png)



### 💻 프로그래밍 실행 결과 
#### 역 관리
```
## 메인 화면
1. 경로 조회
Q. 종료

## 원하는 기능을 선택하세요.
1

## 역 관리 화면
1. 도착 예정 거리
B. 돌아가기

## 출발역을 입력하세요.
설화명곡

## 도착역을 입력하세요.
대구역

[INFO] ---
[INFO] 총 거리 32km
거리가 머니 자동차를 이용하세요!
[INFO] ---
[INFO] 설화명곡
[INFO] 화원
[INFO] 대곡 
[INFO] 진천
[INFO] 월배
[INFO] 상인
[INFO] 월촌
[INFO] 송현
[INFO] 서부정류장
[INFO] 대명
[INFO] 안지랑
[INFO] 현충로
[INFO] 영대병원
[INFO] 교대
[INFO] 명덕
[INFO] 반월당
[INFO] 중앙로
[INFO] 대구역


## 메인 화면
1. 경로 조회
Q. 종료

## 원하는 기능을 선택하세요.
Q

--종료--

```

<br>

## 📈 진행 요구사항
- 우선은 [precourse-subway 저장소](https://github.com/yangdongjue5510/precourse-subway)를 fork/clone해 시작한다.
+ 거리 계산을 하기 위해 [jgrapht를 이용하여 Christofides의 알고리즘 구현하기] (https://github.com/WoongheeLee/Christofides_Algorithm)와 
+ [Jgrapht] (https://github.com/rcpoison/jgrapht)를 참고하여 기존의 프로그램에 적용한다.
- 원래의 기능이나 겹치는 내용은 간략하게 정리밑 삭제하고 거리계산하는 기능을 추가 한다.
+ 원래의 기능에서 하나의 기능을 추가하거나 수정 삭제 할 경우 commit을 실행한다. 
- DataBase를 이용하여 구조를 입히려 했으나 Ulsan Bus는 데이터 크롤링으로 디비에 데이터를 넣고 그걸 소요시간 계산하는것만 잇는 기능이기 때문에 디비를 적용하기에는 소스코드를 새로 다 만들어야 함이 다소 무리가 있다고 판단하여 단순히 출발역과 도착역간에 거리를 계산하는 기능을 모방하였다.
+ 마지막에 거리별로 다른 메세지를 출력하는 기능을 생성한다. 
- 원활한 실행을 위해 아래의 jar 파일을 라이브러리에 추가하는것을 권장한다.
- (https://jar-download.com/artifacts/org.jgrapht/jgrapht-core), (http://www.java2s.com/Code/Jar/j/Downloadjgraphtjar.htm)

<br>

## 📝 License

This project is [MIT](https://github.com/yangdongjue5510/precourse-subway/README.md) licensed.
