package com.improve10x.mad

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoryViewModel: ViewModel() {
    private var _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        // Get the data from CategoriesRepository
        viewModelScope.launch {
            val repo = CategoryRepository()
            val response = repo.getCategories()
            _categories.value = response
        }
        // On success, change the state
    }

}