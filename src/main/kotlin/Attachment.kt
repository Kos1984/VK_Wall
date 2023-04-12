abstract class Attachment {
    abstract val type: Any
}

class Photo () : Attachment() {
    override val type: Any = PhotoAttach()
}

data class PhotoAttach(
    val id: Int = 0 ,
    val albumId: Int = 0,
    val ownerId: Int = 0,
    val userId: Int = 0,
    val text: String? = null,
    val date: Long = 0,
    val size: Array<PhotoCopy> = emptyArray(),
    val width: Int = 0,
    val height: Int = 0
)

class PostedPhoto(
) : Attachment(){
    override val type: Any = PostedPhotoAttach()
}

data class PostedPhotoAttach(
    val id: Int = 0,
    val ownerId: Int = 0,
    val photo130: String? = null,
    val photo604: String? = null
)

class Audio( ) : Attachment(){
    override val type: Any = AudioAttach()
}

data class AudioAttach(
    val id: Int = 0,
    val ownerId: Int = 0,
    val artist: String? = null,
    val title: String? = null,
    val duration: Int = 0,
    val url: String? = null,
    val lyricsId: Int = 0,
    val albumId: Int = 0,
    val genreId: Int = 0,
    val date: Int = 0,
    val noSearch: Boolean = true,
    val isHq: Boolean = false
)
// ToDO описать класс
class Document() : Attachment(){
    override val type: Any = DocumentAttach()
}

data class DocumentAttach(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String? = null,
    val size: Int = 0,
    val ext: String? = null,
    val url: String? = null,
    val date: Int = 0,
    val typeDocument: Int = 0,
    val preview: Preview = Preview() // ToDO описать класс
)

class Link() : Attachment(){
    override val type: Any = LinkAttach()
}

data class LinkAttach(
    val url: String? = null,
    val title: String? = null,
    val caption: String? = null,
    val descriptionLink: String? = null,
    val photo: Photo? = null,
    val product: Product? = null,
    val button: Button? = null,
    val previewPage: String? = null,
    val previewUrl: String? = null
)

class Note() : Attachment(){
    override val type: Any = NoteAttach()
}

data class NoteAttach(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String? = null,
    val text: String? = null,
    val date: Int = 0,
    val comments: Int = 0,
    val readComments: Int = 0,
    val viewUrl: String? = null ,
)

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