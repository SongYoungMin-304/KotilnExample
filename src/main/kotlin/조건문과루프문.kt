import java.lang.Integer.parseInt


fun main() {

    // 조건문(if)
    var max  = 10

    var a = 1
    var b = 2

    if(a < b) max = b

    println(max)

    var max2: Int
    if(a > b){
        max2 = a
    } else{
        max2 = b
    }

    println(max2)

    val max3 = if (a > b) a else b

    println(max3)


    val max4 = if (a > b) {
        println("Choose a")
        a
    } else {
        println("Choose b")
        b
    }

    println(max4)

    // 다중 선택문(when)
    var x: Int = 2
    var s: String ="2"

    when(x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else ->{
            print("x is neither 1 nor 2")
        }
    }

    println()

    when(x){
        parseInt(s) -> print("s encodes x")
        else -> print("s does not encode x")
    }

    println()

    when(x){
        in 1..10 -> print("x is in the range")
        !in 10..20 -> print("x is valid")
        else -> print("non of the above")
    }

    println()

    // 반복문 (for, while)
    val array = arrayOf(1, 2, 3, 4, 5)
    for(item in array){
        print(item)
    }

    println()

    for(i in 1..3){
        print(i)
    }

    println()

    for(i in 6 downTo 0 step 2){
        print(i)
    }

    println()

    val array2 = arrayOf(1,2,3,4,5)
    for(index in array2.indices){
        print(array[index])
    }

    println()

    for((index, value) in array2.withIndex()){
        println("$index 번째는 $value 값을 가집니다.")
    }

    println()

    var x2: Int = 5
    while (x2 > 0) {
        x2--
        println("test")
    }
    

}