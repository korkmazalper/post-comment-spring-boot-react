import React from 'react';
import CardContent from '@mui/material/CardContent';
import { Link } from "react-router-dom";
import { Avatar, OutlinedInput, InputAdornment } from '@mui/material';

function CommentForm({ userId, username }) {
  return (
    <div>
      <CardContent sx={{ display: "flex", flexWrap: "wrap", alignItems: "center" }}>
        <OutlinedInput

          id="outlined-adornment-amount"
          multiline
          fullWidth
         inputProps={{maxLength:25}}
          startAdornment={
            <InputAdornment position="start">
              <Link to={`/users/${userId}`} style={{ textDecoration: "none" }}>
                <Avatar sx={{ bgcolor: "primary.main", color: "white" }}>
                  {username.charAt(0).toUpperCase()}
                </Avatar>
              </Link>
            </InputAdornment>
          }
          sx={{ color: "black", bgcolor: "white" }}
        />
      </CardContent>
    </div>
  );
}

export default CommentForm;
