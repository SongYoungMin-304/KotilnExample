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


## 조건문과 루프문

**조건문(if)**

```kotlin
var max = a
if(a < b) max = b

var max: Int
if(a > b){
  max = a
} else {
  max = b
}

// 식표현으로 3항 연산자 처럼 사용
val max = if(a > b) a else b
```

```kotlin
val max = if(a > b){
  print("Choose a")
  a
} else{
  print("Choose b")
  b
}

val max = if (a > b) { // 컴파일 오류 발생, return 하는것과 다름, 반환하는 것
    print("Choose a")
    return a 
} else {
    print("Choose b")
    return b
}
```

**다중 선택문(when)**

```kotlin
var x: Int = 2

when (x) {
  1 -> print("x == 1")
  2 -> print("x == 2")
  else -> {
    print("x is neither 1 nor 2")
  }
```

```kotlin
var x: Int = 2
var s: Int = 2
val validNumbers: Array<Int> = arrayOf(1,2,3)

    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }

    when (x) {
        parseInt(s) -> print("s encodes x")
        else -> print("s does not encode x")
    }

    when (x) {
        in 1..10 -> print("x is in the range")
        in validNumbers -> print("x is valid")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }
```

```kotlin
fun Request.getBody() =
    when (val response = executeRequest()) {
        is Success -> response.body
        is HttpError -> throw HttpException(response.status)
    }
```

- 함수 실행 결과에 따라서 성공 실패 분기도 가능

**반복문 (for, while)**

**for**

```kotlin
val array = arrayOf(1,2,3,4,5)
for(item in array){
  print(item) // 결과 12345
}

for(i in 1..3){
  println(i) // 결과 : 123
}

for(i in 6 downTo 0 step 2){
  println(i) // 결과 : 6420
}

val array = arrayOf(1, 2, 3, 4, 5)
for (index in array.indices) {
   print(array[index]) //결과 : 12345
}

for((index, value) in array.withIndex()){
  println("$index 번째는 $value 값을 가집니다."))
// 결과 : 0번째는 1값을 가집니다.
// 결과 : 1번째는 2값을 가집니다.
// 결과 : 2번째는 3값을 가집니다.
// 결과 : 3번째는 4값을 가집니다.
// 결과 : 4번째는 5값을 가집니다.

```

**while**

```kotlin
var x: Int = 5
while(x > 0) {
   x--
}

var y: Int = 5
do{
  val y = retrieveData()
} while (y !=null)
```

# 함수


![image](https://user-images.githubusercontent.com/56577599/236842226-cd735aea-c5aa-4d3b-a67e-03b00d1ba83d.png)


- 키워드 - 함수를 선언하시기 위해서는 먼저 fun 키워드를 통해 함수를 선언하겠다는 것을 명시
- 함수 이름 - 키워드 이후에 한칸 띄우고 함수이름을 명시해야함
- 입력값 - 입력받을 값들을 나타냅니다. 이 값은 생략 가능하며, 여러 값일 경우 , 를 통해서 이어붙일 수 있습니다.
- 리턴타입 - 해당 함수의 결과를 반화할 타입을 나타내는 부분입니다. 생략 가능하면 생략하면 Unit 타입의 아무것도 반환하지 않는 타입을 가지게 됩니다.
- 리턴 값 - { } 블럭 사이에 함수의 본문이 들어올 수 있습니다
(함수 본문을 마무리할 때 return 키워드를 사용하여 값을 반환할 수 있습니다.)

```kotlin
val double = double(5)
println("값 = $double")

fun double(x: Int): Int {
  return x * 2
}
```

**파라미터의 기본 값**

```kotlin
val double2 = double2() // 사용하는 곳에서 파라미터 입력하지 않음
println("값 = $double2") // 결과 : 값 = 20

fun double2(x: Int = 10): Int { // 파라미터 x에 = 10 를 추가하여 입력값이 없으면 기본값으로 10을 할당한다고 명시
    return x * 2
}
```

**이름 명시 파라미터**

```kotlin
val double = double(y = 2, x = 5)
prtinln("값 = $double") // 결과 : 값  = 10

fun double(x: Int = 10, y: Int): Int{
   return x * y
}
```

**단일 표현 식(Single Expression)**

```kotlin
val double1 = double_1(x = 5, y = 2)
    val double2 = double_2(x = 5, y = 2)
    println("값_1 = $double1") // 결과 : 값_1 = 10
    println("값_2 = $double2") // 결과 : 값_2 = 10

fun double_1(x: Int = 10, y: Int): Int {
    return x * y
}

fun double_2(x: Int = 10, y: Int): Int = x * y // 단일 표현식으로 {}과 return을 생략
```

**지역 함수, 클로저**

```kotlin
val double1 = double_1(x = 5, y = 2)

println("값_1 = $double1") 

//double_2(x = 5, y = 2) 컴파일 에러

fun double_1(x: Int = 10, y: Int): Int {
   fun double_2(x: Int, y: Int) = x * y
   return x * y * double_2(x, y)
}
```

**Trailling Coomma**

```kotlin
fun double_1(
   x: Int = 10,
   y: Int,
): Int {
    return x * y
}
```

- 추가적인 변수가 없음에도 , 가 찍혀 있슴
