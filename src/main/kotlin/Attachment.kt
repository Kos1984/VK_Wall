

abstract class Attachment {
    abstract val type: String
}

data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Long,
    val size: Array<PhotoCopy> = emptyArray(),
    val width: Int,
    val height: Int
) : Attachment() {
    override val type: String = "Photo"
}

data class PostedPhoto(
    val id: Int = 0,
    val ownerId: Int = 0,
    val photo130: String? = null,
    val photo604: String? = null
) : Attachment(){
    override val type: String = "Posted Photo"
}



data class Audio(
     val id: Int,
     val ownerId: Int,
     val artist: String,
     val title: String,
     val duration: Int,
     val url: String,
     val lyricsId: Int,
     val albumId: Int,
     val genreId: Int,
     val date: Int,
     val noSearch: Boolean = true,
     val isHq: Boolean = false
) : Attachment(){
     override val type: String = "Audio"
 }
// ToDO описать класс
data class Document(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
    val typeDocument: Int,
    val preview: Preview = Preview() // ToDO описать класс
) : Attachment(){
    override val type: String = "Document"
}

data class Link(
    val url: String,
    val title: String,
    val caption: String,
    val descriptionLink: String,
    val photo: Photo? = null, //ToDo может объееденить ?
    val product: Product?, // ToDO описать класс
    val button: Button?, // ToDO описать класс
    val previewPage: String,
    val previewUrl: String
) : Attachment(){
    override val type: String = "Link"
}

data class Note(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val text: String,
    val date: Int,
    val comments: Int,
    val readComments: Int,
    val viewUrl: String,
) : Attachment(){
    override val type: String = "Note"

}
// ToDO поправить данные в классе
data class PhotoCopy(
    val type: String? = null,
    val url: String? = null,
    val width: Int = 0,
    val height: Int = 0,
)

data class Preview(
    val photo: PostedPhoto = PostedPhoto(),
    val sizes: Array<PhotoCopy> = emptyArray(),
    val graffiti: Graffiti = Graffiti(),
    val audioMessage: AudioMessage = AudioMessage(),
)

data class Graffiti(
    val src: String? = null,
    val width: Int = 0,
    val height: Int = 0
)

data class AudioMessage(
    val duration: Int = 0,
    val waveform: IntArray? = null,
    val linkOgg: String? = null,
    val linkMp3: String? = null,
)

data class Product(
    val price: Price? = null,
)

data class Price (
    val amount: Int = 0, // ToDo Целочисленное значение цены, умноженное на 100
    val currency: Currency? = null,
    val text: String? = null,
)

data class Currency(
    val id: Int = 0,
    val name: String? = null,

)

data class Button (
    val title: String? = null,
    val action: Action? = null,
)

data class Action(
    val title: String? = null,
    val url: String? = null,
)