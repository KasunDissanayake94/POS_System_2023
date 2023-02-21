import logo from './logo.svg';
import './App.css';
import {BrowserRouter,Route,Routes} from 'react-router-dom'

// import main pages
import HomePage from './pages/HomePage';

function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route path='/' element={<HomePage/>} />
        </Routes>
    </BrowserRouter>
  );
}

export default App;
