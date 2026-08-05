# Java Network Programming

Java Socket을 이용하여 네트워크 프로그래밍을 학습하며 구현한 프로젝트입니다.
TCP/IP와 HTTP의 동작 원리를 이해하기 위해 Java의 Socket API를 사용하여 다양한 네트워크 프로그램을 직접 구현하고 있습니다.

# 1. Port Scanner

- Java Socket을 이용한 TCP 포트 스캐너
- 사용자가 입력한 IP와 포트 범위를 스캔
- 멀티스레드를 이용하여 빠른 포트 검사

**How to use**
- Target IP 입력
- Start / End Port 입력
- Open Port 출력

# 2. HTTP Client

- Java Socket을 이용하여 HTTP GET 요청을 직접 구현
- HTTP 요청을 생성하고 서버의 응답을 출력

**How to use**
- 사용자 입력 도메인 지원
- HTTP GET Request 생성
- HTTP Response 출력
- InputStream / OutputStream 사용


# 3. HTTP Server

- Java Socket과 ServerSocket을 이용하여 간단한 HTTP 서버를 구현
- HTTP 요청을 받고 요청 헤더를 출력
- HTTP 응답을 생성하여 클라이언트에 전송
- HTML 파일을 웹 브라우저 페이지에 표시


추가 예정 프로젝트..

- TCP Chat Program
- File Transfer
- Banner Grabber
