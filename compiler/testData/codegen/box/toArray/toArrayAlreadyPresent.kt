import java.util.Arrays

class MyCollection<T>(val delegate: Collection<T>): Collection<T> by delegate {
    public fun toArray(): Array<Any?> = Array<Any?>(3, { it })
    public fun <E> toArray(array: Array<E>): Array<E> {
        val asIntArray = array as Array<Int>
        asIntArray[0] = 0
        asIntArray[1] = 1
        asIntArray[2] = 2
        return array
    }
}

fun box(): String {
    val collection = MyCollection(Arrays.asList(2, 3, 9)) as java.util.Collection<*>

    val array1 = collection.toArray()
    val array2 = collection.toArray(Array<Int>(3, { 0 }))

    if (array1 !is Array<Any>) return (array1 as Object).getClass().toString()
    if (array2 !is Array<Int>) return (array2 as Object).getClass().toString()

    val s1 = Arrays.toString(array1)
    val s2 = Arrays.toString(array2)

    if (s1 != "[0, 1, 2]") return "s1 = $s1"
    if (s2 != "[0, 1, 2]") return "s2 = $s2"

    return "OK"
}