// MappingBaserService 정의 open 을 통해3서 상속 가능하게 표시
open class MappingBaseService {

    init{
        println("MappingBaseService initialize")
    }

    // 매개변수는 없고 반환 값은 String
    open fun service(): String {
        return "MappingBaseService"
    }

    open val firstProperty: String = "MappingBaseService property"
}

class MappingService1() : MappingBaseService(){

    init{
        println("MappingService initialize")
    }

    // 매개변수는 없고 반환 값은 String
    override fun service(): String {
        return "MappingService"
    }

    // 매개변수도 Override 가능
    // var -> val , var -> var, val -> val 가능하지만
    // val -> var 불가능
    override val firstProperty: String
        get() = "MappingService Property"

}

// 기본적으로 Kotiln 은 Any 클래스를 상속받는다. 즉 Any 클래스는 모든 객체의 부모 객체
// Any 객체에는 equals(), hashCode(), toString() 만 존재


// 코틀린에서는 인터페이스의 추상화 함수 선언과 함수의 구현이 함께 포함되어질 수 있슴
// 코틀린 클래스와 인터페이스의 차이점은 인터페이스에서는 상태를 저장할 수 없다는 것입니다.
// 인터페이스에서도 멤버변수는 선언할 수 있지만 이 변수들은 추상화 되어있으며 상태로서 사용하고 싶다면
// implementation 받아 오버라이딩하여 사용하여야 합니다.

interface MyInterface{

    val prop: Int // abstract

    val propertyWithImplements: String
    get() = "foo"


     fun foo(){
        print(prop)
    }
}

class Child : MyInterface{

    override val prop: Int = 29

    override fun foo() {
        super.foo()
        println("테스트영민")
    }
}

fun main() {

    val child = Child()

    // MappingBaseService initialize 호출 이후
    // MappingService initialize 호출

    println("1번 service = ${child.prop}")

    child.foo()

}
