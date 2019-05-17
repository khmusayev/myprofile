import React from 'react';
import './App.css';
import Header from './components/layout/Header';
import AuthenticationPage from './components/pages/AuthenticationPage';
import UserHomePage from './components/pages/UserHomePage';
import TestLoggedIn from './components/pages/TestLoggedIn';
import PrivateRoute from './components/pages/PrivateRoute';
import { BrowserRouter as Router , Route} from 'react-router-dom';

function App() {
  return (
    <Router>
      <div className="App">
        <div className="container">
          <Header />
          <Route exact path="/login" component={AuthenticationPage} />
          <Route exact path="/users/:username" component={UserHomePage} />
           <PrivateRoute exact path="/testLoggedIn" component={TestLoggedIn} />
        </div>
      </div>
    </Router>
  );
}

export default App;
