fun main() {

    fun double(x: Int): Int{
        return x * 2
    }

    val double = double(5)
    println("값 = $double")


    // 파라미터 기본 값 세팅
    fun double2(x: Int = 10): Int{
        return x*2
    }

    val double2 = double2()
    println("값 = $double2")

    // 이름 명시 파라미터
    fun double3(x: Int = 10, y: Int): Int {
        return x / y
    }

    val double3 = double3(y = 2, x = 5)
    println("값 = $double3")

    // 단일표현식
    fun double_1(x: Int = 10, y:Int): Int {
        return x * y
    }

    fun double_2(x: Int, y: Int) : Int = x * y
    fun double_3(x: Int = 10, y: Int): Int = x * y

    val double_1 = double_1(x = 5, y = 2)
    val double_2 = double_2(x = 5, y = 2)
    val double_3 = double_2(x = 5, y = 2)

    println("값_1 = $double_1")
    println("값_2 = $double_2")
    println("값_3 = $double_3")

    // 지역함수, 클로저
    fun double_4(x: Int = 10, y: Int): Int{
        fun double_5(x: Int, y: Int) = x * y
        return x * y * double_5(x, y)
    }

    val double4 = double_4(x = 5, y = 2)
    println("값_4 = $double4")

    //val double5 = double_5(x = 5, y = 2) // 컴파일 에러

    // Trailling Coomma
    fun double_6(
        x: Int = 10,
        y: Int,
    ): Int{
        return x * y
    }

    // , 가 맨 마지막에도 그냥 쓰인다
    /*
    1) 소스 비교 명확히 가능 - git 등을 사용하여 코드를 비교할 때 , 는 변화로 잡지 않기 때문에 값의 변화에 집중할 수 있습니다.
    2) 순서 재정렬이 편함 - 함수, enum 등에서 재정렬할때 ,를 신경쓰지 않다도 됩니다.
    3) 코드 자동생성 만들 시 편함 - 마지막 파라미터일 때는 , 를 뺀다라는 로직이 필요없으므로 코드 자동생성을 만들 때 좋습니다.
     */


}