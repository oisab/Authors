package com.oisab.authors

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AuthorsListFragment : Fragment(R.layout.authors_list_fragment) {
    private val authorsAdapter = AuthorsAdapter()
    private lateinit var authorsView: RecyclerView

    companion object {
        fun newInstance(): AuthorsListFragment {
            return AuthorsListFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authorsView = view.findViewById(R.id.authorsView)
        authorsView.adapter = authorsAdapter
        authorsView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        generateData()
    }

    private fun generateData() {
        authorsAdapter.setData(
                ArrayList<CellModel>().apply {
                    add(CellModel("Jack London", R.drawable.ic_launcher_foreground))
                    add(CellModel("Erich Maria Remarque", R.drawable.ic_launcher_foreground))
                    add(CellModel("Oldos Hacksley", R.drawable.ic_launcher_foreground))
                    add(CellModel("George Orwell", R.drawable.ic_launcher_foreground))
                    add(CellModel("Charles Algernon", R.drawable.ic_launcher_foreground))
                    add(CellModel("Antonie de Saint-Exupery", R.drawable.ic_launcher_foreground))
                    add(CellModel("Hermann Hesse", R.drawable.ic_launcher_foreground))
                    add(CellModel("Markus Aurelius", R.drawable.ic_launcher_foreground))
                    add(CellModel("Epictetus", R.drawable.ic_launcher_foreground))
                    add(CellModel("Benedict de Spinoza", R.drawable.ic_launcher_foreground))
                    add(CellModel("Herbert Spencer", R.drawable.ic_launcher_foreground))
                    add(CellModel("Arthur Schopenhauer", R.drawable.ic_launcher_foreground))
                    add(CellModel("Friedrich Nietzsche", R.drawable.ic_launcher_foreground))
                    add(CellModel("Immanuel Kant", R.drawable.ic_launcher_foreground))
                    add(CellModel("Rene Dekart", R.drawable.ic_launcher_foreground))
                    add(CellModel("David Kahn", R.drawable.ic_launcher_foreground))
                    add(CellModel("Bruce Schneier", R.drawable.ic_launcher_foreground))
                })
    }
}