
fun main() {
    NameService(5)

    MappingService(7)

    defaultService("song")

    MappingService2("테스ㅌ")

    println("---------------------")

    val mappingService3 = MappingService3("송영민");
    println("test = ${mappingService3.firstProperty}")


    val mappingService4 = MappingService4("송영민");
    println("test = ${mappingService4.firstProperty}")

}

class NameService constructor(name: String) {

    // 보조생성자
    constructor(value: Int) : this(value.toString()) {
        println("Secondary constructor block that prints $value")
    }

        private val firstProperty = "First property: $name"

    /// 주 생성자
    init {
        println("First initializer blocks that prints $name")
    }

    fun printName(): String = this.firstProperty

}

class MappingService constructor(name: String){

    constructor(value: Int) : this(value.toString()){
        println("Secondary constructor block that prints $value")
    }

}

class defaultService constructor(name: String){

    init{
        println("test $name");
    }
}

// 초기화 블록
class MappingService2 constructor(name: String){
    private val firstProperty = name

    init {
        println("testestest $name $firstProperty")
    }

    // 뒤에 있는 건 처리가 안된다
    //private val secpmtProperty = name
}

class MappingService3 constructor(name: String){
    val firstProperty: String = name;
}

class MappingService4(val firstProperty: String){

}
