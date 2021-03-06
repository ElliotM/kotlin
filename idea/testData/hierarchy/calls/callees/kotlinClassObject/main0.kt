class KA {
    val name = "A"
    fun foo(s: String): String = "A: $s"
}

fun packageFun(s: String): String = s

val packageVal = ""

open class KClientBase {

}

class KClient: KClientBase() {
    class <caret>object {
        val bar = run {
            val localVal = packageFun("")

            KA().foo(KA().name)
            JA().foo(JA().name)
            packageFun(localVal)
        }

        fun bar() {
            KA().foo(KA().name)
            JA().foo(JA().name)
        }
    }

    {
        fun localFun(s: String): String = packageFun(s)


        KA().foo(KA().name)
        JA().foo(JA().name)
        localFun(packageVal)
    }
}