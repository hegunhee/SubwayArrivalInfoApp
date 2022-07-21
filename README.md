# SubwayArrivalInfoApp
## 2022.07.12 ~ 2022.07.15  
## 소개  
지하철 실시간 시간 정보를 불러오는 앱입니다.  
## 앱사진  
![AppMain](https://user-images.githubusercontent.com/57277631/179871012-d5bc6b99-f48d-41f5-8b71-c652240f5aad.png)  
앱 메인  
![AppMainSearch](https://user-images.githubusercontent.com/57277631/179871098-e15e55e3-9e5a-4ab8-887c-242213394305.png)  
검색 결과  
![Detail](https://user-images.githubusercontent.com/57277631/179129352-b3de002b-ae67-4c12-8d68-36f3e26adf60.PNG)  
상세 보기  
![Favorite](https://user-images.githubusercontent.com/57277631/179871124-538ef26b-68cd-410b-9c5a-ef22a8e2562f.png)  
역 선택  
![FavoriteDetail](https://user-images.githubusercontent.com/57277631/179871163-2588c9c3-5901-4267-a496-36c1b89dd941.png)  
## 기술 정보  
* **Retrofit** 사용  
 지하철 역 정보와 지하철 도착 정보를 공공api를 통해서 받아야하기때문에  
 Retrofit을 사용했습니다. 그리고 Json을 파싱해야되기때문에 GsonConverter를 사용했습니다.  
* **DataBinding** 적용  
 dataBinding을 사용하여 findViewById를 사용하지 않으며 xml 파일과 데이터 객체를 연결해줍니다.  
* **Hilt** 적용  
 의존성 주입을 사용해서 테스트를 쉽게 사용하고 코드 내부에서 의존관계를 만들지 않고 관심사를 외부로 돌립니다.  
* **Room Database** 적용  
 지하철 역 정보를 필요할때마다 계속 불러서 사용하는것이 아닌 내부에 저장해두고 사용하고싶어  
 Room DB를 사용하였습니다.  
## 사용 Api  
[지하철 역 정보 검색](https://data.seoul.go.kr/dataList/OA-121/S/1/datasetView.do)  
지하철 이름, 지하철 호선 정보  
[지하철 도착 정보](https://data.seoul.go.kr/dataList/OA-12764/F/1/datasetView.do)  
지하철 현재 위치, 도착 시간, 근접 역  
