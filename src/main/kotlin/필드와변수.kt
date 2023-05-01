fun main() {
    // val - 변경 불가능한
    // var - 변경 가능한

    val name: String ="songyougnmin"
    print(name)

    val one: Int = 1
    val threeBillion: Long = 30000000000
    val oneLong: Long = 1L
    val oneByte: Byte = 1

    println(one)
    println(threeBillion)
    println(oneLong)
    println(oneByte)

    val pi: Double = 3.14
    var eFloat: Float = 2.718f

    println(pi)
    println(eFloat)

    val myTrue: Boolean = true
    val myFalse: Boolean = false

    var aChar: Char = 'a'

    println(myTrue)
    println(myFalse)
    println(aChar)

    val str: String ="abcd 123"

    val str2 = "abcd"
    println(str2.uppercase())
    println(str2)

    val str3: String = "abcd 123"
    println(str3[0])

    val array: Array<Int> = arrayOf(1,2,3)
    array[1] = 4
    println(array[0])
    println(array.get(1))
    array.set(2,5)
    println(array.get(2))

    var arr1 = IntArray(5) //[0,0,0,0,0]
    var arr2 = IntArray(5){42} //[42,42,42,42,42]
    var arr3 = IntArray(5){it * 1 } //[0,1,2,3,4]

    print(arr1.get(4))
    print(arr2.get(4))
    print(arr3.get(4))

}