# Fling

***Modernizing Swing's Pattern***

## Motive

Swing has been the go-to GUI toolkit for Java Developers for over 25+ years because it comes with the JDK. It is 
easy to use with a plethora of components paired with an intuitive imperative design. Swing is simple to use, that 
is what makes it fun, but with Kotlin becoming more and more popular along with the UI ecosystem shifting towards a 
declarative doctrine, Swing shows its outdated patterns. Not only do these outdated patterns increase development 
time, but also boilerplate and eventually becoming a productivity killer.

Fling shifts this productivity killing pattern to a more modern approach by using declarative syntax. 
This 
is done by mapping a lot of normal Swing types to composable functions similar to Jetpack Compose. At the same time, 
Fling introduces a lot of additional layout components to help with reducing boilerplate for common 
layouts like rows and columns. Here are some comparisons

### Comparison #1

> Creating 2 buttons on a vertical flex layout.

**Swing**

```kotlin 
val col = JPanel().apply {       
    layout = BoxLayout(this, BoxLayout.Y_AXIS)      
    add(JButton("Button 1").apply { addActionListener { print("Hello World!") } })
    add(JButton("Button 2"))
}
```

**Fling**
```kotlin 
col {      
    +button("Button 1") { print("Hello World!") }       
    +button("Button 2")  
}  
```

### Comparison #2

> Making a label and button where the button increments the text on the label (counter).

#### Swing

```kotlin
val panel = JPanel().apply {
    layout = BorderLayout() // not required & not counted
    val counter = 0
    val label = JLabel("Count: $counter")
    add(label, BorderLayout.CENTER)
    add(JButton("Increment").apply {
        addActionListener {
            label.text = "Count: ${++counter}"
        }
    }, BorderLayout.SOUTH)
}
```

#### Fling

*Please note that Composable*

```kotlin
val counter = remember(0)
val counterLabel = label("Count: ${counter()}")
counter.observe {
    counterLabel.text = "Count: ${counter()}"
}
+scaffold(
    center = {
        +counterLabel
    },
    south = {
        +button("Increment") {
            counter(counter() + 1)
        }
    }
)
```




