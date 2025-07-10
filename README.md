# VYBZ Agreement Service

VYBZ 플랫폼의 약관 관리 및 사용자 약관 동의를 담당하는 마이크로서비스입니다.

## 📋 목차

-   [개요](#개요)
-   [기술 스택](#기술-스택)
-   [주요 기능](#주요-기능)
-   [프로젝트 구조](#프로젝트-구조)
-   [API 문서](#api-문서)
-   [설치 및 실행](#설치-및-실행)
-   [환경 설정](#환경-설정)
-   [이벤트 처리](#이벤트-처리)
-   [데이터베이스 설계](#데이터베이스-설계)

## 🎯 개요

VYBZ Agreement Service는 다음과 같은 기능을 제공합니다:

-   **약관 관리**: 회원 약관, 개인정보 처리방침, 라이브 서비스 약관 등 관리
-   **사용자별 약관 동의**: 유저와 버스커의 약관 동의 정보 관리
-   **약관 CRUD**: 약관 생성, 조회, 수정, 삭제 기능
-   **이벤트 처리**: Kafka를 통한 버스커 생성 시 약관 동의 자동 처리
-   **서비스 디스커버리**: Eureka Client를 통한 마이크로서비스 등록

## 🛠 기술 스택

### Backend

![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Apache Kafka](https://img.shields.io/badge/Apache_Kafka-231F20?style=for-the-badge&logo=apachekafka&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)

### Infra

![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=githubactions&logoColor=white)
![Amazon EC2](https://img.shields.io/badge/Amazon_EC2-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white)
![Nginx](https://img.shields.io/badge/Nginx-009639?style=for-the-badge&logo=nginx&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)


### 협업

![Discord](https://img.shields.io/badge/Discord-5865F2?style=for-the-badge&logo=discord&logoColor=white)
![Notion](https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=notion&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)

### Database & Message Queue

-   **MySQL 8.0**: 약관 정보 및 사용자 약관 동의 데이터 저장
-   **Apache Kafka**: 비동기 이벤트 처리

### Documentation

-   **Swagger/OpenAPI 3.0**: API 문서화

### Build & Deploy

-   **Gradle**: 빌드 도구
-   **Docker**: 컨테이너화

## 🚀 주요 기능

### 1. 약관 관리 (`/api/v1/agreement`)

-   **약관 추가**: 새로운 약관 생성
-   **약관 조회**: 제목, 유저 타입, 약관 타입별 조회
-   **약관 수정**: 기존 약관 내용 수정
-   **약관 삭제**: 약관 삭제 (Soft Delete)

### 2. 버스커 약관 동의 관리 (`/api/v1/busker-agreement`)

-   **버스커 약관 동의 추가**: 버스커의 약관 동의 정보 저장
-   **버스커 약관 동의 조회**: 버스커 UUID로 약관 동의 목록 조회
-   **버스커 약관 동의 수정**: 버스커의 약관 동의 정보 수정
-   **버스커 약관 동의 삭제**: 버스커의 약관 동의 정보 삭제

### 3. 유저 약관 동의 관리 (`/api/v1/user-agreement`)

-   **유저 약관 동의 추가**: 유저의 약관 동의 정보 저장
-   **유저 약관 동의 조회**: 유저 UUID로 약관 동의 목록 조회
-   **유저 약관 동의 수정**: 유저의 약관 동의 정보 수정
-   **유저 약관 동의 삭제**: 유저의 약관 동의 정보 삭제

### 4. 이벤트 처리

-   **Kafka 이벤트 수신**: 버스커 생성 시 약관 동의 자동 처리
-   **비동기 처리**: Kafka Consumer를 통한 이벤트 처리

### 5. 서비스 디스커버리

-   **Eureka Client**: Netflix Eureka에 서비스 등록
-   **동적 포트 할당**: 서버 포트 0으로 설정하여 동적 할당

## 📁 프로젝트 구조

```
src/main/java/com/vybz/agreement_service/
├── common/                    # 공통 모듈
│   ├── config/               # 설정 클래스들
│   │   └── SwaggerConfig.java
│   ├── entity/               # 공통 엔티티
│   │   ├── BaseEntity.java
│   │   ├── BaseResponseEntity.java
│   │   ├── BaseResponseStatus.java
│   │   └── SoftDeletableEntity.java
│   └── exception/            # 예외 처리
│       ├── AsyncExceptionHandler.java
│       ├── BaseException.java
│       ├── BaseExceptionHandler.java
│       └── BaseExceptionHandlerFilter.java
├── kafka/                    # Kafka 이벤트 처리
│   ├── config/               # Kafka 설정
│   │   ├── BuskerAgreementKafkaConfig.java
│   │   └── CommonKafkaConfig.java
│   ├── consumer/             # 이벤트 컨슈머
│   │   └── BuskerAgreementEventConsumer.java
│   └── event/                # 이벤트 모델
│       └── BuskerAgreementEvent.java
├── agreement/                # 약관 도메인
│   ├── application/          # 약관 서비스 로직
│   │   ├── AgreementService.java
│   │   └── AgreementServiceImpl.java
│   ├── domain/               # 약관 도메인 모델
│   │   ├── Agreement.java
│   │   ├── AgreementType.java
│   │   └── UserType.java
│   ├── dto/                  # 약관 DTO
│   │   ├── request/
│   │   │   ├── RequestAddAgreementDto.java
│   │   │   ├── RequestDeleteAgreementDto.java
│   │   │   └── RequestUpdateAgreementDto.java
│   │   └── response/
│   │       └── ResponseAgreementDto.java
│   ├── infrastructure/       # 약관 리포지토리
│   │   └── AgreementRepository.java
│   ├── presentation/         # 약관 컨트롤러
│   │   └── AgreementController.java
│   └── vo/                   # 약관 VO
│       ├── request/
│       │   ├── RequestAddAgreementVo.java
│       │   ├── RequestDeleteAgreementVo.java
│       │   └── RequestUpdateAgreementVo.java
│       └── response/
│           └── ResponseAgreementVo.java
├── busker_agreement/         # 버스커 약관 동의 도메인
│   ├── application/          # 버스커 약관 동의 서비스 로직
│   │   ├── BuskerAgreementService.java
│   │   └── BuskerAgreementServiceImpl.java
│   ├── domain/               # 버스커 약관 동의 도메인 모델
│   │   └── BuskerAgreement.java
│   ├── dto/                  # 버스커 약관 동의 DTO
│   │   ├── request/
│   │   │   ├── RequestAddBuskerAgreementDto.java
│   │   │   ├── RequestDeleteBuskerAgreementDto.java
│   │   │   └── RequestUpdateBuskerAgreementDto.java
│   │   └── response/
│   │       └── ResponseBuskerAgreementDto.java
│   ├── infrastructure/       # 버스커 약관 동의 리포지토리
│   │   └── BuskerAgreementRepository.java
│   ├── presentation/         # 버스커 약관 동의 컨트롤러
│   │   └── BuskerAgreementController.java
│   └── vo/                   # 버스커 약관 동의 VO
│       ├── request/
│       │   ├── RequestAddBuskerAgreementVo.java
│       │   ├── RequestDeleteBuskerAgreementVo.java
│       │   └── RequestUpdateBuskerAgreementVo.java
│       └── response/
│           └── ResponseBuskerAgreementVo.java
└── user_agreement/           # 유저 약관 동의 도메인
    ├── application/          # 유저 약관 동의 서비스 로직
    │   ├── UserAgreementService.java
    │   └── UserAgreementServiceImpl.java
    ├── domain/               # 유저 약관 동의 도메인 모델
    │   └── UserAgreement.java
    ├── dto/                  # 유저 약관 동의 DTO
    │   ├── request/
    │   │   ├── RequestAddUserAgreementDto.java
    │   │   ├── RequestDeleteUserAgreementDto.java
    │   │   └── RequestUpdateUserAgreementDto.java
    │   └── response/
    │       └── ResponseUserAgreementDto.java
    ├── infrastructure/       # 유저 약관 동의 리포지토리
    │   └── UserAgreementRepository.java
    ├── presentation/         # 유저 약관 동의 컨트롤러
    │   └── UserAgreementController.java
    └── vo/                   # 유저 약관 동의 VO
        ├── request/
        │   ├── RequestAddUserAgreementVo.java
        │   ├── RequestDeleteUserAgreementVo.java
        │   └── RequestUpdateUserAgreementVo.java
        └── response/
            └── ResponseUserAgreementVo.java
```

## 📚 API 문서

Swagger UI를 통해 API 문서를 확인할 수 있습니다:

-   **URL**: `http://localhost:8000/agreement-service/swagger-ui/index.html`
-   **API 그룹**: Agreement-Service, Busker-Agreement-Service, User-Agreement-Service

### 주요 API 엔드포인트

#### 약관 관리 API

-   `POST /api/v1/agreement` - 약관 추가
-   `GET /api/v1/agreement/{title}` - 약관 제목으로 조회
-   `GET /api/v1/agreement/user-type/{userType}` - 유저 타입으로 약관 리스트 조회
-   `GET /api/v1/agreement/agreement-type/{agreementType}` - 약관 타입으로 약관 리스트 조회
-   `GET /api/v1/agreement/list` - 모든 약관 조회
-   `PUT /api/v1/agreement` - 약관 수정
-   `DELETE /api/v1/agreement` - 약관 삭제

#### 버스커 약관 동의 API

-   `POST /api/v1/busker-agreement` - 버스커 약관 동의 추가
-   `GET /api/v1/busker-agreement/list/{buskerUuid}` - 버스커 UUID로 약관 동의 리스트 조회
-   `PUT /api/v1/busker-agreement` - 버스커 약관 동의 수정
-   `DELETE /api/v1/busker-agreement` - 버스커 약관 동의 삭제

#### 유저 약관 동의 API

-   `POST /api/v1/user-agreement` - 유저 약관 동의 추가
-   `GET /api/v1/user-agreement/list/{userUuid}` - 유저 UUID로 약관 동의 리스트 조회
-   `PUT /api/v1/user-agreement` - 유저 약관 동의 수정
-   `DELETE /api/v1/user-agreement` - 유저 약관 동의 삭제

### API 요청/응답 예시

#### 약관 추가 요청

```json
{
    "title": "개인정보 처리방침",
    "content": "개인정보 처리방침 내용...",
    "required": true,
    "userType": "BUSKER",
    "agreementType": "PRIVACY"
}
```

#### 버스커 약관 동의 추가 요청

```json
{
    "buskerUuid": "550e8400-e29b-41d4-a716-446655440000",
    "agreementId": 1,
    "agreed": true
}
```

#### 유저 약관 동의 추가 요청

```json
{
    "userUuid": "550e8400-e29b-41d4-a716-446655440001",
    "agreementId": 1,
    "agreed": true
}
```

#### API 응답 예시

```json
{
    "status": "SUCCESS",
    "message": "요청이 성공적으로 처리되었습니다.",
    "data": {
        "id": 1,
        "title": "개인정보 처리방침",
        "content": "개인정보 처리방침 내용...",
        "required": true,
        "userType": "BUSKER",
        "agreementType": "PRIVACY"
    }
}
```

## 🚀 설치 및 실행

### 1. 사전 요구사항

-   Java 17
-   Gradle 8.4+
-   Docker (선택사항)
-   MySQL 8.0
-   Apache Kafka

### 2. 로컬 실행

```bash
# 프로젝트 클론
git clone <repository-url>
cd vybz-agreement

# Gradle 빌드
./gradlew clean build

# 애플리케이션 실행
./gradlew bootRun
```

### 3. Docker 실행

```bash
# Docker 이미지 빌드
docker build -t vybz-agreement-service .

# Docker 컨테이너 실행
docker run -p 8000:8000 vybz-agreement-service
```

## ⚙️ 환경 설정

### 주요 설정 파일

-   `application.yml`: 기본 설정

### 환경 변수

```yaml
# 서버 설정
server:
    port: 0 # 동적 포트 할당

# 애플리케이션 설정
spring:
    application:
        name: agreement-service

    # Kafka 설정
    kafka:
        bootstrap-servers: ${KAFKA_SERVERS}

    # 데이터베이스 설정
    datasource:
        url: jdbc:mysql://${DB_HOST}:${DB_PORT}/agreement?useSSL=true&allowPublicKeyRetrieval=true&serverTimezone=Asia/Seoul
        username: ${DB_USERNAME}
        password: ${DB_PASSWORD}
```

## 📡 이벤트 처리

### Kafka 이벤트

#### 수신 이벤트

-   `BuskerAgreementEvent`: 버스커 생성 시 약관 동의 이벤트

### 이벤트 컨슈머

-   `BuskerAgreementEventConsumer`: 버스커 생성 이벤트 처리

### 이벤트 처리 플로우

1. **이벤트 수신**: Kafka에서 버스커 생성 이벤트 수신
2. **중복 검증**: 기존 약관 동의 정보 확인
3. **데이터 저장**: 새로운 약관 동의 정보 저장
4. **로깅**: 처리 결과 로깅


## 🏗️ 아키텍처

### 도메인 주도 설계 (DDD)

-   **Domain Layer**: 약관, 버스커 약관 동의, 유저 약관 동의 도메인 모델과 비즈니스 로직
-   **Application Layer**: 약관 서비스 로직과 유스케이스
-   **Infrastructure Layer**: 데이터베이스 접근과 외부 시스템 연동
-   **Presentation Layer**: REST API 엔드포인트

### 마이크로서비스 패턴

-   **Service Discovery**: Eureka Client를 통한 서비스 등록
-   **Event-Driven**: Kafka를 통한 비동기 이벤트 처리
-   **Stateless**: 상태 없는 서비스 설계

### 데이터베이스 설계

-   **MySQL**: 약관 정보, 사용자 약관 동의 데이터
-   **Soft Delete**: 논리적 삭제를 통한 데이터 보존

## 🔧 개발 가이드

### 코드 컨벤션

-   **패키지 구조**: 도메인별 계층 분리
-   **네이밍**: 명확하고 일관된 네이밍 규칙
-   **예외 처리**: BaseException을 통한 통일된 예외 처리
-   **로깅**: Slf4j를 통한 구조화된 로깅

### 테스트

```bash
# 단위 테스트 실행
./gradlew test

# 통합 테스트 실행
./gradlew integrationTest
```

### 약관 타입

-   **MEMBER**: 회원 약관
-   **PRIVACY**: 개인정보 처리방침
-   **LIVE**: 라이브 서비스 약관
-   **SETTLEMENT**: 정산 약관
-   **DONATION**: 후원 약관

### 유저 타입

-   **USER**: 일반 유저
-   **BUSKER**: 버스커

## 📝 라이선스

이 프로젝트는 VYBZ 팀의 내부 프로젝트입니다.

## 👥 팀

-   **개발팀**: VYBZ Backend Team

---

**VYBZ Agreement Service** - 안전하고 효율적인 약관 관리 서비스
