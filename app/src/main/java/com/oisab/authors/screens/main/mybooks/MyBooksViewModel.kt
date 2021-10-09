package com.oisab.authors.screens.main.mybooks

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oisab.authors.R

class MyBooksViewModel : ViewModel() {
    val items = MutableLiveData<MutableList<CellMyBook>>()

    fun generateData() {
        items.postValue(
            ArrayList<CellMyBook>().apply {
                add(CellMyBook("Мартин Иден", "Джек Лондон", R.drawable.ic_launcher_foreground))
                add(CellMyBook("Мастер и Маргарита", "Михаил Булгаков", R.drawable.ic_launcher_foreground))
                add(CellMyBook("Три товарища", "Эрих Мария Ремарк", R.drawable.ic_launcher_foreground))
                add(CellMyBook("Тихий Дон", "Михаил Шолохов", R.drawable.ic_launcher_foreground))
                add(CellMyBook("Атлант расправил плечи", "Айн Рэнд", R.drawable.ic_launcher_foreground))
                add(CellMyBook("Как закалялась сталь", "Николай Островский", R.drawable.ic_launcher_foreground))
                add(CellMyBook("О дивный новый мир", "Олдос Хаксли", R.drawable.ic_launcher_foreground))
                add(CellMyBook("Поднятая целина", "Михаил Шолохов", R.drawable.ic_launcher_foreground))
                add(CellMyBook("Господин из Сан-Франциско", "Иван Бунин", R.drawable.ic_launcher_foreground))
                add(CellMyBook("Солнечный удар", "Иван Бунин", R.drawable.ic_launcher_foreground))
                add(CellMyBook("Алхимик", "Пауло Коэльо", R.drawable.ic_launcher_foreground))
                add(CellMyBook("1984", "Джордж Оруэлл", R.drawable.ic_launcher_foreground))
                add(CellMyBook("Наедине с собой. Размышления.", "Марк Аврелий", R.drawable.ic_launcher_foreground))
                add(CellMyBook("Обломов", "Иван Гончаров", R.drawable.ic_launcher_foreground))
                add(CellMyBook("Война и мир", "Лев Толстой", R.drawable.ic_launcher_foreground))
            }
        )
    }
}