package com.rahamankhata.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.rahamankhata.app.ui.screens.*
import com.rahamankhata.app.ui.theme.RahamanKhataTheme
import com.rahamankhata.app.ui.viewmodel.KhataViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val app = application as RahamanKhataApp
        
        setContent {
            RahamanKhataTheme {
                val navController = rememberNavController()
                val viewModel: KhataViewModel = viewModel(
                    factory = object : androidx.lifecycle.ViewModelProvider.Factory {
                        override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                            @Suppress("UNCHECKED_CAST")
                            return KhataViewModel(app.database) as T
                        }
                    }
                )

                Scaffold(
                    bottomBar = {
                        RahamanKhataBottomBar(navController = navController)
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "dashboard",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("dashboard") { DashboardScreen(viewModel, navController) }
                        composable("customers") { CustomersScreen(viewModel, navController) }
                        composable("ledger/{customerId}") { backStackEntry ->
                            val customerId = backStackEntry.arguments?.getString("customerId") ?: ""
                            CustomerLedgerScreen(customerId, viewModel, navController)
                        }
                        composable("add_transaction") { AddTransactionScreen(viewModel, navController) }
                        composable("expenses") { ExpensesScreen(viewModel, navController) }
                        composable("reports") { ReportsScreen(viewModel, navController) }
                        composable("settings") { SettingsScreen(viewModel, navController) }
                    }
                }
            }
        }
    }
}
