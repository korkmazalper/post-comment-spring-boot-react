import React, { useState } from 'react';
import { Link } from "react-router-dom";
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import { green, purple, red, yellow, grey,blue,pink } from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import ChatBubbleIcon from '@mui/icons-material/ChatBubble';
const ExpandMore = styled((props) => {
  const { expand, ...other } = props;
  return <IconButton {...other} />;
})(({ theme, expand }) => ({
  marginLeft: 'auto',
  transition: theme.transitions.create('transform', {
    duration: theme.transitions.duration.shortest,
  }),
  transform: expand ? 'rotate(180deg)' : 'rotate(0deg)', 
}));

function Post(props) {
  const { title, text, username, userId, creationDate } = props;
  
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
const  [ liked, setLiked] = useState(false)
  
 
  const handleExpandClick = () => {
    setExpanded((prev) => !prev);
  };
  const handleLike = () => {
    setLiked((prev) => !prev);
    console.log("Like durumu:", liked)
  };
  return (
    <div sx={{maxWidth: 800, margin: "auto", padding: 3}}>
<Card sx={{ width: "100%", maxWidth: 800, marginBottom: 3, padding: 3, width:600, bgcolor:pink[50]}}>
      <CardHeader
          avatar={
            <Link to={{pathname:'/users/'+userId}} style={{ textDecoration: 'none' }}>
          <Avatar sx={{ bgcolor: pink[200], color:'whitesmoke' }} aria-label="recipe">
            {username ? username.charAt(0).toUpperCase():"?"}
          </Avatar>
            </Link>
          
        }
        action={
          <IconButton aria-label="settings">
            <MoreVertIcon />
          </IconButton>
        }
          title={<Typography sx={{ color: "red", textAlign:"left" }}>
                    {title}
                  </Typography>}
          
          subheader={
                  <Typography sx={{ color: "blue" , textAlign:"left", fontSize:"0.75rem" }}>
                    {formattedDate}
                  </Typography>
                  }
      />
      
      <CardContent>
        <Typography variant="body2" sx={{ color: 'text.secondary', textAlign:"left" }}>
          {text}
        </Typography>
      </CardContent>
      <CardActions style={{display:"flex", justifyContent:"space-between" }}>
          <IconButton aria-label="add to favorites"
            onClick={handleLike}
          >
          <FavoriteIcon sx={liked ? {color:red[500]}:null} />
          </IconButton >
          
        <IconButton aria-label="comment this post" onClick={handleExpandClick} >
                  <ChatBubbleIcon/>
          </IconButton >
          
        
      {/*   <ExpandMore
          expand={expanded} 
          onClick={handleExpandClick}
          aria-expanded={expanded}
          aria-label="show more"
        >
          <ExpandMoreIcon />
        </ExpandMore> */}
      </CardActions>
      <Collapse in={expanded} timeout="auto" unmountOnExit>
        <CardContent>
         
          <Typography >
            Heat 1/2 cup of the broth in a pot until simmering, add saffron and set
            aside for 10 minutes.
          </Typography>
          <Typography >
            Heat oil in a (14- to 16-inch) paella pan or a large, deep skillet over
            medium-high heat. Add chicken, shrimp and chorizo, and cook, stirring
            occasionally until lightly browned, 6 to 8 minutes. Transfer shrimp to a
            large plate and set aside, leaving chicken and chorizo in the pan. Add
            pimentón, bay leaves, garlic, tomatoes, onion, salt and pepper, and cook,
            stirring often until thickened and fragrant, about 10 minutes. Add
            saffron broth and remaining 4 1/2 cups chicken broth; bring to a boil.
          </Typography>
        </CardContent>
      </Collapse>
    </Card>
    </div>
    
  );
}

export default Post;
