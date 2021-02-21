
![MavenCentral](https://maven-badges.herokuapp.com/maven-central/dev.assemblage/unread-indicator/badge.svg)

# Unread Indicator
A custom view which can be used to show an un-read indicator on the top right corner.
The indicator is drawn as a triangle in half the area of the specified height and width.

## Example

![sample](/assets/example.png)

## Installation

Add the below line in the dependency block of your app's `build.gradle`

```groovy
implementation("dev.assemblage:unread-indicator:$sdkVersion")
```
replace `$sdkVersion` with the latest version of the SDK

## Usage

```xml
  <com.umang.unreadindicator.UnreadIndicator
      android:layout_width="12dp"
      android:layout_height="12dp"
      app:indicatorColor="@color/indicator_color"
    />
``` 