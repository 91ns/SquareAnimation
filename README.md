# Light-Wall
Light Wall Animation for Android

## Try it 

[Download Demo App](https://play.google.com/store/apps/details?id=com.nourshalabi.squareanimation)

![Light Wall](https://github.com/91ns/Light-Wall/blob/master/giphy.gif)

## Usage

```
   LightWall lightWall = findViewById(R.id.lightWall);
   
   // Create an array of colors for the animation
   String[] lights = new String[]{"#2f0727", "#854277", "#c192b8", "#f1d0ee", "#da81af"};
   
   // Pass the desired number of Columns and colors array
   lightWall.animateLightWall(6, lights);

```

## Import

```				
 allprojects {
    repositories {
        ...
        maven {
            url "https://jitpack.io"
        
        }
    }
 }
 ```

```
	dependencies {
	        implementation 'com.github.91ns:SquareAnimation:1.0.0'
	}
```
