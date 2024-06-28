
data class Likes(var count: Int)
data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val postType: String,
    val likes: Likes = Likes(0)
)
object WallService{
    private var posts = emptyArray<Post>()
    private var nextId = 1

    fun add(post: Post): Post {
        val newPost = post.copy(id = nextId++)
        posts += newPost
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, storedPost) in posts.withIndex()) {
            if (storedPost.id == post.id) {
                posts[index] = post.copy(
                    ownerId = storedPost.ownerId,
                    fromId = storedPost.fromId,
                    createdBy = storedPost.createdBy,
                    date = storedPost.date
                )
                return true
            }
        }
        return false
    }
}

fun main() {
    val post = Post(
        id = 0,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 20220628,
        text = "Hello, world!",
        replyOwnerId = 0,
        replyPostId = 0,
        friendsOnly = false,
        postType = "post"
    )

    val addedPost = WallService.add(post)
    println(addedPost)

    val updatePost = addedPost.copy(text = "Hello, Kotlin!")
    val result = WallService.update(updatePost)
    println(result)
}