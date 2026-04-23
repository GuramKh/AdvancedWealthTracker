package com.guram.wealthtracker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.guram.wealthtracker.R
import com.guram.wealthtracker.WealthManager
import com.guram.wealthtracker.databinding.FragmentAnalyticsBinding
import com.guram.wealthtracker.fragments.InputFragment.Companion.KEY_EXPENSES
import com.guram.wealthtracker.fragments.InputFragment.Companion.KEY_INCOME
import com.guram.wealthtracker.fragments.InputFragment.Companion.REQUEST_KEY
import java.text.DecimalFormat
import java.util.Locale

class AnalyticsFragment : Fragment() {
    private var _binding: FragmentAnalyticsBinding? = null
    private val binding get() = _binding!!
    private val fmt = DecimalFormat("#,##0.00")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnalyticsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gkLiTvKValue.text = getString(R.string.analytics_k_value,
            String.format(Locale.getDefault(), "%.4f", WealthManager.K))

        parentFragmentManager.setFragmentResultListener(
            REQUEST_KEY,
            viewLifecycleOwner
        ) { _, bundle ->
            val income   = bundle.getDouble(KEY_INCOME)
            val expenses = bundle.getDouble(KEY_EXPENSES)
            displayResults(income, expenses)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun displayResults(income: Double, expenses: Double) {
        binding.gkLiTvPlaceholder.visibility = View.GONE

        val finalSavings = WealthManager.calculateFinalSavings(income, expenses)
        val netBalance = WealthManager.calculateNetBalance(income, expenses)
        val savingsRate = WealthManager.calculateSavingsRate(income, expenses)
        val status = WealthManager.getFinancialStatus(income, expenses)

        binding.gkLiTvIncomeResult.text = getString(R.string.analytics_income, fmt.format(income))
        binding.gkLiTvExpensesResult.text = getString(R.string.analytics_expenses, fmt.format(expenses))
        binding.gkLiTvNetBalance.text = getString(R.string.analytics_net_balance, fmt.format(netBalance))
        binding.gkLiTvFinalSavings.text = getString(R.string.analytics_final_savings, fmt.format(finalSavings))
        binding.gkLiTvSavingsRate.text = getString(R.string.analytics_savings_rate, String.format(
            Locale.getDefault(), "%.1f", savingsRate))
        binding.gkLiTvStatus.text = status

        val colorRes = if (netBalance >= 0) R.color.surplus_green else R.color.deficit_red
        val color = ContextCompat.getColor(requireContext(), colorRes)
        binding.gkLiTvFinalSavings.setTextColor(color)
        binding.gkLiTvStatus.setTextColor(color)
    }
}
