package adventofcode.day14

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.Test

class CalculatorTest {

    private val pairInsertionStub = mapOf(
        "CH" to "B",
        "HH" to "N",
        "CB" to "H",
        "NH" to "C",
        "HB" to "C",
        "HC" to "B",
        "HN" to "C",
        "NN" to "C",
        "BH" to "H",
        "NC" to "B",
        "NB" to "B",
        "BN" to "B",
        "BB" to "N",
        "BC" to "B",
        "CC" to "N",
        "CN" to "C",
    )

    companion object {
        @JvmStatic
        fun paramsCompleted() = listOf(
            Arguments.of(6, 2, "NBCCN"),
            Arguments.of(20, 3, "NBBBCNCCN"),
            Arguments.of(50, 4, "NBBNBNBBCCNBCNCCN"),
            Arguments.of(50, 5, "NBBNBBNBBBNBBNBBCNCCNBBBCCNBCNCCN"),
        )

        @JvmStatic
        fun paramsUncompleted() = listOf(
            Arguments.of(10, 5, "NBBNBNBBCCNBCNCCN"),
        )
    }

//    @ParameterizedTest(name = "test the most simple {1} steps - completed")
//    @MethodSource("paramsCompleted")
//    fun `test the most simple steps - completed`(sequenceMaxLength: Int, steps: Int, expectedResult: String) {
//        val calculator = Calculator(
//            sequenceMaxLength = sequenceMaxLength,
//            pairInsertions = pairInsertionStub
//        )
//
//        val calculationResult = calculator.calculate("NN", steps, 1)
//
//        calculationResult.completed shouldBe true
//        calculationResult.sequence shouldBe expectedResult
//    }
//
//    @ParameterizedTest(name = "test the most simple {1} steps - uncompleted")
//    @MethodSource("paramsUncompleted")
//    fun `test the most simple steps - uncompleted`(sequenceMaxLength: Int, steps: Int, expectedResult: String) {
//        val calculator = Calculator(
//            sequenceMaxLength = sequenceMaxLength,
//            pairInsertions = pairInsertionStub
//        )
//
//        val calculationResult = calculator.calculate("NN", steps, 1)
//
//        calculationResult.completed shouldBe false
//        calculationResult.sequence shouldBe expectedResult
//    }
//
//    @Test
//    fun `test Calculation till completion for`() {
//        val calculator = Calculator(
//            sequenceMaxLength = 4,
//            pairInsertions = pairInsertionStub
//        )
//
//        var calculationResult = calculator.calculateTillCompletion(template = "NN", steps = 5)
//
//        calculationResult.completed shouldBe true
//        calculationResult.sequence shouldBe """NBBNBBNBBBNBBNBBCNCCNBBBCCNBCNCCN"""
//    }
}