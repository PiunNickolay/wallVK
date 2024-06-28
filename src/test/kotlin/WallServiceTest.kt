import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val post = Post(
            id = 0,
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            date = 20220628,
            text = "Test post",
            replyOwnerId = 0,
            replyPostId = 0,
            friendsOnly = false,
            postType = "post"
        )
        val addedPost = WallService.add(post)
        assertNotEquals(0, addedPost.id)
    }

    @Test
    fun updateExistingPost() {
        val post = Post(
            id = 0,
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            date = 20220628,
            text = "Test post",
            replyOwnerId = 0,
            replyPostId = 0,
            friendsOnly = false,
            postType = "post"
        )
        val addedPost = WallService.add(post)
        val updatePost = addedPost.copy(text = "Updated text")
        val result = WallService.update(updatePost)
        assertTrue(result)
    }
    @Test
    fun testUpdateNonExistingPost() {
        val post = Post(
            id = 999,
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            date = 20220628,
            text = "Test post",
            replyOwnerId = 0,
            replyPostId = 0,
            friendsOnly = false,
            postType = "post"
        )

        val result = WallService.update(post)
        assertFalse(result)
    }
}