package com.guram.wealthtracker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.guram.wealthtracker.R
import com.guram.wealthtracker.WealthManager
import com.guram.wealthtracker.databinding.FragmentProfileBinding
import java.util.Locale

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gkLiTvProfileName.text =
            getString(R.string.name_guram)

        binding.gkLiTvProfileSurname.text =
            getString(R.string.surname_khakhutashvili)

        binding.gkLiTvProfileGroup.text =
            getString(R.string.group_2)

        binding.gkLiTvProfilePrefix.text =
            getString(R.string.resource_id_prefix_gk_li)

        binding.gkLiTvProfileOrientation.text = getString(R.string.profile_orientation)

        binding.gkLiTvProfileFormula.text = getString(R.string.profile_formula)

        binding.gkLiTvProfileKResult.text = getString(R.string.profile_k_result, String.format(
            Locale.getDefault(), "%.4f", WealthManager.K))

        binding.gkLiTvProfileSavingsFormula.text =
            getString(R.string.final_savings_income_expenses_x_k)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
