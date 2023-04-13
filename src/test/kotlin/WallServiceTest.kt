import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val post = Post()
        val result = WallService.add(post)
        assertNotEquals(post.id, result.id)

    }

    @Test
    fun updateTrue() {
        val post = Post()
        WallService.add(post)
        val post2 = Post(id = 1, ownerId = 5)
        val result = WallService.update(post2)
        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        val post = Post()
        WallService.add(post)
        val post2 = Post(id = 0, ownerId = 5)
        val result = WallService.update(post2)
        assertFalse(result)
    }

    @Test
    fun addCommentToPost() {
        val post = Post()
        WallService.add(post)
        val id = 1
        val comment = Comment()
        WallService.createComment(id, comment)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val post = Post()
        WallService.add(post)
        val id = 0
        val comment = Comment()
        WallService.createComment(id, comment)
    }
}