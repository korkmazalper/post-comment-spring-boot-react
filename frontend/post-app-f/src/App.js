import logo from './logo.svg';
import './App.css';
import Post from './components/Post/Post';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar/Navbar';
import Home from './components/Home/Home';
import User from './components/User/User';
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Navbar> </Navbar>
        <Routes>
          <Route  path="/" element={<Home/>}></Route>
          <Route  path="/users/:userId" element={<User/>}></Route>
        </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
