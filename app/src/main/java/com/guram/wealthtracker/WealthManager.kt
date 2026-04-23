package com.guram.wealthtracker

object WealthManager {

    private const val NAME_LETTERS    = 5
    private const val SURNAME_LETTERS = 11
    private const val BIRTH_DAY       = 30

    val K: Double = (NAME_LETTERS + SURNAME_LETTERS).toDouble() / BIRTH_DAY.toDouble()

    fun calculateFinalSavings(income: Double, expenses: Double): Double =
        (income - expenses) * K

    fun calculateNetBalance(income: Double, expenses: Double): Double =
        income - expenses

    fun calculateSavingsRate(income: Double, expenses: Double): Double {
        if (income <= 0.0) return 0.0
        return ((income - expenses) / income) * 100.0
    }

    fun getFinancialStatus(income: Double, expenses: Double): String {
        val net = calculateNetBalance(income, expenses)
        return when {
            net > 0 -> "Status: Surplus"
            net == 0.0 -> "Status: Break-even"
            else -> "Status: Deficit"
        }
    }
}
