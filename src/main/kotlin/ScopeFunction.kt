fun main() {

    val mappingService = MappingService8("sabarada", 15)
    println(mappingService) // 결과 : 이름 = sabarada, 나이 = 15
    mappingService.changeName("karol")
    mappingService.incrementAge()
    println(mappingService) // 결과 : 이름 = karol, 나이 = 16

    // With 확장함수형식
    with(MappingService8("sabarada", 15)){
        println(this) // 결과 : 이름 = karol, 나이 = 16
        this.changeName("karol")
        this.incrementAge()
        println(this) // 결과 : 이름 = karol, 나이 = 16
    }

    MappingService8("sabarada", 15).let {
        println(it) // 결과 : 이름 = karol, 나이 = 16
        it.changeName("karol")
        it.incrementAge()
        println(it) // 결과 : 이름 = karol, 나이 = 16
    }

    MappingService8("sabarada", 15).run {
        println(this) // 결과 : 이름 = karol, 나이 = 16
        this.changeName("karol")
        incrementAge() // this 생략
        println(this) // 결과 : 이름 = karol, 나이 = 16
    }

    MappingService8("sabarada", 15)
        .also { println(it) } // 결과 : 이름 = karol, 나이 = 16
        .also { it.changeName("karol") }
        .also { it.incrementAge() }
        .also { println(it) } // 결과 : 이름 = karol, 나이 = 16

    MappingService8("sabarada11", 15)
        .also { println(it) } // 결과 : 이름 = karol, 나이 = 16
        .also { it.changeName("karol22") }
        .also { it.incrementAge() }
        .let { println(it) } // 결과 : 이름 = karol, 나이 = 16
}

class MappingService8(
    private var name: String,
    private var age: Int
) {

    fun changeName(name: String) {
        this.name = name
    }

    fun incrementAge() {
        age++
    }

    override fun toString(): String {
        return "이름 = $name, 나이 = $age"
    }
}