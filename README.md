# 디자인 패턴

자주 사용하는 설계 패턴을 정형화해서 이를 유형별로 가장 최적의 방법으로 개발할 수 있도록 정해둔 설계.

알고리즘과 유사하지만, 명확하게 정답이 있는 형태는 아니며, 프로젝트의 상황에 맞추어 적용이 가능하다.

 <br>

### Gof 디자인 패턴

- 소프트웨어를 설계할 때는 기존에 경험이 매우 중요하다. 그러나 모든 사람들이 다양한 경험을 가지고 있을 수 없다. 이러한 지식을 공유하기 위해서 나온 것이 GOF(Gang Of Four)의 디자인 패턴이다. 객체지향 개념에 따른 설계중 재사용할 경우 유용한 설계를 디자인 패턴으로 정리 해둔 것이다.


### 디자인 패턴의 장/단점

- 장점 : 개발자간의 원활한 소통, 소프트웨어 구조 파악 용이, 재사용을 통한 개발 시간 단축, 설계 변경 요청에 대한 유연한 대처

- 단점 : 객체지향 설계/구현, 초기 투자 비용 부담


### 생성 패턴

- 객체를 생성하는 것과 관련된 패턴으로 객체의 생성과 변경이 전체 시스템에 미치는 영향을 최소화 하고, 코드의 유연성을 높여준다.

  - Factory Method
  - Singleton
  - Prototype
  - Builder
  - Abstract Factory
  - Chaning
 

### 구조 패턴

- 프로그램 내의 자료구조나 인터페이스 구조 등 프로그램 구조를 설계하는데 활용 될 수 있는 패턴.

- 클래스, 객체들의 구성을 통해서 더 큰 구조를 만들 수 있게 해준다. 큰 규모의 시스템에서는 많은 클래스들이 서로 의존성을 가지게 되는데, 이런 복잡한 구조를 개발하기 쉽게 만들어 주고, 유지 보수 하기 쉽게 만들어 준다.

  - Adapter
  - Composite
  - Bridge
  - Decorator
  - Facase
  - Flyweight
  - Proxy
 

### 행위 패턴

- 반복적으로 사용되는 객체들의 상호작용을 패턴화한 것으로, 클래스나 객체들이 상호작용하는 방법과 책임을 분산하는 방법을 제공한다. 행위 패턴은 행위 관련 패턴을 사용하여 독립적으로 일을 처리하고자 할 때 사용한다.

  - Template Method
  - Interpreter
  - Iterator
  - Observer
  - Strategy
  - Visitor
  - Chain of responsibility
  - Command
  - Mediator
  - State
  - Memento
  
  <br>
  
-----


## [Singleton pattern](https://github.com/seyeonn/design/tree/master/src/com/company/design/singleton)
- Singleton패턴은 어떠한 클래스(객체)가 유일하게 1개만 존재할 때 사용한다.
- 이를 주로 사용하는 곳은 서로 자원을 공유할 때 사용하는데, 실물 세계에서는 프린터가 해당되며, 실제 프로그래밍에서는 TCP Socket 통신에서 서버와 연결된 connect 객체에 주로 사용한다.
- spring의 경우 bean 클래스나 객체는 기본적으로 상글톤으로 관리를 해야 한다. 직접 생성하지 않고, application context 를 통해 spring에서 관리 되고 있고, 그런 것들 자체가 단 하나의 객체만 존재하게 된다.
- 자기 자신을 객체로 가지고 있어야 한다. (private으로 보호)
- 기본 생성자를 private으로 막아야 한다. 
- static 반환형 getInstance() 메소드를 통해 현재 가지고 있는 객체가 null인지 아닌지 체크해야 한다. 객체가 없는 경우 새로 생성 후 리턴하고, 있는 경우는 바로 리턴한다. (이 메소드를 사용하는 클래스는 모두 singleton 패턴으로 치부한다.)

<br>

## [Adapter pattern](https://github.com/seyeonn/design/tree/master/src/com/company/design/adapter)
- Adapter는 실생활에서는 100v 를 220v로 변경해주거나, 그 반대로 해주는 흔히 돼지코라고 불리는 변환기를 예로 들 수 있다.
- 호환성이 없는 기존 클래스의 인터페이스를 변환하여 재사용할 수 있도록 한다.
- SOLID 중에서 개방 폐쇄 원칙(OCP)를 따른다. 
- 연결시켜줄 객체를 하나 생성.
- 기본 생성자에서 매개변수로 연결시켜줄 객체를 받고, 연결해준다.

<br>

## [Proxy pattern](https://github.com/seyeonn/design/tree/master/src/com/company/design/proxy)
- Proxy는 대리인 이라는 뜻으로, 뭔가를 대신해서 처리하는 것.
- Proxy Class를 통해서 대신 전달하는 형태로 설계되며, 실제 클라이언트는 Proxy로 부터 결과를 받는다.
- Cache의 기능으로도 활용이 가능하다. 
- Spring 같은 경우 Proxy pattern을 사용하여 AOP를 사용한다.
- [AOP](https://github.com/seyeonn/design/tree/master/src/com/company/design/aop) 같은 경우, Proxy 기능을 통하여 특정한 메소드나 기능에 앞, 뒤로 내가 원하는 기능 또는 내가 원하는 메소드, 앞뒤로 넘어가는 arguement에 대해서 조작할 수 있고, 여러가지 흩어져있는 기능들을 동일하게 제공하도록 하나로 묶어줄 수 있다.
- AOP는 특정 메소드가 얼마나 시간이 걸리는 지 측정할 때 사용한다. 관점 지향 특징으로 앞뒤를 살펴야 한다. 전후 메소드는 Runnable형으로 functional interface이다. 
- 시간 체크 시에는 동시성 문제 때문에 AtomicLong을 사용한다.
- SOLID 중에서 개방 폐쇄 원칙(OCP)과 의존 역전 원칙 (DIP)를 따른다.

<br>

## [Decorator pattern](https://github.com/seyeonn/design/tree/master/src/com/company/design/decorator)
- 데코레이터 패턴은 기존 뼈대(클래스)는 유지하되, 이후 필요한 형태로 꾸밀 때 사용한다. 
- 확장이 필요한 경우 상속의 대안으로도 활용 한다.
- SOLID 중에서 개방 폐쇄 원칙(OCP)과 의존 역전 원칙 (DIP)를 따른다.
- 기본 베이스를 두고 필요한 부분을 더 첨가하여 데코레이팅한다.

<br>

## [Observer pattern](https://github.com/seyeonn/design/tree/master/src/com/company/design/observer)
- 관찰자 패턴은 변화가 일어 났을 때, 미리 등록된 다른 클래스에 통보(이벤트를 전달)해주는 패턴을 구현한 것이다.
- 많이 보이는 곳은 event listener 에서 해당 패턴을 사용하고 있다. - 표준적인 예시

<br>

## [Facade pattern](https://github.com/seyeonn/design/tree/master/src/com/company/design/facade)
- Facade는 건물의 앞쪽 정면 이라는 뜻으로, 건물의 뒷쪽에서는 뭐가 있는지 모르는 것을 뜻한다.
- 여러 개의 객체와 실제 사용하는 서브 객체의 사이에 복잡한 의존관계가 있을 때, 중간에 facade라는 객체를 두고, 여기서 제공하는 interface만을 활용하여 기능을 사용하는 방식이다.
- facade는 자신이 가지고 있는 각 클래스의 기능을 명확히 알아야 한다.
- 어떠한 interface를 제공할지도 정확히 알아야 한다.
- 여러 개의 객체를 합쳐서 특정한 기능을 만들 때 사용한다.
- 각각의 객체에 의존하는 것보다 facade 패턴을 적용시키면 앞쪽의 정면만 바라볼 수 있도록 객체가 하나 만들어지고, 이 facade 객체를 통해 안에 있는 복잡한 여러 가지 의존성을 가진 것들은 새로운 인터페이스의 형태로 제공하게 된다.
- 바깥쪽에서는 기존과 달리 굉장히 간략하게 코드를 줄일 수 있다.
- 여러가지 객체 의존성들을 안쪽으로 숨겨주는 형태의 패턴.

<br>

## [Strategy pattern](https://github.com/seyeonn/design/tree/master/src/com/company/design/strategy)
- 전략 패턴으로 불리며, 객체지향의 꽃이다.
- 유사한 행위들을 캡슐화하여, 객체의 행위를 바꾸고 싶은 경우 직접 변경하는 것이 아닌 전략만 변경하여, 유연하게 확장하는 패턴 SOLID 중에서 개방 폐쇄 원칙(OCP)과 의존 역전 원칙 (DIP)를 따른다.
- 전략 메서드를 가진 전략 객체 ( Normal Strategy - 인코딩을 하지 않는 기본 전략, Base64 Strategy )
- 전략 객체를 사용하는 컨텍스트 (Encoder)
- 전략 객체를 생성해 컨텍스트에 주입하는 클라이언트(Main class)
- 인코더 자체는 그대로 있고 전략 즉, Normal식 plain text로 인코딩을 할 건지, Base64로 할 건지, 조금 더 확장한다면 Base32로 할 건지 또는 암호화를 적용시킨다던지 그래서 특정한 text에 대해서 변화를 주고자 할 때 인코더에 대해서 if문으로 작성하거나 이런 게 아니라 전략, 즉 plain text냐 base64냐 암호화냐 해쉬값을 구하느냐 이런것들의 전략을 수정해줌으로써 결과를 동일하게 얻을 수 있는 패턴이다.
- 인코더 객체 자체는 변하지 않고, 이런 전략의 주입을 통해서 결과가 달라지도록 설정한다.
