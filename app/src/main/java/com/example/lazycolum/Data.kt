package com.example.lazycolum

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

enum class User { USER_1, USER_2 }

data class Message(val sender: User, val text: String, val timestamp: LocalDateTime)

val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")  // TODO: check wrong pattern. IDE made me decare Type explicitly
val messages = listOf(
    Message(User.USER_1, "Hola, ¿has oído hablar de la programación reactiva en Android?", LocalDateTime.parse("01/01/2021 10:00", formatter)),
    Message(User.USER_2, "No, no he oído hablar de eso. ¿Puedes explicármelo?", LocalDateTime.parse("01/01/2021 10:05", formatter)),
    Message(User.USER_1, "Claro, es un paradigma de programación que se centra en manejar flujos de datos y eventos asíncronos. Fue introducido por primera vez en Android con la aparición de la biblioteca RxJava en 2013 por Netflix", LocalDateTime.parse("01/01/2021 10:10", formatter)),
    Message(User.USER_2, "Entiendo, entonces es una forma de manejar tareas asíncronas de manera más eficiente", LocalDateTime.parse("01/01/2021 10:15", formatter)),
    Message(User.USER_1, "Exacto, se utiliza para manejar tareas como peticiones de red, operaciones de base de datos y entrada de usuario de una forma más eficiente y mantenible. ", LocalDateTime.parse("01/01/2021 10:20", formatter)),
    Message(User.USER_1, "Después, Compose también introdujo un enfoque de programación reactiva en su arquitectura.", LocalDateTime.parse("01/01/2021 10:20", formatter)),
    Message(User.USER_2, "Eso es realmente interesante. Definitivamente investigaré más sobre ello. ¡Gracias por explicarlo!", LocalDateTime.parse("01/01/2021 10:25", formatter))
)
