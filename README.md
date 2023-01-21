# MusicWiki

MusicWiki is an unofficial Last.fm app that contains information about different music genres, the albums, artists and tracks listed under the genre.<br>

## Features
The following is a list of the app's features:<br>

1. Users have the ability to browse a comprehensive menu of genres and to explore their desired selection.

2. Upon the selection of a specific genre, the user is presented with information regarding the genre, including the top albums, top tracks, and top artists within that genre. 

3. Users have the ability to select and explore any item from the presented list of top albums, top tracks, and top artists within a selected genre.

4. The app boasts a sleek and modern design.

<br>

## Decisions

The following are the decisions made during the development of the application:<br>
1. The architecture pattern chosen for this application is Model-View-ViewModel (MVVM), as it aligns with the following reasons:<br>

* Separation of concerns: MVVM separates the UI and business logic<br>
* Better code reuse
* Better code readabiliy
* Better performance

2. The library chosen for handling API calls in this application is Retrofit, for the following reasons:
* Simplifies the process of making HTTP requests and handling responses.
* Seamless integration with other libraries such Gson, which can be used for Json parsing.
* Large and active community of developers and contributors
* Given that the application required the capability to parse multiple types of JSON objects, the use of Retrofit proved to be an efficient solution.

3. The image loading library selected for this app  is Glide, for the following reasons:
* Fast and simple
* Uses a memory and disk caching system to avoid reloading images that have already been loaded
* Actively maintained

4. To facilitate inter-fragment communication, the Safe Args library was employed.

5. The dependency injection library used for this is Hilt
* Greatly abstracts the complexity of dependency injection

## Assumptions

The following are the assumptions made during the production of the application: <br>

1.  The data stored on the Last.fm server is expected to remain relatively static. <br>
    In the event that the data on the Last.fm server is dynamic in nature, we would have employed the use of Kotlin flows to monitor and update the data at regular intervals.
