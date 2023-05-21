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

# 클래스(Class)

## 클래스(Class)

클래스란 객체를 정의하는 틀 또는 설계라는 의미를 가지고 있습니다.

![image](https://github.com/SongYoungMin-304/KotilnExample/assets/56577599/4accb242-f94a-4f20-b6c1-fef12aa8ca90)

- 클래스 선언 키워드 
- class 키워드를 통해 클래스를 선어할 수 있습니다.
- 클래스 이름
- 클래스 이름을 쓰며 일반적으로 파스칼케이스(PascalCase)를 이름 규칙으로 가져갑니다.
- 기본 생성자
- 클래스 이름 옆에 생성자 키워드 constructor을 넣어 생성자를 선언할 수 있습니다.
- 기본적인 접근제어자는 public 이며 **public으로 사용할 때는 constructor을 생략하고 사용할 수 있습니다.**
- 멤버변수
- val 또는 var 키워드를 통해 내부 변수를 선언할 수 있습니다.
- 초기화 블럭
- 객체가 생성될때 초기화 블럭이 실행됩니다.
- **실행 순서는 위에서 아래로 차례대로 실행되며 init 블럭에서는 해당 블럭보다 위에 선언되어있는 멤버볌수, 그리고 생성자 변수만을 사용할 수 있습니다.**
- 내부함수
- 클래스의 상태 업데이트 등을 캡슐화하여 사용하기 위해 클래스 내부에 함수를 선언할 수 있습니다.

```kotlin
class NameService constructor(name: String) {
   private val firstPropery = "First propery: $name"

   inti {
      println("First initializer block $name")
   }
 
   fun printName(): String = this.firstProperty
}

-- 실행결과
nameService("songyoungmin")
// 결과 : First initializer block songyoungmin
```

## 생성자(constructor)

```kotlin
class NameService constructor(name: String){

  constructor(value: Int) : this(value.toString()) {
     println("Secondary constructor block that prints $value")

  private val firstProperty ="First property: $name"

  init {
     println("First initialize block that prints $name")
  }
  
  fun printName(): String = this.firstProperty
}

-- 실행결과
 nameService(5)
// First initializer block that prints 5
// Secondary constructor block that prints 5
```

- 주 생성자와 보조 생성자로 나눌 수 있다.
- 보조생성자의 매개변수는 주 생성자의 매개변수와 달라야 한다.

## 멤버 변수(Properties)

```kotlin
class MappingService constructor(name: String){
    val firstProperty: String = name
}

class MappingService(val firstProperty: String){

}
// 두개가 동일하다.

val mappingService = MappingService("H")
println("firstProperty = ${mappingService.firstProperty}")
// 결과 : firstProperty 

```

- 매개변수를 받아서 처리할 수 도 있고 아니면 아예 선언 부분에 정의할 수도 있다.
- 생성자를 생성하고 매개변수로 가져올 수 있다.

 ※ 여기서 클래스의 변수에 직접 가져오는 것 인가?

→ java로 치면 getter 를 사용 하는 것이다.(val 이여서 getter, var 이면 setter 이다.)

```java
public final class NameService {
   @NotNull
   private final String firstProperty;

   @NotNull
   public final String getFirstProperty() {
      return this.firstProperty;
   }

   public MappingService(@NotNull String firstProperty) {
      Intrinsics.checkNotNullParameter(firstProperty, "firstProperty");
      super();
      this.firstProperty = firstProperty;
   }
}
```

아래 처럼 커스텀 마이징도 가

```java
val firstProperty: String
get() = this.toString()
set(value) {
   setDataFromString(value)
}
```
# 클래스 -상속과 인터페이스
※상속은 생략할 수 있음

```java
class NameService constructor(name: String)
class NameService(name: String)
// 동일
```

## 상속

```java
open class MappingBaseService {
     fun service(): String ="MappingBaseService"
}

class MappingService(val firstProperty: String) : MappingBaseService(){

}

-- 실행결과
val mappingService = MappingService("H")
println("service = ${mappingService.service()}")
// 결과 : service = MappingBaseService
```

## 상속에서의 초기화 순서

```java
open class MappingBaseService {

   init {
       println("MappingBaseService initialize")
   }
   
   fun service(): String ="MappingBaseService"
}

class MappingService(val firstProperty: String) : MappingBaseService() {

   init {
      println("MappingService initialize")
   }
{
```

```java
val mappingService = MappingService("H") 
// 결과 : MappingBaseService initialize
//       MappingService initialize
```

- 클래스 상속에서 초기화는 부모 객체에서 먼저 이루어지고 이후 자식 객체에서 이루어 진다는 것을 알 수 있다.

## 상속에서의 오버라이딩

```java
open class MappingBaseService [

    open val firstProperty: String = "MappingBaseService property"

    open fun service(): String{
         return "MappingBaseService"
    }
}

class MappingService(val firstProperty: String): MappingBaseService(){

    override val firstProperty: String = "MappingService property"

    override fun service(): String{ // 오버라이딩
       return "MappingService"
    }
}

-- 실행결과
val mappingService = MappingService("H")
println("service = ${mappingService.service()}")
// 결과 : service = MappingService

val mappingService = MappingService()
println("service = ${mappingService.firstProperty}") 
// 결과 : service = MappingService
```

- open 으로 열어서 자식 객체에서 오버라이딩 가능
- 코틀린에서는 멤버변수도 오버라이딩 할 수 있다.
- **추가적으로 부모 객체의 var 타입의 멤버변수는 val로 오버라이딩할 수 가능, 
하지만 반대는 되지 않음.** 

왜냐하면 var는 getter, setter를 모두 가지고 있지만 val는 getter만 가지고 있기 때문입니다. 또한 기본 생성자에 override를 이용하여 값을 가져오는 것도 가능합니다.

## Any에 관하여

- 코틀린의 모든 클래스는 명시적으로 특정 클래스를 상속 받지 않으면 Any 객체를 묵시적으로 상속
- equals(), hashCode(), toString()

```java
public open class Any {

public open operator fun equals(other: Any?): Boolean
public open fun hashCode(): Int
public open fun toString(): String
}
```

## 인터페이스(interface)

```java
interface MyInterface{

   val prop: Int
   
   open fun foo(){
      print(prop) // optional body
   }
}

class Child : MyInterface {

    override val prop: Int = 29
   
    override fun foo(){
       super.foo()
       println("테스트영민)
    }
}

-- 실행결과

val child = Child()

// MappingBaseService initialize 호출 이후
// MappingService initialize 호출

println("1번 service = ${child.prop}")

child.foo()

// 결과
// 1번 service = 29
// 29테스트영민
```

- 인터페이스에서 변수를 선언하거나 함수 내용을 쓸 수있으나 실제로 override를 해야 사용 할 수 있다.(open 도 필요 없음)


# 클래스 -static 과 접근제어자

## **정적 클래스 ( static class )**

- 클래스 내부에 정적 클래스 및 변수를 선언하기 위해서는 companion 키워드를 사용하면 됩니다.
- companion 클래스를 선언하고 그 내부에 변수 및 함수를 선언하면 이곳에 선언된 요소들은 객체를 만들지 않고도 바로 접근이 가능합니다.

```kotlin
class MappingService private constructor(
   val name: String = DEFAULT_NAME
) {

    companion object {

      fun create(): MappingService = MappingService()

      fun create(name: String): MappingService = MappingService(name)

      const val DEFAULT_NAME: String = "sabardada"
   }
}

-- 실행
fun main(){

    val mappingService_1 = MappingService.create()
   
    println("mappingService_1 = ${mappingService_1.name}")

    val mappingService_2 = MappingService.create("songyoungmin")
   
    println("mappingService_2 = ${mappingService_2.name}")

    println("mappingService_3 = ${MappingService7.DEFAULT_NAME}")
    
}

-- mappingService_1 = sabardada
-- mappingService_2 = songyoungmin
-- mappingService_3 = sabardada
```

- 생성자에 val name : String = DEFAULT_NAME 으로 해둔 부분은 아래의 내용과 같다

```kotlin
class MappingService constructor(name: String){
    val firstProperty: String = name // 또는 DEFAULT_NAME 값, 매개변수가 없으면
}
```

→ 즉 생성자의 디폴트 값이 존재하고 생성자의 매개변수가 있거나 없거나에 따라서 처리가능

```kotlin
companion object Factory{
  ...
}
```

- MappingService.Factory.create() 처럼 사용해도 된다.

→ 자바로 바꾸면 아래의 내용과 같다.

```java
public final class MappingService {

   @Nullable
   private final String name;
   @NotNull
   public static final String DEFAULT_NAME = "sabardada";
   @NotNull
   public static final MappingService.Companion Companion = new MappingService.Companion((DefaultConstructorMarker)null);

   @Nullable
   public final String getName() {
      return this.name;
   }

   private MappingService(String name) {
      this.name = name;
   }

   // $FF: synthetic method
   MappingService(String var1, int var2, DefaultConstructorMarker var3) {
      if ((var2 & 1) != 0) {
         var1 = "sabardada";
      }

      this(var1);
   }

   // $FF: synthetic method
   public MappingService(String name, DefaultConstructorMarker $constructor_marker) {
      this(name);
   }

   public static final class Companion {
      @NotNull
      public final MappingService create() {
         return new MappingService((String)null, 1, (DefaultConstructorMarker)null);
      }

      @NotNull
      public final MappingService create(@NotNull String name) {
         Intrinsics.checkNotNullParameter(name, "name");
         return new MappingService(name, (DefaultConstructorMarker)null);
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
```

## **컴파일 타임 상수(compile-time constants)**

- 컴파일 타임 상수는 class 명세가 method 메모리 영역에 들어갈 때 함께 초기화 되어 객체를 만들지 않아도 사용할 수 있는 상수
1. companion object를 클래스 내부에 선언 후 그 내부에 const val을 사용하는 방법

```java
class MappingService {
   companion object {
      const val DEFAULT_NAME: String = "sabardada"
   }
}
```

1. 클래스 밖에 top-level 에 const val을 선언하는 방법(top level 에 대해서 따로 설명)

```java
const val DEFAULT_NAME_2: String ="sabardada"

class MappingService private constructor(
  val name:String = DEFAULT_NAME_2
}
```

1. object 클래스로 선언하여 그 안에 const val을 선언하는 방법

```java
object MappingBaserService{
    const val DEFAULT_NAME_3: String ="sabardada"
}
```

## **접근 제어자(Modifier)**

- private - 클래스 외부에서 접근이 불가능합니다.
- protected - 상속관계에 있는 외부에서는 접근이 가능합니다.
- internal - 한 모듈안에서 라면 접근이 가능합니다.
- public - 어디서든 접근이 가능합니다.

```kotlin
open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4 // 기본값 : public
   
    protected class Nested {
      public val e: Int = 5
    }
}

class Subclass : Outer(){
   // a는 private 이기 때문에 참조 불가
   // b, c, d, e 는 참조가능

   override val b = 5 //'b'는 protected 로 오버라이딩 가능
}

class Unreleated(o: Outer){
   // o.a, o.b 는 접근 불가능
   // o.c와 o.d는 접근 가능(같은 module)
   // Outer, Nested 그리고 Nested::e 는 접근 불가
}
```

# NPE

- Null Pointer Exception

자바에서 일반적으로 발생하는 npe

```java
public void test(String str){
// str의 null 체크 없이 사용한다면 npe 발생 가능성 존재
  if(str == null || str.equals("")){
      //str을 이용한 동작
  }
}

```

코틀린에서 null은 어떻게 처리하는가?

1) 일반적으로 코틀린에서 아래처럼 변수에 null을 대입하려고 하면 컴파일 에러가 발생

```kotlin
var name: String = "sabarada"
name = null // 컴파일 에러 발생

// null 을 허용하고 싶을 때는 
var name: String? = "sabarada"
name = null // OK
```

**※ null이 될 수 있는 타입을 주고 그 내부 함수를 호출하면 NPE 발생?**

```kotlin
var name: String? ="sabarada"
var size= name.length // 컴파일 에러 발생
```

→ 컴파일 에러의 내용은 `Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?` 입니다. 즉, null 허용 타입일 경우에는 타입 체크또는 더 명확한 명시를 하지 않으면 내부 함수 또는 변수를 호출할 수 없다는 내용입니다.

## null 체크를 하는 방법

**1) 조건문으로 체크하기**

```kotlin
var name: String? ="sabarada"
if (name != null && name.isNotEmpty()) {
    println("이름은 $name , 이름의 길이 = ${name.length}") // 결과 : 이름은 sabarada , 이름의 길이 = 8
} else {
    println("Empty string")
}
```

- if / else 를 이용하여 name의 null 체크를 했기 때문에 위에서는 컴파일 에러가 발생하던 name.length 가 정상적으로 컴파일 되는 것으로 확인

**2) 안전한 호출(safe call)**

```kotlin
var name: String? = "sabarada"
var nullName: String? = null
println("name = ${name?.length}") // 결과 : name = 8
println("name = ${nullName?.length}") // 결과 : name = null
```

- 내부 함수 또는 변수를 호출 할 때 ?. 으로 호출합니다. 이렇게 하면 null 일 경우 null을 반환하며 그렇지 않을 경우 정상적으로 값을 반환합니다.

```kotlin
class OutterEntity(
  val innerEntity: InnerEntity? = null
){

}

class InnerEntity(
  val name: String? = null
){

}

// 호출 가능 방식
val outterEntity: OutterEntity? = OutterEntity(InnerEntity("sabarada"))

if(outterEntity != null && outterEntity.innerEntity !=null && outterEntity.innerEntity.name != null){
   println("name = ${outterEntity.innerEntity.name}")
} else {
   println("name is null")
}

// ? 키워드를 사용한 방법
val name = outterEntity?.innerEntity?.name
println("name = $name") // 결과 name = sabarada

```

## 엘비스 연산자

```kotlin
val outterEntity: OutterEntity? = OutterEntity()

val name = outterEntity?.innerEntity?.name ?: "default"
println("name = $name") // 결과 : name = default
```

## The !! operator

```kotlin
val outterEntity: OutterEntity? = OutterEntity()

val name = outterEntity!!.innerEntity!!.name // java.lang.NullPointerException
```

- NullPointerException 발생하고 프로그램은 종

## 클래스 초기화 과정에서 발생할 수 있는 NPE

```kotlin
class Demo2 {
    val some: Int
    val someString: String

    init {
        fun Demo2.indirectSome() = some
        fun Demo2.indirectSomeString() = someString
        println(indirectSome()) // prints 0
        println(indirectSomeString().replace("1", "2")) // someString은 초기화 되지 않았지만 간접적으로 접근하여 NPE가 발생할 수 있습니다.
        some = 1
        someString = ""
    }
}
```

- initialize block 에서 간접적으로 초기화 되지 않은 변수에 접근

```kotlin
abstract class Base {
    val code: String = calculate()
    abstract fun calculate(): String
}

class Derived(private val x: String) : Base() {
    override fun calculate() = x
}

fun testIt() {
    Derived("sabarada").code.replace("", "") // Expected: NPE 발생
}
```

- 자식 클래스의 값을 부모클래스의 값으로 대입하고 있습니다. 따라서 초기화 순서에 의헤 code 에는 값이 "sabarada"가 아닌 null로 들어가게되며 사용함에 있어서 NPE가 발생하게 됩니다.

# Scope Function

Scope Function은 객체 컨텍스트 내에서 코드 블럭을 실행할 수 있도록 해줍니다. 즉, Scope Function 을 이용하면 객체의 정보를 기본적으로 가지고 있는 코드 블럭을 만들어 사용할 수 있어 간결한 코딩을 가능하게 해줌

```kotlin
class MappingService(
    private var name: String, 
    private var age: Int
){

   fun changeName(name: String){
       this.name = name
   }

   fun incrementAge(){
       age++
   }

   override fun toString(): String{
        return "이름 = $name, 나이 = $age"
   }
}
```

```kotlin
val mappingService = MappingService("sabarada", 15)
println(mappingService) // 결과 : 이름 = sabarada, 나이 = 15

mappingService.changeName("karol")
mappingService.incrementAge()
println(mappingService) // 결과 : 이름 = karol, 나이 = 18
```

Scope Functions 

```kotlin
MappingService("sabarada", 15).let{
   println(it) // 결과 : 이름 = sabarada, 나이 = 15
   it.changeName("karol"
   it.incrementAge()
   println(it) // 결과 : 이름 = karol, 나이 = 18
}
```

### 용어 정리

Scope Functions

**let, run, with, apply, also**

1) 컨테스트 객체를 참조하는 방법

2) 반환 값

3) 확장함수 

여부에 따라 각각 다르게 사용되어집니다. 

※ Scope Function 블럭은 람다(lambda) function 입니다. 이 람다는 파라미터로 2가지를 가지고 있슴

(this, it) 해당 키워드를 통해 객체를 이용가능하게 되는 것

둘의 커버할 수 있는 커버리지가 다르지는 않으며 단지 본인의 코딩 스타일에 따라서 선택하면 좋음

### 컨테이스 객체를 참조하는 방법

**let, also
→ it를 통해서 context object를 참조, it는 this보다 짧으며 조금 더 읽기 쉽다는 게 장점,**

→ 하지만 scope function block 안에 또다른 람다가 사용되어 it이 사용된다면 두개의 it을 구분짖기가 힘듭니다.

```kotlin
MappingService("sabarada", 15).let{
   println(it) // 결과 : 이름 = sabarada, 나이 = 15
   it.changeName("karol")
   it.incrementAge()
   println(it) // 결과 : 이름 = karol, 나이 = 18
}
```

**run, with, apply**

**→ this를 통해서 context object를 참조합니다. 그래서 사용할 때 class 내부에 있는 함수의 형식으로 사용하실 수 있습니다.** 

→ 또한 this를 생략하는 것도 가능합니다. 

→ 하지만 이럴 경우 외부 함수와 context object 함수의 구분이 어렵기 때문에 this는 붙이는 것을 추천

```kotlin
MappingService("sabarada", 15).run{
   println(it) // 결과 : 이름 = sabarada, 나이 = 15
   this.changeName("karol")
   incrementAge() // this 생략
   println(it) // 결과 : 이름 = karol, 나이 = 18
}
```

- this: run, with, apply
- it : let, also

### 반환 값(Return value)

- **apply, also는 context object를 반환합니다.**
- 즉, scope function 을 호출 시킨 자기자신을 반환
- 호출 시 call chaning을 이요할 수 있습니다.

```kotlin
MappingService("sabarada", 15)
   .also{ println(it) } // 결과 : 이름 = sabarada, 나이 = 15
   .also{ it.changeName("karol") }
   .also{ it.incrementAge() }
   .also{ println(it) } // 결과 : 이름 = karol, 나이 = 18
```

- **let, run, with 는 람다의 결과를 반환합니다.** 즉 scope function block에서 마지막 명령어의 결과를 반환합니다.
- also로 call chaning을 하면서 마지막에 let을 통해서 println은 반환값을 가지지 않기 때문에 전체 call chaining 도 반환 값을 가지지 않도록 합니다.
- 불필요한 객체 반환을 막는 것

```kotlin
MappingService("sabarada", 15)
   .also{ println(it) } // 결과 : 이름 = sabarada, 나이 = 15
   .also{ it.changeName("karol") }
   .also{ it.incrementAge() }
   .let{ println(it) } // 결과 : 이름 = karol, 나이 = 18
```

### 구현체

→ 각 구현체들이 어떻게 구현하고 있는 지, 그리고 어디에서 사용하면 좋을지에 대해서 알아보자’

**let**

- let은 it을 파라미터로 사용하고 있습니다. 그리고 람다(lambda) 결과를 반환

```kotlin
val mappingService : MappingService? = createService() // nullable 한 함수!

mappingService?.let { // mappingService 가 null 이 아닌 경우에만 let scope Function 실행
     println(it) // 결과 : 이름 = karol, 나이 = 16
    it.changeName("karol")
    it.incrementAge()
    println(it) // 결과 : 이름 = karol, 나이 = 16
}
```

**run**

- run은 this를 이용하여 접근이 가능합니다.
- 람다 결과 반환

```kotlin
val objectString: String = MappingService("sabarada", 15).run {
            this.incrementAge()
            this.toString()
        }

println(objectString) // 결과 : 이름 = sabarada, 나이 = 16
val resultString: String = run {
    val first: String = "sabarada"
    val second: String = "Karol"

    "$first is $second"
}

println(resultString) // 결과 : sabarada is Karol
```

**with**

- with는 확장 함수가 아닙니다.  with는 객체를 파라미터로 받습니다.
- lambda function 내부에서는 this를 파라미터를 이용

```kotlin
val mappingList: List<MappingService> =
    listOf(MappingService("sabarada", 15), MappingService("karol", 15))

val sumValue = with(mappingList) {
    var sumValue = 0
    for (value in mappingList) {
        sumValue += value.getAge()
    }
    sumValue
}

println(sumValue)
```

**apply**

- apply는 this를 이용해서 해당 객체에 접근할 수 있습니다.
- 객체 자체를 반환하는 특성

```kotlin
val mappingService: MappingService = MappingService("sabarada", 15)
    .apply {
        this.incrementAge()
        this.incrementAge()
    }

println(mappingService) // 결과 : 이름 = sabarada, 나이 = 17
```

**also**

- also는 it을 이용하여 객체접근이 가능하며 객체  자체를 반환
- 일반적으로 call chaning

```kotlin
MappingService("sabarada", 15)
    .also { println(it) } // 결과 : 이름 = karol, 나이 = 16
    .also { it.changeName("karol") }
    .also { it.incrementAge() }
    .also { println(it) } // 결과 : 이름 = karol, 나이 = 16
```

**정리**

| 함수 | 객체 참조 방법 | 반환 값 | 확장 함수 여부 |
| --- | --- | --- | --- |
| let | it | Lambda result | Yes |
| run | this | Lambda result | Yes |
| run | this | Lambda result | No: called without the context object |
| with | this | Lambda result | No: takes the context object as an argument. |
| apply | this | Context object | Yes |
| also | it | Context object | Yes |

# 연산자 오버로딩

연산자 오버로딩이란 객체 지향 프로그래밍에서 다형성의 특별한 경우로 다른 연산자들이 함수 연산자를 통해서 구현을 할 때를 말한다.

**- 이 말인 즉슨 +,- 등 과 같은 연산자가 어떤 값과 함께 사용하느냐에 따라서 다르게 동작할 수 있도록 그것을 커스터마이징 할 수 있다는 의미**

- java에서도 연산자 오버로딩은 아니지만 같은 연산자에서 다르게 동작하는 예제가 있습니다.

```kotlin
String a ="sabarada is";
String b = "karol";
String result = a + " " + b; // sabarada is karol

int c = 1;
int d = 2;

int result_2 = c + d //3
```

### 코틀린에서의 연산자 오버로딩

```kotlin
data class Price(val value: Int){
   operator fun plus(b: Price): Price{
        return Price(value + b.value)
   }
}

val a: Price = Price(10)
val b: Price = Price(50)
val result: Price = a + b //결과 Price(60)

```

### 단항 연산자(Unary operations)

```kotlin
data class Price(val value: Int) {

    operator fun inc(): Price {
        return Price(value + 100)
    }

    operator fun dec(): Price {
        return Price(value - 100)
    }
}
var a = Price(500)
println("value = ${a++}") // 결과 : Price(value=500)
println("value = ${a}")   // 결과 : Price(value=600)
println("value = ${++a}") // 결과 : Price(value=700)

println("value = ${a--}") // 결과 : Price(value=700)
println("value = ${a}")   // 결과 : Price(value=600)
println("value = ${--a}") // 결과 : Price(value=500)
```

### 사칙 연산

| 표현 | 함수 |
| --- | --- |
| a + b | a.plus(b) |
| a - b | a.minus(b) |
| a * b | a.times(b) |
| a / b | a.div(b) |
| a % b | a.rem(b) |
| a += b | a.plusAssign(b) |
| a -= b | a.minusAssign(b) |
| a *= b | a.timesAssign(b) |
| a /= b | a.divAssign(b) |
| a %= b | a.remAssign(b) |

```kotlin
data class Price(val value: Int){
   operator fun rem(b: Price): Price {
     return Price(value + price.value)
   }
}

val a = Price(500)
val b = Price(499)
println("rem = ${a % b}")    // 결과 : rem = Price(999)
```

### get / set

```kotlin
data class Price(var value: Int) {
    operator fun get(num: Int): Int {
        return value
    }
}

val a = Price(500)        
println("a_price = ${a[100/* dummy 숫자 */]}") // 결과 : a = 500
```

```kotlin
data class Price(var value: Int) {

    operator fun set(num: Int, value: Int) {
        this.value = value
    }
}

val a = Price(500)
a[100] = 10
println("a_price = ${a[100/* dummy 숫자 */]}") // 결과 : a = 10
```

### 생성자

```kotlin
data class Price private constructor(val value: Int) {

    companion object {
        operator fun invoke(): Price {
            return Price(100)
        }

        operator fun invoke(value: Int): Price {
            return Price(value)
        }
    }
}

val a = Price(500)
println("a = $a") // 결과 : a = Price(500)

val b = Price()
println("b = $b") // 결과 : b = Price(100)
```



# 인라인 함수와 reified 키워드
- 인라인 키워드는 자바에서는 제공하지 않는 코틀린만의 키워드

## 람다식을 사용했을 때 무의미한 객체 생성을 예방

- 인라인 함수를 사용한다면 람다식을 사용했을 때 무의미한 객체 생성을 막을 수 있습니다.

```kotlin
fun doSomethingElse(lambda: () -> Unit){
    println("Doing somethint else")
    lambda()
}
```

```java
public static final void doSomethingElse(Function0 lambda) {
    System.out.println("Doing something else");
    lambda.invoke();
}
```

```kotlin
fun doSomething() {
   println("Before lambada")
   doSomethingElse {
       println("inside lambda")
   }
   println("After lambda)
}
```

```java
public static final void doSomething() {
    System.out.println("Before lambda");
    doSomethingElse(new Function() {
            public final void invoke() {
            System.out.println("Inside lambda");
        }
    });
    System.out.println("After lambda");
}
```

- doSomehtingElse의 파라미터로 새로운 객체를 생성하여 넘겨준다
- 즉 doSomething 이라는 메서드를 호출할 때마다 새로이 만들어집니다.(무의미하게 새로운 객체를 매번 생성)

**인라인으로 변경한다면?**

```kotlin
inline fun doSomethingElse(lambda: () -> Unit){
   println("Doing something else")
   lambda()
}
```

```java
public static final void doSomething() {
    System.out.println("Before lambda");
    System.out.println("Doing something else");
    System.out.println("Inside lambda");
    System.out.println("After lambda");
}
```

## 람다식에 로컬 변수 사용

```kotlin
fun doSomething() {
    val greetings = "Hello"
    doSomethingElse {
        println("$greetings from lambda")
    }
}
```

```java
public static final void doSomething() {
   String greetings = "Hello";
   doSomethingElse(new Function(greetings){
      public final void invoke(){
      System.out.println(this.$greetings + " from lambda");
      }
   });
}
```

- 객체에 변수가 추가 되었음
- 즉 객체의 메모리 사용량이 늘어남

## reified 키워드

```kotlin
fun <T> doSomething(someValue: T)
```

```kotlin
fun <T> doSomething(someValue: T, Class<T> type) { // runtime에서도 타입을 알 수 있게 Class<T> 넘김
    println("Doing something with value: $someValue")               // OK
    println("Doing something with type: ${T::class.simpleName}")    // Error
}
```

```kotlin
inline fun <reified T> doSomething(someValue: T) {
    println("Doing something with value: $someValue")               // OK
    println("Doing something with type: ${T::class.simpleName}")    // OK
}
```
