# 수강신청 프로그램

2024년 1학기 '절차적 사고와 프로그래밍' 수업 프로젝트로 개발된 **자바 스윙(Java Swing) 기반의 수강신청 시뮬레이션 프로그램**입니다. 학생 정보, 강좌 정보, 수강신청 내역을 관리하며, 시각적인 사용자 인터페이스를 통해 수강신청 과정을 효율적으로 처리할 수 있도록 돕습니다.

## 🚀 주요 기능

- **강좌 조회 및 검색**: 등록된 모든 강좌를 조회하고, 조건에 따라 검색할 수 있습니다.

- **수강신청 및 취소**: 학생이 강좌를 신청하거나 이미 신청한 강좌를 취소할 수 있습니다.

- **중복 신청 및 시간표 충돌 방지**: 이미 신청한 강좌는 다시 신청할 수 없으며, 시간표가 중복되는 강좌는 신청할 수 없습니다.

- **수강 정원 관리**: 각 강좌의 최대 정원을 초과하여 신청할 수 없습니다.

- **학점 제한 관리**: 학생이 신청 가능한 최대 학점을 초과하여 강좌를 신청할 수 없습니다.

- **MySQL 데이터베이스 연동**: 강좌 및 수강신청 데이터를 데이터베이스에 영속적으로 저장하고 관리합니다.

- **직관적인 GUI**: Java Swing을 활용하여 사용자 친화적인 그래픽 사용자 인터페이스를 제공합니다.

## 🛠️ 기술 스택

- **언어**: Java 17

- **GUI 프레임워크**: Java Swing

- **데이터베이스**: MySQL

- **JDBC 드라이버**: `mysql-connector-j-9.3.0.jar`

- **기타 라이브러리**: `commons-codec-1.9.jar` 

## 📁 프로젝트 구조

```
📦 CourseRegistration
┣ 📂 src                     # 소스 코드
┃  ┣ 📂 controller          # 비즈니스 로직 및 이벤트 처리
┃  ┣ 📂 model               # 데이터 모델 및 DAO (Data Access Object)
┃  ┗ 📂 view                # 사용자 인터페이스 (Java Swing)
┣ 📂 lib                     # 외부 라이브러리 (JAR 파일)
┃  ┣ 📜 commons-codec-1.9.jar
┃  ┗ 📜 mysql-connector-j-9.3.0.jar
┣ 📂 data                    # 초기 강좌 데이터를 포함하는 텍스트 파일 등
┃  ┗ 📜 courses.txt          # (예시) 강좌 데이터 파일
┣ 📂 docs                    # 데이터베이스 스키마 및 초기 데이터 SQL
┃  ┗ 📜 database_setup.sql   # 테이블 생성 및 초기 데이터 삽입 SQL
┗ 📜 README.md
```

## ⚙️ 실행 방법

이 프로젝트는 Java와 MySQL 환경이 필요합니다.

### 1. 전제 조건

- **Java 17 이상**: JDK/JRE가 설치되어 있어야 합니다.

- **MySQL 서버**: MySQL 데이터베이스 서버가 실행 중이어야 합니다.

- **MySQL JDBC 드라이버**: `lib` 폴더에 `mysql-connector-j-9.3.0.jar` 파일이 있는지 확인하세요.

- **Commons Codec**: `lib` 폴더에 `commons-codec-1.9.jar` 파일이 있는지 확인하세요.

### 2. 데이터베이스 설정

1. MySQL 서버에 접속합니다.

2. `docs/database_setup.sql` 파일을 실행하여 필요한 데이터베이스 및 테이블을 생성하고 초기 데이터를 삽입합니다.
   
   - 예시 SQL (파일 내용에 따라 변경될 수 있습니다):
     
     ```
     CREATE DATABASE IF NOT EXISTS course_db;
     USE course_db;
     
     -- 필요한 테이블 생성 (예: courses, students, registrations)
     CREATE TABLE IF NOT EXISTS courses (
         course_id VARCHAR(10) PRIMARY KEY,
         title VARCHAR(100),
         professor VARCHAR(50),
         credit INT,
         capacity INT,
         current_enrollment INT DEFAULT 0,
         time_slot VARCHAR(20)
     );
     -- INSERT 문 등
     ```

3. 프로그램 내 DB 연결 정보(URL, 사용자명, 비밀번호)를 프로젝트에 맞게 `model` 패키지 내 `Constants.java`의 `database`의 상수를 수정할 수 있습니다.

### 3. 프로젝트 빌드 및 실행

1. **프로젝트 클론**:
   
   ```
   git clone https://github.com/Suehyun666/2024_1-1_Course_Register.git
   cd 2024_1-1_Course_Register
   ```

2. **라이브러리 설정**:
   
   - 사용하는 IDE (예: IntelliJ IDEA, Eclipse)에서 `lib` 폴더 내의 `.jar` 파일들을 프로젝트의 **외부 라이브러리로 추가**해야 합니다.
     
     - **IntelliJ IDEA**: `File` -> `Project Structure` -> `Modules` -> `Dependencies` 탭에서 `+` 버튼 클릭 후 `JARs or directories...` 선택하여 `lib` 폴더 내 `.jar` 파일 추가.
     
     - **Eclipse**: `Project` -> `Properties` -> `Java Build Path` -> `Libraries` 탭에서 `Add External JARs...` 선택하여 `lib` 폴더 내 `.jar` 파일 추가.

3. **컴파일 및 실행**:
   
   - **IDE 사용**: `src` 폴더 내 `Main.java` (혹은 메인 클래스) 파일을 실행합니다.
   
   - **명령 프롬프트/터미널**:
     
     ```
     # src 디렉토리로 이동
     cd src
     
     # 컴파일 (lib 경로에 따라 `-cp` 옵션 조정 필요)
     javac -cp ".;../lib/mysql-connector-j-9.3.0.jar;../lib/commons-codec-1.9.jar" Main.java
     
     # 실행
     java -cp ".;../lib/mysql-connector-j-9.3.0.jar;../lib/commons-codec-1.9.jar" Main
     ```
     
     - `.;` (Windows) 또는 `.:` (macOS/Linux)는 현재 디렉토리와 JAR 파일들을 클래스패스에 포함시키는 경로입니다.

## 📸 스크린샷

**로그인 화면**

<img width="2559" height="1439" alt="Image" src="https://github.com/user-attachments/assets/e28c6397-19e8-436f-a250-a6d75ebac407" />

**수강신청 화면**

<img width="1681" height="947" alt="Image" src="https://github.com/user-attachments/assets/e45e4f7f-17c0-4da0-ba8a-b428f02ed9c6" />

## 🏛️ 아키텍처 개요

이 프로그램은 **MVC(Model-View-Controller) 패턴**을 기반으로 설계되었습니다.

- **Model**: 강좌, 학생, 수강신청 등 핵심 데이터를 관리하고, 데이터베이스와의 상호작용(DAO)을 담당합니다.

- **View**: Java Swing을 사용하여 사용자에게 보이는 GUI 요소를 담당하며, Model의 데이터를 시각적으로 표현합니다.

- **Controller**: View에서 발생하는 사용자 이벤트를 처리하고, Model을 업데이트하거나 View를 갱신하도록 지시합니다.

이러한 분리를 통해 각 부분이 독립적으로 관리되고, 코드의 유지보수성과 확장성이 향상됩니다.

## 💡 기술적 의사결정

- **Java Swing 선택**: '절차적 사고와 프로그래밍' 수업의 요구사항과 Java 기반 GUI 학습 목적에 부합하여 선택되었습니다. 복잡한 웹 프레임워크 대신 데스크톱 애플리케이션 개발에 집중할 수 있었습니다.

- **MySQL 사용**: 데이터 영속성 확보 및 관계형 데이터베이스 관리 시스템(RDBMS)의 기본 개념 학습을 위해 선택되었습니다. 대규모 데이터 처리보다는 SQL 기본 문법 및 JDBC 연동 실습에 중점을 두었습니다.

- **`commons-codec` 라이브러리 포함**: 비밀번호 해싱 등 데이터 보안 관련 기능 구현 시 활용할 수 있도록 포함했습니다. (실제 사용 여부는 프로젝트 구현에 따라 다를 수 있습니다.)

## ⚠️ 문제 해결 기록

개발 과정에서 마주쳤던 주요 문제점과 해결 방안을 요약합니다.

- **데이터베이스 연결 관리**:
  
  - **문제**: 매번 DB 작업을 할 때마다 연결을 생성하고 닫는 오버헤드가 발생하거나, 연결이 제대로 닫히지 않아 자원 누수가 발생할 수 있었습니다.
  
  - **해결**: `DataSource` 패턴을 도입하거나, DB 연결을 싱글톤(Singleton) 패턴으로 관리하여 효율성을 높이고 자원 관리를 용이하게 했습니다.

- **한글 인코딩 문제**:
  
  - **문제**: data디렉토리에서 텍스트 데이터를 가져올 때 인코딩이 깨지는 문제가 발생했습니다.
  
  - **해결**: Dao에서 file을 읽을 때 `UTF-8` 옵션을 추가하여 해결했습니다.

## ✅ 추후 개선사항

- **사용자 로그인/인증 모듈 추가**: 학생 또는 관리자 계정 기반의 로그인 기능을 구현하여 보안을 강화하고 사용자별 접근 권한을 관리합니다.

- **수강신청 기간 및 조건 관리**: 실제 수강신청 시스템처럼 신청 기간을 설정하고, 학년/학과별 신청 제한 등 복잡한 비즈니스 로직을 추가합니다.

- **성적 조회 및 관리 기능**: 수강신청 내역과 연계하여 학생의 성적을 조회하고 관리하는 기능을 추가합니다.

- **데이터 유효성 검증 강화**: 사용자 입력에 대한 더욱 견고한 유효성 검증 로직을 추가하여 잘못된 데이터 입력을 방지합니다.

- **보고서 및 통계 기능**: 특정 강좌의 수강신청 현황, 인기 강좌 등 다양한 통계 데이터를 시각적으로 제공합니다.
