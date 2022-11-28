# 내일배움캠프 4기 - B반 8조

### 01. 프로젝트 명

- 조미김은행

---

### 02. 프로젝트 설명

- 이 프로젝트는 은행 내에서 이루어지는 간단한 입출금과 거래 내역 조회를 위해 만들어졌다.
- 관리자 로그인 기능으로 회원/계좌 관리가 가능하다.
- 은행 관리 시스템을 최대한 Layered Architecture 이용하여 구현
- Java의 scanner 기능 사용해서 구현.

---

### 03. 팀원 소개 및 역할



| 이름   | 역할            | 
|------|---------------|
| 조성현  | 팀장 - 발표       | 
| 김관호  | 팀원 - 기술 총책임   |
| 김동균  | 팀원 - 구현과 오류수정 |
| 김학윤  | 팀원 - 구현과 오류수정 |
| 이혜민  | 팀원 - 구현과 오류수정 |




---

### 04. 사용 기술


<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> <br>
<img src="https://img.shields.io/badge/IntelliJ%20IDEA-005AF0?style=for-the-badge&logo=IntelliJ%20IDEA&logoColor=white"> <br>
<img src="https://img.shields.io/badge/java-9cf.svg?style=for-the-badge&logo=data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAxMjggMTI4Ij48cGF0aCBmaWxsPSIjMDA3NEJEIiBkPSJNNTIuNTgxIDY3LjgxN3MtMy4yODQgMS45MTEgMi4zNDEgMi41NTdjNi44MTQuNzc4IDEwLjI5Ny42NjYgMTcuODA1LS43NTMgMCAwIDEuOTc5IDEuMjM3IDQuNzM1IDIuMzA5LTE2LjgzNiA3LjIxMy0zOC4xMDQtLjQxOC0yNC44ODEtNC4xMTN6bS0yLjA1OS05LjQxNXMtMy42ODQgMi43MjkgMS45NDUgMy4zMTFjNy4yOC43NTEgMTMuMDI3LjgxMyAyMi45NzktMS4xMDMgMCAwIDEuMzczIDEuMzk2IDMuNTM2IDIuMTU3LTIwLjM1MiA1Ljk1NC00My4wMjEuNDY5LTI4LjQ2LTQuMzY1eiIvPjxwYXRoIGZpbGw9IiNFQTJEMkUiIGQ9Ik02Ny44NjUgNDIuNDMxYzQuMTUxIDQuNzc4LTEuMDg4IDkuMDc0LTEuMDg4IDkuMDc0czEwLjUzMy01LjQzNyA1LjY5Ni0xMi4yNDhjLTQuNTE5LTYuMzQ5LTcuOTgyLTkuNTAyIDEwLjc3MS0yMC4zNzguMDAxIDAtMjkuNDM4IDcuMzUtMTUuMzc5IDIzLjU1MnoiLz48cGF0aCBmaWxsPSIjMDA3NEJEIiBkPSJNOTAuMTMyIDc0Ljc4MXMyLjQzMiAyLjAwNS0yLjY3OCAzLjU1NWMtOS43MTYgMi45NDMtNDAuNDQ0IDMuODMxLTQ4Ljk3OS4xMTctMy4wNjYtMS4zMzUgMi42ODctMy4xODcgNC40OTYtMy41NzYgMS44ODctLjQwOSAyLjk2NS0uMzM0IDIuOTY1LS4zMzQtMy40MTItMi40MDMtMjIuMDU1IDQuNzE5LTkuNDY5IDYuNzYyIDM0LjMyNCA1LjU2MyA2Mi41NjctMi41MDYgNTMuNjY1LTYuNTI0em0tMzUuOTctMjYuMTM0cy0xNS42MjkgMy43MTMtNS41MzQgNS4wNjNjNC4yNjQuNTcgMTIuNzU4LjQzOSAyMC42NzYtLjIyNSA2LjQ2OS0uNTQzIDEyLjk2MS0xLjcwNCAxMi45NjEtMS43MDRzLTIuMjc5Ljk3OC0zLjkzIDIuMTA0Yy0xNS44NzQgNC4xNzUtNDYuNTMzIDIuMjMtMzcuNzA2LTIuMDM4IDcuNDYzLTMuNjExIDEzLjUzMy0zLjIgMTMuNTMzLTMuMnpNODIuMiA2NC4zMTdjMTYuMTM1LTguMzgyIDguNjc0LTE2LjQzOCAzLjQ2Ny0xNS4zNTMtMS4yNzMuMjY2LTEuODQ1LjQ5Ni0xLjg0NS40OTZzLjQ3NS0uNzQ0IDEuMzc4LTEuMDYzYzEwLjMwMi0zLjYyIDE4LjIyMyAxMC42ODEtMy4zMjIgMTYuMzQ1IDAgMCAuMjQ3LS4yMjQuMzIyLS40MjV6Ii8+PHBhdGggZmlsbD0iI0VBMkQyRSIgZD0iTTcyLjQ3NCAxLjMxM3M4LjkzNSA4LjkzOS04LjQ3NiAyMi42ODJjLTEzLjk2MiAxMS4wMjctMy4xODQgMTcuMzEzLS4wMDYgMjQuNDk4LTguMTUtNy4zNTQtMTQuMTI4LTEzLjgyOC0xMC4xMTgtMTkuODUyIDUuODg5LTguODQyIDIyLjIwNC0xMy4xMzEgMTguNi0yNy4zMjh6Ii8+PHBhdGggZmlsbD0iIzAwNzRCRCIgZD0iTTU1Ljc0OSA4Ny4wMzljMTUuNDg0Ljk5IDM5LjI2OS0uNTUxIDM5LjgzMi03Ljg3OCAwIDAtMS4wODIgMi43NzctMTIuNzk5IDQuOTgxLTEzLjIxOCAyLjQ4OC0yOS41MjMgMi4xOTktMzkuMTkxLjYwMyAwIDAgMS45OCAxLjY0IDEyLjE1OCAyLjI5NHoiLz48cGF0aCBmaWxsPSIjRUEyRDJFIiBkPSJNOTQuODY2IDEwMC4xODFoLS40NzJ2LS4yNjRoMS4yN3YuMjY0aC0uNDd2MS4zMTdoLS4zMjlsLjAwMS0xLjMxN3ptMi41MzUuMDY2aC0uMDA2bC0uNDY4IDEuMjUxaC0uMjE2bC0uNDY1LTEuMjUxaC0uMDA1djEuMjUxaC0uMzEydi0xLjU4MWguNDU3bC40MzEgMS4xMTkuNDMyLTEuMTE5aC40NTR2MS41ODFoLS4zMDJ2LTEuMjUxem0tNDQuMTkgMTQuNzljLTEuNDYgMS4yNjYtMy4wMDQgMS45NzgtNC4zOTEgMS45NzgtMS45NzQgMC0zLjA0NS0xLjE4Ni0zLjA0NS0zLjA4NSAwLTIuMDU1IDEuMTQ2LTMuNTYgNS43MzgtMy41NmgxLjY5N3Y0LjY2N2guMDAxem00LjAzMSA0LjU0OHYtMTQuMDc3YzAtMy41OTktMi4wNTMtNS45NzMtNi45OTctNS45NzMtMi44ODYgMC01LjQxNi43MTQtNy40NzMgMS42MjJsLjU5MiAyLjQ5M2MxLjYyLS41OTUgMy43MTUtMS4xNDcgNS43NzEtMS4xNDcgMi44NSAwIDQuMDc1IDEuMTQ3IDQuMDc1IDMuNTIxdjEuNzc5aC0xLjQyNGMtNi45MjEgMC0xMC4wNDQgMi42ODUtMTAuMDQ0IDYuNzIzIDAgMy40NzkgMi4wNTggNS40NTYgNS45MzMgNS40NTYgMi40OSAwIDQuMzUxLTEuMDI4IDYuMDg4LTIuNTMzbC4zMTYgMi4xMzdoMy4xNjN2LS4wMDF6bTEzLjQ1MiAwaC01LjAyN2wtNi4wNTEtMTkuNjg5aDQuMzkxbDMuNzU2IDEyLjA5OS44MzUgMy42MzVjMS44OTYtNS4yNTggMy4yNC0xMC41OTYgMy45MTItMTUuNzMzaDQuMjcxYy0xLjE0MyA2LjQ4MS0zLjIwMyAxMy41OTgtNi4wODcgMTkuNjg4em0xOS4yODgtNC41NDhjLTEuNDY1IDEuMjY2LTMuMDEgMS45NzgtNC4zOTIgMS45NzgtMS45NzYgMC0zLjA0Ni0xLjE4Ni0zLjA0Ni0zLjA4NSAwLTIuMDU1IDEuMTQ5LTMuNTYgNS43MzYtMy41NmgxLjcwMXY0LjY2N2guMDAxem00LjAzMyA0LjU0OHYtMTQuMDc3YzAtMy41OTktMi4wNTktNS45NzMtNi45OTktNS45NzMtMi44ODkgMC01LjQxOC43MTQtNy40NzUgMS42MjJsLjU5MyAyLjQ5M2MxLjYyLS41OTUgMy43MTgtMS4xNDcgNS43NzQtMS4xNDcgMi44NDYgMCA0LjA3NCAxLjE0NyA0LjA3NCAzLjUyMXYxLjc3OWgtMS40MjRjLTYuOTIzIDAtMTAuMDQ1IDIuNjg1LTEwLjA0NSA2LjcyMyAwIDMuNDc5IDIuMDU2IDUuNDU2IDUuOTMgNS40NTYgMi40OTEgMCA0LjM0OS0xLjAyOCA2LjA5MS0yLjUzM2wuMzE4IDIuMTM3aDMuMTYzdi0uMDAxem0tNTYuNjkzIDMuMzQ2Yy0xLjE0NyAxLjY3OS0zLjAwNSAzLjAwOC01LjAzNyAzLjc1N2wtMS45ODktMi4zNDVjMS41NDctLjc5NCAyLjg3Mi0yLjA3NSAzLjQ4OS0zLjI2OS41MzItMS4wNjMuNzUzLTIuNDMuNzUzLTUuNzAxVjkyLjg5MWg0LjI4NHYyMi4xNzNjMCA0LjM3NS0uMzQ4IDYuMTQ0LTEuNSA3Ljg2N3oiLz48L3N2Zz4=">


---

### 05. 구현사항

| Package      | Function                       | Request                | Response               |
|--------------|--------------------------------|------------------------|------------------------|
| Application  | Logic 구현                       | Data Package으로 data 요청 | Presentation에 기능 제공    |
| Data         | Data의 리스트화와 데이터 제공             | -                      | Application에 Data 제공   |
| Entity       | Object화                        | -                      | 전체 패키지에 Object 제공      |
| Presentation | UI 기능 구현                       | Application으로 로직 요청    | User에게 시각화 제공          |
| Printer      | Abstraction, 추후에 발생할 변경 비용 최소화 | -                      | 전체 프로젝트에서 추상화/변경 비용 감소 |

![img.png](img.png)
![img_2.png](img_2.png)

- Class, Method는 각자의 책임과 기능을 다하는 것으로 구현
- Layered Architecture 의 구현
- Data는 Application을 바라보고(데이터를 제공하고)
- Application은 Presentation을 바라본다(로직을 제공한다)
- Layered Architecture의 구현으로 비용 최소화, 분업의 원할함을 도모했다.
- 위 사진은 각자의 Branch로 분할 작업하는 이미지.

--- 

### 06. 관련 링크

<a href="https://giant-honeycrisp-305.notion.site/6901a11fdc3d45349e38f0171c85dacb"> 개발 일지 노션 </a>