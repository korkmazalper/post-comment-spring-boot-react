import React, { useState } from 'react';
import { Link } from "react-router-dom";

import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';

import CardContent from '@mui/material/CardContent';

import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import { green, purple, red, yellow, grey,blue,pink } from '@mui/material/colors';

import MoreVertIcon from '@mui/icons-material/MoreVert';

import { Alert, Box, Button, InputAdornment, OutlinedInput, Snackbar } from '@mui/material';


function PostForm(props) {
    const { username, userId, refreshPosts } = props;
    const [text, setText ] = useState("");
  const [title, setTitle] = useState("");
  const [isSent, setIsSent] = useState(false);
 const formattedDate = new Date().toLocaleString("tr", {
  weekday: "long", 
  year: "numeric",
  month: "long", 
  day: "2-digit",
  hour: "2-digit",
  minute: "2-digit",
  second: "2-digit",
});
    const savePost = () => {
        fetch("/posts",
            {
                method: "POST",
                headers: {
                    "Content-Type":"application/json",
                },
                body: JSON.stringify(
                    {
                        title: title,
                        userId: userId,
                        text:text,
                    }),
            })
            .then((res) => res.json())
        .catch((err)=>console.log(err))
    }
  const handleSubmit = () => {
    savePost();
    setIsSent(true);
    setTitle("");
    setText("");
    refreshPosts();
    };

    const handleTitle = (value) => {
      setTitle(value);
      setIsSent(false);
    }
    const handleText = (value) => {
      setText(value);
      setIsSent(false);
  }
  const handleClose = () => {
    setIsSent(false);
  };

  return (
    <div sx={{ maxWidth: 800, margin: "auto", padding: 3 }}>
      
 <Snackbar
        open={isSent}
        autoHideDuration={1500}
        onClose={handleClose}
      >
        <Alert onClose={handleClose} severity='success'>
          Posted successfully !
        </Alert>
        </Snackbar>

<Card sx={{ width: "100%", maxWidth: 800, marginBottom: 3, padding: 3, width:600, bgcolor:pink[50]}}>
      <CardHeader
          avatar={
            <Link to={{pathname:'/users/'+userId}} style={{ textDecoration: 'none' }}>
          <Avatar sx={{ background: 'linear-gradient(60deg,#2196f3 30%,rgb(86, 83, 238) 90%)'}} aria-label="recipe">
            {username ? username.charAt(0).toUpperCase():"?"}
          </Avatar>
            </Link>
          
        }
        action={
          <IconButton aria-label="settings">
            <MoreVertIcon />
          </IconButton>
        }
          title={<Box sx={{ color: "red", textAlign:"left" }}>
              {<OutlinedInput
                  id="outlined-adornment-amount"
                  multiline
                  placeholder='Title'
              inputProps={{ maxLength: 25 }}
              value={title}
                  fullWidth
                  onChange={(i)=> handleTitle(i.target.value)}
              >

              </OutlinedInput>}
                  </Box>}
          
          subheader={
                  <Typography sx={{ color: "blue" , textAlign:"left", fontSize:"0.75rem" }}>
                    {formattedDate}
                  </Typography>
                  }
      />
      
      <CardContent>
        <Typography variant="body2" sx={{ color: 'text.secondary', textAlign:"left" }}>
         {<OutlinedInput
                  id="outlined-adornment-amount"
                  multiline
                  placeholder='Text'
                  inputProps={{ maxLength: 250 }}
              fullWidth
              value={text}
                  onChange={(i)=> handleText(i.target.value)}
                  endAdornment={
                              <InputAdornment position="end">
                                    <Button variant="contained"
                                  style={{background:'linear-gradient(45deg,#2196f3 30%, #21cbf3 90%)', color:'white'}}
                                  
                                  onClick={()=>handleSubmit()}
                                  >
                                      Post
                                  </Button>
                              </InputAdornment>
                    }      
              >

              </OutlinedInput>}
        </Typography>
      </CardContent>
  
      </Card>
     
    </div>
    
  );
}

export default PostForm;
