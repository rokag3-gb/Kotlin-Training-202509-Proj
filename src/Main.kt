//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
fun main() {
    val name = "Kotlin"
    //TIP 캐럿을 강조 표시된 텍스트에 놓고 <shortcut actionId="ShowIntentionActions"/>을(를) 누르면
    // IntelliJ IDEA이(가) 수정을 제안하는 것을 확인할 수 있습니다.
    println("Hello World, " + name + "!")
    println("Hello, $name World!")

    for (i in 1..3) {
        println("i = $i")
    }

    // val: 불변 (Immutable)
    // var: 가변 (Mutable)

    /*************************************/
    // 값을 더한 후 문자열 보간
    val a: Int = 3
    val b = 5
    println("a + b = ${a + b}")

    /*************************************/
    // 여러 줄 문자열
    val name2 = "jwoo.kim"
    val message = """
        안녕하세요.
        오늘의 사용자: $name2
        시스템에 정상 로그인되었습니다.
    """.trimIndent()

    println("여러 줄 문자열 출력 샘플:\n$message") // "\n" 줄넘김

    /*************************************/
    // Kotlin 문자열 보간과 Java 문자열 포맷 비교
    val x = 10
    val y = 20
    println("Kotlin 문자열 보간과 Java 문자열 포맷 비교 결과")
    println("Kotlin 식 문자열 보간: ${x + y}")
    println("Java식 문자열 포맷: %d".format(x + y))

    /*************************************/
    var name3: String = "정우"
//    name3 = null // 이런 경우 Java에서는 NullPointerException 발생. Kotlin에서는 컴파일 오류로 막아주는 것 뿐만 아니라, 코드 작성 때부터 오류 알려줌.

    var nickname: String? = null // ✅ nullable
    nickname = "홍길동"
    nickname = null
    println("nickname = $nickname, nickname 길이 = ${nickname?.length}") // safe call

    /*************************************/
    //
    println("AssemblyInfo.FileVersion = ${AssemblyInfo.FileVersion}")
    println("AssemblyInfo.InformationVersion = ${AssemblyInfo.InformationVersion}")

    /*****************************************/

    // 피보나치 수열 출력 함수 호출
    println(fibonacciIterative(10))
    println(fibonacciIterative2(10))
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