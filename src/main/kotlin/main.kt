import java.lang.RuntimeException

data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Long = System.currentTimeMillis()/1000,
    val text: String = "Hello world",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val comments: Comments = Comments(),
    val copyright: String? = null,
    val likes: Likes = Likes(),
    val reposts: Reposts = Reposts(),
    val views: Views = Views(),
    val postType: String? = null,
    val postSource: PostSource? = null, // сделать класс
    val attachments: Array<Attachment> = emptyArray(),
    val geo: Geo = Geo(),
    val singerId: Int = 0,
    val copyHistory: Array<Int>? = null,
    val canPin: Boolean = true,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val postponedId: Int = 0,
)





data class Comments(
    val count: Int = 0,
    val canPost: Boolean = true,
)

data class Likes(
    val count: Int = 0,
    val userLikes: Boolean = false,
    val canLike: Boolean = false,
    val canPublish: Boolean = false
)

data class Reposts(
    val count: Int = 0,
    val userReposed: Boolean = false
)
data class Views(
    val count: Int = 0,
)

data class PostSource(
    val key: Long = 0, // найти инфу что должен содержать класс
)

data class Geo(
    val type: String? = null,
    val coordinates: String? = null,
    val place: Place? = null
)

data class Place(
    val place: String? = null
)

object WallService {
    private var posts = emptyArray<Post>()
    private var postsId = 1
    private var  commentId = 1
    private var comments = emptyArray<Comment>()

    fun add (post: Post): Post {
        val postTemp = post.copy(id = postsId)
        posts += postTemp
        postsId ++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postTemp) in  posts.withIndex()) {
            if (post.id == postTemp.id) {
                posts[index] = post
                return true
            }
        }
        return false
    }

    fun createComment(postId: Int, comment: Comment) : Comment {
        for ((index, postTemp) in  posts.withIndex()) {
            if (postId == postTemp.id){
                comments += comment
                return comments.last()
            }
        }
        return throw PostNotFoundException("Пост не найден")

    }
}

class PostNotFoundException (message: String) : RuntimeException(message)

fun main() {
    val post = Post()
    val comment = Comment()
    val comment2 = Comment()
    WallService.add(post)
    println( WallService.createComment(1, comment))
    println(WallService.createComment(2, comment2))
}
