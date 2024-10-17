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
                  <Route path="/login" element={<Login/>} />
                  <Route path="/register" element={<Register/>} />
                  <Route path="/localrecommendation" element={<LocalRecommendation />} />
                  <Route path="/events" element={<Events />} />
                  <Route path="/groups" element={<Groups />} />
          </Routes>
      </div>
    </Router>
  );
}

export default App;
