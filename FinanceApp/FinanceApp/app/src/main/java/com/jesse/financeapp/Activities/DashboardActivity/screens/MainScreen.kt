package com.jesse.financeapp.Activities.DashboardActivity.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jesse.financeapp.Domain.ExpenseDomain

@Composable
fun MainScreen(
    onCardClick:()->Unit={},
    expenses: List<ExpenseDomain>
){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) { }
    }
}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview(){
    val expenses = listOf(
        ExpenseDomain("Cafeteria", 12.50, "img1", "17 jun 2025 08:30"),
        ExpenseDomain("Mercado", 573.12, "img2", "17 jun 2025 12:45"),
        ExpenseDomain("Transporte", 4.25, "img3", "17 jun 2025 18:10"),
        ExpenseDomain("Cinema", 27.75, "img4", "17 jun 2025 21:00"),
    )
    MainScreen(expenses=expenses)
}
