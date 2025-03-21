import Post from '../Post/Post'
import React,{useState,useEffect} from 'react'
import './Home.scss'
import PostForm from '../Post/PostForm';
function Home() { 
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [postList, setPostList] = useState([]);
    const refreshPosts = () => {
        fetch("/posts")
            .then(res => res.json())
            .then(
                (result) => {
                    setIsLoaded(true);
                    const resultReversed = result.reverse();
                    setPostList(resultReversed);

                },
                (error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            )
    }
    useEffect(() => {
        refreshPosts()
    }, [postList]);
    if (error) {
        return <div> Error ! </div>
    } else if (!isLoaded) {
        return <div>
            Loading...
        </div>
    }
  return (
     <div className='container' >
          <PostForm userId={3} username={'Yasmin'}  refreshPosts={refreshPosts} />
          {postList.map(post => (
              <Post postId={ post.id} title={post.title} text={post.text}
                  creationDate={post.createdAt}
                  username={post.userName}
                  userId={post.userId}
                 
              >
                  
                  </Post>
                   
             
          ))}
   </div>
  )

 
}

export default Home
