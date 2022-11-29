# 내일배움캠프 4기 - B반 8조

### 0. 팀 소개 [ 조미김 조!]

**B반 8조**

**조**성현, **이**혜민, **김**관호, **김**동균, **김**학윤

<img src = "https://s3.us-west-2.amazonaws.com/secure.notion-static.com/66560826-6047-403a-967e-1fc8e931018e/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221129%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221129T000910Z&X-Amz-Expires=86400&X-Amz-Signature=f740b9f4789b964e00f1bdd817f895246da03727e40fc6aed0c5156de1387111&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">


### 1. 프로젝트 주제 - **은행 관리 시스템**

- 제안해주신 명세를 바탕으로 ** \‘조미김 조\’ **만의 특색있는 은행 관리 시스템을 제작하고자 함
- 일반 사용자 / 어드민을 나누어 유저가 관리될 수 있는 은행 시스템 구축 목표

---

### 2. 프로젝트 개요

- 은행 내에서 이루어지는 간단한 입출금, 거래 내역 조회, 계좌 관리 등 구현
- 일반 사용자 / 어드민의 분리
    - 일반 사용자 - 자신 소유의 계좌 입출금, 관리 및 거래내역 열람가능
    - 어드민 - 회원 계좌와 계정 관리 및 은행 전체 기록 확인 가능
- Layered Architecture 를 적용해 프로젝트 제작 구조화    (아래에서 자세히 설명)
    - Presentation ↔ Application ↔ Data
    - entity 패키지를 통한 객체 구현
- Java의 Scanner 기능과 Print를 사용해 입출력 구현

---

### 03. 팀원 소개 및 역할


| 이름   | 역할            | 
|------|---------------|
| 조성현  | 팀장 - 레포지토리, 유저 로직 구현       | 
| 김관호  | 팀원 - 프린터, 유저 로직 구현   |
| 김동균  | 팀원 - 레포지토리, 유저 로직 구현 |
| 김학윤  | 팀원 - 프레젠테이션, 어드민 로직 구현 |
| 이혜민  | 팀원 - 프레젠테이션, 어드민 로직 구현 |




---

### 04. 사용 기술


<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> <br>
<img src="https://img.shields.io/badge/IntelliJ%20IDEA-005AF0?style=for-the-badge&logo=IntelliJ%20IDEA&logoColor=white"> <br>
<img src="https://img.shields.io/badge/java-9cf.svg?style=for-the-badge&logo=data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAxMjggMTI4Ij48cGF0aCBmaWxsPSIjMDA3NEJEIiBkPSJNNTIuNTgxIDY3LjgxN3MtMy4yODQgMS45MTEgMi4zNDEgMi41NTdjNi44MTQuNzc4IDEwLjI5Ny42NjYgMTcuODA1LS43NTMgMCAwIDEuOTc5IDEuMjM3IDQuNzM1IDIuMzA5LTE2LjgzNiA3LjIxMy0zOC4xMDQtLjQxOC0yNC44ODEtNC4xMTN6bS0yLjA1OS05LjQxNXMtMy42ODQgMi43MjkgMS45NDUgMy4zMTFjNy4yOC43NTEgMTMuMDI3LjgxMyAyMi45NzktMS4xMDMgMCAwIDEuMzczIDEuMzk2IDMuNTM2IDIuMTU3LTIwLjM1MiA1Ljk1NC00My4wMjEuNDY5LTI4LjQ2LTQuMzY1eiIvPjxwYXRoIGZpbGw9IiNFQTJEMkUiIGQ9Ik02Ny44NjUgNDIuNDMxYzQuMTUxIDQuNzc4LTEuMDg4IDkuMDc0LTEuMDg4IDkuMDc0czEwLjUzMy01LjQzNyA1LjY5Ni0xMi4yNDhjLTQuNTE5LTYuMzQ5LTcuOTgyLTkuNTAyIDEwLjc3MS0yMC4zNzguMDAxIDAtMjkuNDM4IDcuMzUtMTUuMzc5IDIzLjU1MnoiLz48cGF0aCBmaWxsPSIjMDA3NEJEIiBkPSJNOTAuMTMyIDc0Ljc4MXMyLjQzMiAyLjAwNS0yLjY3OCAzLjU1NWMtOS43MTYgMi45NDMtNDAuNDQ0IDMuODMxLTQ4Ljk3OS4xMTctMy4wNjYtMS4zMzUgMi42ODctMy4xODcgNC40OTYtMy41NzYgMS44ODctLjQwOSAyLjk2NS0uMzM0IDIuOTY1LS4zMzQtMy40MTItMi40MDMtMjIuMDU1IDQuNzE5LTkuNDY5IDYuNzYyIDM0LjMyNCA1LjU2MyA2Mi41NjctMi41MDYgNTMuNjY1LTYuNTI0em0tMzUuOTctMjYuMTM0cy0xNS42MjkgMy43MTMtNS41MzQgNS4wNjNjNC4yNjQuNTcgMTIuNzU4LjQzOSAyMC42NzYtLjIyNSA2LjQ2OS0uNTQzIDEyLjk2MS0xLjcwNCAxMi45NjEtMS43MDRzLTIuMjc5Ljk3OC0zLjkzIDIuMTA0Yy0xNS44NzQgNC4xNzUtNDYuNTMzIDIuMjMtMzcuNzA2LTIuMDM4IDcuNDYzLTMuNjExIDEzLjUzMy0zLjIgMTMuNTMzLTMuMnpNODIuMiA2NC4zMTdjMTYuMTM1LTguMzgyIDguNjc0LTE2LjQzOCAzLjQ2Ny0xNS4zNTMtMS4yNzMuMjY2LTEuODQ1LjQ5Ni0xLjg0NS40OTZzLjQ3NS0uNzQ0IDEuMzc4LTEuMDYzYzEwLjMwMi0zLjYyIDE4LjIyMyAxMC42ODEtMy4zMjIgMTYuMzQ1IDAgMCAuMjQ3LS4yMjQuMzIyLS40MjV6Ii8+PHBhdGggZmlsbD0iI0VBMkQyRSIgZD0iTTcyLjQ3NCAxLjMxM3M4LjkzNSA4LjkzOS04LjQ3NiAyMi42ODJjLTEzLjk2MiAxMS4wMjctMy4xODQgMTcuMzEzLS4wMDYgMjQuNDk4LTguMTUtNy4zNTQtMTQuMTI4LTEzLjgyOC0xMC4xMTgtMTkuODUyIDUuODg5LTguODQyIDIyLjIwNC0xMy4xMzEgMTguNi0yNy4zMjh6Ii8+PHBhdGggZmlsbD0iIzAwNzRCRCIgZD0iTTU1Ljc0OSA4Ny4wMzljMTUuNDg0Ljk5IDM5LjI2OS0uNTUxIDM5LjgzMi03Ljg3OCAwIDAtMS4wODIgMi43NzctMTIuNzk5IDQuOTgxLTEzLjIxOCAyLjQ4OC0yOS41MjMgMi4xOTktMzkuMTkxLjYwMyAwIDAgMS45OCAxLjY0IDEyLjE1OCAyLjI5NHoiLz48cGF0aCBmaWxsPSIjRUEyRDJFIiBkPSJNOTQuODY2IDEwMC4xODFoLS40NzJ2LS4yNjRoMS4yN3YuMjY0aC0uNDd2MS4zMTdoLS4zMjlsLjAwMS0xLjMxN3ptMi41MzUuMDY2aC0uMDA2bC0uNDY4IDEuMjUxaC0uMjE2bC0uNDY1LTEuMjUxaC0uMDA1djEuMjUxaC0uMzEydi0xLjU4MWguNDU3bC40MzEgMS4xMTkuNDMyLTEuMTE5aC40NTR2MS41ODFoLS4zMDJ2LTEuMjUxem0tNDQuMTkgMTQuNzljLTEuNDYgMS4yNjYtMy4wMDQgMS45NzgtNC4zOTEgMS45NzgtMS45NzQgMC0zLjA0NS0xLjE4Ni0zLjA0NS0zLjA4NSAwLTIuMDU1IDEuMTQ2LTMuNTYgNS43MzgtMy41NmgxLjY5N3Y0LjY2N2guMDAxem00LjAzMSA0LjU0OHYtMTQuMDc3YzAtMy41OTktMi4wNTMtNS45NzMtNi45OTctNS45NzMtMi44ODYgMC01LjQxNi43MTQtNy40NzMgMS42MjJsLjU5MiAyLjQ5M2MxLjYyLS41OTUgMy43MTUtMS4xNDcgNS43NzEtMS4xNDcgMi44NSAwIDQuMDc1IDEuMTQ3IDQuMDc1IDMuNTIxdjEuNzc5aC0xLjQyNGMtNi45MjEgMC0xMC4wNDQgMi42ODUtMTAuMDQ0IDYuNzIzIDAgMy40NzkgMi4wNTggNS40NTYgNS45MzMgNS40NTYgMi40OSAwIDQuMzUxLTEuMDI4IDYuMDg4LTIuNTMzbC4zMTYgMi4xMzdoMy4xNjN2LS4wMDF6bTEzLjQ1MiAwaC01LjAyN2wtNi4wNTEtMTkuNjg5aDQuMzkxbDMuNzU2IDEyLjA5OS44MzUgMy42MzVjMS44OTYtNS4yNTggMy4yNC0xMC41OTYgMy45MTItMTUuNzMzaDQuMjcxYy0xLjE0MyA2LjQ4MS0zLjIwMyAxMy41OTgtNi4wODcgMTkuNjg4em0xOS4yODgtNC41NDhjLTEuNDY1IDEuMjY2LTMuMDEgMS45NzgtNC4zOTIgMS45NzgtMS45NzYgMC0zLjA0Ni0xLjE4Ni0zLjA0Ni0zLjA4NSAwLTIuMDU1IDEuMTQ5LTMuNTYgNS43MzYtMy41NmgxLjcwMXY0LjY2N2guMDAxem00LjAzMyA0LjU0OHYtMTQuMDc3YzAtMy41OTktMi4wNTktNS45NzMtNi45OTktNS45NzMtMi44ODkgMC01LjQxOC43MTQtNy40NzUgMS42MjJsLjU5MyAyLjQ5M2MxLjYyLS41OTUgMy43MTgtMS4xNDcgNS43NzQtMS4xNDcgMi44NDYgMCA0LjA3NCAxLjE0NyA0LjA3NCAzLjUyMXYxLjc3OWgtMS40MjRjLTYuOTIzIDAtMTAuMDQ1IDIuNjg1LTEwLjA0NSA2LjcyMyAwIDMuNDc5IDIuMDU2IDUuNDU2IDUuOTMgNS40NTYgMi40OTEgMCA0LjM0OS0xLjAyOCA2LjA5MS0yLjUzM2wuMzE4IDIuMTM3aDMuMTYzdi0uMDAxem0tNTYuNjkzIDMuMzQ2Yy0xLjE0NyAxLjY3OS0zLjAwNSAzLjAwOC01LjAzNyAzLjc1N2wtMS45ODktMi4zNDVjMS41NDctLjc5NCAyLjg3Mi0yLjA3NSAzLjQ4OS0zLjI2OS41MzItMS4wNjMuNzUzLTIuNDMuNzUzLTUuNzAxVjkyLjg5MWg0LjI4NHYyMi4xNzNjMCA0LjM3NS0uMzQ4IDYuMTQ0LTEuNSA3Ljg2N3oiLz48L3N2Zz4=">


---

### 5. 프로젝트 계층 소개 [Presentation ↔ Application ↔ Data]

| 패키지 명 | 클래스 명 | 설명 |
| --- | --- | --- |
| Presentation | UserUI, AdminUI | 사용자에게 입력을 받고, 결과값을 보여주는 입출력 기능 구현부 |
| Application | AdminLogic , UserLogic | Presentation 계층에서 입력받은 값을 바탕으로, Data 계층과 상호작용하며 값들을 처리하는 로직 구현부 |
| Data | AccountDB , HistoryDB, , UserDB | Application에서 요청한 데이터의 삽입 , Application에서 요청한 데이터의 전체 조회, 부분 조회 값을 전달 |
| Entity | User, Account, History, TradeType(Enum) | 프로젝트 내에서 사용할 객체 정의, TradeType(Enum 자료형)을 통한 거래 유형 정의 |
| Printer | Printer | 코드 단순화 + 사용자에게 보여질 print 값 관리(리팩터링 용이성) |

<img src= "https://s3.us-west-2.amazonaws.com/secure.notion-static.com/2da37b58-92e0-4054-889c-5cbfa7b08736/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221129%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221129T002232Z&X-Amz-Expires=86400&X-Amz-Signature=c15ce185f28a222c01f34f002fb53bd05017bf6855870598e0326d7da9013f32&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

## 좌측[프로젝트 구조]  / 우측 [Git branch - master, develop, feat]
--- 

### 06. 관련 링크

<a href="https://polydactyl-count-920.notion.site/or-599109d6482f46e68a2fb4fa8ff77c33"> 개발 일지 노션 </a>
