![GitHub repo size](https://img.shields.io/github/repo-size/cassianasoares/Android-Game-Quiz-With-ROOM)
![GitHub top language](https://img.shields.io/github/languages/top/cassianasoares/Android-Game-Quiz-With-ROOM)
![GitHub last commit](https://img.shields.io/github/last-commit/cassianasoares/Android-Game-Quiz-With-ROOM)


# Android Quiz

A simple quiz game using Room persistence library

![Main](https://user-images.githubusercontent.com/57958790/85030980-80883200-b154-11ea-950e-1f458e55cfb4.png)
![Loading Game State](https://user-images.githubusercontent.com/57958790/85031052-972e8900-b154-11ea-8e67-8f51650ea62b.png)
![Play Chosen Answer](https://user-images.githubusercontent.com/57958790/85031104-a7466880-b154-11ea-8b62-70bfd5c3360c.png)
![Result](https://user-images.githubusercontent.com/57958790/85031227-ce049f00-b154-11ea-90dd-ddb028d16b16.png)


# System Requirements

- Android Studio
- Room persistence library
- LiveData
- ViewModel

# GuideLine

### Note
  If you are interested in knowing your database structure the code below is in the build.glade (Module: app):
  
  ```
  //Create json with code database structure
        javaCompileOptions {
            annotationProcessorOptions {
                arguments = [
                        "room.schemaLocation": "$projectDir/schemas".toString()
                ]
            }
        }
  ```
  
  It will generate a json file that you can find at: Project -> app -> schemas.
  
# Features

- Query, Insert and Delete database

# Credits

- [LoadingView](https://github.com/ldoublem/LoadingView)
