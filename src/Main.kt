//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
fun main(args: Array<String>) {
    // 메인 진입점 -> fun main()

    val list1 = listOf(1, 2, 3)
    val list2 = mutableListOf(1, 2, 3) // 불변이지만 가변 리스트에 값을 추가할 수 있다.
    list2.add(4)

    val rand = Math.random()
    println("rand = $rand")

    val score = 400 * rand
    val grade = if (score >= 90) "A"
    else if (score >= 80) { "B" }
    else if (score >= 60) { "C" }
    else "D"
    println("score = $score -> grade = $grade")

    val name = "Kotlin"
    //TIP 캐럿을 강조 표시된 텍스트에 놓고 <shortcut actionId="ShowIntentionActions"/>을(를) 누르면
    // IntelliJ IDEA이(가) 수정을 제안하는 것을 확인할 수 있습니다.
    println("Hello World, " + name + "!")
    println("Hello, $name World!\n")

    for (i in 1..3) {
        println("i = $i")
    }

    // val: 불변 (Immutable) 최초 할당(init) 후 읽기(get)만 가능
    // var: 가변 (Mutable) - get, set 가능

    /*************************************/
    // 값을 더한 후 문자열 보간
    val a: Int = 3
    val b = 5
    println("a + b = ${a + b}\n")

    /*************************************/
    // 여러 줄 문자열
    val name2 = "jwoo.kim"
    val message = """
        안녕하세요.
        오늘의 사용자: $name2
        시스템에 정상 로그인되었습니다.
    """.trimIndent()

    println("여러 줄 문자열 출력 샘플:\n$message\n") // "\n" 줄넘김

    /*************************************/
    // 타입 추론
    val s = "ABC" // String
    val i = 1 // int
    val l = 1L // long
    val d = 1.0 // double
    val f = 1.0f // float

    println("s = $s -> ${s::class}")
    println("i = $i -> ${i::class}")
    println("l = $l -> ${l::class}")
    println("d = $d -> ${d::class}")
    println("f = $f -> ${f::class}\n")

    /*************************************/
    // Kotlin 문자열 보간과 Java 문자열 포맷 비교
    val x = 10
    val y = 20
    println("Kotlin 문자열 보간과 Java 문자열 포맷 비교 결과")
    println("Kotlin 식 문자열 보간: ${x + y}")
    println("Java식 문자열 포맷: %d \n".format(x + y))

    /*************************************/
    // Null Safety
    // Kotlin에서는 NullPointerException 차단.
    var name3: String = "정우"
//    name3 = null // 이런 경우 Java에서는 NullPointerException 발생. Kotlin에서는 컴파일 오류로 막아주는 것 뿐만 아니라, 코드 작성 때부터 오류 알려줌.

    var nickname: String? = null // ✅ nullable
    nickname = "홍길동"
    nickname = null
    println("nickname = $nickname, nickname 길이 = ${nickname?.length}\n") // safe call

    /*************************************/
    // 싱글톤 객체 AssemblyInfo 내부에 변수값 출력
    println("AssemblyInfo.FileVersion = ${AssemblyInfo.FileVersion}")
    println("AssemblyInfo.InformationVersion = ${AssemblyInfo.InformationVersion}\n")

    /*****************************************/

    // 피보나치 수열 출력 함수 호출
    println(fibonacciIterative(10))
    println(fibonacciIterative2(10))

    val price: Int = 100

    if (price in arrayOf(100, 200, 300)) {
        println("100 이 포함되어 있다.\n")
    } else {
        println("100 이 포함되어 있지 않다.\n")
    }

    /*****************************************/

    // 간단한 함수 호출

    val p1: Int = 100
    val p2: Int = 200
    val p3 = sumPrice2(p1, p2)
    println("p3 = $p3\n")

    // 클래스

    val item = Item("BOOK", 10_000)
    println("아이템 네임 = ${item.name}, 아이템 가격 = ${item.price}\n")

    item.buy()
    item.sell()
}

class Item (
    val name: String,
    val price: Int,
) : ItemTrade {
    override fun buy() {
        println("buy() 가 재정의 되었다. 여기서 name은 $name")
    }

    override fun sell() {
        println("sell() 이 재정의 되었다. 여기서 name은 $name")
    }
}

enum class Color {
    RED,
    GREEN,
    BLUE,
}

interface ItemTrade {
    fun buy()
    fun sell()
}

fun sumPrice(price1: Int, price2: Int): Int {
    val price = price1 + price2
    return price
}

fun sumPrice2(price1: Int, price2: Int) = price1 + price2


interface Greeter {
    fun greet()
    fun greetImplementation() { // interface 안에는 계약 뿐만 아니라 구현도 넣을 수 있다.
        println("Kotlin Interface 안에는 계약 뿐만 아니라 구현도 넣을 수 있다.")
    }
}

fun functionSample() {
    fun add(a: Int, b: Int): Int {
        fun add2(): Int {
            return 0
        }

        return a + b
    }
}

fun fibonacciIterative(n: Int): List<Long> {
    if (n <= 0) return emptyList()
    if (n == 1) return listOf(0)

    val result = mutableListOf<Long>(0, 1)

    for (i in 2 until n + 1) {
        result.add(result[i - 1] + result[i - 2])
//        println("i = $i")
    }
    return result
}

fun fibonacciIterative2(n: Int): List<Long> {
    if (n <= 0) return emptyList()
    if (n == 1) return listOf(0)

    val result = mutableListOf<Long>(0, 1)

    for (i in 2..n) {
        result.add(result[i - 1] + result[i - 2])
//        println("i = $i")
    }
    return result
}

// 싱글톤 객체 선언
object AssemblyInfo {
    var major: Int = 1
    var yearMonth: Int = 2509
    var build: Int = 27
    val AppVersion: String = "$major.$yearMonth.$build"

    // Git short SHA 정보 (7 digits)
    val gitSha: String = "64290d8"

    // 다양한 버전 속성들
    val FileVersion: String = "$major.$yearMonth.$build"
    val ProductVersion: String = "$major.$yearMonth.0"
    val InformationVersion: String = "$major.$yearMonth.$build+$gitSha"
}