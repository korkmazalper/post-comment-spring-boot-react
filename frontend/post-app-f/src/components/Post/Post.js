import React, { useState, useRef, useEffect } from 'react';
import { Link } from "react-router-dom";
import { Box, Card, CardHeader, CardContent, CardActions, Collapse, Avatar, IconButton, Typography, Container } from '@mui/material';
import { red, pink, blue } from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import ChatBubbleIcon from '@mui/icons-material/ChatBubble';
import Comment from '../Comment/Comment';
import CommentForm from '../Comment/CommentForm';

function Post({ title, text, username, userId, creationDate, postId }) {
  const formattedDate = new Date(creationDate).toLocaleString("tr", {
    weekday: "long",
    year: "numeric",
    month: "long",
    day: "2-digit",
    hour: "2-digit",
    minute: "2-digit",
    second: "2-digit",
  });

  const [expanded, setExpanded] = useState(false);
  const [liked, setLiked] = useState(false);
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [commentList, setCommentList] = useState([]);
  const isInitialMount = useRef(true);

  const handleExpandClick = () => {
    setExpanded(prev => !prev);
    refreshComments();
  };

  const handleLike = () => {
    setLiked(prev => !prev);
  };

  const refreshComments = () => {
    fetch("/comments?postId" + postId)
      .then(res => res.json())
      .then(
        (result) => {
          setIsLoaded(true);
          setCommentList(result.reverse());
          
        },
        (error) => {
          setIsLoaded(true);
          setError(error);
        }
      );
  };

  useEffect(() => {
    if (isInitialMount.current) {
      isInitialMount.current = false;
    } else {
      refreshComments();
    }
  }, []);

  return (
    <Box sx={{ maxWidth: 800, margin: "auto", padding: 3 }}>
      <Card sx={{ width: "100%", maxWidth: 800, marginBottom: 3, padding: 3, bgcolor: pink[50] }}>
        <CardHeader
          avatar={
            <Link to={{ pathname: '/users/' + userId }} style={{ textDecoration: 'none' }}>
              <Avatar sx={{ background: 'linear-gradient(60deg,#2196f3 30%,rgb(86, 83, 238) 90%)' }}>
                {username ? username.charAt(0).toUpperCase() : "?"}
              </Avatar>
            </Link>
          }
          action={<IconButton aria-label="settings"><MoreVertIcon /></IconButton>}
          title={<Typography sx={{ color: "red", textAlign: "left" }}>{title}</Typography>}
          subheader={<Typography sx={{ color: "blue", textAlign: "left", fontSize: "0.75rem" }}>{formattedDate}</Typography>}
        />
        <CardContent>
          <Typography variant="body2" sx={{ color: 'text.secondary', textAlign: "left" }}>{text}</Typography>
        </CardContent>
        <CardActions sx={{ display: "flex", justifyContent: "space-between" }}>
          <IconButton aria-label="add to favorites" onClick={handleLike}>
            <FavoriteIcon sx={liked ? { color: red[500] } : {}} />
          </IconButton>
          <IconButton aria-label="comment this post" onClick={handleExpandClick}>
            <ChatBubbleIcon />
          </IconButton>
        </CardActions>
        <Collapse in={expanded} timeout="auto" unmountOnExit>
          <Container fixed>
            {error ? "error" :
              isLoaded ? commentList.map(comment => (
              <Comment userId={1} username={"USER"} text={comment.text} key={comment.id} />
            )) : "Loading"}
            <CommentForm userId={1} username={"USER"} text={"text"}></CommentForm>
          </Container>
        </Collapse>
      </Card>
    </Box>
  );
}

export default Post;
