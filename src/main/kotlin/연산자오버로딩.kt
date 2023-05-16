// 기본 생성자는 1개 이상의 매개변수를 가져야함
// 모든 기본 생성자 매개변수는 val 또는 var로 선언해야 한다.
// equals(), hashCode(), toString() Methods 기본적으로 제공
// 데이터 클래스는 일반 클래스보다 데이터를 보관하기 유용
data class Price(val value: Int){
    operator fun plus(b: Price): Price{
        // 매개변수는 Price 로 받아서 Price를 반환함
        // plus 는 class 가 + 할 때 동작하는 걸 정의
        return Price(value + b.value)
    }
}

data class Price2(val value: Int) {

    operator fun inc(): Price2 {
        return Price2(value + 100)
    }

    operator fun dec(): Price2 {
        return Price2(value - 100)
    }
}

data class Price3(val value: Int){
    operator fun rem(b: Price3): Price3 {
        return Price3(value + b.value)
    }
}

data class Price4(var value: Int){
    operator fun get(num: Int): Int{
        println("게터")
        return value;
    }

    operator fun set(num: Int, value: Int){
        println("세터")
        this.value = value
    }
}

fun main() {

    val a: Price = Price(10)
    val b: Price = Price(50)
    val result: Price = a + b //결과 Price(60)

    println(result)

    var c = Price2(500)
    println("value = ${c++}") // 결과 : Price(value=500)
    println("value = ${c}")   // 결과 : Price(value=600)
    println("value = ${++c}") // 결과 : Price(value=700)

    println("value = ${c--}") // 결과 : Price(value=700)
    println("value = ${c}")   // 결과 : Price(value=600)
    println("value = ${--c}") // 결과 : Price(value=500)

    var d = Price3(500)
    var e = Price3(499)

    println("rem = ${d % e}")

    val f = Price4(500)
    println("a_price = ${f[100]}")
    f[100] = 20
    println("a_price = ${f[1200]}")

}