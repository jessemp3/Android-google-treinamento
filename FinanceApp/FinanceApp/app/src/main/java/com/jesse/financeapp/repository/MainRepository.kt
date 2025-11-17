package com.jesse.financeapp.repository

import com.jesse.financeapp.domain.ExpenseDomain

class MainRepository {
    val items = mutableListOf(
        ExpenseDomain("Cafeteria", 12.50, "img1", "17 jun 2025 08:30"),
        ExpenseDomain("Mercado", 573.12, "img2", "17 jun 2025 12:45"),
        ExpenseDomain("Transporte", 4.25, "img3", "17 jun 2025 18:10"),
        ExpenseDomain("Cinema", 27.75, "img4", "17 jun 2025 21:00"),
    )
}