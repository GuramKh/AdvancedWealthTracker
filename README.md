# Advanced Wealth Tracker

**Student:** Guram Khakhutashvili | **Group:** 2

---

## K Coefficient Formula

```
K = (Name letters + Surname letters) / Birth day
K = (5 + 11) / 30
K = 16 / 30
K ≈ 0.5333
```

| Variable       | Value                     |
|----------------|---------------------------|
| Name           | Guram (5 letters)         |
| Surname        | Khakhutashvili (11 letters) |
| Birth day      | 30                        |
| **K**          | **≈ 0.5333**              |

### Final Savings Formula

```
Final Savings = (Income − Expenses) × K
```

---

## Resource ID Naming Convention

**Prefix:** `gk_li_`

- `gk` — initials (Guram **K**hakhutashvili → G + K)
- `li` — last two letters of surname (Khakhutash**vili** → `li`)

Examples:
- `gk_li_et_income`
- `gk_li_et_expenses`
- `gk_li_btn_save`
- `gk_li_tv_final_savings`

---

## ViewPager2 Orientation

Surname **Khakhutashvili** starts with **K** → consonant → **VERTICAL** orientation.

---

## Architecture

- **Single Activity** (`MainActivity`) + **3 Fragments** in ViewPager2
- **No ViewModel** — data transferred via **Fragment Result API** (`setFragmentResult` / `setFragmentResultListener`)
- **`WealthManager.kt`** — all math operations isolated here
- **ConstraintLayout** used for every screen

## Project Structure

```
app/src/main/java/com/guram/wealthtracker/
├── MainActivity.kt
├── WealthManager.kt
├── adapter/
│   └── WealthPagerAdapter.kt
└── fragments/
    ├── InputFragment.kt
    ├── AnalyticsFragment.kt
    └── ProfileFragment.kt
```
