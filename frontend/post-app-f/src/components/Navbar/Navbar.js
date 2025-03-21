import React from 'react';
import { Link } from "react-router-dom";

import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import { green, purple, red, yellow, grey,blue,pink } from '@mui/material/colors';
function Navbar() {
    const userId = 1;  
    
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static" sx={{ bgcolor: "#0000FF", color:"#FFFFFF" , marginRight:2}} >
        <Toolbar>
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          >
            <MenuIcon />
          </IconButton>
                  <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
                      <Box display="flex" justifyContent="space-between" alignItems="center">
                          <Link to="/" style={{ textDecoration: "none" ,color:"#FFFFFF" }}>Home</Link>
                          <Link to={`/users/${userId}`} style={{ textDecoration: "none", color:"#FFFFFF" }}>User </Link>               
                      </Box>
           
        </Typography>
                
        </Toolbar>
      </AppBar>
    </Box>
  );
}


export default Navbar;
