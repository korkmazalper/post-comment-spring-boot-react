import React from 'react'
import {useParams} from "react-router-dom"
function User() {
    const { userId } = useParams();
  return (
      <div>
          <p>
        User : {userId}        
          </p>
      
    </div>
  )
}

export default User;
