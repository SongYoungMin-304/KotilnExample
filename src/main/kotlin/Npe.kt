fun main() {

/*
    var name1: String = "sabarada"
    name1 = null // 컴파일 에러 발생

// null 을 허용하고 싶을 때는
    var name: String? = "sabarada"
    name = null // OK

    var name3: String? ="sabarada"
    var size= name3.length // 컴파일 에러 발생

    var name: String? ="sabarada"
    if (name != null && name.isNotEmpty()) {
        println("이름은 $name , 이름의 길이 = ${name.length}") // 결과 : 이름은 sabarada , 이름의 길이 = 8
    } else {
        println("Empty string")
    }

    var name4: String? = "sabarada"
    var nullName: String? = null
    println("name = ${name4?.length}") // 결과 : name = 8
    println("name = ${nullName?.length}") // 결과 : name = null


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

    val outterEntity: OutterEntity? = OutterEntity()

    val name = outterEntity?.innerEntity?.name ?: "default"
    println("name = $name") // 결과 : name = default

    val outterEntity: OutterEntity? = OutterEntity()

    val name = outterEntity!!.innerEntity!!.name // java.lang.NullPointerException
*/

}

class OutterEntity(
    val innerEntity: InnerEntity? = null
){

}

class InnerEntity(
    val name: String? = null
){

}

fun test(str: String?) {
// str의 null 체크 없이 사용한다면 npe 발생 가능성 존재
    if (str == null || str == "") {
        //str을 이용한 동작
    }
}

