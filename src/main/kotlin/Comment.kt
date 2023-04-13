data class Comment (
    val id: Int = 0,
    val fromId: Int = 0,
    val date: Long = 0,
    val text: String? = null,
    val donat: Donat = Donat(),
    val replyToUser: Int = 0,
    val replyToComment: Int = 0,
    val attachments: Attachment? = null,
    val parentsStack: IntArray? = null,
    val thread: Thread = Thread(),
)

data class Donat (
    val isDonat: Boolean = false,
    val placeholder: String? = null,
)

data class Thread (
    val count: Int = 0,
    val items: Array<Any>? = null, // ToDo надо ли описывать класс Items
    val canPost: Boolean = true,
    val showReplyButton: Boolean = true,
    val groupsCanPost: Boolean =true,
)