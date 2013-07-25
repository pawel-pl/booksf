package facebook;

/*Observer Pattern
 * 
 * Design a realtime service that tells users which of their friends are currently online. 
 * 
 * 
 * class User {
    UserID id;  // unique id
    std::list<Update> self_updates; // owned by user; list of updates in reverse chrono order
    std::list<Update *> friend_updates;  // owned by user friends; list of updates in reverse chronological order
    std::list<User *> friends; // Friend list
};

class Update {
    UpdateType type; // media type of this update - can be photo/video etc
    DateTime timestamp;
    Message msg; // Message text in this update
    Media *media;   // can be pointer to photo/video/audio in the update OR NULL
    List<Comment> comments;  // Comments on this update
}
 */
public class GetNewsFeed {

	public void foo() {
		System.out.println(getClass().getCanonicalName());
	}
}
