# CurrencyEditText
[![](https://jitpack.io/v/SWRevo/CurrencyEditText.svg)](https://jitpack.io/#SWRevo/CurrencyEditText)

## Implementation in Android Studio
## Gradle
Add the following to your `build.gradle` to use:
```
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.SWRevo:FloatSlideUpSheet:1.4.0'
}
```
## Implementation in Sketchware
Version 1.5.0 uses material component version 1.0.0 and appcompat 1.0.0 for support in Sketchware
Add the following to your Sketchware `local_library` download use:
```
dependencies {
    implementation 'com.github.SWRevo:FloatSlideUpSheet:1.5.0'
}
```

## Usage
## KOTLIN

```java

class FloatingSlideUpSheetActivity : AppCompatActivity() {

    private var slideContent : FloatingSlideUpLayout? = null
    private var containerFloatingMenu : LinearLayout? = null
    private var contentExpandContainer : LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        slideContent = findViewById(R.id.slide_conten)
        containerFloatingMenu = findViewById(R.id.container_floating_menu)
        contentExpandContainer = findViewById(R.id.content_expand_container)
        initView()
    }


    @SuppressLint("ResourceAsColor")
    private fun initView() {
        val floatingSlideUpSheet =   FloatingSlideUpBuilder(this, slideContent!!)
                .setFloatingMenuRadiusInDp(32)
                .setFloatingMenuColor(android.R.color.white)
                .setFloatingMenu(containerFloatingMenu!!)
                .setPanel(contentExpandContainer!!)
                .build()


    }

}

```

## JAVA

```java

public class FloatingSlideUpActivity extends AppCompatActivity {

    private FloatingSlideUpLayout slideContent;
    private LinearLayout containerFloatingMenu;
    private LinearLayout contentExpandContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slideContent = findViewById(R.id.slide_conten);
        containerFloatingMenu = findViewById(R.id.container_floating_menu);
        contentExpandContainer = findViewById(R.id.content_expand_container);
        initView();
    }

    @SuppressLint("ResourceAsColor")
    private void initView() {
        FloatingSlideUpBuilder floatingSlideUpSheet = new FloatingSlideUpBuilder(this, slideContent);
        floatingSlideUpSheet.setFloatingMenuRadiusInDp(32);
        floatingSlideUpSheet.setFloatingMenuColor(android.R.color.white);
        floatingSlideUpSheet.setFloatingMenu(containerFloatingMenu);
        floatingSlideUpSheet.setPanel(contentExpandContainer);
        floatingSlideUpSheet.build();
    }
}

```

## License
This project is sourced and wholly thought of https://github.com/rizmaulana/floating-slideup-sheet/blob/master/README.MD
I am IndoSW is a project modifier to support JAVA and Sketchware users

MIT License

Copyright (c) [2021] [IndoSW]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
