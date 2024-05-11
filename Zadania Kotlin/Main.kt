fun main() {
    println("Suma 10 i 3 to: ${sum(10, 3)}")
    println("Czy 3 jest parzysta? ${isEven(3)}")
    println("Większa z liczb 7 i 10 to: ${maxOf(7, 10)}")
    println("Długość słowa 'Kotlin' to: ${stringLength("Kotlin")}")
    println("Po kapitalizacji 'kotlin': ${capitalizeFirst("kotlin")}")
    println("Silnia liczby 5 to: ${factorial(5)}")
    println("Liczby parzyste do 10: ${evenNumbers(10)}")
    println("Czy 'kajak' jest palindromem? ${isPalindrome("kajak")}")
    println("Liczby większe od 10 z listy [8, 23, 14, 2]: ${filterGreaterThanTen(listOf(8, 23, 14, 2))}")
    printList(listOf("Kotlin", "is", "fun"))
}
/**
 * 1
 * Zwraca sumę dwóch liczb całkowitych.
 * @param a pierwsza liczba całkowita
 * @param b druga liczba całkowita
 * @return suma `a` i `b`
 */
fun sum(a: Int, b: Int): Int {
    return a + b
}
/**
 * 2
 * Sprawdza, czy liczba jest parzysta.
 * @param number liczba do sprawdzenia
 * @return `true` jeśli liczba jest parzysta, `false` w przeciwnym razie
 */
fun isEven(number: Int): Boolean {
    return number % 2 == 0
}
/**
 * 3
 * Zwraca większą z dwóch liczb.
 * @param x pierwsza liczba do porównania
 * @param y druga liczba do porównania
 * @return większa liczba z `x` i `y`
 */
fun maxOf(x: Int, y: Int): Int {
    return if (x > y) x else y
}
/**
 * 4
 * Zwraca długość podanego ciągu znaków.
 * @param str ciąg znaków do zmierzenia
 * @return długość ciągu znaków `str`
 */
fun stringLength(str: String): Int {
    return str.length
}
/**
 * 5
 * Zwraca ciąg znaków z wielką pierwszą literą.
 * @param str ciąg znaków do transformacji
 * @return ciąg znaków z wielką pierwszą literą
 */
fun capitalizeFirst(str: String): String {
    return str.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}
/**
 * 6
 * Oblicza silnię liczby całkowitej.
 * @param n liczba, dla której ma być obliczona silnia
 * @return silnia liczby `n`
 */
fun factorial(n: Int): Int {
    var result = 1
    for (i in 1..n) {
        result *= i
    }
    return result
}
/**
 * 7
 * Tworzy listę liczb parzystych od 1 do podanej liczby.
 * @param upTo liczba, do której generowana jest lista
 * @return lista liczb parzystych
 */
fun evenNumbers(upTo: Int): List<Int> {
    return (1..upTo).filter { it % 2 == 0 }
}
/**
 * 8
 * Sprawdza, czy ciąg znaków jest palindromem.
 * @param str ciąg znaków do sprawdzenia
 * @return `true` jeśli `str` jest palindromem, `false` w przeciwnym razie
 */
fun isPalindrome(str: String): Boolean {
    return str == str.reversed()
}
/**
 * 9
 * Filtruje listę liczb całkowitych, zwracając tylko te większe od 10.
 * @param numbers lista liczb do przefiltrowania
 * @return lista liczb większych od 10
 */
fun filterGreaterThanTen(numbers: List<Int>): List<Int> {
    return numbers.filter { it > 10 }
}
/**
 * 10
 * Wypisuje wszystkie elementy listy.
 * @param items lista elementów do wyświetlenia
 */
fun printList(items: List<String>) {
    items.forEach { println(it) }
}






