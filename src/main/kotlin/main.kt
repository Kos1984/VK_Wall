data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val text: String = "Hello world",
    val date: Long = System.currentTimeMillis()/1000,
    val copyright: String? = null,
    val friendsOnly: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val comments: Comments = Comments()
)

data class Comments(
    val count: Int = 0,
    val canPost: Boolean = true,

)

object WallService {
    private var posts = emptyArray<Post>()
    private var postsId = 1

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
}

fun main() {
    val post = Post()
    val post1 =  post.copy()
    val post2 = post.copy(id =1, ownerId = 5)

    println (WallService.add(post))
    WallService.add(post1)
    WallService.update(post2)
}
