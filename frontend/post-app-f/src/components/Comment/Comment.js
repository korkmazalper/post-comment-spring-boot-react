import { makeStyles } from '@mui/material';
import React from 'react'
import CardContent from '@mui/material/CardContent';
import { Alert, Button, InputAdornment, OutlinedInput, Snackbar } from '@mui/material';
import { Link } from "react-router-dom";
import Avatar from '@mui/material/Avatar';


function Comment({text, userId, username}) {
      return (
    <div>
          <CardContent >
              <OutlinedInput
                  disabled
                  id="outlined-adornment-amount"
                  multiline
                  inputProps={{}                 }
                  fullwidth
                  value={text}
                  startAdornment={
                      <InputAdornment position="start">
                          <Link  to={{pathname: '/users/'+userId}} >
                              <Avatar  >
                                  {username.charAt(0).toUpperCase()}
                              </Avatar>
                          
                          </Link>
                      </InputAdornment>
                  }
                  stlye={{color:"black", backgroundColor:"white"}}
              >
                  
              </OutlinedInput>

      </CardContent>
    </div>
  )
}

export default Comment
