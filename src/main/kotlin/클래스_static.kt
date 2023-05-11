
fun main() {

    val mappingService_1 = MappingService7.create()

    println("mappingService_1 = ${mappingService_1.name}")

    val mappingService_2 = MappingService7.create("songyoungmin")

    println("mappingService_2 = ${mappingService_2.name}")

    println("mappingService_3 = ${MappingService7.DEFAULT_NAME}")

}

class MappingService7 private constructor(
    val name: String = DEFAULT_NAME
) {

    companion object {

        fun create(): MappingService7 = MappingService7()


        fun create(name: String): MappingService7 = MappingService7(name)


        const val DEFAULT_NAME: String = "sabardada"
    }
}

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