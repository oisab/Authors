package com.oisab.authors.screens.main.suggestions

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oisab.authors.R
import com.oisab.authors.data.SuggestedAuthorsListRepository
import com.oisab.authors.data.remote.AuthorsListResponse
import kotlinx.coroutines.*
import javax.inject.Inject

class SuggestedAuthorsViewModel @Inject constructor(private val repository: SuggestedAuthorsListRepository): ViewModel() {

    val items = MutableLiveData<MutableList<CellSuggestedBook>>()
    private var myJob: Job? = null


    fun generateData() {
        items.postValue(
        ArrayList<CellSuggestedBook>().apply {
            add(CellSuggestedBook("Jack London", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBook("Erich Maria Remarque", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBook("Oldos Hacksley", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBook("George Orwell", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBook("Charles Algernon", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBook("Antonie de Saint-Exupery", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBook("Hermann Hesse", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBook("Markus Aurelius", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBook("Epictetus", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBook("Benedict de Spinoza", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBook("Herbert Spencer", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBook("Arthur Schopenhauer", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBook("Friedrich Nietzsche", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBook("Immanuel Kant", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBook("Rene Dekart", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBook("David Kahn", R.drawable.ic_launcher_foreground))
            add(CellSuggestedBook("Bruce Schneier", R.drawable.ic_launcher_foreground))
        })

        myJob = viewModelScope.launch {
            val result = getAuthorsData()
            withContext(Dispatchers.Main) {
                Log.e("TAG", result.toString())
            }
        }
    }

    private suspend fun getAuthorsData(): AuthorsListResponse {
        return repository.fetchAuthorsListAsync()
    }

    override fun onCleared() {
        myJob?.cancel()
        super.onCleared()
    }
}