package org.krkmz.postapp.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostCreateRequest {
    private Long id;
    private String title;
    private String text;
    @JsonProperty( "userId" )
    private Long userId;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getText () {
        return text;
    }

    public void setText (String text) {
        this.text = text;
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }
}
