22500354 성하민

① 프로젝트 소개

프로젝트 주제 : Book Management Web
Render 배포 URL : 
프로젝트 구조 : 
    java (controller(WebController(이번 과제에 사용), Controller), service, repository, domain, dto)
    resources (templates(books/list.html, form.html), static/css(style.css))
실행 방법 : Week06AssignmentApplication실행 후 브라우저에 접속
주요 화면 : 따로 image 폴더 제작 후 넣어두겠습니다.
Web Endpoint 표
    HTTP Method	URL	기능	반환
    GET	/books	전체 목록	books/list View
    GET	/books/new	등록 Form	books/form View
    POST	/books	데이터 등록	redirect:/books




② 이번 과제 키워드  : 이번 주에 학습하거나 사용한 주요 키워드를 작성합니다.
@Controller :  HTML 화면을 응답하는 Spring Controller
Thymeleaf (th:each, th:text, th:href, th:action, th:if) : 서버의 데이터를 HTML에 넣어 화면을 만들어 주는 역할 (순서대로 텍스트, 주소, form 전송주소, 조건이 참일때만 해당 태그 보여줌)
Model, @ModelAttribute : Controller에서 View(HTML)로 데이터를 전달하는 객체
redirect: : Controller의 반환값 앞에 붙이면 HTML을 그리지 않고, 브라우저에게 지정한 URL로 다시 GET 요청



③ 핵심 내용 정리 : 이번 과제를 통해 이해한 핵심 내용을 3~5개 정도 작성합니다.
1. @Controller와 @RestController의 차이 : @RestController는 반환값을 JSON 데이터로 응답, @Controller는 반환값을 View 이름으로 해석
2. Model로 데이터를 View에 전달하는 방법 : model.addAttribute("books", bookService.findAll())처럼 이름표("books")를 붙여 데이터를 담으면, Thymeleaf에서 ${books}로 꺼내 쓸 수 있다.
3. Thymeleaf로 Collection을 HTML에 출력 : th:each="book : ${books}" th:text="${book.title}"
4. redirect: : return "redirect:/books"는 HTML을 그리지 않고 브라우저에게 GET /books로 다시 요청하라고 지시



④ Weekly Report

1. Key Learning : 이번 주 배운 핵심 내용 3가지
   1. @Controller는 view 이름을 반환하고 Model에 데이터를 담으면 Thymleaf가 Html로 렌더링한다
   2. POST 처리 후에는 redirect:로 GET 요청을 유도하는 PRG 패턴을 사용하면 중복 제출을 막을 수 있다.
   3. 백엔드에 thymleaf 를 사용하면 웹페이지를 통해 CRUD 기능을 구현할 수 있다.

Web UI Flow
: Browser → Controller → Service → Repository → Model → Thymeleaf → HTML
브라우저가 GET /books를 요청하면, Controller가 Service와 Repository를 거쳐 책 목록을 가져와 Model에 담고, Thymeleaf가 이를 HTML 표로 만들어 보여준다.

HTML 응답Form Flow
: HTML Form → Controller → Service → Repository → redirect → GET의 실행 흐름
Form에서 POST /books로 보낸 데이터를 Controller가 @ModelAttribute로 받아 저장한 뒤, redirect:/books로 다시 GET 요청을 보내 목록 화면을 보여준다.

Problem & Solution
2. 구현 중 발생한 문제와 해결 방법 1가지
   : 과제 예시를 보고 따라하다 @PostMapping("/books")을 그대로 치고 오류가 발생했다. 이미 @RequestMapping("/books")가 있어 /books/books가 되는 상황이었기 때문이다. 따라서 클래스 매핑 방식을 메서드마다 쓰지 않는 방식을 채택하기로 했다.


3. Code Review : 가장 중요하다고 생각한 코드 1개와 그 이유
    : @PostMapping
        public String create(@ModelAttribute BookRequest request) {
            bookService.create(request);
            return "redirect:/books";
    }
    저번 과제에서 CRUD기능 중 가장 많이 달라진 부분이자 과제의 핵심이라고 생각한다. Form의 요청을 dto와 연결하고 refirect로 중복 등록을 막는 것이 form을 이용한 CRUD의 핵심이라 생각한다.

3. AI Usage : AI를 활용한 부분과 생성된 코드를 직접 확인/수정한 부분
    : CSS , html 파일을 주어진 프롬프트를 활용하여 코드를 생성했고 주어진 조건에 맞게 모든 내용을 포함 및 디자인했는지 확인 후 수정하여 추가했다.
5. Reflection : 새롭게 알게 된 점 또는 궁금한 점 1가지
    : 이번 코드는 js를 사용하지 않았는데 js까지 사용할 경우, 어느 웹페이지 동작을 할 수 있을지 궁금하다.
6. 건의사항
    : README 작성할 때, 특히 이번 키워드나 흐름을 적어라 하고 이미 다 써있는 경우가 있는데 이를 어떻게 작성하면 좋을지, 지금처럼 하면 될 지 궁금합니다.