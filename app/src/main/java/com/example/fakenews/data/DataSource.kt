package com.example.fakenews.data

import com.example.fakenews.R
import com.example.fakenews.domain.NewsInteractor
import com.example.fakenews.presentation.recycler.News

class DataSource{

     var dataList: List<News> = mutableListOf(
        News(
            "Он был там!",
            R.drawable.ic_launcher_foreground,
            "Сарко Дмитрий",
            "01.11.2021",
            "Игры",
            """Студия Playtonic не раз копировала классические платформеры. 
                |Yooka-Laylee похожа на старые игры Rare, в особенности на Banjo-Kazooie, а Yooka-Laylee and the Impossible Lair — на Donkey Kong Country. 
                |Поэтому символично, что именно эта компания выступила издателем Demon Turf, — игры, сильно напоминающей трёхмерные Super Mario.
                |Хотя коллектив независимых разработчиков не смог достичь тех же вершин, которые доступны Nintendo, подобраться ему удалось довольно близко.""".trimMargin()
        ),
        News(
            "Он был там!",
            R.drawable.ic_launcher_foreground,
            "Козел Михаель",
            "03.11.2021",
            "Политика",
            """Студия Playtonic не раз копировала классические платформеры. 
                |Yooka-Laylee похожа на старые игры Rare, в особенности на Banjo-Kazooie, а Yooka-Laylee and the Impossible Lair — на Donkey Kong Country. 
                |Поэтому символично, что именно эта компания выступила издателем Demon Turf, — игры, сильно напоминающей трёхмерные Super Mario.
                |Хотя коллектив независимых разработчиков не смог достичь тех же вершин, которые доступны Nintendo, подобраться ему удалось довольно близко.""".trimMargin()
        ),
        News(
            "Он был там!",
            R.drawable.ic_launcher_foreground,
            "Козел Михаель",
            "02.11.2021",
            "Игры",
            """Студия Playtonic не раз копировала классические платформеры. 
                |Yooka-Laylee похожа на старые игры Rare, в особенности на Banjo-Kazooie, а Yooka-Laylee and the Impossible Lair — на Donkey Kong Country. 
                |Поэтому символично, что именно эта компания выступила издателем Demon Turf, — игры, сильно напоминающей трёхмерные Super Mario.
                |Хотя коллектив независимых разработчиков не смог достичь тех же вершин, которые доступны Nintendo, подобраться ему удалось довольно близко.""".trimMargin()
        ),
        News(
            "Он был там!",
            R.drawable.ic_launcher_foreground,
            "Козел Михаель",
            "01.11.2021",
            "Политика",
            """Студия Playtonic не раз копировала классические платформеры. 
                |Yooka-Laylee похожа на старые игры Rare, в особенности на Banjo-Kazooie, а Yooka-Laylee and the Impossible Lair — на Donkey Kong Country. 
                |Поэтому символично, что именно эта компания выступила издателем Demon Turf, — игры, сильно напоминающей трёхмерные Super Mario.
                |Хотя коллектив независимых разработчиков не смог достичь тех же вершин, которые доступны Nintendo, подобраться ему удалось довольно близко.""".trimMargin()
        ),
        News(
            "Он был там!",
            R.drawable.ic_launcher_foreground,
            "Сарко Дмитрий",
            "02.11.2021",
            "Игры",
            """Студия Playtonic не раз копировала классические платформеры. 
                |Yooka-Laylee похожа на старые игры Rare, в особенности на Banjo-Kazooie, а Yooka-Laylee and the Impossible Lair — на Donkey Kong Country. 
                |Поэтому символично, что именно эта компания выступила издателем Demon Turf, — игры, сильно напоминающей трёхмерные Super Mario.
                |Хотя коллектив независимых разработчиков не смог достичь тех же вершин, которые доступны Nintendo, подобраться ему удалось довольно близко.""".trimMargin()
        )
    )
}