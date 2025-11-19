package com.jesse.financeapp.repository

import com.jesse.financeapp.domain.ExpenseDomain

class MainRepository {
    val items = mutableListOf(
        ExpenseDomain("Restaurant", 12.50, "restaurant", "17 jun 2025 08:30"),
        ExpenseDomain("McDonald", 573.12, "mcdonald", "17 jun 2025 12:45"),
        ExpenseDomain("Restaurant", 4.25, "restaurant", "17 jun 2025 18:10"),
        ExpenseDomain("Cinema", 27.75, "cinema", "17 jun 2025 21:00"),
    )
}