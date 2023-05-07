# kotiln

## 코틀린의 변수와 타입

### 코틀린의 필드와 변수

![image](https://user-images.githubusercontent.com/56577599/236685025-b2cae554-7866-44b1-a2b7-6782353ea96e.png)


**KeyWord**

- val - 변경불가능한 변수로 지정하는 키워드
- var - 변경 가능한 변수로 지정하는 키워드

**변수이름**

- 키워드 다음에는 한큰을 띄우고 변수 이름을 가집니다. 해당 변수이름을 통해 개발자는 변수에 접근할 수 있습니다.

**변수 타입**

- 변수 이름 뒤에는 : 을 붙이며 띄운 후 해당 변수의 타입을 지정합니다. 코틀린은 타입추론을 언어 차원에서 지원해주고 있습니다. 따라서 초기화 값이 있고 충분히 추론할 수 있는 값에 대해서는 변수 타입이 선택 사항(Optional) 입니다.

**초기화 값**

- 변수는 선언과 동시에 초기화 해줄 수 있습니다. 해당값을 통해 변수 타입 추론이 이루어 질 수 있습니다.

```kotlin
val name: String = "SABARADA"
print(name)
```

- 타입 추론을 지원하지만 명시적으로 타입을 지정하는 것이 맞아 보임(컴파일 에러를 위해서)
- 변수 키워드는 웬만하면 var 보다는 val 을 사용하는 것을 추천
(val 을 사용한다면 초기화한 값이 아무리 어려운 비즈니스 로직을 거치더라도 처음 초기화한 그 값을 가리키고 있는 다는 것을 확인)

### 코틀린의 타입

- 코틀린은 모든것이 객체
- 코틀린으로 코딩할 때는 원시 타입과 참조 타입을 구분해서 사용할 필요는 없습니다.

### Number Type

![image](https://user-images.githubusercontent.com/56577599/236685032-fc719a3e-9733-4b17-b70b-5ca608bc7986.png)


```kotlin
val one: Int = 1
val threeBillion: Long = 300000000
val oneLong: Long = 1L
val oneByte: Byte = 1
```

![image](https://user-images.githubusercontent.com/56577599/236685042-28c8307a-2548-43a3-bb63-79c90a2b0519.png)


```kotlin
val pi: Double = 3.14
val eFloat: Float = 2.718f
```

### Booleans

- Boolean 타입은 참 또는 거짓을 나타내는 변수 타입입니다.

- || - OR 로직
- && - AND 로직
- !- Not 로직

```kotlin
val myTrue: Boolean = true
val myFalse: Boolean = false
```

### Characters

- Char 타입은 문자 1개를 나타내는 변수 타입입니다. String 객체의 내부는 Char의 배열로 되어있습니다. 단일로는 아래와 같이 사용합니다.

```kotlin
val aChar: Char = 'a'
```

### Strings

- String 타입은 문자열을 나타내는 타입입니다.
- String 타입은 변경 불가능한 타입입니다. 따라서 값을 수정하거나 할 수 없고 값을 변경한다는 것은 새롭게 할당하는 것입니다.

```kotlin
val str: String ="abcd 123"

var str ="abcd"
println(str.uppercase()) //"ABCD"
println(str) // "abcd"
```

```kotlin
val str: String ="abcd 123"
print(str[0]) // 'a'
```

### Arrays

- 코틀린에서 배열은 Array 클래스를 통해 표현되어집니다. arrayof() 함수를 이용하여 배열을 선언할 수 있으며 [] 또는 get/set 함수를 이용하여 접근할 수 있습니다.

```kotlin
val array: Array<Int> = arrayOf(1,2,3)
array[1] = 4
print(array[0]) //1
print(array.get(1)) //4
array.set(2,5)
print(array.get(2)) // 5
```

```kotlin
val arr = IntArray(5) //[0,0,0,0,0]
val arr = IntArray(5) { 42 } //[42,42,42,42,42]
val arr = IntArray(5) {it + 1} //[0,1,2,3,4]
```

### ※ val var 간의 차이

```kotlin
val blogName = "Kotlin World"
blogName ="Kotlin Hello" // 컴파일 에러

var date ="2021-10-02"
date = "2021-10-03" // 가능
date = 17 // 이건 형태가 변경되는 거여서 안된다.

```

- 타입 추론으로 String으로 표시를 안해도 String 으로 인지하는 것
- String 을 안하면 헷갈리는 부분도 있어서 팀 규칙으로 사용하게 하기도 한다.
