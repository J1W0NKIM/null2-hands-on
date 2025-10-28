### Commit Convention
---
이 프로젝트에서는 가장 널리 사용되는 [Conventional Commits](https://www.conventionalcommits.org/ko/v1.0.0/) 규칙을 따릅니다. 각 커밋 메시지는 아래 형식을 지켜 주세요.

```
<타입>[선택 사항: 범위]: <간단한 요약>
```

- **타입**: 변경 사항의 성격을 나타냅니다. 아래 표준 타입 중 하나를 사용합니다.
    - `feat`: 새로운 기능 추가
    - `fix`: 버그 수정
    - `docs`: 문서 수정 또는 보강
    - `style`: 코드 포매팅, 세미콜론 누락 등 기능에 영향 없는 변경
    - `refactor`: 버그 수정이나 기능 추가가 아닌 코드 리팩터링
    - `test`: 테스트 코드 추가 또는 보완
    - `chore`: 빌드, 도구, 라이브러리 등 기타 작업
- **범위**: (선택) 영향을 받는 모듈, 파일 등을 괄호 없이 간단히 명시합니다.
- **요약**: 50자 이내로 현재형을 사용해 간결하게 작성합니다.

필요하다면 본문을 추가해 변경 이유, 주요 내용, 참고사항 등을 서술하고, 마지막에는 관련 이슈를 `Closes #이슈번호` 형태로 연결해 주세요.




### Development Environment
---
이 프로젝트는 **Gradle Version Catalog** 기반으로 관리되며, 아래 환경을 기준으로 구성되어 있습니다.

#### 📦 Build Environment
| 구성 요소 | 버전 | 비고 |
|------------|--------|------|
| **Android Gradle Plugin (AGP)** | 8.12.0 | Gradle 8.13 이상 필요 |
| **Gradle Wrapper** | 8.13 | `gradle-wrapper.properties` 기준 |
| **Kotlin** | 2.2.21 | JVM target 17 이상 권장 |
| **Android SDK** | 34 이상 | Android Studio Koala(이후) 호환 |

#### 📁 주요 파일 구조
