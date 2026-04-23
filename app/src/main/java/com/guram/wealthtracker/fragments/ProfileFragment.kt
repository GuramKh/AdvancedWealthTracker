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

        binding.apply {
            gkLiTvProfileName.text = getString(R.string.name_guram)
            gkLiTvProfileSurname.text = getString(R.string.surname_khakhutashvili)
            gkLiTvProfileGroup.text = getString(R.string.group_2)
            gkLiTvProfilePrefix.text = getString(R.string.resource_id_prefix_gk_li)
            gkLiTvProfileOrientation.text = getString(R.string.profile_orientation)
            gkLiTvProfileFormula.text = getString(R.string.profile_formula)
            gkLiTvProfileKResult.text = getString(R.string.profile_k_result, String.format(Locale.getDefault(), "%.4f", WealthManager.K))
            gkLiTvProfileSavingsFormula.text = getString(R.string.final_savings_income_expenses_x_k)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
