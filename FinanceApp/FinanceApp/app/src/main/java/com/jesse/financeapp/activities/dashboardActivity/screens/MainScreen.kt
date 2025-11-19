package com.jesse.financeapp.activities.dashboardActivity.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jesse.financeapp.activities.dashboardActivity.components.ActionButtonRow
import com.jesse.financeapp.activities.dashboardActivity.components.CardSection
import com.jesse.financeapp.activities.dashboardActivity.components.ExpenseItem
import com.jesse.financeapp.activities.dashboardActivity.components.HeaderSection
import com.jesse.financeapp.domain.ExpenseDomain

@Composable
fun MainScreen(
    onCardClick: () -> Unit = {},
    expenses: List<ExpenseDomain>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item { HeaderSection() }
            item { CardSection(onCardClick) }
            item { ActionButtonRow() }

            items(expenses) {item -> ExpenseItem(item) }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    val expenses = listOf(
        ExpenseDomain("Restaurant", 12.50, "restaurant", "17 jun 2025 08:30"),
        ExpenseDomain("McDonald", 53.12, "mcdonald", "17 jun 2025 12:45"),
        ExpenseDomain("Restaurant", 573.25, "restaurant", "17 jun 2025 18:10"),
        ExpenseDomain("Cinema", 87.75, "cinema", "17 jun 2025 21:00"),
    )
    MainScreen(expenses = expenses)
}
