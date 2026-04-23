package com.guram.wealthtracker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.guram.wealthtracker.databinding.FragmentInputBinding

class InputFragment : Fragment() {
    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gkLiBtnSave.setOnClickListener { onSaveClicked() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onSaveClicked() {
        if (!validateInputs()) return

        val income = binding.gkLiEtIncome.text.toString().toDouble()
        val expenses = binding.gkLiEtExpenses.text.toString().toDouble()

        val result = Bundle().apply {
            putDouble(KEY_INCOME, income)
            putDouble(KEY_EXPENSES,expenses)
        }

        parentFragmentManager.setFragmentResult(REQUEST_KEY, result)

        Toast.makeText(requireContext(), "Data saved. Check Analytics tab.", Toast.LENGTH_SHORT).show()
    }

    private fun validateInputs(): Boolean {
        var valid = true

        val incomeStr = binding.gkLiEtIncome.text.toString().trim()
        val expensesStr = binding.gkLiEtExpenses.text.toString().trim()

        if (incomeStr.isEmpty()) {
            binding.gkLiEtIncome.error = "Income is required"
            valid = false
        } else {
            val income = incomeStr.toDoubleOrNull()
            if (income == null) {
                binding.gkLiEtIncome.error = "Enter a valid number"
                valid = false
            } else if (income < 0) {
                binding.gkLiEtIncome.error = "Income cannot be negative"
                valid = false
            } else {
                binding.gkLiEtIncome.error = null
            }
        }

        if (expensesStr.isEmpty()) {
            binding.gkLiEtExpenses.error = "Expenses are required"
            valid = false
        } else {
            val expenses = expensesStr.toDoubleOrNull()
            if (expenses == null) {
                binding.gkLiEtExpenses.error = "Enter a valid number"
                valid = false
            } else if (expenses < 0) {
                binding.gkLiEtExpenses.error = "Expenses cannot be negative"
                valid = false
            } else {
                binding.gkLiEtExpenses.error = null
            }
        }

        return valid
    }

    companion object {
        const val REQUEST_KEY = "wealth_data"
        const val KEY_INCOME = "income"
        const val KEY_EXPENSES = "expenses"
    }
}
