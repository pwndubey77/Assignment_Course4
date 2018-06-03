package com.upgrad.ImageHoster.common;

import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.model.Image;
import org.hibernate.Session;

public class CommentManager extends SessionManager {

    /**
     * This method saves a Comment object to the database
     *
     * @param comment Comment object to be saved into the database
     *
     * @return the saved Comment object
     */
    public Comment createComment(Comment comment) {
        Session session = openSession();
        session.save(comment);
        commitSession(session);
        return comment;
    }
}
