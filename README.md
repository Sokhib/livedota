# livedota
Sample Dota 2 eSports matches, leagues app based on MVVM architecture. 

<h1>Screenshots</h1>
<p align="center">
  <img src="https://github.com/Sokhib/livedota/blob/feature-branch/app/src/main/res/drawable/screenshot1.jpg" width="200" title="Match Details" alt="Match Details">
  <img src="https://github.com/Sokhib/livedota/blob/feature-branch/app/src/main/res/drawable/screenshot2.jpg" width="200" title="Favored Matches" alt="Favored Matches">
  <img src="https://github.com/Sokhib/livedota/blob/feature-branch/app/src/main/res/drawable/screenshot3.jpg" width="200" title="Matches" alt="Matches">
  <img src="https://github.com/Sokhib/livedota/blob/feature-branch/app/src/main/res/drawable/screenshot4.jpg" width="200" title="Matches" alt="Matches">
</p>
<h1>Tech stack & Open-source libraries</h1>
<ul>
<li><a href="https://kotlinlang.org/" rel="nofollow">Kotlin</a> based </li>
<li><a href="https://github.com/Kotlin/kotlinx.coroutines">Coroutines + Flow </a></li>
<li> Architecture Components
<ul>
<li>LiveData - observable data holder.</li>
<li>Databinding - for binding UI components in your layouts to data sources in your app.</li>
<li>ViewModel - lifecycle aware for storing and managing UI-related data.</li>
<li>Room Database - provides an abstraction layer over SQLite</li>
</ul>
</li>
<li>Architecture
<ul>
<li>MVVM Architecture (Model - View - ViewModel)</li>
<li>Repository pattern</li>
</ul>
</li>
<li><a href="https://dagger.dev/">Dagger 2 </a> - dependency injection</li>
<li><a href="https://github.com/square/retrofit">Retrofit2 &amp; Gson</a> - constructing the REST API</li>
<li><a href="https://github.com/square/okhttp">OkHttp3</a> - used as logging interceptor </li>
<li><a href="https://github.com/bumptech/glide">Glide</a> - for loading images </li>
<li><a href="https://github.com/JakeWharton/timber">Timber</a> - logging</li>
</ul>
