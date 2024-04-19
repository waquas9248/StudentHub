import React from 'react';
import './App.css';
import HomePage from './components/HomePage';
import Login from './components/Login';
import Register from './components/Register';
import Events from './components/Events';
import Groups from './components/Groups';
import LocalRecommendation from './components/LocalRecommendation';
import { BrowserRouter as Router,Routes, Route } from 'react-router-dom';

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
                  <Route path="/" element={<HomePage />} />
                  <Route path="/Login" element={<Login/>} />
                  <Route path="/Register" element={<Register/>} />
                  <Route path="/LocalRecommendation" element={<LocalRecommendation />} />
                  <Route path="/Events" element={<Events />} />
                  <Route path="/Groups" element={<Groups />} />
                </Routes>
      </div>
    </Router>
  );
}

export default App;